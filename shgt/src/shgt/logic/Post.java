package shgt.logic;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

/**
 * 帖子类
 * 
 * @author ben
 * 
 */
public class Post implements Serializable {
	
	public Post() {
		
	}
	
	public Post(int postid) throws SQLException {
		ResultSet rs = DBOperator.getPost(postid);
		rs.beforeFirst();
		if(rs.next()) {
			this.id = postid;
			this.setTitle(rs.getString("title"));
			this.setDetail_info(rs.getString("post_info"));
			this.setReleaseDate(rs.getDate("releaseDate"));
			this.setType(rs.getInt("type"));
			this.setUser_id(rs.getInt("p_user_id"));
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 评论结果集
	 */
	private ResultSet rs = null;
	
	/**
	 * 对该帖子的评论总数
	 */
	private int commentNum;

	/**
	 * 过期
	 */
	public static final int out = 0;

	/**
	 * 转让
	 */
	public static final int zr = 1;

	/**
	 * 求购
	 */
	public static final int qg = 2;

	/**
	 * 编号
	 */
	private int id;

	/**
	 * 发表该帖子的用户编号
	 */
	private int user_id;

	/**
	 * 详细描述
	 */
	private String detail_info;

	/**
	 * 帖子类型（过期、求购或转让）
	 */
	private int type;

	/**
	 * 帖子相关的物品的类型
	 */
	private int g_type;

	/**
	 * @return the g_type
	 */
	public int getG_type() {
		return g_type;
	}

	/**
	 * @param g_type
	 *            the g_type to set
	 */
	public void setG_type(int g_type) {
		this.g_type = g_type;
	}

	/**
	 * 该帖子关联的物品，默认为空
	 */
	private Goods gds = null;

	/**
	 * 帖子标题
	 */
	private String title;

	/**
	 * 帖子发表的日期
	 */
	private Date releaseDate;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the detail_info
	 */
	public String getDetail_info() {
		return detail_info;
	}

	/**
	 * @param detail_info
	 *            the detail_info to set
	 */
	public void setDetail_info(String detail_info) {
		this.detail_info = detail_info;
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the releaseDate
	 */
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * @param releaseDate
	 *            the releaseDate to set
	 */
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 * @return the gds
	 */
	public Goods getGds() {
		return gds;
	}

	/**
	 * @param gds
	 *            the gds to set
	 */
	public void setGds(Goods gds) {
		this.gds = gds;
	}

	/**
	 * 更新帖子的内容到数据库
	 * 
	 * @return
	 */
	public boolean update() {
		return false;
	}

	/**
	 * 删除此帖，其所有相关的评论也会被删除
	 * 
	 * @return
	 */
	public boolean destroy() {
		return false;
	}

	/**
	 * 取出该帖子的所有评论
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public Comment[] getAllComments(){
		try{
		if (rs == null) {
			rs = DBOperator.getCommentSet(id);
			rs.last();
			commentNum = rs.getRow();
		}
		Comment[] coms = new Comment[commentNum];
		rs.beforeFirst();
		for(int i = 0; i < commentNum;i++) {
			rs.next();
			coms[i] = new Comment();
			coms[i].setId(rs.getInt("id"));
			coms[i].setPost_id(id);
			coms[i].setUser_id(rs.getInt("c_user_id"));
			coms[i].setContent(rs.getString("content"));
		}
		return coms;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
