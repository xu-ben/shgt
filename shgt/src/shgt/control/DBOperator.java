package shgt.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作
 * 
 * @author ben
 * 
 */
public class DBOperator {

	/**
	 * Connection对象
	 */
	public static Connection con = null;

	/**
	 * @throws SQLException
	 *             连接数据库
	 * 
	 * @return
	 * @return
	 * @throws
	 */
	public static void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String str = "jdbc:mysql://202.204.125.14:3306/shgt";
		con = DriverManager.getConnection(str, "root", "root");
	}

	/**
	 * 通过类型名称得到类型id
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static int getTypeIdByName(String typename) {
		try {
			if (con == null) {
				connect();
			}
			Statement st;
			st = con.createStatement();
			String sql = "select id from goods_type where type = \'"	+ typename + "\'";
			ResultSet rs = st
					.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	/**
	 * 返回所有类型的结果集，按类型的id排序
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getTypesSet() throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery("select * from goods_type order by id");
	}

	/**
	 * 从数据库中选出所有的用户，按注册时间排序
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getUsersSet() throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery("select * from users order by id");
	}

	/**
	 * 通过用户编号查找数据库中的记录
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getUser(int id) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql = new String("select * from users where id = ?");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		return ps.executeQuery();
	}

	/**
	 * 通过用户名查找数据库中的记录
	 * 
	 * @param username
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getUser(String username) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql = new String("select * from users where username = \'"
				+ username + "\'");
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery(sql);
	}

	/**
	 * 按帖子编号返回数据据中该帖子数据的结果集
	 * 
	 * @param postid
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getPost(int postid) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql = new String("select * from post where id = ?");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, postid);
		return ps.executeQuery();
	}

	/**
	 * 从数据库中删除某一用户记录
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static void deleteUserByid(int id) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql1 = new String("select id from post where p_user_id = ?");
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, id);
		ResultSet rs = ps1.executeQuery();
		rs.beforeFirst();
		while (rs.next()) {
			deletePostByid(rs.getInt(1));
		}
		String sql2 = new String("delete from users where id = ?");
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, id);
		ps2.executeUpdate();
	}

	/**
	 * 从数据库中删除某一物品分类记录
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static void deleteTypeByid(int id) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql1 = new String(
				"update goods set g_type_id = null where g_type_id = ?");
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, id);
		ps1.executeUpdate();

		String sql2 = new String(
				"update post set p_type_id = null where p_type_id = ?");
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, id);
		ps2.executeUpdate();

		String sql3 = new String("delete from goods_type where id = ?");
		PreparedStatement ps3 = con.prepareStatement(sql3);
		ps3.setInt(1, id);
		ps3.executeUpdate();
	}

	/**
	 * 从数据库中删除某一帖子的记录
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void deletePostByid(int id) throws SQLException {
		if (con == null) {
			connect();
		}
		String sql1 = new String("delete from comment where c_post_id = ?");
		PreparedStatement ps1 = con.prepareStatement(sql1);
		ps1.setInt(1, id);
		ps1.executeUpdate();

		String sql2 = new String("delete from goods where g_post_id = ?");
		PreparedStatement ps2 = con.prepareStatement(sql2);
		ps2.setInt(1, id);
		ps2.executeUpdate();

		String sql3 = new String("delete from post where id = ?");
		PreparedStatement ps3 = con.prepareStatement(sql3);
		ps3.setInt(1, id);
		ps3.executeUpdate();
	}

	/**
	 * 返回系统中所有的帖子,按发表时间，越新的帖子越靠前
	 * 
	 * @return
	 */
	public static ResultSet getPostsSet() throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery("select * from post order by id desc");
	}

	/**
	 * 返回系统中所有的物品,按发表时间，越新的物品越靠前
	 * 
	 * @return
	 */
	public static ResultSet getGoodsSet() throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery("select * from goods order by id desc");
	}

	/**
	 * 返回系统中所有包含指定关键词的帖子,按发表时间，越新的帖子越靠前
	 * 
	 * @return
	 */
	public static ResultSet getPostsSet(String keyword) throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		String sql = new String("select * from post where title like \'%");
		sql += keyword;
		sql += "%\' or post_info like \'%";
		sql += keyword;
		sql += "%\' order by releaseDate desc";
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery(sql);
	}

	/**
	 * 返回系统中所有指定物品类型或物品类型未知的帖子，按发表时间，越新的帖子越靠前
	 * 
	 * @param typeid
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getPostsSet(int typeid) throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		String sql = new String(
				"select * from post where p_type_id is null or p_type_id = ");
		sql += typeid;
		sql += " order by releaseDate desc";
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		return st.executeQuery(sql);
	}

	/**
	 * 返回指定帖子的所有评论,按发表时间，越新的评论越靠前
	 * 
	 * @return
	 */
	public static ResultSet getCommentSet(int postid) throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st;
		st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		String sql = "select * from comment where c_post_id = " + postid;
		return st.executeQuery(sql);
	}

	/**
	 * 关闭连接
	 * 
	 * @return
	 */
	public static boolean close() {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 根据用户名与密码从数据库中取出对应的用户记录
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet getUser(String username, String password)
			throws SQLException {
		if (con == null) {
			connect();
		}
		String sql = new String(
				"select * from users where username = ? and password = ?");
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ps.setString(2, password);
		return ps.executeQuery();
	}

	/**
	 * 从数据库中取出管理员密码
	 * 
	 * @throws SQLException
	 */
	public static String getAdminPassword() throws SQLException {
		if (con == null) {
			connect();
		}
		Statement st = con.createStatement();
		String sql = "select password from users where username = \'admin\'";
		ResultSet rs = st.executeQuery(sql);
		if (rs.next()) {
			return rs.getString(1);
		}
		return null;
	}
	
	public static String latin1ToGBK(String str) {
		try {
			String temp_p = str;
			byte[] temp_t = temp_p.getBytes("ISO-8859-1");
			String temp = new String(temp_t, "GBK");
			return temp;
		} catch (Exception ex) {
			System.out.println(ex);
			return "";
		}

	}

	public static String GBKToLatin1(String str) {
		if (str == null) {
			str = "";
		} else {
			try {
				str = new String(str.getBytes("GBK"), "ISO-8859-1");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return str;
	}
	
	public static String UTFToGBK(String str) {
		try {
			String temp_p = str;
			byte[] temp_t = temp_p.getBytes("UTF-8");
			String temp = new String(temp_t, "GBK");
			return temp;
		} catch (Exception ex) {
			System.out.println(ex);
			return "";
		}

	}

	public static String GBKToUTF(String str) {
		if (str == null) {
			str = "";
		} else {
			try {
				str = new String(str.getBytes("GBK"), "UTF-8");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return str;
	}
	public static String latin1ToUTF(String str) {
		try {
			String temp_p = str;
			byte[] temp_t = temp_p.getBytes("ISO-8859-1");
			String temp = new String(temp_t, "UTF-8");
			return temp;
		} catch (Exception ex) {
			System.out.println(ex);
			return "";
		}

	}

	public static String UTFToLatin1(String str) {
		if (str == null) {
			str = "";
		} else {
			try {
				str = new String(str.getBytes("UTF-8"), "ISO-8859-1");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return str;
	}
	
}
