package shgt.logic;

import java.io.Serializable;
import java.sql.SQLException;

/**
 * 管理员类
 * 
 * @author ben
 * 
 */
public class Administrator implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 用户管理器
	 */
	private UserManager um = null;

	/**
	 * 物品分类管理器
	 */
	private TypeManager tm = null;

	/**
	 * 返回物品分类管理器
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
	 * 返回用户管理器
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
	 * 列出系统中所有的用户
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
	 * 列出系统中所有的物品分类
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
	 * 列出所有的帖子
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
