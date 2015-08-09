package shgt.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

public class UserManager {

	/**
	 * 结果集
	 */
	private ResultSet rs = null;

	/**
	 * 用户总量
	 */
	private int totalUsers;

	public UserManager() throws SQLException {
		init();
	}
	
	public void init() throws SQLException {
		rs = DBOperator.getUsersSet();
		rs.last();
		totalUsers = rs.getRow();
	}
	
	/**
	 * 从数据库中删除某一用户记录
	 * @param id
	 * @return
	 */
	public boolean deleteUserByid(int id) {
		try {
			DBOperator.deleteUserByid(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		try {
			init();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 返回所有用户
	 * @return
	 * @throws SQLException
	 */
	public Member[] listAllUsers() throws SQLException {
		Member[] users = new Member[totalUsers];
		rs.beforeFirst();
		for (int i = 0; i < totalUsers; i++) {
			rs.next();
			users[i] = new Member();
			users[i].setId(rs.getInt("id"));
			users[i].setEmail(rs.getString("email"));
			users[i].setUsername(rs.getString("username"));
			users[i].setPassword(rs.getString("password"));
			users[i].setRegisterTime(rs.getDate("registertime"));
			users[i].setIdentityid(rs.getString("identityid"));
			users[i].setSex(rs.getInt("sex"));
			users[i].setTelephone(rs.getString("telephone"));
		}
		return users;
	}
}
