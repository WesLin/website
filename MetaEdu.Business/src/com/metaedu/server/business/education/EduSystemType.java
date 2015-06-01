package com.metaedu.server.business.education;

import java.util.ArrayList;

import com.metaedu.server.business.common.Area;
import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.common.MultiNameOwner;

/** 学制类型
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class EduSystemType implements MultiNameOwner<EduSystemName> {
	
	/** 学制值：大陆幼儿园 */
	public static final int ID_CHINA_MAINLAND_YOUERYUAN = 101001; 
	/** 学制类型：大陆幼儿园 */
	public static EduSystemType SYSTEM_CHINA_MAINLAND_YOUERYUAN = null;
	
	/** 学制值：大陆小学（6年制）*/
	public static final int ID_CHINA_MAINLAND_XIAOXUE = 102001;
	/** 学制类型：大陆小学（6年制）*/
	public static EduSystemType SYSTEM_CHINA_MAINLAND_XIAOXUE = null;
	
	/** 学制值：大陆初中（3年制）*/
	public static final int ID_CHINA_MAINLAND_CHUZHONG = 103001;
	/** 学制类型：大陆初中（3年制）*/	
	public static EduSystemType SYSTEM_CHINA_MAINLAND_CHUZHONG = null;
	
	/** 学制值：大陆高中（3年制）*/
	public static final int ID_CHINA_MAINLAND_GAOZHONG = 104001;
	/** 学制类型：大陆高中（3年制）*/	
	public static EduSystemType SYSTEM_CHINA_MAINLAND_GAOZHONG = null;
	
	/** 学制值：大陆大学本科 */
	public static final int ID_CHINA_MAINLAND_DAXUE = 106001;
	/** 学制类型：大陆大学本科 */	
	public static EduSystemType SYSTEM_CHINA_MAINLAND_DAXUE = null;
	
	
	/** 学制编号（主键）*/
	private int _id = 0;
	
	/** 获取学制编号（主键）
	 * @return
	 */
	public int getId() {
		return this._id;
	}
	
	/** 学制关联地区（暂不使用）*/
	private ArrayList<Area> _areas = null;
	
	/** 获取学制关联地区（暂不使用）
	 * @return
	 */
	public ArrayList<Area> getAreas() {
		return this._areas;
	}
	
	/** 相关年级 */
	private ArrayList<GradeType> _grades = new ArrayList<GradeType>();
	
	/** 获取相关年级
	 * <p>相关年级按照编号从小到大排列，以利于升级计算</p>
	 * @return
	 */
	public ArrayList<GradeType> getGrades() {
		return this._grades;
	}
	
	/** 起始年级 */
	private GradeType _gradeStart = null;
	
	/** 获得起始年级
	 * @return
	 */
	public GradeType getGradeStart() {
		return this._gradeStart;
	}
	
	/** 结束年级 */
	private GradeType _gradeOver = null;
	
	/** 获得结束年级
	 * @return
	 */
	public GradeType getGradeOver() {
		return this._gradeOver;
	}
	
	/** 获取下一个年级（如果没有下一个年级则返回 NULL）
	 * @param refGradeValue 当前的年级值（ID）
	 * @return 下一个年级或者 NULL
	 */
	public GradeType getGradeNext(int refGradeValue) {
		if (this._grades.size() > 0) {
			for (int i=0; i<this._grades.size(); i++) {
				if (this._grades.get(i).getId() > refGradeValue) return this._grades.get(i);
			}
		}
		return null;
	} 
	
	/** 插入年级类型
	 * @param refGradeType
	 */
	public void addGrade(GradeType refGradeType) {
		if (this._grades.size() > 0) { // 如果已存在年级队列
			boolean isInserted = false; // 是否中途已经插入
			int curGradesSize = this._grades.size();
			for (int i=0; i<curGradesSize; i++) { // 遍历所有的年级队列
				GradeType tmpGrade = this._grades.get(i);
				if (tmpGrade.getId() >= refGradeType.getId()) { // 
					this._grades.add(i, refGradeType);
					if (i == 0) this._gradeStart = refGradeType; // 如果是插入首位，则 gradeStart 设为新加的 GradeType
					isInserted = true;
					break;
				}
			}
			if (!isInserted) { // 如果中途没有插入
				this._grades.add(refGradeType);
				this._gradeOver = refGradeType;
			}
		} else {
			this._grades.add(refGradeType);
			this._gradeStart = refGradeType;
			this._gradeOver = refGradeType;
		}
	}
	
	/** 学制名称集合 */
	public ArrayList<EduSystemName> _names = new ArrayList<EduSystemName>();
	
	/** 获取学制名称集合
	 * @return
	 */
	public ArrayList<EduSystemName> getNames() {
		return this._names;
	}
	
	/** 添加学制名称
	 * @param refName
	 */
	public void addName(EduSystemName refName) {
		this._names.add(refName);
	}
	
	/** 获取指定语言类型的学制名称对象
	 * @param refLanguageType 指定的语言类型
	 * @return
	 */
	public EduSystemName getName(int refLanguageType) {
		for (EduSystemName curName : this._names) {
			if (curName.getLanguageType() == refLanguageType) return curName;
		}
		return null;
	}
	
	/** 获取指定语言类型的学制名称
	 * @param refLanguageType 指定的语言类型
	 * @return
	 */
	public String getNameValue(int refLanguageType) {
		for (EduSystemName curName : this._names) {
			if (curName.getLanguageType() == refLanguageType) return curName.getName();
		}
		return "no defined edu-system name";
	}
	
	/** 构造函数
	 * @param refId 学制编号
	 */
	public EduSystemType(int refId) {
		this._id = refId;
	}
	
	/** 静态执行 */
	static {
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN = new EduSystemType(EduSystemType.ID_CHINA_MAINLAND_YOUERYUAN);
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addName(new EduSystemName("幼儿园（大陆）", LanguageType.SIMPLIFIED_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addName(new EduSystemName("幼稚園（大陸）", LanguageType.TRADTIONAL_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addName(new EduSystemName("Kindergarden And Pre-K (China Mainland)", LanguageType.ENGLISH));
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addGrade(GradeType.GRADE_CHINA_MAINLAND_YOU_1);
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addGrade(GradeType.GRADE_CHINA_MAINLAND_YOU_2);
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addGrade(GradeType.GRADE_CHINA_MAINLAND_YOU_3);
		EduSystemType.SYSTEM_CHINA_MAINLAND_YOUERYUAN.addGrade(GradeType.GRADE_CHINA_MAINLAND_YOU_4);
		
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE = new EduSystemType(EduSystemType.ID_CHINA_MAINLAND_XIAOXUE);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addName(new EduSystemName("小学（大陆六年制）", LanguageType.SIMPLIFIED_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addName(new EduSystemName("小學（大陸六年制）", LanguageType.TRADTIONAL_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addName(new EduSystemName("Grade 1-6 (China Mainland)", LanguageType.ENGLISH));
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_1);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_2);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_3);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_4);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_5);
		EduSystemType.SYSTEM_CHINA_MAINLAND_XIAOXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_GRADE_6);
		
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG = new EduSystemType(EduSystemType.ID_CHINA_MAINLAND_CHUZHONG);
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addName(new EduSystemName("初中（大陆三年制）", LanguageType.SIMPLIFIED_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addName(new EduSystemName("初中（大陸三年制）", LanguageType.TRADTIONAL_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addName(new EduSystemName("Grade 7-9 (China Mainland)", LanguageType.ENGLISH));
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_CHU_1);
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_CHU_2);
		EduSystemType.SYSTEM_CHINA_MAINLAND_CHUZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_CHU_3);
		
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG = new EduSystemType(EduSystemType.ID_CHINA_MAINLAND_GAOZHONG);
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addName(new EduSystemName("高中（大陆三年制）", LanguageType.SIMPLIFIED_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addName(new EduSystemName("高中（大陸三年制）", LanguageType.TRADTIONAL_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addName(new EduSystemName("Grade 10-12 (China Mainland)", LanguageType.ENGLISH));
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_GAO_1);
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_GAO_2);
		EduSystemType.SYSTEM_CHINA_MAINLAND_GAOZHONG.addGrade(GradeType.GRADE_CHINA_MAINLAND_GAO_3);
		
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE = new EduSystemType(EduSystemType.ID_CHINA_MAINLAND_DAXUE);
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addName(new EduSystemName("本科（大陆）", LanguageType.SIMPLIFIED_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addName(new EduSystemName("本科（大陸）", LanguageType.TRADTIONAL_CHINESE));
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addName(new EduSystemName("College / University (China Mainland)", LanguageType.ENGLISH));
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_DA_1);
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_DA_2);
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_DA_3);
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_DA_4);
		EduSystemType.SYSTEM_CHINA_MAINLAND_DAXUE.addGrade(GradeType.GRADE_CHINA_MAINLAND_DA_5);
		
	}
	
	
}
