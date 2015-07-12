package com.metaedu.server.business.metaweb;

import java.io.Serializable;
import java.util.List;

/** 课时摘要列表模型
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class LessonSummaryListModel extends DetailsListBaseModel implements Serializable {

	private static final long serialVersionUID = 8608219613273459277L;

	/** 课时摘要明细 */
	private List<LessonSummary> details = null;

	/** 课时摘要明细 */
	public List<LessonSummary> getDetails() {
		return details;
	}

	/** 课时摘要明细 */
	public void setDetails(List<LessonSummary> details) {
		this.details = details;
	}
	
	
}
