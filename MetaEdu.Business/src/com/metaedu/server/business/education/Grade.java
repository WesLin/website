package com.metaedu.server.business.education;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.common.MultiNameOwner;

/** 年级类型（并初始化各个年级类型数据）
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class Grade implements MultiNameOwner<GradeName>, Serializable  {
	
	private static final long serialVersionUID = -8761268139515566097L;
	
	/** 年级值：大陆托儿班 */
	public static final int ID_CHINA_MAINLAND_YOU_1 = 101001;
	/** 年级类型：托儿班 */
	public static Grade GRADE_CHINA_MAINLAND_YOU_1 = null;
	
	/** 年级值：大陆小班 */
	public static final int ID_CHINA_MAINLAND_YOU_2 = 101002;
	/** 年级类型：大陆小班 */
	public static Grade GRADE_CHINA_MAINLAND_YOU_2 = null;
	
	/** 年级值：大陆中班 */
	public static final int ID_CHINA_MAINLAND_YOU_3 = 101003;
	/** 年级类型：大陆中班 */
	public static Grade GRADE_CHINA_MAINLAND_YOU_3 = null;
	
	/** 年级值：大陆大班 */
	public static final int ID_CHINA_MAINLAND_YOU_4 = 101004;
	/** 年级类型：大陆大班 */
	public static Grade GRADE_CHINA_MAINLAND_YOU_4 = null;
	
	/** 年级值：大陆一年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_1 = 102001;
	/** 年级类型：大陆一年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_1 = null;
	
	/** 年级值：大陆二年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_2 = 102002;
	/** 年级类型：大陆二年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_2 = null;
	
	/** 年级值：大陆三年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_3 = 102003;
	/** 年级类型：大陆三年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_3 = null;
	
	/** 年级值：大陆四年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_4 = 102004;
	/** 年级类型：大陆四年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_4 = null;
	
	/** 年级值：大陆五年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_5 = 102005;
	/** 年级类型：大陆五年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_5 = null;
	
	/** 年级值：大陆六年级 */
	public static final int ID_CHINA_MAINLAND_GRADE_6 = 102006;
	/** 年级类型：大陆六年级 */
	public static Grade GRADE_CHINA_MAINLAND_GRADE_6 = null;
	
	/** 年级值：大陆初一 */
	public static final int ID_CHINA_MAINLAND_CHU_1 = 103001;
	/** 年级类型：大陆初一 */
	public static Grade GRADE_CHINA_MAINLAND_CHU_1 = null;
	
	/** 年级值：大陆初二 */
	public static final int ID_CHINA_MAINLAND_CHU_2 = 103002;
	/** 年级类型：大陆初二 */
	public static Grade GRADE_CHINA_MAINLAND_CHU_2 = null;
	
	/** 年级值：大陆初三 */
	public static final int ID_CHINA_MAINLAND_CHU_3 = 103003;
	/** 年级类型：大陆初三 */
	public static Grade GRADE_CHINA_MAINLAND_CHU_3 = null;
	
	/** 年级值：大陆高一 */
	public static final int ID_CHINA_MAINLAND_GAO_1 = 104001;
	/** 年级类型：大陆高一 */
	public static Grade GRADE_CHINA_MAINLAND_GAO_1 = null;
	
	/** 年级值：大陆高二 */
	public static final int ID_CHINA_MAINLAND_GAO_2 = 104002;
	/** 年级类型：大陆高二 */
	public static Grade GRADE_CHINA_MAINLAND_GAO_2 = null;
	
	/** 年级值：大陆高三 */
	public static final int ID_CHINA_MAINLAND_GAO_3 = 104003;
	/** 年级类型：大陆高三 */
	public static Grade GRADE_CHINA_MAINLAND_GAO_3 = null;
	
	/** 年级值：大陆大一 */
	public static final int ID_CHINA_MAINLAND_DA_1 = 106001;
	/** 年级类型：大陆大一 */
	public static Grade GRADE_CHINA_MAINLAND_DA_1 = null;
	
	/** 年级值：大陆大二 */
	public static final int ID_CHINA_MAINLAND_DA_2 = 106002;
	/** 年级类型：大陆大二 */
	public static Grade GRADE_CHINA_MAINLAND_DA_2 = null;
	
	/** 年级值：大陆大三 */
	public static final int ID_CHINA_MAINLAND_DA_3 = 106003;
	/** 年级类型：大陆大三 */
	public static Grade GRADE_CHINA_MAINLAND_DA_3 = null;
	
	/** 年级值：大陆大四 */
	public static final int ID_CHINA_MAINLAND_DA_4 = 106004;
	/** 年级类型：大陆大四 */
	public static Grade GRADE_CHINA_MAINLAND_DA_4 = null;
	
	/** 年级值：大陆大五 */
	public static final int ID_CHINA_MAINLAND_DA_5 = 106005;
	/** 年级类型：大陆大五 */
	public static Grade GRADE_CHINA_MAINLAND_DA_5 = null;
	
	
	/** 年级数值 */
	private int _id = 0;
	
	/** 获取年级数值
	 * @return
	 */
	public int getId() {
		return this._id;
	}
	
	/** 年级名称集合 */
	private ArrayList<GradeName> _names = new ArrayList<GradeName>();
	
	/** 获取年级名称集合
	 * @return
	 */
	public ArrayList<GradeName> getNames() {
		return this._names;
	}
	
	/** 添加年级名称
	 * @param refGradeName
	 */
	public void addName(GradeName refGradeName) {
		this._names.add(refGradeName);
	}
	
	/** 获取指定语言类型的名称对象 */
	public GradeName getName(int refLanguageType) {
		for (GradeName curName : this._names) {
			if (curName.getLanguageType() == refLanguageType) return curName;
		}
		return null;
	}
	
	/** 获取指定语言类型的年级名称
	 * @param refLanguageType 指定的语言类型
	 * @return
	 */
	public String getNameValue(int refLanguageType) {
		for (GradeName curName : this._names) {
			if (curName.getLanguageType() == refLanguageType) return curName.getName();
		}
		return "no defined grade name value";
	}
	
	/** 构造函数
	 * @param refGradeId 年级类型值（编号）
	 */
	public Grade(int refGradeId) {
		this._id = refGradeId;
	}
	
	
	/** 年级编号与实体映射表 */
	private static HashMap<Integer, Grade> gradeMap = new HashMap<Integer, Grade>();
	
	/** 获取指定编号的年级类型实体
	 * @param refGradeTypeId
	 */
	public static Grade getGrade(Integer refGradeTypeId) {
		return gradeMap.get(refGradeTypeId);
	}
	
	
	/** 静态生成年级类型 */
	static {
		Grade.GRADE_CHINA_MAINLAND_YOU_1 = new Grade(Grade.ID_CHINA_MAINLAND_YOU_1);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_YOU_1, Grade.GRADE_CHINA_MAINLAND_YOU_1);
		Grade.GRADE_CHINA_MAINLAND_YOU_1.addName(new GradeName("托儿所", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_1.addName(new GradeName("幼兒園", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_1.addName(new GradeName("Pre-K", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_YOU_2 = new Grade(Grade.ID_CHINA_MAINLAND_YOU_2);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_YOU_2, Grade.GRADE_CHINA_MAINLAND_YOU_2);
		Grade.GRADE_CHINA_MAINLAND_YOU_2.addName(new GradeName("小班", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_2.addName(new GradeName("K1/小班", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_2.addName(new GradeName("K1", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_YOU_3 = new Grade(Grade.ID_CHINA_MAINLAND_YOU_3);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_YOU_3, Grade.GRADE_CHINA_MAINLAND_YOU_3);
		Grade.GRADE_CHINA_MAINLAND_YOU_3.addName(new GradeName("中班", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_3.addName(new GradeName("K2/中班", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_3.addName(new GradeName("K2", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_YOU_4 = new Grade(Grade.ID_CHINA_MAINLAND_YOU_4);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_YOU_4, Grade.GRADE_CHINA_MAINLAND_YOU_4);
		Grade.GRADE_CHINA_MAINLAND_YOU_4.addName(new GradeName("大班", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_4.addName(new GradeName("K3/中班", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_YOU_4.addName(new GradeName("K3", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_1 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_1);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_1, Grade.GRADE_CHINA_MAINLAND_GRADE_1);
		Grade.GRADE_CHINA_MAINLAND_GRADE_1.addName(new GradeName("一年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_1.addName(new GradeName("一年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_1.addName(new GradeName("Grade 1", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_2 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_2);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_2, Grade.GRADE_CHINA_MAINLAND_GRADE_2);
		Grade.GRADE_CHINA_MAINLAND_GRADE_2.addName(new GradeName("二年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_2.addName(new GradeName("二年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_2.addName(new GradeName("Grade 2", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_3 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_3);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_3, Grade.GRADE_CHINA_MAINLAND_GRADE_3);
		Grade.GRADE_CHINA_MAINLAND_GRADE_3.addName(new GradeName("三年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_3.addName(new GradeName("三年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_3.addName(new GradeName("Grade 3", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_4 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_4);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_4, Grade.GRADE_CHINA_MAINLAND_GRADE_4);
		Grade.GRADE_CHINA_MAINLAND_GRADE_4.addName(new GradeName("四年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_4.addName(new GradeName("四年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_4.addName(new GradeName("Grade 4", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_5 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_5);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_5, Grade.GRADE_CHINA_MAINLAND_GRADE_5);
		Grade.GRADE_CHINA_MAINLAND_GRADE_5.addName(new GradeName("五年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_5.addName(new GradeName("五年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_5.addName(new GradeName("Grade 5", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GRADE_6 = new Grade(Grade.ID_CHINA_MAINLAND_GRADE_6);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GRADE_6, Grade.GRADE_CHINA_MAINLAND_GRADE_6);
		Grade.GRADE_CHINA_MAINLAND_GRADE_6.addName(new GradeName("六年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_6.addName(new GradeName("六年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GRADE_6.addName(new GradeName("Grade 6", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_CHU_1 = new Grade(Grade.ID_CHINA_MAINLAND_CHU_1);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_CHU_1, Grade.GRADE_CHINA_MAINLAND_CHU_1);
		Grade.GRADE_CHINA_MAINLAND_CHU_1.addName(new GradeName("初一/七年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_1.addName(new GradeName("中一/七年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_1.addName(new GradeName("Grade 7", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_CHU_2 = new Grade(Grade.ID_CHINA_MAINLAND_CHU_2);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_CHU_2, Grade.GRADE_CHINA_MAINLAND_CHU_2);
		Grade.GRADE_CHINA_MAINLAND_CHU_2.addName(new GradeName("初二/八年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_2.addName(new GradeName("中二/八年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_2.addName(new GradeName("Grade 8", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_CHU_3 = new Grade(Grade.ID_CHINA_MAINLAND_CHU_3);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_CHU_3, Grade.GRADE_CHINA_MAINLAND_CHU_3);
		Grade.GRADE_CHINA_MAINLAND_CHU_3.addName(new GradeName("初三/九年级", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_3.addName(new GradeName("中三/九年級", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_CHU_3.addName(new GradeName("Grade 9", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GAO_1 = new Grade(Grade.ID_CHINA_MAINLAND_GAO_1);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GAO_1, Grade.GRADE_CHINA_MAINLAND_GAO_1);
		Grade.GRADE_CHINA_MAINLAND_GAO_1.addName(new GradeName("高一", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_1.addName(new GradeName("高一/中四", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_1.addName(new GradeName("Grade 10", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GAO_2 = new Grade(Grade.ID_CHINA_MAINLAND_GAO_2);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GAO_2, Grade.GRADE_CHINA_MAINLAND_GAO_2);
		Grade.GRADE_CHINA_MAINLAND_GAO_2.addName(new GradeName("高二", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_2.addName(new GradeName("高二/中五", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_2.addName(new GradeName("Grade 11", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_GAO_3 = new Grade(Grade.ID_CHINA_MAINLAND_GAO_3);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_GAO_3, Grade.GRADE_CHINA_MAINLAND_GAO_3);
		Grade.GRADE_CHINA_MAINLAND_GAO_3.addName(new GradeName("高三", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_3.addName(new GradeName("高三/中六", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_GAO_3.addName(new GradeName("Grade 12", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_DA_1 = new Grade(Grade.ID_CHINA_MAINLAND_DA_1);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_DA_1, Grade.GRADE_CHINA_MAINLAND_DA_1);
		Grade.GRADE_CHINA_MAINLAND_DA_1.addName(new GradeName("大一", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_1.addName(new GradeName("大一", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_1.addName(new GradeName("Year 1", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_DA_2 = new Grade(Grade.ID_CHINA_MAINLAND_DA_2);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_DA_2, Grade.GRADE_CHINA_MAINLAND_DA_2);
		Grade.GRADE_CHINA_MAINLAND_DA_2.addName(new GradeName("大二", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_2.addName(new GradeName("大二", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_2.addName(new GradeName("Year 2", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_DA_3 = new Grade(Grade.ID_CHINA_MAINLAND_DA_3);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_DA_3, Grade.GRADE_CHINA_MAINLAND_DA_3);
		Grade.GRADE_CHINA_MAINLAND_DA_3.addName(new GradeName("大三", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_3.addName(new GradeName("大三", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_3.addName(new GradeName("Year 3", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_DA_4 = new Grade(Grade.ID_CHINA_MAINLAND_DA_4);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_DA_4, Grade.GRADE_CHINA_MAINLAND_DA_4);
		Grade.GRADE_CHINA_MAINLAND_DA_4.addName(new GradeName("大四", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_4.addName(new GradeName("大四", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_4.addName(new GradeName("Year 4", LanguageType.ENGLISH));
		
		Grade.GRADE_CHINA_MAINLAND_DA_5 = new Grade(Grade.ID_CHINA_MAINLAND_DA_5);
		gradeMap.put(Grade.ID_CHINA_MAINLAND_DA_5, Grade.GRADE_CHINA_MAINLAND_DA_5);
		Grade.GRADE_CHINA_MAINLAND_DA_5.addName(new GradeName("大五", LanguageType.SIMPLIFIED_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_5.addName(new GradeName("大五", LanguageType.TRADTIONAL_CHINESE));
		Grade.GRADE_CHINA_MAINLAND_DA_5.addName(new GradeName("Year 5", LanguageType.ENGLISH));
		
	}
	
	
	
	
}
