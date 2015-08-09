package shgt.logic;

import java.io.Serializable;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

/**
 * ϵͳ��Ա�࣬����ע���Ա���ο�
 * 
 * @author ben
 * 
 */
public class Member implements Serializable {

	// public static void main(String[] args) {
	// ResultSet rs = DBOperator.getResultSet();
	// try {
	// rs.beforeFirst();
	// while (rs.next()) {
	// System.out.println(rs.getString("username"));
	// }
	//
	// Date now = new Date(System.currentTimeMillis());
	// rs.moveToInsertRow();
	// rs.updateString("username", "С��");
	// rs.updateString("password", "haha");
	// rs.updateString("telephone", "15120093058");
	// rs.updateString("email", "liubaiyan_2010@163.com");
	// rs.updateString("identityid", "123456789876543214");
	// rs.updateInt("sex", 1);
	// rs.updateDate("registertime", now);
	// rs.insertRow();
	//
	// rs.beforeFirst();
	// while (rs.next()) {
	// System.out.println(rs.getString("username"));
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ο�ID
	 */
	public static final int visitor_id = -1;
	
	/**
	 * �Ƿ���ԱID
	 */
	public static final int error_id = -2;

	/**
	 * �û����
	 */
	private int id;

	/**
	 * �û���
	 */
	private String username = null;

	/**
	 * ����
	 */
	private String password = null;

	/**
	 * �Ա�
	 */
	private int sex = 0;

	/**
	 * @return the sex
	 */
	public int getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(int sex) {
		this.sex = sex;
	}

	/**
	 * ���֤��
	 */
	private String identityid = null;

	/**
	 * ��������
	 * 
	 * @param id
	 */
	private String email = null;

	/**
	 * ��ϵ�绰
	 * 
	 * @param id
	 */
	private String telephone = null;

	/**
	 * ע��ʱ��
	 */
	private Date registerTime = null;

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
	 * @return the username
	 */
	public String getUsername() {
		if(this.id == Member.visitor_id)
			return "�ο�";
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the identityid
	 */
	public String getIdentityid() {
		return identityid;
	}

	/**
	 * @param identityid
	 *            the identityid to set
	 */
	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the registerTime
	 */
	public Date getRegisterTime() {
		return registerTime;
	}

	/**
	 * @param registerTime
	 *            the registerTime to set
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	/**
	 * ͨ��ϵͳ��Ա�������һ��ϵͳ��Ա����
	 * @param id
	 * @throws SQLException
	 */
	public Member(int id) throws SQLException {
		if (id == visitor_id) {
			this.setId(visitor_id);
			this.setUsername("�ο�");
			return;
		}
		ResultSet rs = DBOperator.getUser(id);
		rs.beforeFirst();
		if (rs.next()) {
			this.setId(id);
			this.setEmail(rs.getString("email"));
			this.setUsername(rs.getString("username"));
			this.setPassword(rs.getString("password"));
			this.setRegisterTime(rs.getDate("registertime"));
			this.setIdentityid(rs.getString("identityid"));
			this.setSex(rs.getInt("sex"));
			this.setTelephone(rs.getString("telephone"));
		} else {
			this.setId(error_id);
		}
	}

	public Member() {
	}

	/**
	 * �жϵ�ǰ��Ա�Ƿ���ע���Ա
	 * 
	 * @return
	 */
	public boolean isVIP() {
		return id > 0;
	}

	/**
	 * ע��
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Member register(String name, String password, String email, int sex,
			String identityid, String telephone) throws SQLException {
		ResultSet rs = DBOperator.getUser(name);
		rs.beforeFirst();
		if (rs.next()) {
			return null;
		}
		Date now = new Date(System.currentTimeMillis());
		Member m = new Member();
		m.setUsername(name);
		m.setEmail(email);
		m.setIdentityid(identityid);
		m.setPassword(password);
		m.setRegisterTime(now);
		m.setSex(sex);
		m.setTelephone(telephone);

		rs.moveToInsertRow();
		rs.updateString("username", name);
		rs.updateString("password", password);
		rs.updateString("telephone", telephone);
		rs.updateString("email", email);
		rs.updateString("identityid", identityid);
		rs.updateInt("sex", sex);
		rs.updateDate("registertime", now);
		rs.insertRow();
		rs.beforeFirst();
		while(rs.next()) {
			if(rs.getString("username").equals(name)) {
				m.setId(rs.getInt("id"));
				break;
			}
		}
		return m;
	}

	/**
	 * �г�ϵͳ�����е���Ʒ����
	 * 
	 * @return
	 */
	public GoodsType[] listAllTypes() {
		TypeManager tm = null;
		try {
			tm = new TypeManager();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (tm != null) {
			try {
				return tm.listAllTypes();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * ���������
	 */
	private PostsManager pb = null;

	/**
	 * ȡ�����������
	 */
	public PostsManager getPostsManager() {
		if(this.pb != null) {
			return this.pb;
		}
		try {
			pb = new PostsManager();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.pb;
	}
	
	/**
	 * �����������������
	 * @param keyword
	 * @return
	 */
	public boolean resetPostsManager(String keyword) {
		try {
			pb = new PostsManager(keyword);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �����������������
	 * @param typeid
	 * @return
	 */
	public boolean resetPostsManager(int typeid) {
		try {
			pb = new PostsManager(typeid);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �õ�һ�����ӵ���������
	 * 
	 * @param p
	 * @return
	 */
	public CommentsManager getCommentsBrowser(Post p) {
		return null;
	}

	/**
	 * ��Ա�����ӷ�������
	 * 
	 * @param p
	 * @return
	 */
	public boolean releaseAComment(Post p) {
		return false;
	}

	/**
	 * �����û����ݵ����ݿ����
	 * 
	 * @return
	 */
	public boolean updateToDB() {
		return false;
	}

	/**
	 * ͨ���û�������������һ����Ա��������û�����������󣬽����ؿ�
	 * @param username
	 * @param password
	 * @return
	 */
	public static Member getMember(String username, String password) {
		try {
			ResultSet rs = DBOperator.getUser(username, password);
			rs.beforeFirst();
			if (rs.next()) {
				Member m = new Member();
				m.setId(rs.getInt("id"));
				m.setEmail(rs.getString("email"));
				m.setUsername(rs.getString("username"));
				m.setPassword(rs.getString("password"));
				m.setRegisterTime(rs.getDate("registertime"));
				m.setIdentityid(rs.getString("identityid"));
				m.setSex(rs.getInt("sex"));
				m.setTelephone(rs.getString("telephone"));
				return m;
			} else {
				return null;
			}
		} catch (SQLException se) {
			return null;
		}
	}
	
	/**
	 * ������ͨ�οͶ���
	 * @return
	 */
	public static Member getANormalVisitor() {
		try {
			return new Member(Member.visitor_id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
