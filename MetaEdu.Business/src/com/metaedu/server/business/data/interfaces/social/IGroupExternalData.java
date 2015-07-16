package com.metaedu.server.business.data.interfaces.social;

import java.util.List;

import com.metaedu.server.business.user.User;



/** 业务群外部数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IGroupExternalData {
	
	/** 获取指定班级的群组编号（已取消，因为班级群编号即班级编号）
	 * @param refClazzId
	 * @return
	 */
//	public String getGroupIdByClazzId(String refClazzId);
	
	/** 获取指定机构内课程的群
	 * @param refInstitutionId
	 * @param refCourseId
	 * @return
	 */
	public String getGroupIdByInstitutionIdAndCourseId(String refInstitutionId, String refCourseId);
	
	/** 获取指定课程的业务群集合
	 * @param refCourseId
	 * @return
	 */
	public String[] getGroupsByCourseId(String refCourseId);
	
	/** 创建一个业务群（不限定开始和结束时间型）
	 * @param refName
	 * @param refInstitutionId
	 * @param refGroupType
	 * @param refTypeMark
	 * @return 创建的业务群的编号
	 */
	public String createGroup(String refName, String refInstitutionId, int refGroupType, String refTypeMark);
	
	/** 删除一个业务群
	 * @param refGroupId
	 * @return
	 */
	public boolean removeGroup(String refGroupId);
	
	/** 更改群名称
	 * @param refGroupId
	 * @param refName
	 * @return
	 */
	public boolean updateGroupName(String refGroupId, String refName);

	/** 添加一个群用户
	 * @param refGroupId 添加向的群
	 * @param refUser 添加的用户
	 * @param refCharacterType 添加的角色类型
	 * @return
	 */
//	public boolean addGroupUser(String refGroupId, User refUser, int refCharacterType);
	
	/** 添加一个群用户
	 * @param refGroupId 添加向的群
	 * @param refUserId 添加的用户主键
	 * @param refCharacterType 添加的角色类型
	 * @return
	 */
	public boolean addGroupUser(String refGroupId, String refUserId, int refCharacterType);
	
	/** 批量添加群用户
	 * @param refGroupId 添加向的群
	 * @param refUsers 添加的用户集合
	 * @param refCharacterType 添加的角色类型
	 * @return
	 */
	public boolean addGroupUsers(String refGroupId, List<User> refUsers, int refCharacterType);
	
	/** 移除一个群用户
	 * @param refGroupId 群主键
	 * @param refUserId 用户主键
	 * @return
	 */
	public boolean removeGroupUser(String refGroupId, String refUserId);
	
	/** 批量移除群用户
	 * @param refGroupId 群主键
	 * @param refUserIds 用户主键集合
	 * @return
	 */
	public boolean removeGroupUsers(String refGroupId, List<String> refUserIds);
	
	
}
