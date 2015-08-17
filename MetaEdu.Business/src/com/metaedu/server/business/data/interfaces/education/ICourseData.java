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
	 * @param refCourseId 指定的课程主键
	 * @return 课程实体或 Null
	 */
	public Course getValidCourseById(String refCourseId);
	
	/** 创建一个课程
	 * @param refCourse 待创建课程实体
	 * @return 是否创建成功
	 */
	public boolean createCourse(Course refCourse);
	
	/** 更新课程（不变更课程的业务群属性）
	 * @param refCourse 待更新课程实体
	 * @return 是否更新成功
	 */
	public boolean updateCourse(Course refCourse);
	
	/** 删除课程
	 * @param refCourseId 待删除课程主键
	 * @return 是否删除成功
	 */
	public boolean removeCourse(String refCourseId);
	
	/** 获取指定班级相应的课程集合
	 * @param refClazzId 指定的班级编号
	 * @return 指定班级对应的课程集合
	 */
	public List<Course> getCoursesByClazzId(String refClazzId);
	
	/** 将一个班级加入到课程中
	 * @param refCourseId 所属课程主键
	 * @param refClazzId 待添加班级主键
	 * @return 是否添加成功
	 */
	public boolean addCourseClazz(String refCourseId, String refClazzId);
	
	/** 将一个班级从课程中移除
	 * @param refCourseId 所属课程主键
	 * @param refClazzId 待移除班级主键
	 * @return 是否移除成功
	 */
	public boolean removeCourseClazz(String refCourseId, String refClazzId);
	
	/** 添加一个课程教师
	 * @param refCourseId 课程主键
	 * @param refInstitutionId 教师所在机构主键
	 * @param refUserId 待添加教师主键
	 * @return 是否添加成功
	 */
	//public boolean addCourseTeacher(String refCourseId, String refInstitutionId, User refUser);
	public boolean addCourseTeacher(String refCourseId, String refInstitutionId, String refUserId);
	
	/** 移除一个课程教师
	 * @param refCourseId 所属课程主键
	 * @param refInstitutionId 教师所属机构主键
	 * @param refUserId 待移除教师主键
	 * @return 是否移除成功
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
