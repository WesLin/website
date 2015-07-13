package com.metaedu.server.business.metaweb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.metaedu.server.business.education.Subject;

/** 课程摘要
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class CourseSummary {

	/** 课程编号 */
	private String id="";

	/** 课程编号 */
	public String getId() {
		return id;
	}

	/** 课程编号 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 课程名称 */
	private String name = "";

	/** 获取课程名称 */
	public String getName() {
		return name;
	}

	/** 设置课程名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 机构主键 */
	private String institutionId = "";

	/** 获取机构主键 */
	public String getInstitutionId() {
		return institutionId;
	}

	/** 设置机构主键 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	
	/** 所属机构名称 */
	private String institutionName = "";
	
	/** 所属机构名称 */
	public String getInstitutionName() {
		return institutionName;
	}

	/** 所属机构名称 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	/** 科目类型 */
	private int subjectType = Subject.ID_CHINA_GAOZHONG_YUWEN;

	/** 获取科目类型 */
	public int getSubjectType() {
		return subjectType;
	}

	/** 设置科目类型 */
	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}

	/** 授课教师摘要列表 */
	public List<UserSummary> teacherSummaries = new ArrayList<UserSummary>();
	
	/** 授课教师摘要列表 */
	public List<UserSummary> getTeacherSummaries() {
		return teacherSummaries;
	}

	/** 授课教师摘要列表 */
	public void setTeacherSummaries(List<UserSummary> teacherSummaries) {
		this.teacherSummaries = teacherSummaries;
	}

	/** 起始时间 */
	private Date beginTime = new Date();

	/** 获取起始时间 */
	public Date getBeginTime() {
		return beginTime;
	}

	/** 设置起始时间 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/** 结束时间 */
	private Date overTime = new Date();

	/** 获取结束时间 */
	public Date getOverTime() {
		return overTime;
	}

	/** 设置结束时间 */
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	
	
	
	
}
