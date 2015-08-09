package shgt.logic;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

/**
 * ������
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
	 * ���۽����
	 */
	private ResultSet rs = null;
	
	/**
	 * �Ը����ӵ���������
	 */
	private int commentNum;

	/**
	 * ����
	 */
	public static final int out = 0;

	/**
	 * ת��
	 */
	public static final int zr = 1;

	/**
	 * ��
	 */
	public static final int qg = 2;

	/**
	 * ���
	 */
	private int id;

	/**
	 * ��������ӵ��û����
	 */
	private int user_id;

	/**
	 * ��ϸ����
	 */
	private String detail_info;

	/**
	 * �������ͣ����ڡ��󹺻�ת�ã�
	 */
	private int type;

	/**
	 * ������ص���Ʒ������
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
	 * �����ӹ�������Ʒ��Ĭ��Ϊ��
	 */
	private Goods gds = null;

	/**
	 * ���ӱ���
	 */
	private String title;

	/**
	 * ���ӷ��������
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
	 * �������ӵ����ݵ����ݿ�
	 * 
	 * @return
	 */
	public boolean update() {
		return false;
	}

	/**
	 * ɾ����������������ص�����Ҳ�ᱻɾ��
	 * 
	 * @return
	 */
	public boolean destroy() {
		return false;
	}

	/**
	 * ȡ�������ӵ���������
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
