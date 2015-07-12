package com.metaedu.server.business.data.interfaces.education;

import java.util.List;

import com.metaedu.server.business.education.Course;
import com.metaedu.server.business.user.User;

/** 课程基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface ICourseData {

	/** 获取指定编号的课程实体
	 * @param refCourseId
	 * @return
	 */
	public Course getValidCourseById(String refCourseId);
	
	/** 创建一个课程
	 * @param refCourse
	 * @return
	 */
	public boolean createCourse(Course refCourse);
	
	/** 更新课程
	 * @param refCourse
	 * @return
	 */
	public boolean updateCourse(Course refCourse);
	
	/** 删除课程
	 * @param refCourseId
	 * @return
	 */
	public boolean removeCourse(String refCourseId);
	
	/** 获取指定班级相应的课程集合
	 * @param refClazzId 指定的班级编号
	 * @return
	 */
	public List<Course> getCoursesByClazzId(String refClazzId);
	
	/** 将一个班级加入到课程中
	 * @param refCourseId
	 * @param refClazzId
	 * @return
	 */
	public boolean addCourseClazz(String refCourseId, String refClazzId);
	
	/** 将一个班级从课程中移除
	 * @param refCourseId
	 * @param refClazzId
	 * @return
	 */
	public boolean removeCourseClazz(String refCourseId, String refClazzId);
	
	/** 添加一个课程教师
	 * @param refCourseId
	 * @param refInstitutionId
	 * @param refUser
	 * @return
	 */
	public boolean addCourseTeacher(String refCourseId, String refInstitutionId, User refUser);
	
	/** 移除一个课程教师
	 * @param refCourseId
	 * @param refUserId
	 * @return
	 */
	public boolean removeCourseTeacher(String refCourseId, String refInstitutionId, String refUserId);
	
	/** 添加同个机构内的来自相关班级的学生
	 * @param refCourseId
	 * @param refInstitutionId
	 * @param refUserId
	 * @return
	 */
	//public boolean addCourseStudent(String refCourseId, String refInstitutionId, User refUser);
	
	/** 移除同个机构内的来自相关班级的学生
	 * @param refCourseId
	 * @param refInstitutionId
	 * @param refUserId
	 * @return
	 */
	//public boolean removeCourseStudent(String refCourseId, String refInstitutionId, String refUserId);
	
	
	
}
