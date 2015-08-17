package com.metaedu.server.business.data.interfaces.user;

import java.util.List;

import com.metaedu.server.business.user.Character;
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
	 * @return 指定的用户实体或 Null
	 */
	public User getUserByLoginInfo(Boolean refIsGeneral, String refInstitutionId, String refCharacterNumber, String refCharacterPassword);
	
	
	/** 获取指定编号的有效用户
	 * @param refUserId 指定的用户编号
	 * @return 用户实体或 Null
	 */
	public User getValidUserById(String refUserId);
	
	
	/** 获取指定机构内用户的指定类型角色
	 * @param refInstitutionId 角色所属机构主键
	 * @param refUserId 角色所属用户主键
	 * @param refCharacterType 限定的角色类型
	 * @return 角色实体或 Null
	 */
	public Character getCharacter(String refInstitutionId, String refUserId, int refCharacterType);
	
	/** 快速创建一个带基本属性及机构、角色属性的用户
	 * @param refSurname 用户姓
	 * @param refName 用户名
	 * @param refSex 用户性别
	 * @param refInstitutionId 快速创建角色所属的机构主键 
	 * @param refCharacterNumber 快速创建角色的登陆名
	 * @param refCharacterType 快速创建角色的登陆密码
	 * @return 创建后的用户实体
	 */
	public User createSimpleCharacteredUser(String refSurname, String refName, int refSex, String refInstitutionId, String refCharacterNumber, int refCharacterType);

	/** 获取指定班级编号的学生用户
	 * @param refClazzId 指定的班级主键
	 * @return 班级学生用户实体集合
	 */
	public List<User> getStudentUsersByClazzId(String refClazzId);
	
	/** 获取指定班级编号的教师用户
	 * @param refClazzId 指定的班级主键
	 * @return 班级教师用户实体集合
	 */
	public List<User> getTeacherUsersByClazzId(String refClazzId);
	
	/** 获取指定课程与机构编号的学生用户
	 * @param refInstitutionId 指定的机构编号
	 * @param refCourseId 指定的课程编号
	 * @return 指定机构与课程的所有学生用户实体
	 */
	public List<User> getStudentUsersByInstitutionAndCourseId(String refInstitutionId, String refCourseId);
	
	/** 获取指定课程与机构编号的教师用户
	 * @param refInstitutionId 指定的机构编号
	 * @param refCourseId 指定的课程编号
	 * @return 指定机构与课程的所有教师用户实体
	 */
	public List<User> getTeacherUsersByInstitutionAndCourseId(String refInstitutionId, String refCourseId);
	
	/** 获取指定课程编号的所有机构学生用户
	 * @param refCourseId 指定的课程编号
	 * @return 指定课程的所有学生用户实体
	 */
	public List<User> getStudentUsersByCourseId(String refCourseId);
	
	/** 获取指定课程编号的所有机构教师用户
	 * @param refCourseId 指定的课程编号
	 * @return 指定课程的所有教师用户实体
	 */
	public List<User> getTeacherUsersByCourseId(String refCourseId);
	
	
}
