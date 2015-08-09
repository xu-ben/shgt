package shgt.logic;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * ����Ա��
 * 
 * @author ben
 * 
 */
public class Administrator implements Serializable {

	/**
	 * ���л�ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �û�������
	 */
	private UserManager um = null;

	/**
	 * ��Ʒ���������
	 */
	private TypeManager tm = null;

	/**
	 * ������Ʒ���������
	 */
	public TypeManager getTypeManager() {
		if (tm == null) {
			try {
				tm = new TypeManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tm;
	}

	/**
	 * �����û�������
	 * 
	 * @return
	 */
	public UserManager getUserManager() {
		if (um == null) {
			try {
				um = new UserManager();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return um;
	}

	/**
	 * �г�ϵͳ�����е��û�
	 * 
	 * @return
	 */
	public Member[] listAllUsers() {
		if (um == null) {
			getUserManager();
		}
		if (um != null) {
			try {
				return um.listAllUsers();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * �г�ϵͳ�����е���Ʒ����
	 * 
	 * @return
	 */
	public GoodsType[] listAllTypes() {
		if (tm == null) {
			getTypeManager();
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
	 * �г����е�����
	 * 
	 * @return
	 */
	public Post[] listAllPosts() {
		return null;
	}
	
	public CommentsManager getCommentsBrowser(Post p) {
		return null;
	}
}
