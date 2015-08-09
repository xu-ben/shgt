package shgt.logic;

import java.io.Serializable;
import java.sql.ResultSet;

import shgt.control.DBOperator;

public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 更新评论到数据库中
	 * 
	 * @return
	 */
	public boolean updata() {
		return false;
	}

	/**
	 * 删除此条评论，数据库中相应的记录也会被删除
	 * 
	 * @return
	 */
	public boolean destroy() {
		return false;
	}

	/**
	 * 此评论在数据库表中的编号
	 */
	private int id;

	/**
	 * 发表该评论的用户编号
	 */
	private int user_id;

	/**
	 * 该评论所在帖子的编号
	 */
	private int post_id;

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
	 * 返回回复人的姓名
	 * 
	 * @return
	 */
	public String getUserName() {
		try {
			ResultSet rs = DBOperator.getUser(user_id);
			if (rs.next()) {
				return rs.getString("username");
			}
		} catch (Exception e) {
		}
		return null;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the post_id
	 */
	public int getPost_id() {
		return post_id;
	}

	/**
	 * @param post_id
	 *            the post_id to set
	 */
	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 评论的内容
	 */
	private String content;

}
