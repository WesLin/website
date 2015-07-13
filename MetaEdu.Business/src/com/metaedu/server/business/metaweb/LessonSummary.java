package com.metaedu.server.business.metaweb;

import java.io.Serializable;
import java.util.Date;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.education.Subject;
import com.metaedu.server.utils.text.TimeUtils;

/** 课时摘要
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class LessonSummary implements Serializable {

	private static final long serialVersionUID = 6886327022345269080L;
	
	/** 课次主键 */
	private String id = "";

	/** 获取课次主键 */
	public String getId() {
		return id;
	}

	/** 设置课次主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 课时名称 */
	private String name = "";

	/** 获取课时名称 */
	public String getName() {
		return name;
	}

	/** 设置课时名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 关联课程主键 */
	private String courseId = "";

	/** 获取关联课程主键 */
	public String getCourseId() {
		return courseId;
	}

	/** 设置关联课程主键 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	/** 关联课程名称 */
	private String courseName = "";
	
	/** 关联课程名称 */
	public String getCourseName() {
		return courseName;
	}

	/** 关联课程名称 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	/** 课程学科种类 */
	private int subjectType = Subject.ID_CHINA_GAOZHONG_OTHER;

	/** 课程学科种类 */
	public int getSubjectType() {
		return subjectType;
	}

	/** 课程学科种类 */
	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
	}
	
	/** 获取学科名称（简体中文）*/
	public String getSubjectName() {
		return Subject.getSubject(this.subjectType).getNameValue(LanguageType.SIMPLIFIED_CHINESE);
	}

	/** 上课教师编号 */
	private String teacherId = "";

	/** 获取上课教师编号 */
	public String getTeacherId() {
		return teacherId;
	}

	/** 设置上课教师编号 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	/** 上课教师姓名 */
	private String teacherName = "";
	
	/** 上课教师姓名 */
	public String getTeacherName() {
		return teacherName;
	}

	/** 上课教师姓名 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/** 上课开始时间 */
	private Date beginTime = new Date();

	/** 获取上课开始时间 */
	public Date getBeginTime() {
		return beginTime;
	}

	/** 设置上课开始时间 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/** 获取上课时间简单显示 */
	public String getBeginTimeText() {
		return TimeUtils.getShortTimeText(this.beginTime);
	}
	
	/** 下课时间 */
	private Date overTime = new Date();

	/** 获取下课时间 */
	public Date getOverTime() {
		return overTime;
	}

	/** 设置下课时间 */
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	/** 获取下课时间简单显示 */
	public String getOverTimeText() {
		return TimeUtils.getShortTimeText(this.overTime);
	}
	
	/** 是否需要录像 */
	private boolean recordNeed = false;

	/** 是否需要录像 */
	public boolean getRecordNeed() {
		return recordNeed;
	}

	/** 是否需要录像 */
	public void setRecordNeed(boolean recordNeed) {
		this.recordNeed = recordNeed;
	}
	
	/** 录像是否就绪 */
	private boolean recordReady = false;

	/** 录像是否就绪 */
	public boolean getRecordReady() {
		return recordReady;
	}

	/** 录像是否就绪 */
	public void setRecordReady(boolean recordReady) {
		this.recordReady = recordReady;
	}
	
	
	
	
}
