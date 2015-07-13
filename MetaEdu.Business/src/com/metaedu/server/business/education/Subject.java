package com.metaedu.server.business.education;

import java.io.Serializable;
import java.util.ArrayList;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.common.MultiNameOwner;

/** 学科类型（并初始化各个学科类型数据）
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class Subject implements MultiNameOwner<SubjectName>, Serializable {

	private static final long serialVersionUID = 3177228532733813591L;
	
	/** 科目代码：未指定科目 */
	public static final int ID_UNPOINTED_SUBJECT = 1;
	/** 科目代码：未指定科目 */
	public static Subject SUBJECT_UNPOINTED_SUBJECT = null;
	
	/** 科目代码：高中其他学科 */
	public static final int ID_CHINA_GAOZHONG_OTHER = 100001000;
	/** 科目实体：高中其他学科 */
	public static Subject SUBJECT_CHINA_GAOZHONG_OTHER = null;
	
	/** 科目代码：高中语文 */
	public static final int ID_CHINA_GAOZHONG_YUWEN = 740001000;
	/** 科目实体：高中语文 */
	public static Subject SUBJECT_CHINA_GAOZHONG_YUWEN = null;
	
	/** 科目代码：高中英语 */
	public static final int ID_CHINA_GAOZHONG_YINGYU = 740001100;
	/** 科目实体：高中英语 */
	public static Subject SUBJECT_CHINA_GAOZHONG_YINGYU = null;
	
	/** 科目代码：高中数学 */
	public static final int ID_CHINA_GAOZHONG_SHUXUE = 110001000;
	/** 科目实体：高中数学 */
	public static Subject SUBJECT_CHINA_GAOZHONG_SHUXUE = null;
	
	/** 科目代码：高中化学 */
	public static final int ID_CHINA_GAOZHONG_HUAXUE = 150001000;
	/** 科目实体：高中化学 */
	public static Subject SUBJECT_CHINA_GAOZHONG_HUAXUE = null;
	
	/** 科目代码：高中物理 */
	public static final int ID_CHINA_GAOZHONG_WULI = 140001000;
	/** 科目实体：高中物理 */
	public static Subject SUBJECT_CHINA_GAOZHONG_WULI = null;
	
	/** 科目代码：高中生物 */
	public static final int ID_CHINA_GAOZHONG_SHENGWU = 180001000;
	/** 科目实体：高中生物 */
	public static Subject SUBJECT_CHINA_GAOZHONG_SHENGWU = null;
	
	/** 科目代码：高中政治 */
	public static final int ID_CHINA_GAOZHONG_ZHENGZHI = 810001000;
	/** 科目实体：高中政治 */
	public static Subject SUBJECT_CHINA_GAOZHONG_ZHENGZHI = null;
	
	/** 科目代码：高中历史 */
	public static final int ID_CHINA_GAOZHONG_LISHI = 770001000;
	/** 科目实体：高中政治 */
	public static Subject SUBJECT_CHINA_GAOZHONG_LISHI = null;
	
	/** 科目代码：高中地理 */
	public static final int ID_CHINA_GAOZHONG_DILI = 170001000;
	/** 科目实体：高中地理 */
	public static Subject SUBJECT_CHINA_GAOZHONG_DILI = null;
	
	/** 科目代码：高中通用技术 */
	public static final int ID_CHINA_GAOZHONG_TONGYONGJISHU = 410001000;
	/** 科目实体：高中通用技术 */
	public static Subject SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU = null;
	
	/** 科目代码：高中信息技术 */
	public static final int ID_CHINA_GAOZHONG_XINXIJISHU = 520001000;
	/** 科目实体：高中信息技术 */
	public static Subject SUBJECT_CHINA_GAOZHONG_XINXIJISHU = null;
	
	
	/** 构造函数
	 * @param refId
	 */
	public Subject(int refId) {
		this.id = refId;
	}
	
	/** 学科类型值 */
	private int id = 0;
	
	/** 获取学科类型值
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/** 学科名称集合 */
	private ArrayList<SubjectName> names = new ArrayList<SubjectName>();

	/** 获取学科名称集合 */
	public ArrayList<SubjectName> getNames() {
		return this.names;
	}

	/** 获取指定语言类型的学科名称
	 * @param refLanguageType 学科类型
	 */
	public SubjectName getName(int refLanguageType) {
		for (SubjectName curName : this.names) {
			if (curName.getLanguageType() == refLanguageType) return curName;
		}
		return null;
	}

	/** 添加一个学科名称
	 * @param refName 待添加的学科名称
	 */
	public void addName(SubjectName refName) {
		this.names.add(refName);
	}

	/** 获取指定语言类型的名称值
	 * @param refLanguageType 指定的语言类型
	 */
	public String getNameValue(int refLanguageType) {
		for (SubjectName curName : this.names) {
			if (curName.getLanguageType() == refLanguageType) return curName.getName();
		}
		return null;
	}

	/** 科目数据缓存表 */
	private static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	/** 获取所有学科列表 */
	public static ArrayList<Subject> getAllSubjects() {
		return subjectList;
	}
	
	/** 获取科目编码对应的科目实体
	 * @param refSubjectId 指定的科目编码
	 * @return
	 */
	public static Subject getSubject(Integer refSubjectId) {
		for (Subject curSub : subjectList) {
			if (curSub.getId() == refSubjectId) return curSub;
		}
		return null;
	}
	
	
	static {
		Subject.SUBJECT_UNPOINTED_SUBJECT = new Subject(Subject.ID_UNPOINTED_SUBJECT);
		subjectList.add(Subject.SUBJECT_UNPOINTED_SUBJECT);
		Subject.SUBJECT_UNPOINTED_SUBJECT.addName(new SubjectName("未指定科目", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_UNPOINTED_SUBJECT.addName(new SubjectName("未指定科目", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_UNPOINTED_SUBJECT.addName(new SubjectName("Subject Unpointed", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_YUWEN = new Subject(Subject.ID_CHINA_GAOZHONG_YUWEN);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_YUWEN);
		Subject.SUBJECT_CHINA_GAOZHONG_YUWEN.addName(new SubjectName("高中语文", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_YUWEN.addName(new SubjectName("高中語文", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_YUWEN.addName(new SubjectName("Chinese ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_YINGYU = new Subject(Subject.ID_CHINA_GAOZHONG_YINGYU);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_YINGYU);
		Subject.SUBJECT_CHINA_GAOZHONG_YINGYU.addName(new SubjectName("高中英语", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_YINGYU.addName(new SubjectName("高中英語", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_YINGYU.addName(new SubjectName("English ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_SHUXUE = new Subject(Subject.ID_CHINA_GAOZHONG_SHUXUE);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_SHUXUE);
		Subject.SUBJECT_CHINA_GAOZHONG_SHUXUE.addName(new SubjectName("高中数学", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_SHUXUE.addName(new SubjectName("高中數學", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_SHUXUE.addName(new SubjectName("Maths ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_WULI = new Subject(Subject.ID_CHINA_GAOZHONG_WULI);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_WULI);
		Subject.SUBJECT_CHINA_GAOZHONG_WULI.addName(new SubjectName("高中物理", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_WULI.addName(new SubjectName("高中物理", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_WULI.addName(new SubjectName("Physics ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_HUAXUE = new Subject(Subject.ID_CHINA_GAOZHONG_HUAXUE);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_HUAXUE);
		Subject.SUBJECT_CHINA_GAOZHONG_HUAXUE.addName(new SubjectName("高中化学", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_HUAXUE.addName(new SubjectName("高中化學", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_HUAXUE.addName(new SubjectName("Chemistry ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_SHENGWU = new Subject(Subject.ID_CHINA_GAOZHONG_SHENGWU);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_SHENGWU);
		Subject.SUBJECT_CHINA_GAOZHONG_SHENGWU.addName(new SubjectName("高中生物", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_SHENGWU.addName(new SubjectName("高中生物", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_SHENGWU.addName(new SubjectName("Biology ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_ZHENGZHI = new Subject(Subject.ID_CHINA_GAOZHONG_ZHENGZHI);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_ZHENGZHI);
		Subject.SUBJECT_CHINA_GAOZHONG_ZHENGZHI.addName(new SubjectName("思想政治", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_ZHENGZHI.addName(new SubjectName("思想政治", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_ZHENGZHI.addName(new SubjectName("Ideological And Political", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_LISHI = new Subject(Subject.ID_CHINA_GAOZHONG_LISHI);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_LISHI);
		Subject.SUBJECT_CHINA_GAOZHONG_LISHI.addName(new SubjectName("高中历史", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_LISHI.addName(new SubjectName("高中歷史", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_LISHI.addName(new SubjectName("History ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_DILI = new Subject(Subject.ID_CHINA_GAOZHONG_DILI);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_DILI);
		Subject.SUBJECT_CHINA_GAOZHONG_DILI.addName(new SubjectName("高中地理", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_DILI.addName(new SubjectName("高中地理", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_DILI.addName(new SubjectName("Geography ( Grade 10-12 )", LanguageType.ENGLISH));

		Subject.SUBJECT_CHINA_GAOZHONG_XINXIJISHU = new Subject(Subject.ID_CHINA_GAOZHONG_XINXIJISHU);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_XINXIJISHU);
		Subject.SUBJECT_CHINA_GAOZHONG_XINXIJISHU.addName(new SubjectName("信息技术", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_XINXIJISHU.addName(new SubjectName("信息技術", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_XINXIJISHU.addName(new SubjectName("Information Technology ( Grade 10-12 )", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU = new Subject(Subject.ID_CHINA_GAOZHONG_TONGYONGJISHU);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU);
		Subject.SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU.addName(new SubjectName("通用技术", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU.addName(new SubjectName("通用技術", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_TONGYONGJISHU.addName(new SubjectName("General Technology", LanguageType.ENGLISH));
		
		Subject.SUBJECT_CHINA_GAOZHONG_OTHER = new Subject(Subject.ID_CHINA_GAOZHONG_OTHER);
		subjectList.add(Subject.SUBJECT_CHINA_GAOZHONG_OTHER);
		Subject.SUBJECT_CHINA_GAOZHONG_OTHER.addName(new SubjectName("高中其他学科", LanguageType.SIMPLIFIED_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_OTHER.addName(new SubjectName("高中其他學科", LanguageType.TRADTIONAL_CHINESE));
		Subject.SUBJECT_CHINA_GAOZHONG_OTHER.addName(new SubjectName("Others ( Grade 10-12 )", LanguageType.ENGLISH));
		
	}
	
	
	
	
	

	
}
