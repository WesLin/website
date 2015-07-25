package com.metaedu.server.business.education;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.metaedu.server.utils.text.TimeUtils;

/** 班级类
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 9093519711108490614L;
	
	/** 构造函数
	 * @param refIsInit 是否新建
	 * @param refInstitutionOrCourseId 机构或者课程主键
	 */
	public Course(boolean refIsInit, String refInstitutionOrCourseId) {
		if (refIsInit) { // 如果是新建
			this.id = refInstitutionOrCourseId + "-" + TimeUtils.getNebulaTimestamp(new Date());
			this.institutionId = refInstitutionOrCourseId;
		} else { // 如果是赋值
			this.id = refInstitutionOrCourseId;
		}
	}
	
	/** 课程主键 */
	//private String id = HashUtils.getUuidCompact();
	private String id = "";

	/** 获取课程主键 */
	public String getId() {
		return id;
	}

	/** 设置课程主键 */
	public void setId(String id) {
		this.id = id;
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
	
	/** 科目类型 */
	private int subjectType = Subject.ID_UNPOINTED_SUBJECT;

	/** 获取科目类型 */
	public int getSubjectType() {
		return subjectType;
	}

	/** 设置科目类型 */
	public void setSubjectType(int subjectType) {
		this.subjectType = subjectType;
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
	
	/** 是否有效班级 */
	private boolean isValid = true;

	/** 获取是否有效班级 */
	public boolean getIsValid() {
		return isValid;
	}

	/** 设置是否有效班级 */
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
	
	/** 获取据此课程创建的群组名称
	 * @return
	 */
	public String getGroupName() {
		Calendar ca = Calendar.getInstance();
		ca.setTime(this.beginTime);
		String curYear = String.valueOf(ca.get(Calendar.YEAR));
		int curMonthValue = ca.get(Calendar.MONTH) + 1;
		String curMonth = curMonthValue < 10 ? "0" + curMonthValue : "" + curMonthValue;
		return curYear + "." + curMonth + " " + this.getName();
	}
	
}
