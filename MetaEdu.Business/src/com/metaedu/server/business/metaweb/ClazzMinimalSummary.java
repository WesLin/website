package com.metaedu.server.business.metaweb;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.education.ClazzType;
import com.metaedu.server.business.education.EduSystem;
import com.metaedu.server.business.education.Grade;

/** 班级最小摘要
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class ClazzMinimalSummary implements Serializable {

	private static final long serialVersionUID = -4157332993126132293L;
	
	/** 班级主键 UUID */
	private String id = "";

	/** 获取班级主键 UUID */
	public String getId() {
		return id;
	}

	/** 设置班级主键 UUID */
	public void setId(String id) {
		this.id = id;
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
	
	/** 学制类型 */
	private int eduSystemType = EduSystem.ID_UNLIMITED_SYSTEM;
	
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
	
	/** 开始年级类型，默认未指定 */
	private int beginGradeType = Grade.ID_UNLIMITED_GRADE;

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
	
	/** 获取班级全名 */
	public String getFullName() {
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(this.beginTime);
		String curYearStr = String.valueOf(beginCal.get(Calendar.YEAR)).substring(2);
		if (this.clazzType == ClazzType.ADMIN) { // 如果是行政班
			// 计算升级差异
			Date curDate = new Date();
			long curTime = curDate.getTime();
			int yearDiff = (int)Math.floor((curTime - beginCal.getTime().getTime())/(1000 * 60 * 60 * 24 *365));
			if (yearDiff >= 0) { // 如果是当前时间前开始的班级
				Grade curGrade = this.getEduSystem().getDiffGrade(yearDiff);
				if (curGrade != null) { // 如果尚未毕业
					return curGrade.getNameValue(LanguageType.SIMPLIFIED_CHINESE) + this.name;
				} // 如果已经毕业，交给后面处理
			}
			// 如果是未开始的班级或已经毕业的班级
			return curYearStr + "届 " + this.name;
		} else { // 如果是教学班
			int curMonth = beginCal.get(Calendar.MONTH) + 1;
			String curMonthStr = curMonth < 10 ? "0" + String.valueOf(curMonth) : String.valueOf(curMonth);
			return curYearStr + "." + curMonthStr + " " + this.name;
		}
	}
	
	

}
