package shgt.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

public class TypeManager {

	/**
	 * 结果集
	 */
	private ResultSet rs = null;

	/**
	 * 物品分类总量
	 */
	private int totalTypes;

	public TypeManager() throws SQLException {
		init();
	}
	
	public void init() throws SQLException {
		rs = DBOperator.getTypesSet();
		rs.last();
		totalTypes = rs.getRow();
	}
	
	/**
	 * 从数据库中删除某一物品分类记录
	 * @param id
	 * @return
	 */
	public boolean deleteTypeByid(int id) {
		try {
			DBOperator.deleteTypeByid(id);
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
	 * 列出系统中所有的物品分类,按类型的名称排序
	 * 
	 * @return
	 * @throws SQLException 
	 */
	public GoodsType[] listAllTypes() throws SQLException {
		if (rs == null) {
			return null;
		}
		GoodsType[] gts = new GoodsType[totalTypes];
		rs.beforeFirst();
		int i = 0;
		while (rs.next()) {
			gts[i] = new GoodsType();
			gts[i].setTypeid(rs.getInt("id"));
			gts[i].setTypeName(rs.getString("type"));
			i++;
		}
		return gts;
	}

}
