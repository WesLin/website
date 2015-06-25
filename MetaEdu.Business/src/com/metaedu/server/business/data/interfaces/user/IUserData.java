package com.metaedu.server.business.data.interfaces.user;


import java.util.List;

import com.metaedu.server.business.user.User;



/** 用户数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IUserData {

	/** 用登录信息获取一个用户实体
	 * @param refIsGeneral 是否通用账号登录
	 * @param refInstitutionId 机构编号
	 * @param refCharacterNumber 用户角色学号或者工号
	 * @param refCharacterPassword 用户角色登录密码
	 * @return
	 */
	public User getUserByLoginInfo(Boolean isGeneral, String refInstitutionId, String refCharacterNumber, String refCharacterPassword);
	
	
	/** 获取指定编号的有效用户
	 * @param refUserId 指定的用户编号
	 * @return
	 */
	public User getValidUserById(String refUserId);
	
	
	/** 添加一个带基本属性及机构、角色属性的用户
	 * @param refSurname
	 * @param refName
	 * @param refSex
	 * @param refInstitutionId
	 * @param refCharacterNumber
	 * @param refCharacterType
	 * @return
	 */
	public User createSimpleCharacteredUser(String refSurname, String refName, int refSex, String refInstitutionId, String refCharacterNumber, int refCharacterType);

	/** 获取指定班级编号的学生用户
	 * @param refClazzId
	 * @return
	 */
	public List<User> getStudentUsersByClazzId(String refClazzId);
	
	/** 获取指定班级编号的教师用户
	 * @param refClazzId
	 * @return
	 */
	public List<User> getTeacherUsersByClazzId(String refClazzId);
	
	/** 获取指定课程与机构编号的学生用户
	 * @param refClazzId
	 * @return
	 */
	public List<User> getStudentUsersByInstitutionAndCourseId(String refInstitutionId, String refCourseId);
	
	/** 获取指定课程与机构编号的教师用户
	 * @param refInstitutionId
	 * @param refCourseId
	 * @return
	 */
	public List<User> getTeacherUsersByInstitutionAndCourseId(String refInstitutionId, String refCourseId);
	
	/** 获取指定课程编号的所有机构学生用户
	 * @param refCourseId
	 * @return
	 */
	public List<User> getStudentUsersByCourseId(String refCourseId);
	
	/** 获取指定课程编号的所有机构教师用户
	 * @param refCourseId
	 * @return
	 */
	public List<User> getTeacherUsersByCourseId(String refCourseId);
	
	
}
