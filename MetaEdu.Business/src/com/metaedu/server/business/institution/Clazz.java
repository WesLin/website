package com.metaedu.server.business.institution;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.education.EduSystem;
import com.metaedu.server.business.education.Grade;
import com.metaedu.server.utils.text.HashUtils;

/** 班级类
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Clazz implements Serializable {

	private static final long serialVersionUID = 2000785229468705414L;
	
	/** 班级主键 UUID */
	private String id = HashUtils.getUuidCompact();

	/** 获取班级主键 UUID */
	public String getId() {
		return id;
	}

	/** 设置班级主键 UUID */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 关联机构编号 */
	private String institutionId = "";

	/** 获取关联机构编号 */
	public String getInstitutionId() {
		return institutionId;
	}

	/** 设置关联机构编号 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}
	
	/** 班级名称 */
	private String name;

	/** 获取班级名称 */
	public String getName() {
		return name;
	}

	/** 设置班级名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 班级类型，默认行政班 */
	private int clazzType = ClazzType.ADMIN;

	/** 获取行政班类型 */
	public int getClazzType() {
		return clazzType;
	}

	/** 设置行政班类型 */
	public void setClazzType(int clazzType) {
		this.clazzType = clazzType;
	}
	
	/** 学制类型 */
	private int eduSystemType = EduSystem.ID_CHINA_MAINLAND_GAOZHONG;
	
	/** 获取学制类型 */
	public int getEduSystemType() {
		return eduSystemType;
	}

	/** 设置学制类型 */
	public void setEduSystemType(int eduSystemType) {
		this.eduSystemType = eduSystemType;
	}
	
	/** 获取学制 */
	public EduSystem getEduSystem() {
		return EduSystem.getEdySystem(this.eduSystemType);
	}

	/** 开始时间 */
	private Date beginTime = new Date();

	/** 获取开始时间 */
	public Date getBeginTime() {
		return beginTime;
	}

	/** 设置开始时间 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/** 开始年级类型，默认高一 */
	private int beginGradeType = Grade.ID_CHINA_MAINLAND_GAO_1;

	/** 获取开始年级 */
	public int getBeginGradeType() {
		return beginGradeType;
	}

	/** 设置开始年级类型 */
	public void setBeginGradeType(int beginGradeType) {
		this.beginGradeType = beginGradeType;
	}
	
	/** 获取开始年级实体 */
	public Grade getBeginGrade() {
		return Grade.getGrade(this.beginGradeType);
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
	
	/** 获取据此班级创建的群组名称
	 * @return
	 */
	public String getGroupName() {
		//int curYear = this.beginTime.get
		Calendar ca = Calendar.getInstance();
		ca.setTime(this.beginTime);
		String curYear = String.valueOf(ca.get(Calendar.YEAR)).substring(2);
		return curYear + "届 " + Grade.getGrade(this.getBeginGradeType()).getNameValue(LanguageType.SIMPLIFIED_CHINESE) + " " + this.getName();
	}
	
	
	
	
}
