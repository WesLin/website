package com.metaedu.server.business.metaweb;

import java.io.Serializable;

/** 明细列表基类模型
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class DetailsListBaseModel implements Serializable {

	private static final long serialVersionUID = -6197687965176845597L;
	
	/** 条目总计 */
	private int detailsCount = 0;

	/** 条目总计 */
	public int getDetailsCount() {
		return detailsCount;
	}

	/** 条目总计 */
	public void setDetailsCount(int detailsCount) {
		this.detailsCount = detailsCount;
	}
	
	/** 每页显示的条目数量，默认20条 */
	private int detailsPerPage = 20;

	/** 每页显示的条目数量，默认20条 */
	public int getDetailsPerPage() {
		return detailsPerPage;
	}

	/** 每页显示的条目数量，默认20条 */
	public void setDetailsPerPage(int detailsPerPage) {
		if (detailsPerPage > 0) this.detailsPerPage = detailsPerPage;
		else detailsPerPage = 20;
	}
	
	/** 获取页数统计 */
	public int getPageCount() {
		if (this.detailsPerPage > 0) return (int)Math.ceil((double)this.detailsCount/(double)this.detailsPerPage);
		else return 0;
	}
	
	/** 当前页位置 */
	private int currentPage = 1;

	/** 当前页位置 */
	public int getCurrentPage() {
		return currentPage;
	}

	/** 当前页位置 */
	public void setCurrentPage(int refCurrentPage) {
		if (refCurrentPage > 0) this.currentPage = refCurrentPage;
		else this.currentPage = 1;
	}
	
	
	
	
}
