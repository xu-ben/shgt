package shgt.view;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shgt.control.DBOperator;
import shgt.logic.Administrator;
import shgt.logic.GoodsType;
import shgt.logic.Member;
import shgt.logic.TypeManager;
import shgt.logic.UserManager;

/**
 * Servlet implementation class AdminView
 */
public class AdminView extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * 管理员对象
	 */
	private Administrator a = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminView() {
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
		String[] requestTypes = {"alterType", "deleteType",
				"alterMember", "deleteMember" };
		String reqname = request.getParameter("reqname");
		int i;
		for (i = 0; i < requestTypes.length; i++) {
			if (reqname.equals(requestTypes[i])) {
				break;
			}
		}
		if (i == requestTypes.length) {
			return;
		}
		if (reqname == null) {
			return;
		}

		switch (i) {
		case 0:
			doAlterType(request, response);
			break;
		case 1:
			doDeleteType(request, response);
			break;
		case 2:
			doAlterUser(request, response);
			break;
		case 3:
			doDeleteUser(request, response);
			break;
		default:
			break;
		}
	}

	/**
	 * 修改物品分类
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doAlterType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (a == null) {
			return;
		}
		listinfo(request, response);
	}

	/**
	 * 删除物品分类
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doDeleteType(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (a == null) {
			return;
		}
		int type_id = Integer.parseInt(request.getParameter("typeid"));
		TypeManager tm = a.getTypeManager();
		if (tm.deleteTypeByid(type_id)) {
			request.setAttribute("status", "SUCESS");
		} else {
			request.setAttribute("status", "FAILED");
		}
		listinfo(request, response);
	}

	/**
	 * 修改用户信息
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doAlterUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (a == null) {
			return;
		}
		listinfo(request, response);
	}

	/**
	 * 删除用户
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void doDeleteUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (a == null) {
			return;
		}
		int user_id = Integer.parseInt(request.getParameter("userid"));
		UserManager um = a.getUserManager();
		if (um.deleteUserByid(user_id)) {
			request.setAttribute("status", "SUCESS");
		} else {
			request.setAttribute("status", "FAILED");
		}
		listinfo(request, response);
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
		if(a != null) {
			return ;
		}
		
		String password = request.getParameter("password");
		String pwd = null;
		try {
			pwd = DBOperator.getAdminPassword();
		} catch (SQLException e) {
			e.printStackTrace();
			return ;
		}
		if(password.equals(pwd)) {
			a = new Administrator();
			listinfo(request, response);
		}
	}

	private void listinfo(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		GoodsType[] types = a.listAllTypes();
		request.setAttribute("types", types);
		Member[] users = a.listAllUsers();
		request.setAttribute("users", users);
		String forwardUrl = new String("adminpage.jsp");
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
		doLogin(request, response);
	}
}
