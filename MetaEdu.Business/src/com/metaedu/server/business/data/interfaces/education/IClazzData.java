package com.metaedu.server.business.data.interfaces.education;

import java.util.List;

import com.metaedu.server.business.education.Clazz;
import com.metaedu.server.business.user.User;

/** 班级基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface IClazzData {
	
	/** 获取指定主键的一个有效班级
	 * @param refClazzId
	 * @return
	 */
	public Clazz getValidClazzById(String refClazzId);
	
	/** 获取指定课程的所有相关班级
	 * @param refCourseId
	 * @return
	 */
	public List<Clazz> getClazzsByCourseId(String refCourseId);
	
	/** 创建一个班级
	 * @param refClazz
	 * @return
	 */
	public boolean createClazz(Clazz refClazz);
	
	/** 更新一个班级（不变更班级的业务群属性）
	 * @param refClazz
	 * @return
	 */
	public boolean updateClazz(Clazz refClazz);
	
	/** 移除一个班级
	 * @param refClazzId
	 * @return
	 */
	public boolean removeClazz(String refClazzId);
	
	/** 添加一个用户到班级中
	 * @param refClazzId 指定的班级主键
	 * @param refInstitutionId 所属机构主键
	 * @param refUser 待添加用户实体
	 * @param refCharacterType 角色类型
	 * @return
	 */
//	public boolean addClazzUser(String refClazzId, String refInstitutionId, User refUser, int refCharacterType);
	public boolean addClazzUser(String refClazzId, String refInstitutionId, String refUserId, int refCharacterType);
	
	/** 批量添加用户到班级中
	 * @param refClazzId 指定的班级主键
	 * @param refInstitutionId 所属机构主键
	 * @param refUsers 待添加用户实体集合
	 * @param refCharacterType 角色类型
	 * @return
	 */
//	public boolean addClazzUsers(String refClazzId, String refInstitutionId, List<User> refUsers, int refCharacterType);
	
	/** 从班级中移除一个用户
	 * @param refClazzId 指定的班级主键
	 * @param refInstitutionId 所属机构主键
	 * @param refUserId 待移除用户主键
	 * @return
	 */
	public boolean removeClazzUser(String refClazzId, String refInstitutionId, String refUserId, int refCharacterType);
	
	/** 从班级中批量移除用户
	 * @param refClazzId 指定的班级主键
	 * @param refInstitutionId 所属机构主键
	 * @param refUserIds 待移除用户主键集合
	 * @return
	 */
//	public boolean removeClazzUsers(String refClazzId, String refInstitutionId, List<String> refUserIds, int refCharacterType);
	
	
}
