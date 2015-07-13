package com.metaedu.server.business.data.interfaces.metaweb;

import java.util.List;

import com.metaedu.server.business.metaweb.CourseSummary;
import com.metaedu.server.business.metaweb.InstitutionSummary;
import com.metaedu.server.business.metaweb.LessonSummary;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;

/** Meta 站点数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IMetaWebData {
	
	/** 根据机构的各类名称输出相近机构摘要信息
	 * @param refName 机构各类名称
	 * @return
	 */
	public List<InstitutionSummary> getInstitutionSummaryByName(String refName);
	
	/** 获取指定机构和工号或学号的用户摘要信息（1.0 版本简化登录用）
	 * @param refInstitutionId
	 * @param refCharacterNumber
	 * @return
	 */
	public UserSummary getUserSummary(String refInstitutionId, String refCharacterNumber);
	
	/** 获取指定条件的相关教师摘要
	 * @param refInstitutionId 指定的机构
	 * @param refCourseId 指定的课程，指定为 Null 则不限制
	 * @return
	 */
	public List<UserSummary> getTeacherSummaries(String refInstitutionId, String refCourseId);
	
	/** 获取指定条件的课程摘要列表
	 * @param refInstitutionId 指定的机构
	 * @param refCourseId 指定的课程编号，null 或者空字符串为不限制
	 * @param refSubjectType 指定的科目类型，0为不限制
	 * @param isBeforeOver 是否仅显示关闭时间前的课程
	 * @param isTeacherFilled 是否附加教师信息
	 * @param isClazzFilled 是否附加班级信息
	 * @return
	 */
	public List<CourseSummary> getCourseSummaries(String refInstitutionId, String refCourseId, int refSubjectType, boolean isBeforeOver, boolean isTeacherFilled, boolean isClazzFilled);
	
	/** 获取指定条件的课时摘要列表
	 * @param refCourseId
	 * @return
	 */
//	public List<LessonSummary> getLessonSummaries(String refCourseId);
	
	/** 获取指定机构的课时摘要列表模型（按日期排序）
	 * @param refInstitutionId 指定机构的编号
	 * @param refUserId 用户主键
	 * @param refCharacterType 角色类型
	 * @param refSubjectType 指定的科目种类，0为不限
	 * @param refCourseId 指定的课程编号，null为不限
	 * @param refDetailsPerPage 每页显示的条目数量
	 * @param refCurrentPage 指定的页数
	 * @return
	 */
	public LessonSummaryListModel getLessonSummaryListModel(String refInstitutionId, String refUserId, int refCharacterType, int refSubjectType, String refCourseId, int refDetailsPerPage, int refCurrentPage);
	
	
	
	
}
