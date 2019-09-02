package yuanian.utils;

import java.util.List;

public class PageVo<T> {
	
	private Integer totalPage ;//总页数
	private Integer currentPage; // 当前页码
	private Integer totalCount;//总记录数
	private int limit;	// 每页显示的记录数
	private List<T> list; //记录集合
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public int getLimit() { return limit; }
	public void setLimit(int limit) { this.limit = limit; }
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
