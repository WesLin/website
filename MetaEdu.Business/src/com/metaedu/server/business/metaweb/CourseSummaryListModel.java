package com.metaedu.server.business.metaweb;

import java.io.Serializable;
import java.util.List;

/** 课程摘要列表模型
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class CourseSummaryListModel extends DetailsListBaseModel implements Serializable {

	private static final long serialVersionUID = -9016084481966399355L;
	
	/** 课程摘要明细 */
	private List<CourseSummary> details = null;

	/** 课程摘要明细 */
	public List<CourseSummary> getDetails() {
		return details;
	}

	/** 课程摘要明细 */
	public void setDetails(List<CourseSummary> details) {
		this.details = details;
	}

}
