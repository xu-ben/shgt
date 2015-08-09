package shgt.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import shgt.control.DBOperator;

/**
 * ���������
 * 
 * @author ben
 * 
 */
public class PostsManager {

	/**
	 * �����
	 */
	private ResultSet rs = null;

	/**
	 * ��ǰҳ��
	 */
	private int curPageNum;

	/**
	 * ��ǰ�����������Ӻ�
	 */
	private int curPostNum;

	/**
	 * ��������
	 */
	private int totalPostNum;

	/**
	 * ��ҳ��
	 */
	private int totalPageNum;

	/**
	 * ��ǰҳ
	 */
	private Post[] curPage = null;

	/**
	 * һҳ����Ҫ��������
	 */
	private int postNumInAPage;

	public PostsManager() throws SQLException {
		rs = DBOperator.getPostsSet();
		postNumInAPage = 10;
		init();
	}
	
	public PostsManager(String keyword) throws SQLException {
		rs = DBOperator.getPostsSet(keyword);
		postNumInAPage = 10;
		init();
	}

	public PostsManager(int typeid) throws SQLException {
		rs = DBOperator.getPostsSet(typeid);
		postNumInAPage = 10;
		init();
	}

	/**
	 * ���������б�
	 * 
	 * @throws SQLException
	 */
	public void init() throws SQLException {
		rs.last();
		totalPostNum = rs.getRow();
		if (totalPostNum % postNumInAPage == 0) {
			totalPageNum = totalPostNum / postNumInAPage;
		} else {
			totalPageNum = totalPostNum / postNumInAPage + 1;
		}
		curPageNum = 0;
		curPostNum = 0;
	}

	/**
	 * ���ص�index������
	 * 
	 * @param index��1��ʼ���
	 * @return
	 * @throws SQLException
	 */
	public Post getPost(int index) throws SQLException {
		if (index < 1 || index > totalPostNum)
			return null;
		rs.moveToCurrentRow();
		if (curPostNum > index) {
			while (curPostNum > index) {
				rs.previous();
				curPostNum--;
			}
		} else if (curPostNum < index) {
			while (curPostNum < index) {
				rs.next();
				curPostNum++;
			}
		}
		Post p = new Post();
		p.setId(rs.getInt("id"));
		p.setTitle(rs.getString("title"));
		p.setDetail_info(rs.getString("post_info"));
		p.setReleaseDate(rs.getDate("releaseDate"));
		p.setType(rs.getInt("type"));
		p.setUser_id(rs.getInt("p_user_id"));
		return p;
	}

	/**
	 * ������������
	 * 
	 * @return
	 */
	public int getTotalPostNum() {
		return totalPostNum;
	}

	/**
	 * ������Ҫ����ҳ������ʾ����������
	 * 
	 * @return
	 */
	public int getTotalPageNum() {
		return this.totalPageNum;
	}

	/**
	 * ��һҳ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Post[] nextPage() {
		try {
			if (curPageNum == 0) {
				return getFirstPage();
			}
			if (curPageNum >= totalPageNum) {
				return this.curPage;
			}
			int s = curPageNum * this.postNumInAPage + 1;
			int e = s + this.postNumInAPage - 1;
			if (e < this.totalPostNum) {
				e = this.totalPostNum;
			}
			curPage = getPostsOfInterval(s, e);
			curPageNum++;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return curPage;
	}

	/**
	 * ��һҳ
	 * 
	 * @throws SQLException
	 */
	public Post[] lastPage() {
		try {
			if (curPageNum == 0) {
				return getFirstPage();
			}
			if (curPageNum == 1) {
				return this.curPage;
			}
			int s = (curPageNum - 1) * this.postNumInAPage + 1;
			int e = s + this.postNumInAPage - 1;
			curPage = getPostsOfInterval(s, e);
			curPageNum--;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return curPage;
	}

	/**
	 * �������Ӻ���[start,end]�������������
	 * 
	 * @param start
	 * @param end
	 * @return
	 * @throws SQLException
	 */
	public Post[] getPostsOfInterval(int start, int end) throws SQLException {
		int num = end - start + 1;
		Post[] pt = new Post[num];
		rs.absolute(start);
		for (int i = 0; i < num; i++) {
			pt[i] = new Post();
			pt[i].setId(rs.getInt("id"));
			pt[i].setTitle(rs.getString("title"));
			pt[i].setDetail_info(rs.getString("post_info"));
			pt[i].setReleaseDate(rs.getDate("releaseDate"));
			pt[i].setType(rs.getInt("type"));
			pt[i].setUser_id(rs.getInt("p_user_id"));
			rs.next();
		}
		curPostNum = end;
		return pt;
	}

	/**
	 * ���ص�һҳ
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Post[] getFirstPage() {
		if (curPageNum == 1) {
			return curPage;
		}
		try {
			if (totalPageNum <= 0) {
				return null;
			} else if (totalPageNum <= 1) {
				curPage = getPostsOfInterval(1, totalPostNum);
			} else {
				curPage = getPostsOfInterval(1, postNumInAPage);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		curPageNum = 1;
		return curPage;
	}

	/**
	 * ���ص�ǰҳ
	 * 
	 * @return
	 */
	public Post[] getCurPage() {
		return curPage;
	}

	/**
	 * ת����indexҳ
	 * 
	 * @param index
	 * @return
	 */
	public Post[] toPage(int index) {
		// if (index <= 0 || index > pageNum) {
		return null;
		// }
		// int s = (index - 1) * postNumInAPage;
		// int e = postnum - s;
		// if (e > postNumInAPage) {
		// e = postNumInAPage;
		// }
		// Post[] ans = new Post[e];
		// for (int i = 0; i < e; i++) {
		// ans[i] = posts[s + i];
		// }
		// curPage = index;
		// return ans;
	}

	/**
	 * ���ص�ǰ����ҳ��
	 * @return
	 */
	public int getCurPageNum() {
		return this.curPageNum;
	}
}
