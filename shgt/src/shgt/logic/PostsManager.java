package shgt.logic;

import java.sql.ResultSet;
import java.sql.SQLException;
import shgt.control.DBOperator;

/**
 * 帖子浏览器
 * 
 * @author ben
 * 
 */
public class PostsManager {

	/**
	 * 结果集
	 */
	private ResultSet rs = null;

	/**
	 * 当前页码
	 */
	private int curPageNum;

	/**
	 * 当前帖子所在帖子号
	 */
	private int curPostNum;

	/**
	 * 总帖子数
	 */
	private int totalPostNum;

	/**
	 * 总页数
	 */
	private int totalPageNum;

	/**
	 * 当前页
	 */
	private Post[] curPage = null;

	/**
	 * 一页中需要几条帖子
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
	 * 更新帖子列表
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
	 * 返回第index条帖子
	 * 
	 * @param index从1开始编号
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
	 * 返回帖子总数
	 * 
	 * @return
	 */
	public int getTotalPostNum() {
		return totalPostNum;
	}

	/**
	 * 返回需要多少页才能显示完所有帖子
	 * 
	 * @return
	 */
	public int getTotalPageNum() {
		return this.totalPageNum;
	}

	/**
	 * 下一页
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
	 * 上一页
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
	 * 返回帖子号在[start,end]区间的所有帖子
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
	 * 返回第一页
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
	 * 返回当前页
	 * 
	 * @return
	 */
	public Post[] getCurPage() {
		return curPage;
	}

	/**
	 * 转到第index页
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
	 * 返回当前所在页码
	 * @return
	 */
	public int getCurPageNum() {
		return this.curPageNum;
	}
}
