package com.metaedu.server.business.education;

import java.io.Serializable;
import java.util.Date;

import com.metaedu.server.utils.text.TimeUtils;

/** 课次类
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Lesson implements Serializable {

	private static final long serialVersionUID = 3352290446456449183L;

	/** 构造函数
	 * @param refIsInit 是否初始化
	 * @param refLessonOrInstitutionId 课次主键或对应的机构主键
	 */
	public Lesson(boolean refIsInit, String refLessonOrInstitutionId) {
		if (refIsInit) { // 如果是新建
			this.courseId = refLessonOrInstitutionId;
			this.id = refLessonOrInstitutionId + "-" + TimeUtils.getNebulaTimestamp(new Date()); // 33位
		} else { // 如果是赋值
			this.id = refLessonOrInstitutionId;
		}
	}
	
	/** 课次主键 */
//	private String id = HashUtils.getUuidCompact();
	private String id = "";

	/** 获取课次主键 */
	public String getId() {
		return id;
	}

	/** 设置课次主键 */
//	public void setId(String id) {
//		this.id = id;
//	}
	
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
	
	/** 是否需要录像（默认否）*/
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

	/** 是否有效 */
	private boolean isValid = true;

	/** 获取是否有效 */
	public boolean getIsValid() {
		return isValid;
	}

	/** 设置是否有效 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/** 创建时间 */
	private Date createTime = new Date();

	/** 获取创建时间 */
	public Date getCreateTime() {
		return createTime;
	}

	/** 设置创建时间 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** 更新时间 */
	private Date updateTime = new Date();

	/** 获取更新时间 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/** 设置更新时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
	
}
