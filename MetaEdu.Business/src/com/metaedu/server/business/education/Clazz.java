package com.metaedu.server.business.education;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.metaedu.server.business.common.BasicValue;
import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.finance.Currency;
import com.metaedu.server.business.sharing.SharingLevel;
import com.metaedu.server.utils.text.TimeUtils;

/** 班级类
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Clazz implements Serializable {

	private static final long serialVersionUID = 2000785229468705414L;
	
	
	/** 构造函数
	 * @param refIsInit 是初始化还是赋值
	 * @param refInstitutionId 机构编号
	 */
	public Clazz(boolean refIsInit, String refInstitutionOrClazzId) {
		if (refIsInit) { // 如果是新建
			this.institutionId = refInstitutionOrClazzId;
			this.id = this.institutionId + "-" + TimeUtils.getNebulaTimestamp(new Date());
		} else { // 如果是赋值
			this.id = refInstitutionOrClazzId;
		}
	}
	
	/** 班级主键 UUID */
	//private String id = HashUtils.getUuidCompact();
	private String id = "";

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
	
	/** 班级类型，默认普通班级 */
	private int clazzType = ClazzType.NORMAL;

	/** 获取行政班类型 */
	public int getClazzType() {
		return clazzType;
	}

	/** 设置行政班类型 */
	public void setClazzType(int clazzType) {
		this.clazzType = clazzType;
	}
	
	/** 是否选修班级 */
	private boolean isSelective = false;
	
	/** 是否选修班级 */
	public boolean getIsSelective() {
		return isSelective;
	}

	/** 是否选修班级 */
	public void setIsSelective(boolean refIsSelective) {
		this.isSelective = refIsSelective;
	}
	
	/** 开放报名时间，仅选修班需要设置，默认无开放时间 */
	private Date openTime = BasicValue.UNDEFINED_DATE;
	
	/** 开放报名时间，仅选修班需要设置 */
	public Date getOpenTime() {
		return openTime;
	}

	/** 开放报名时间，仅选修班需要设置 */
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	
	/** 关闭报名时间，仅选修班需要设置，默认无开放时间 */
	private Date closeTime = BasicValue.UNDEFINED_DATE;
	
	/** 关闭报名时间，仅选修班需要设置 */
	public Date getCloseTime() {
		return closeTime;
	}

	/** 关闭报名时间，仅选修班需要设置 */
	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
	
	/** 报班人数限制，默认无（或跟随机构默认人数上限）*/
	private int memberLimit = 0;
	
	/** 报班人数限制，默认无（或跟随机构默认人数上限）*/
	public int getMemberLimit() {
		return memberLimit;
	}

	/** 报班人数限制，默认无（或跟随机构默认人数上限）*/
	public void setMemberLimit(int refMemberLimit) {
		this.memberLimit = refMemberLimit;
	}
	
	/** 结算货币类型，默认人民币 */
	private int currencyType = Currency.ID_CNY;
	
	/** 结算货币类型 */
	public int getCurrencyType() {
		return currencyType;
	}

	/** 结算货币类型 */
	public void setCurrencyType(int currencyType) {
		this.currencyType = currencyType;
	}
	
	/** 购买费用，以分计算 */
	private int joinCost = 0;
	
	/** 购买费用，以分计算 */
	public int getJoinCost() {
		return joinCost;
	}

	/** 购买费用，以分计算 */
	public void setJoinCost(int refJoinCost) {
		this.joinCost = refJoinCost;
	}
	
	/** 班级共享级别，默认私有 */
	private int sharingLevel = SharingLevel.PRIVATE;

	/** 班级共享级别，默认私有 */
	public int getSharingLevel() {
		return sharingLevel;
	}

	/** 班级共享级别，默认私有 */
	public void setSharingLevel(int sharingLevel) {
		this.sharingLevel = sharingLevel;
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
		String curYear = String.valueOf(ca.get(Calendar.YEAR));
		int curMonthValue = ca.get(Calendar.MONTH) + 1;
		String curMonth = curMonthValue < 10 ? "0" + curMonthValue : "" + curMonthValue;
		if (clazzType == ClazzType.ADMIN) { // 如果是行政班
			return curYear + " " + Grade.getGrade(this.getBeginGradeType()).getNameValue(LanguageType.SIMPLIFIED_CHINESE) + " " + this.getName();
		} else { // 如果是其他类型（教学与公开班等）
			return curYear + "." + curMonth + " " + Grade.getGrade(this.getBeginGradeType()).getNameValue(LanguageType.SIMPLIFIED_CHINESE) + " " + this.getName();
		}
	}
	
	
	
	
}
