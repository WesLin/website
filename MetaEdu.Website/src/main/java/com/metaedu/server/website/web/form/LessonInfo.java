package com.metaedu.server.website.web.form;

import java.util.Date;

import com.metaedu.server.utils.text.TimeUtils;

/** 课时编辑用信息
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class LessonInfo {

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
	
	/** 课程主键 */
	private String courseId = "";

	/** 课程主键 */
	public String getCourseId() {
		return courseId;
	}

	/** 课程主键 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	
	/** 课时名称 */
	private String name = "";

	/** 课时名称 */
	public String getName() {
		return name;
	}

	/** 课时名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 授课教师主键 */
	private String teacherId = "";

	/** 授课教师主键 */
	public String getTeacherId() {
		return teacherId;
	}

	/** 授课教师主键 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	
	/** 上课时间 */
	private Date beginTime = new Date();

	/** 上课时间 */
	public Date getBeginTime() {
		return beginTime;
	}

	/** 上课时间 */
	public void setBeginTime(String refBeginTime) {
		this.beginTime = TimeUtils.getDateFromString(refBeginTime);
	}
	
	/** 下课时间 */
	private Date overTime = new Date();

	/** 下课时间 */
	public Date getOverTime() {
		return overTime;
	}

	/** 下课时间 */
	public void setOverTime(String refOverTime) {
		this.overTime = TimeUtils.getDateFromString(refOverTime);
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
	
}
