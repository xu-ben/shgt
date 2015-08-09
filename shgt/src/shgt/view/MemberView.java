package shgt.view;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import shgt.control.DBOperator;
import shgt.logic.GoodsType;
import shgt.logic.Member;
import shgt.logic.Post;
import shgt.logic.PostsManager;

/**
 * Servlet implementation class MemberView
 */
public class MemberView extends HttpServlet {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 访问者对象
	 */
	private Member m = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MemberView() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String[] requestTypes = { "login", "search", "releasepost", "alter",
				"quit", "firstpage", "nextpage", "lastpage", "showpost", "reply", "cleanbytype", "toreleasepage" };
		String reqname = request.getParameter("reqname");
		if (reqname == null) {
			return;
		}
		int i;
		for (i = 0; i < requestTypes.length; i++) {
			if (reqname.equals(requestTypes[i])) {
				break;
			}
		}
		if (i == requestTypes.length) {
			return;
		}

		switch (i) {
		case 0:
			doLogin(request, response);
			break;
		case 1:
			doSearch(request, response);
			break;
		case 2:
			doReleasePost(request, response);
			break;
		case 5:
			m.getPostsManager().getFirstPage();
			refresh(request, response);
			break;
		case 6:
			m.getPostsManager().nextPage();
			refresh(request, response);
			break;
		case 7:
			m.getPostsManager().lastPage();
			refresh(request, response);
			break;
		case 8:
			doShowPost(request, response);
			break;
		case 9:
			doReply(request, response);
			break;
		case 10:
			doCleanByType(request, response);
			break;
		case 11:
			doToReleasePage(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 前往发布帖子页面
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doToReleasePage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		GoodsType[] types = m.listAllTypes();
		request.setAttribute("types", types);
		String forwardUrl = new String("releasepost.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}


	private void doCleanByType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		int typeid = Integer.parseInt(request.getParameter("typeid"));
		if(m.resetPostsManager(typeid)) {
			m.getPostsManager().getFirstPage();
			refresh(request, response);
		}
	}

	/**
	 * 搜索
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doSearch(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {	
		String keyword = request.getParameter("keyword");
		if(m.resetPostsManager(keyword)) {
			m.getPostsManager().getFirstPage();
			refresh(request, response);
		}
	}

	/**
	 * 回复帖子
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doReply(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(!m.isVIP()) {
			return ;
		}
		int postid =  Integer.parseInt(request.getParameter("postid"));
		String content = request.getParameter("content");
		int userid = m.getId();
		try {
			ResultSet rs = DBOperator.getCommentSet(0);
			rs.moveToInsertRow();
			rs.updateString("content", content);
			rs.updateInt("c_post_id", postid);
			rs.updateInt("c_user_id", userid);
			rs.insertRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Post p;
		try {
			p = new Post(postid);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		request.setAttribute("user", m);
		request.setAttribute("curpost", p);
		String forwardUrl = new String("postpage.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
	/**
	 * 发布帖子
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doReleasePost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		MultipartRequest newRequest = new MultipartRequest(request, getServletContext().getRealPath("UploadImages")); // 将上传的文件移至特定目录

		String title = newRequest.getParameterValues("title")[0];
		String content = newRequest.getParameterValues("content")[0];
		int posttype = Integer.parseInt(newRequest.getParameterValues("posttype")[0]);
		int user_id = m.getId();
		int postid = 0;

		Date now = new Date(System.currentTimeMillis());
		try {
			ResultSet rs = DBOperator.getPostsSet();
			rs.moveToInsertRow();
			rs.updateString("title", title);
			rs.updateString("post_info", content);
			rs.updateDate("releaseDate", now);
			rs.updateInt("type", posttype);
			rs.updateInt("p_user_id", user_id);
			rs.insertRow();
			if(rs.first()) {
				postid = rs.getInt("id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(posttype == 1) {
			Enumeration<String> tempEnum = newRequest.getFileNames();
			String tagname = tempEnum.nextElement();
			File f = newRequest.getFile(tagname);
			String picPath = null;
			if(f != null && f.exists()) {
				picPath = f.getAbsolutePath();
			}

			String name = newRequest.getParameterValues("name")[0];
			int price = Integer.parseInt(newRequest.getParameterValues("price")[0]);
			String description = newRequest.getParameterValues("description")[0];
			String typename = newRequest.getParameterValues("goodstype")[0];
			typename = DBOperator.latin1ToUTF(typename);
			int typeid = DBOperator.getTypeIdByName(typename);
			try {
				ResultSet rs = DBOperator.getGoodsSet();
				rs.moveToInsertRow();
				rs.updateString("name", name);
				rs.updateString("description", description);
				rs.updateDate("releasedate", now);
				rs.updateInt("price", price);
				rs.updateInt("g_type_id", typeid);
				rs.updateInt("g_post_id", postid);
				if(picPath != null) {
					rs.updateString("picpath", picPath);
				}
				rs.insertRow();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 登录
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		if (username == null) {
			m = Member.getANormalVisitor();
			m.getPostsManager().getFirstPage();
			refresh(request, response);
			return ;
		}
		String password = request.getParameter("password");
		m = Member.getMember(username, password);
		if (m == null) {
			failToLogin(request, response);
			return;
		}
		m.getPostsManager().getFirstPage();
		refresh(request, response);
	}

	/**
	 * 登录失败后的处理
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void failToLogin(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.println("登录失败!" + username + password);
	}

	/**
	 * 注销
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doLogout(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}
	
	private void refresh(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsType[] types = m.listAllTypes();
		request.setAttribute("types", types);
		Post[] posts = null;
		PostsManager pm = m.getPostsManager();
		posts = pm.getCurPage();
		request.setAttribute("posts", posts);
		request.setAttribute("user", m);
		request.setAttribute("curPage", pm.getCurPageNum());
		request.setAttribute("totalPage", pm.getTotalPageNum());
		String forwardUrl = new String("memberpage.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}
	
	/**
	 * 显示某一帖子的详细信息
	 * 
	 * @param postid
	 */
	private void doShowPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int postid = Integer.parseInt(request.getParameter("postid"));
		Post p;
		try {
			p = new Post(postid);
		} catch (SQLException e) {
			e.printStackTrace();
			return;
		}
		request.setAttribute("user", m);
		request.setAttribute("curpost", p);
		String forwardUrl = new String("postpage.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher(forwardUrl);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String[] requestTypes = { "login", "register", "releasepost" };
		String reqname = request.getParameter("reqname");
		if (reqname == null) {
			doReleasePost(request, response);
			return;
		}
		int i;
		for (i = 0; i < requestTypes.length; i++) {
			if (reqname.equals(requestTypes[i])) {
				break;
			}
		}
		if (i == requestTypes.length) {
			return;
		}
		switch (i) {
		case 0:
			doLogin(request, response);
			break;
		case 1:
			doRegister(request, response);
			break;
		case 2:
			doReleasePost(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 注册
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if(m != null) {
			return ;
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("telephone");
		String identityid = request.getParameter("identityid");
		int sex = Integer.parseInt(request.getParameter("sex"));
		
		try {
			m = Member.register(username, password, email, sex, identityid, phone);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(m != null && m.isVIP()) {
			m.getPostsManager().getFirstPage();
			refresh(request, response);
		}else {
			PrintWriter out = response.getWriter();
			out.println("注册失败");
		}
	}
}
