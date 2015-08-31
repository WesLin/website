package com.metaedu.server.website.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.education.Clazz;
import com.metaedu.server.business.education.ClazzType;
import com.metaedu.server.business.education.Course;
import com.metaedu.server.business.education.EduSystem;
import com.metaedu.server.business.education.Grade;
import com.metaedu.server.business.education.Lesson;
import com.metaedu.server.business.education.Subject;
import com.metaedu.server.business.institution.Institution;
import com.metaedu.server.business.metaweb.LessonSummaryListModel;
import com.metaedu.server.business.metaweb.UserSummary;
import com.metaedu.server.business.user.CharacterType;
import com.metaedu.server.business.user.User;
import com.metaedu.server.business.user.UserSexType;
import com.metaedu.server.log.LogPak;
import com.metaedu.server.utils.text.TimeUtils;

/**
 * 功能测试用 Controller
 * 
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
@Controller
@RequestMapping("/test")
public class TestController {

	/** 日志类 */
	private static LogPak log = new LogPak(TestController.class);

	/** 新建课程 */
	@RequestMapping("/createCourse")
	public ModelAndView createCourse(@RequestParam("institutionId") String refInstitutionId,
			@RequestParam("name") String refName, @RequestParam("subjectType") Integer refSubjectType) {
		String curResult = "fail";
		// 获取指定机构
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById(refInstitutionId);

		if (curIns != null) {
			// 创建课程
			Course newCourse = new Course(true, curIns.getId());
			newCourse.setName(refName);
			newCourse.setInstitutionId(curIns.getId());
			newCourse.setBeginTime(new Date());
			newCourse.setOverTime(TimeUtils.getDateFromString("2015-12-31 00:00:00"));
			newCourse.setSubjectType(refSubjectType);
			newCourse.setEnableGroup(false); // 不创建群组
			DataFactory.getCourseData().createCourse(newCourse);
			curResult = newCourse.getId(); // 返回课程编号
		}

		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 新建班级 */
	@RequestMapping("/createClazz")
	public ModelAndView createClazz(@RequestParam("institutionId") String refInstitutionId,
			@RequestParam("name") String refName, @RequestParam("clazzType") Integer refClazzType,
			@RequestParam("beginDate") String refBeginDate, @RequestParam("eduSystemType") Integer refEduSystemType,
			@RequestParam("beginGradeType") Integer refBeginGradeType) {
		String curResult = "success";

		Clazz newClazz = new Clazz(true, refInstitutionId);
		newClazz.setInstitutionId(refInstitutionId);
		newClazz.setName(refName);
		newClazz.setClazzType(refClazzType);
		newClazz.setBeginTime(TimeUtils.getDateFromString(refBeginDate + " 00:00:00"));
		newClazz.setEduSystemType(refEduSystemType); // 学制
		newClazz.setBeginGradeType(refBeginGradeType); // 初始年级
		newClazz.setEnableGroup(false); // 禁止业务群
		DataFactory.getClazzData().createClazz(newClazz);

		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 新建用户 */
	@RequestMapping("/createUser")
	public ModelAndView createUser(@RequestParam("institutionId") String refInstitutionId,
			@RequestParam("surname") String refSurName, @RequestParam("name") String refName,
			@RequestParam("sex") Integer refSexType, @RequestParam("isStudent") Integer refIsStudent,
			@RequestParam("account") String refAccount) {
		String curResult = "success";
		// 获取指定机构
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById(refInstitutionId);
		int curSexType = refIsStudent == 1 ? CharacterType.STUDENT : CharacterType.TEACHER;
		User curUser = DataFactory.getUserData().createSimpleCharacteredUser(refSurName, refName, refSexType,
				curIns.getId(), refAccount, curSexType);
		curResult = curUser.getId();
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 新建随机学生 */
	@RequestMapping("/createRandomStudent")
	public ModelAndView createRandomStudent(

	) {
		String curResult = "success";
		// 获取指定机构
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860021000000010"); // 获取上外
		for (int i = 1; i <= 100; i++) {
			String namefix = "";
			if (i < 10)
				namefix = "00" + i;
			else if (i < 100)
				namefix = "0" + i;
			else
				namefix = "" + i; // 100
			User curUser = DataFactory.getUserData().createSimpleCharacteredUser("学生", namefix, UserSexType.UNKNOWN,
					curIns.getId(), "kouyuqianghua" + namefix, CharacterType.STUDENT);
			DataFactory.getClazzData().addClazzUser("0860021000000010-1508060311500721", curIns.getId(),
					curUser.getId(), CharacterType.STUDENT); // 加入高级口译名师班
		}
		DataFactory.getCourseData().addCourseClazz("0860021000000010-1508060300300845",
				"0860021000000010-1508060311500721"); // 加入班级到课程
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 添加班级用户 */
	@RequestMapping("/addClazzUser")
	public ModelAndView addClazzUser(@RequestParam("institutionId") String refInstitutionId,
			@RequestParam("clazzId") String refClazzId, @RequestParam("userId") String refUserId,
			@RequestParam("characterType") int refCharacterType) {
		String curResult = "success";
		DataFactory.getClazzData().addClazzUser(refClazzId, refInstitutionId, refUserId, refCharacterType);
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 添加课程教师 */
	@RequestMapping("/addCourseTeacher")
	public ModelAndView addCourseTeacher(@RequestParam("institutionId") String refInstitutionId,
			@RequestParam("courseId") String refCourseId, @RequestParam("teacherId") String refTeacherId) {
		String curResult = "success";
		DataFactory.getCourseData().addCourseTeacher(refCourseId, refInstitutionId, refTeacherId);
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 添加课程关联班级 */
	@RequestMapping("/addCourseClazz")
	public ModelAndView addCourseClazz(@RequestParam("courseId") String refCourseId,
			@RequestParam("clazzIds") String refClazzIds) {
		String curResult = "success";
		String[] curClazzIds = refClazzIds.split(",");
		if (curClazzIds.length > 0) {
			for (int i = 0; i < curClazzIds.length; i++) {
				log.debug("addCourseClazz", "准备添加班级 " + curClazzIds[i] + " 至课程 " + refCourseId);
				DataFactory.getCourseData().addCourseClazz(refCourseId, curClazzIds[i]);
			}
		}
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curResult);
		return curModel;
	}

	/** 新建课次测试 */
	// @RequestMapping("/createLesson")
	// public ModelAndView createLesson(HttpServletRequest request) {
	// String courseId = "257f74ec4e2f492d86317823095ce099"; // 炒股讲座主键
	// String teacherId = "72184eaef0534da7ac7256bf4bee8d57"; // 诸葛亮主键
	//
	// Lesson newLesson = new Lesson();
	// newLesson.setCourseId(courseId);
	// newLesson.setTeacherId(teacherId);
	// newLesson.setName("测试课程");
	// Calendar ca = Calendar.getInstance();
	// ca.add(Calendar.MINUTE, +5);
	// newLesson.setBeginTime(ca.getTime());
	// ca.add(Calendar.MINUTE, +40);
	// newLesson.setOverTime(ca.getTime());
	// DataFactory.getLessonData().createLesson(newLesson); // 推送到 Lesson 服务
	//
	// ModelAndView curModel = new ModelAndView("/result");
	// curModel.addObject("result", "推送课程 " + newLesson.getId());
	// return curModel;
	// }

	/**
	 * 新建班级、学生、课程流程测试
	 * 
	 * @return
	 */
	// @RequestMapping("/addOther")
	// public ModelAndView addOther(HttpServletRequest request) {
	// Institution curIns =
	// DataFactory.getInstitutionData().getInstitutionById("00000000000000000000000000000000");
	//// User curUser =
	// DataFactory.getUserData().createSimpleCharacteredUser("测试学生01", "",
	// UserSexType.MALE, curIns.getId(), "250001", CharacterType.STUDENT);
	//// User curUser2 =
	// DataFactory.getUserData().createSimpleCharacteredUser("关", "",
	// UserSexType.MALE, curIns.getId(), "250002", CharacterType.STUDENT);
	//// User curUser3 =
	// DataFactory.getUserData().createSimpleCharacteredUser("张", "飞",
	// UserSexType.MALE, curIns.getId(), "250003", CharacterType.STUDENT);
	//// User curUser4 =
	// DataFactory.getUserData().createSimpleCharacteredUser("诸葛", "亮",
	// UserSexType.FEMALE, curIns.getId(), "250004", CharacterType.TEACHER);
	//// User curUser5 =
	// DataFactory.getUserData().createSimpleCharacteredUser("赵", "云",
	// UserSexType.FEMALE, curIns.getId(), "250005", CharacterType.STUDENT);
	//// User curUser6 =
	// DataFactory.getUserData().createSimpleCharacteredUser("马", "超",
	// UserSexType.FEMALE, curIns.getId(), "250006", CharacterType.STUDENT);
	//// User curUser7 =
	// DataFactory.getUserData().createSimpleCharacteredUser("黄", "忠",
	// UserSexType.FEMALE, curIns.getId(), "250007", CharacterType.STUDENT);
	//// User curUser8 =
	// DataFactory.getUserData().createSimpleCharacteredUser("魏", "延",
	// UserSexType.MALE, curIns.getId(), "250008", CharacterType.STUDENT);
	// // 创建班级
	// Clazz newClazz =
	// DataFactory.getClazzData().getValidClazzById("21388e8b92674cddb4192d5f0fbebf1b");
	// for (int i=1; i<=100; i++) {
	// String stufix = "";
	// if (i<10) stufix = "00" + i;
	// else if (i<100) stufix = "0" + i;
	// else stufix = "" + i;
	// User curUser =
	// DataFactory.getUserData().createSimpleCharacteredUser("测试学生" + stufix,
	// "", UserSexType.MALE, curIns.getId(), "100" + stufix,
	// CharacterType.STUDENT);
	// DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(),
	// curUser.getId(), CharacterType.STUDENT);
	// }
	//
	//
	// ModelAndView curModel = new ModelAndView("/result");
	// curModel.addObject("result", curIns.getDefaultName());
	// return curModel;
	// }

	/**
	 * 新建班级、学生、课程流程测试
	 * 
	 * @return
	 */
	// @RequestMapping("/simple")
	// public ModelAndView simple(HttpServletRequest request) {
	// Institution curIns =
	// DataFactory.getInstitutionData().getInstitutionById("0860000100000000");
	//// User curUser =
	// DataFactory.getUserData().createSimpleCharacteredUser("荀", "彧",
	// UserSexType.FEMALE, curIns.getId(), "250012", CharacterType.TEACHER);
	//// DataFactory.getCourseData().addCourseTeacher("0860000100000000-1507071712140282",
	// curIns.getId(), curUser);
	//
	// //System.out.println(DataFactory.getGroupExternalData().getGroupIdByInstitutionIdAndCourseId("0860000100000000",
	// "0860000100000000-1507071712140282"));
	// User curUser = DataFactory.getUserData().createSimpleCharacteredUser("荀",
	// "彧", UserSexType.FEMALE, curIns.getId(), "250012",
	// CharacterType.TEACHER);
	// ModelAndView curModel = new ModelAndView("/result");
	// curModel.addObject("result", curIns.getDefaultName());
	// return curModel;
	// }

	/**
	 * 新建班级、学生、课程流程测试
	 * 
	 * @return
	 */
	// @RequestMapping("/addTeacherAndLesson")
	// public ModelAndView addTeacherAndLesson(HttpServletRequest request) {
	// Institution curIns =
	// DataFactory.getInstitutionData().getInstitutionById("0860000100000000");
	// User curUser = DataFactory.getUserData().createSimpleCharacteredUser("荀",
	// "彧", UserSexType.FEMALE, curIns.getId(), "250012",
	// CharacterType.TEACHER);
	// //User curUser =
	// DataFactory.getUserData().getValidUserById("1507152335490670");
	// DataFactory.getCourseData().addCourseTeacher("0860000100000000-1507071712140282",
	// curIns.getId(), curUser.getId());
	// ModelAndView curModel = new ModelAndView("/result");
	// curModel.addObject("result", curIns.getDefaultName());
	// return curModel;
	// }

	/**
	 * 新建教师并添加到课程中
	 * 
	 * @return
	 */
	// @RequestMapping("/addTeacher")
	// public ModelAndView addTeacher(HttpServletRequest request) {
	// Institution curIns =
	// DataFactory.getInstitutionData().getInstitutionById("0860000100000000");
	// User curUser = DataFactory.getUserData().createSimpleCharacteredUser("黄",
	// "刚", UserSexType.MALE, curIns.getId(), "huanggang",
	// CharacterType.TEACHER);
	// //User curUser =
	// DataFactory.getUserData().getValidUserById("1507152335490670");
	// DataFactory.getCourseData().addCourseTeacher("0860000100000000-1507071712140259",
	// curIns.getId(), curUser.getId());
	// DataFactory.getCourseData().addCourseTeacher("0860000100000000-1507071712140282",
	// curIns.getId(), curUser.getId());
	// ModelAndView curModel = new ModelAndView("/result");
	// curModel.addObject("result", curIns.getDefaultName());
	// return curModel;
	// }

	/**
	 * 添加管理员
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/addAdmin")
	public ModelAndView addAdmin(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860000100000000");
		User curUser = DataFactory.getUserData().createSimpleCharacteredUser("管理", "员", UserSexType.MALE,
				curIns.getId(), "250000", CharacterType.ADMIN);
		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curIns.getDefaultName());
		return curModel;
	}

	/**
	 * 新建班级、学生、课程流程测试
	 * 
	 * @return
	 */
	@RequestMapping("/buildSchool")
	public ModelAndView buildSchool(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860021000000010");

		// 创建班级
		Clazz newClazz = new Clazz(true, curIns.getId());
		newClazz.setInstitutionId(curIns.getId());
		newClazz.setName("上外测试班");
		newClazz.setClazzType(ClazzType.ADMIN);
		newClazz.setBeginTime(TimeUtils.getDateFromString("2015-07-25 00:00:00"));
		newClazz.setEduSystemType(EduSystem.ID_UNLIMITED_SYSTEM); // 不限定学制
		newClazz.setBeginGradeType(Grade.ID_UNLIMITED_GRADE); // 不限定年级
		DataFactory.getClazzData().createClazz(newClazz);

		// 创建学生
		User curUser01 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生01", UserSexType.MALE,
				curIns.getId(), "student01", CharacterType.STUDENT);
		User curUser02 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生02", UserSexType.MALE,
				curIns.getId(), "student02", CharacterType.STUDENT);
		User curUser03 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生03", UserSexType.MALE,
				curIns.getId(), "student03", CharacterType.STUDENT);
		User curUser04 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生04", UserSexType.MALE,
				curIns.getId(), "student04", CharacterType.STUDENT);
		User curUser05 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生05", UserSexType.MALE,
				curIns.getId(), "student05", CharacterType.STUDENT);
		User curUser06 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生06", UserSexType.MALE,
				curIns.getId(), "student06", CharacterType.STUDENT);
		User curUser07 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生07", UserSexType.MALE,
				curIns.getId(), "student07", CharacterType.STUDENT);
		User curUser08 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生08", UserSexType.MALE,
				curIns.getId(), "student08", CharacterType.STUDENT);
		User curUser09 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生09", UserSexType.MALE,
				curIns.getId(), "student09", CharacterType.STUDENT);
		User curUser10 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "学生10", UserSexType.MALE,
				curIns.getId(), "student10", CharacterType.STUDENT);

		// 学生加入班级
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser01.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser02.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser03.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser04.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser05.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser06.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser07.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser08.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser09.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), curUser10.getId(),
				CharacterType.STUDENT);

		// 创建课程
		Course newCourse = new Course(true, curIns.getId());
		newCourse.setName("上外测试课程");
		newCourse.setInstitutionId(curIns.getId());
		newCourse.setBeginTime(new Date());
		newCourse.setOverTime(TimeUtils.getDateFromString("2016-12-31 00:00:00"));
		newCourse.setSubjectType(Subject.ID_UNPOINTED_SUBJECT);
		DataFactory.getCourseData().createCourse(newCourse);

		// 加入班级到课程
		DataFactory.getCourseData().addCourseClazz(newCourse.getId(), newClazz.getId());

		// 创建教师
		User curUserT01 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "教师01", UserSexType.MALE,
				curIns.getId(), "teacher01", CharacterType.TEACHER);
		User curUserT02 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "教师02", UserSexType.MALE,
				curIns.getId(), "teacher02", CharacterType.TEACHER);
		User curUserT03 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "教师03", UserSexType.MALE,
				curIns.getId(), "teacher03", CharacterType.TEACHER);
		User curUserT04 = DataFactory.getUserData().createSimpleCharacteredUser("测试", "教师04", UserSexType.MALE,
				curIns.getId(), "teacher04", CharacterType.TEACHER);

		// 加入教师到课程
		DataFactory.getCourseData().addCourseTeacher(newCourse.getId(), curIns.getId(), curUserT01.getId());
		DataFactory.getCourseData().addCourseTeacher(newCourse.getId(), curIns.getId(), curUserT02.getId());
		DataFactory.getCourseData().addCourseTeacher(newCourse.getId(), curIns.getId(), curUserT03.getId());
		DataFactory.getCourseData().addCourseTeacher(newCourse.getId(), curIns.getId(), curUserT04.getId());

		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curIns.getDefaultName());
		return curModel;
	}

	/**
	 * 新建班级、学生、课程流程测试
	 * 
	 * @return
	 */
	@RequestMapping("/initSchool")
	public ModelAndView processTest(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860000100000000");
		User curUser = DataFactory.getUserData().createSimpleCharacteredUser("刘", "备", UserSexType.MALE, curIns.getId(),
				"250001", CharacterType.STUDENT);
		User curUser2 = DataFactory.getUserData().createSimpleCharacteredUser("关", "羽", UserSexType.MALE,
				curIns.getId(), "250002", CharacterType.STUDENT);
		User curUser3 = DataFactory.getUserData().createSimpleCharacteredUser("张", "飞", UserSexType.MALE,
				curIns.getId(), "250003", CharacterType.STUDENT);
		User curUser4 = DataFactory.getUserData().createSimpleCharacteredUser("诸葛", "亮", UserSexType.FEMALE,
				curIns.getId(), "250004", CharacterType.TEACHER);
		User curUser5 = DataFactory.getUserData().createSimpleCharacteredUser("赵", "云", UserSexType.FEMALE,
				curIns.getId(), "250005", CharacterType.STUDENT);
		User curUser6 = DataFactory.getUserData().createSimpleCharacteredUser("马", "超", UserSexType.FEMALE,
				curIns.getId(), "250006", CharacterType.STUDENT);
		User curUser7 = DataFactory.getUserData().createSimpleCharacteredUser("黄", "忠", UserSexType.FEMALE,
				curIns.getId(), "250007", CharacterType.STUDENT);
		User curUser8 = DataFactory.getUserData().createSimpleCharacteredUser("魏", "延", UserSexType.MALE,
				curIns.getId(), "250008", CharacterType.STUDENT);
		// 创建班级
		// Clazz newClazz = new Clazz();
		Clazz newClazz = new Clazz(true, curIns.getId());
		newClazz.setInstitutionId(curIns.getId());
		newClazz.setName("A班");
		newClazz.setClazzType(ClazzType.ADMIN);
		newClazz.setBeginTime(TimeUtils.getDateFromString("2014-09-01 00:00:00"));
		newClazz.setBeginGradeType(Grade.ID_CHINA_MAINLAND_GAO_1);
		DataFactory.getClazzData().createClazz(newClazz);
		String clazzId = newClazz.getId();
		Clazz newClazz2 = new Clazz(true, curIns.getId());
		newClazz2.setInstitutionId(curIns.getId());
		newClazz2.setName("B班");
		newClazz2.setClazzType(ClazzType.ADMIN);
		newClazz2.setBeginTime(TimeUtils.getDateFromString("2014-09-01 00:00:00"));
		newClazz2.setBeginGradeType(Grade.ID_CHINA_MAINLAND_GAO_1);
		DataFactory.getClazzData().createClazz(newClazz2);
		String clazzId2 = newClazz2.getId();
		// 创建课程
		Course newCourse = new Course(true, curIns.getId());
		newCourse.setName("斗鱼直播课堂");
		newCourse.setInstitutionId(curIns.getId());
		DataFactory.getCourseData().createCourse(newCourse);
		String courseId = newCourse.getId();
		Course newCourse2 = new Course(true, curIns.getId());
		newCourse2.setName("炒股讲座");
		newCourse2.setInstitutionId(curIns.getId());
		DataFactory.getCourseData().createCourse(newCourse2);
		String courseId2 = newCourse2.getId();
		// 将用户加入到班级
		Clazz createdClazz = DataFactory.getClazzData().getValidClazzById(clazzId);
		Clazz createdClazz2 = DataFactory.getClazzData().getValidClazzById(clazzId2);

		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser2.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser3.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser5.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser6.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser7.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz.getId(), curIns.getId(), curUser8.getId(),
				CharacterType.STUDENT);

		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser2.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser3.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser5.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser6.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser7.getId(),
				CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(createdClazz2.getId(), curIns.getId(), curUser8.getId(),
				CharacterType.STUDENT);

		// 将班级加入到课程1
		Course createdCourse = DataFactory.getCourseData().getValidCourseById(newCourse.getId());
		Course createdCourse2 = DataFactory.getCourseData().getValidCourseById(newCourse2.getId());
		DataFactory.getCourseData().addCourseClazz(createdCourse.getId(), clazzId);
		DataFactory.getCourseData().addCourseClazz(createdCourse.getId(), clazzId2);
		DataFactory.getCourseData().addCourseClazz(createdCourse2.getId(), clazzId);
		DataFactory.getCourseData().addCourseClazz(createdCourse2.getId(), clazzId2);

		// DataFactory.getClazzData().addClazzUser(clazzId, curIns.getId(),
		// curUser3, CharacterType.STUDENT);
		// DataFactory.getClazzData().addClazzUser(clazzId2, curIns.getId(),
		// curUser3, CharacterType.STUDENT);

		DataFactory.getCourseData().addCourseTeacher(courseId, curIns.getId(), curUser4.getId());
		DataFactory.getCourseData().addCourseTeacher(courseId2, curIns.getId(), curUser4.getId());

		// DataFactory.getCourseData().addCourseClazz(createdCourse.getId(),
		// clazzId2);
		// DataFactory.getClazzData().removeClazzUser(clazzId, curIns.getId(),
		// curUser.getId(), CharacterType.STUDENT);
		// DataFactory.getCourseData().removeCourse(courseId);
		// DataFactory.getClazzData().removeClazz(clazzId);

		// DataFactory.getClazzData().removeClazzUser(clazzId, curIns.getId(),
		// curUser.getId(), CharacterType.STUDENT);
		// DataFactory.getClazzData().removeClazzUser(clazzId, curIns.getId(),
		// curUser2.getId(), CharacterType.STUDENT);
		// DataFactory.getClazzData().addClazzUser(clazzId, curIns.getId(),
		// curUser, CharacterType.STUDENT);
		// DataFactory.getClazzData().addClazzUser(clazzId, curIns.getId(),
		// curUser2, CharacterType.STUDENT);
		// DataFactory.getClazzData().removeClazz(clazzId);
		// DataFactory.getCourseData().removeCourseClazz(courseId, clazzId);
		// DataFactory.getCourseData().removeCourseClazz(courseId, clazzId2);
		// DataFactory.getCourseData().addCourseClazz(createdCourse.getId(),
		// clazzId);
		// DataFactory.getCourseData().addCourseClazz(createdCourse.getId(),
		// clazzId2);
		// DataFactory.getCourseData().removeCourse(courseId);
		// DataFactory.getCourseData().removeCourse(courseId2);

		// 新增 100 人
		for (int i = 1; i <= 100; i++) {
			String stufix = "";
			if (i < 10)
				stufix = "00" + i;
			else if (i < 100)
				stufix = "0" + i;
			else
				stufix = "" + i;
			User testUser = DataFactory.getUserData().createSimpleCharacteredUser("测试学生" + stufix, "", UserSexType.MALE,
					curIns.getId(), "100" + stufix, CharacterType.STUDENT);
			DataFactory.getClazzData().addClazzUser(newClazz.getId(), curIns.getId(), testUser.getId(),
					CharacterType.STUDENT);
		}

		ModelAndView curModel = new ModelAndView("/result");
		curModel.addObject("result", curIns.getDefaultName());
		return curModel;
	}

	/**
	 * 文件上传提交页面
	 * 
	 * @return
	 */
	@RequestMapping("/fileupload")
	public ModelAndView fileUpload(HttpServletRequest request) {
		ModelAndView curModel = new ModelAndView("/test/fileupload");
		return curModel;
	}

	/**
	 * 文件上传响应
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ("/processupload"), method = RequestMethod.POST)
	// @RequestParam(value="file") 是必须的参数（该参数对应输入的表单中的文件流 name="" 的值），否则无法解析到
	// MultipartFile 的传入
	public ModelAndView processUpload(@RequestParam(value = "file") final MultipartFile refFile) {
		ModelAndView curModel = new ModelAndView("/test/processupload");
		String fileName = refFile.getOriginalFilename();
		curModel.addObject("result", fileName);
		return curModel;
	}

	/**
	 * 多文件上传响应
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = ("/processuploads"), method = RequestMethod.POST)
	// @RequestParam(value="file") 是必须的参数（该参数对应输入的表单中的文件流 name="" 的值），否则无法解析到
	// MultipartFile 的传入
	public ModelAndView processUpload(@RequestParam(value = "file") MultipartFile[] refFiles) {
		ModelAndView curModel = new ModelAndView("/test/processupload");
		String fileName = refFiles[0].getOriginalFilename();
		curModel.addObject("result", fileName);
		return curModel;
	}

	/** 用户设置页面 */
	@RequestMapping("/set-info")
	public ModelAndView toSetInfo(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/course/course-info");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

	/** 课程列表页面 */
	@RequestMapping("/course-list")
	public ModelAndView toSCourseList(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/course/course-list");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curModel.addObject("summary", curUserSummary);
		LessonSummaryListModel curLessonModel = DataFactory.getMetaWebData().getLessonSummaryListModel(
				curUserSummary.getInstitutionId(), curUserSummary.getUserId(), curUserSummary.getCharacterType(), 0,
				null, 20, 1); // 获取课程列表，不限定学科，不限定课程编号，每页20条
		System.out.println(curLessonModel.getDetails().size());
		curModel.addObject(curLessonModel);
		return curModel;
	}

	/** 课程详情页面 */
	@RequestMapping("/course-info")
	public ModelAndView toCourseInfo(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/course/course-info");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

	/** 我的班级页面 */
	@RequestMapping("/myClazz")
	public ModelAndView toMyClazz(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/clazz/myClazz");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

	/** 班级详情页面 */
	@RequestMapping("/clazz-info")
	public ModelAndView toClazzInfo(HttpSession session) {
		ModelAndView curModel = new ModelAndView("/clazz/clazz-info");
		UserSummary curUserSummary = (UserSummary) session.getAttribute("summary");
		curModel.addObject("summary", curUserSummary);
		return curModel;
	}

}
