package shgt.logic;

import java.sql.ResultSet;
import java.sql.SQLException;

import shgt.control.DBOperator;

public class TypeManager {

	/**
	 * �����
	 */
	private ResultSet rs = null;

	/**
	 * ��Ʒ��������
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
	 * �����ݿ���ɾ��ĳһ��Ʒ�����¼
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
	 * �г�ϵͳ�����е���Ʒ����,�����͵���������
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
