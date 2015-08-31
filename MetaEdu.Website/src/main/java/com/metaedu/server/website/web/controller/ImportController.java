package com.metaedu.server.website.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.education.Clazz;
import com.metaedu.server.business.education.ClazzType;
import com.metaedu.server.business.education.Course;
import com.metaedu.server.business.education.EduSystem;
import com.metaedu.server.business.education.Grade;
import com.metaedu.server.business.institution.Institution;
import com.metaedu.server.business.user.CharacterType;
import com.metaedu.server.business.user.User;
import com.metaedu.server.business.user.UserSexType;
import com.metaedu.server.log.LogPak;
import com.metaedu.server.utils.poi.CellUtils;
import com.metaedu.server.utils.text.StringAndByteUtils;
import com.metaedu.server.utils.text.TimeUtils;

/** 数据导入 Controller
 * @author Sam
 * @version 1.0
 * @since 2015.07.17
 */
@Controller
public class ImportController {
	
	/** 日志类 */
	private static LogPak log = new LogPak(ImportController.class);
	
	/** 学生名单导入上传页
	 * @param request
	 * @return
	 */
	@RequestMapping(value=("/import/student"))
	public ModelAndView importStudent(HttpServletRequest request) {
		ModelAndView curModel = new ModelAndView("/import/student");
		return curModel;
	}
	
	/** 学生名单导入修补页
	 * @param request
	 * @return
	 */
	@RequestMapping(value=("/import/student-repair"))
	public ModelAndView importStudentRepair(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860571100000010"); // 机构编号
		Clazz curClz = DataFactory.getClazzData().getValidClazzById("0860571100000010-1507161636250503"); // 班级实体
		User curUser = DataFactory.getUserData().createSimpleCharacteredUser("吴", "林峰", UserSexType.MALE, curIns.getId(), "140525", CharacterType.STUDENT);
		DataFactory.getClazzData().addClazzUser(curClz.getId(), curIns.getId(), curUser.getId(), CharacterType.STUDENT);
		ModelAndView curModel = new ModelAndView("result");
		curModel.addObject("result", "成功");
		return curModel;
	}
	
	/** 教师名单导入修补页
	 * @param request
	 * @return
	 */
	@RequestMapping(value=("/import/teacher-repair"))
	public ModelAndView importTeacherRepair(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860571100000010"); // 机构编号
		// 创建课程
		Course curCourse = new Course(true, curIns.getId());
		curCourse.setName("高中数学预备课程");
		curCourse.setInstitutionId(curIns.getId());
		curCourse.setSubjectType(110001000);
		DataFactory.getCourseData().createCourse(curCourse);
		
//		User curUser = DataFactory.getUserData().createSimpleCharacteredUser("位", "华", UserSexType.FEMALE, curIns.getId(), "weihua", CharacterType.TEACHER);
//		DataFactory.getCourseData().addCourseTeacher(curCourse.getId(), curIns.getId(), curUser.getId());
//		User curUser2 = DataFactory.getUserData().createSimpleCharacteredUser("陈", "孝举", UserSexType.MALE, curIns.getId(), "chenxiaoju", CharacterType.TEACHER);
//		DataFactory.getCourseData().addCourseTeacher(curCourse.getId(), curIns.getId(), curUser2.getId());
		User curUser = DataFactory.getUserData().getValidUserById("1507161825090248"); // 位华
		User curUser2 = DataFactory.getUserData().getValidUserById("1507161825090266"); // 陈孝举
		DataFactory.getCourseData().addCourseTeacher(curCourse.getId(), curIns.getId(), curUser.getId());
		DataFactory.getCourseData().addCourseTeacher(curCourse.getId(), curIns.getId(), curUser2.getId());
		
		ModelAndView curModel = new ModelAndView("result");
		curModel.addObject("result", "成功");
		return curModel;
	}
	
