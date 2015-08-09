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
	 * �������۵����ݿ���
	 * 
	 * @return
	 */
	public boolean updata() {
		return false;
	}

	/**
	 * ɾ���������ۣ����ݿ�����Ӧ�ļ�¼Ҳ�ᱻɾ��
	 * 
	 * @return
	 */
	public boolean destroy() {
		return false;
	}

	/**
	 * �����������ݿ���еı��
	 */
	private int id;

	/**
	 * ��������۵��û����
	 */
	private int user_id;

	/**
	 * �������������ӵı��
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
	 * ���ػظ��˵�����
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
	 * ���۵�����
	 */
	private String content;

}