	/** 课程名单导入修补页
	 * @param request
	 * @return
	 */
	@RequestMapping(value=("/import/course-repair"))
	public ModelAndView importCourseRepair(HttpServletRequest request) {
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById("0860571100000010"); // 机构编号
		// 创建课程
//		Course curCourse = DataFactory.getCourseData().getValidCourseById("0860571100000010-1507161823160138");
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161556450143"); // 1
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161600580322"); // 2
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161604110215"); // 3
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161621480622"); // 4
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161636250503"); // 5
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161752470952"); // 6
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161802070438"); // 7
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161803270002"); // 8
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161804520119"); // 9
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161806190605"); // 10
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161807380133"); // 11
//		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507161809540055"); // 12
		
		Course curCourse = DataFactory.getCourseData().getValidCourseById("0860571100000010-1507172338200651");
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172203550579"); // 1
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172207520270"); // 2
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172211450558"); // 3
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172215140618"); // 4
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172220040578"); // 5
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172223230459"); // 6
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172226040461"); // 7
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172229140237"); // 8
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172232200792"); // 9
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172244000578"); // 10
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172247310633"); // 11
		DataFactory.getCourseData().addCourseClazz(curCourse.getId(), "0860571100000010-1507172250210395"); // 12
		ModelAndView curModel = new ModelAndView("result");
		curModel.addObject("result", "成功");
		return curModel;
	}
	
	
	/** 学生名单导入执行
	 * @param refInstitutionId 机构编号
	 * @param refEduSystemType 学制类型
	 * @param refCurrentGradeType 当前的年级类型
	 * @param refClazzName 班级名称
	 * @param refFile 上传的 Excel 文件实体
	 * @return
	 */
	@RequestMapping(value=("/import/student-ope"), method = RequestMethod.POST)
	// @RequestParam(value="file") 是必须的参数（该参数对应输入的表单中的文件流 name="" 的值），否则无法解析到 MultipartFile 的传入
	public ModelAndView importStudentOpe(
			@RequestParam("institutionId") String refInstitutionId, 
			@RequestParam("eduSystemType") int refEduSystemType, 
			@RequestParam("currentGradeType") int refCurrentGradeType, 
			@RequestParam("clazzName") String refClazzName, 
			@RequestParam(value="file") final MultipartFile refFile) {
		ModelAndView curModel = new ModelAndView("result");
		
		// 初始化参数
		Institution curIns = DataFactory.getInstitutionData().getInstitutionById(refInstitutionId);
		if (curIns != null) { // 如果是有效机构
			EduSystem curSystem = EduSystem.getEdySystem(refEduSystemType);
			Grade tmpGrade = Grade.getGrade(refCurrentGradeType);
			int tmpDiff = curSystem.getGradeDiff(tmpGrade.getId()); // 计算当前年级和起始年级间的差
			if (tmpDiff > -1) { // 如果年级有效
				// 计算初始年
				Calendar curCal = Calendar.getInstance();
				int curYear = curCal.get(Calendar.YEAR);
				int startYear = curYear - tmpDiff; // 初始年份
				int curMonth = curCal.get(Calendar.MONTH) + 1;
				if (curMonth < 9) { // 如果是 9 月以前，年份多减一年
					startYear--;
				}
				
				// 导入四中 15 届高一，增加一年
				startYear++;
				
				String beginTimeStr = startYear + "-09-01 00:00:00";
				Date beginTime = TimeUtils.getDateFromString(beginTimeStr);
				// 创建班级
				Clazz curClazz = new Clazz(true, curIns.getId());
				curClazz.setName(StringAndByteUtils.stringISOToUTF(refClazzName)); // 设置班级名称
				curClazz.setClazzType(ClazzType.ADMIN); // 导入班级默认暂为行政班
				curClazz.setInstitutionId(refInstitutionId); // 所属机构
				curClazz.setEduSystemType(refEduSystemType); // 学制类型
				curClazz.setBeginGradeType(curSystem.getGradeStart().getId()); // 初始年级
				curClazz.setBeginTime(beginTime); // 设置开始时间
				DataFactory.getClazzData().createClazz(curClazz); // 创建班级
//				Clazz curClazz = DataFactory.getClazzData().getValidClazzById("0860571100000010-1507161621480622"); // 班级实体
				log.debug("importStudentOpe", "准备导入 " + startYear + " 届 " + Grade.getGrade(curClazz.getBeginGradeType()).getNameValue(LanguageType.SIMPLIFIED_CHINESE) + curClazz.getName() + " 数据");
				// 读取 Excel
				try {
					InputStream curInpStream = refFile.getInputStream(); // 获取文件流
					//HSSFWorkbook curWorkbook = new HSSFWorkbook(curInpStream); // 获取 Excel 工作簿
					XSSFWorkbook curWorkbook = new XSSFWorkbook(curInpStream);
					int curSheetCount = curWorkbook.getNumberOfSheets();
					log.debug("importStudentOpe", "共计 " + curSheetCount + " 页");
					XSSFSheet curSheet = curWorkbook.getSheetAt(0); // 取第 0 页
					if (curSheet != null) {
						// 从第一行判断内容是否正确
						int curRowCount = curSheet.getLastRowNum() + 1; // 获取最后一行的行标号（getLastRowNum 取值比最后一行行数小1）
						if (curRowCount >= 2) { // 如果超过两行，一行表头，至少一行内容
							XSSFRow headRow = curSheet.getRow(0);
							int curColCount = headRow.getPhysicalNumberOfCells(); // 获取表头中单元数量
							//log.debug("importStudentOpe", headRow.getCell(0).getStringCellValue());
							if (curColCount == 3 
								&& headRow.getCell(0).getStringCellValue().trim().equals("姓名") 
								&& headRow.getCell(1).getStringCellValue().trim().equals("学号/考号")
								&& headRow.getCell(2).getStringCellValue().trim().equals("性别")
							) { // 如果格式判断正确
								for (int i=1; i<curRowCount; i++) { // 遍历所有数据行
									XSSFRow curRow = curSheet.getRow(i); // 获取当前数据行
									try {
										String curFullName = CellUtils.getStringValue(curRow.getCell(0)).trim();
										String curCharacterNumber = CellUtils.getStringValue(curRow.getCell(1)).trim();
										if (curFullName.length() >= 2 && curCharacterNumber.length() >= 1) { // 如果长度符合要求
											String curSurName = curFullName.length() >= 4 ? curFullName.substring(0, 2) : curFullName.substring(0, 1);
											String curName = curFullName.length() >= 4 ? curFullName.substring(2) : curFullName.substring(1);
											int curSexType = CellUtils.getStringValue(curRow.getCell(2)).trim().equals("男") ? UserSexType.MALE : UserSexType.FEMALE;
											log.debug("importStudentOpe", "准备导入：" + curSurName + " " + curName + " - " + curCharacterNumber + " - " + curSexType);
											User curUser = DataFactory.getUserData().createSimpleCharacteredUser(curSurName, curName, curSexType, curIns.getId(), curCharacterNumber, CharacterType.STUDENT);
											DataFactory.getClazzData().addClazzUser(curClazz.getId(), curIns.getId(), curUser.getId(), CharacterType.STUDENT);
										} else {
											log.debug("importStudentOpe", "姓名（" + curFullName + "）或登录账号（" + curCharacterNumber + "）名称不正确");
											continue;
										}
									} catch (Exception ex) {
										ex.printStackTrace();
										log.debug("importStudentOpe", "行数据处理错误");
										continue;
									}
								}
							} else log.debug("importStudentOpe", "格式不正确");
						} else log.debug("importStudentOpe", "数据行数不符合要求");
					} else log.debug("importStudentOpe", "无效的表");
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				
				// 添加学生
				
				String fileName = refFile.getOriginalFilename();
				curModel.addObject("result", "添加完成");
			} else log.debug("importStudent", "无效的年级（" + refCurrentGradeType + "）或学制（" + refEduSystemType + "）参数");
		} else log.debug("importStudent", "无效的机构指定 " + refInstitutionId);
		return curModel;
	}
	
	
}
