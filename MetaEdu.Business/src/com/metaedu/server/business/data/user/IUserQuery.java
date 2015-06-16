package com.metaedu.server.business.data.user;

import com.metaedu.server.business.user.User;



/** 用户数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IUserQuery {

	/** 用登录信息获取一个用户实体
	 * @param refIsGeneral 是否通用账号登录
	 * @param refInstitutionId 机构编号
	 * @param refCharacterNumber 用户角色学号或者工号
	 * @param refCharacterPassword 用户角色登录密码
	 * @return
	 */
	public User getUserByLoginInfo(Boolean isGeneral, String refInstitutionId, String refCharacterNumber, String refCharacterPassword);
	
	
	/** 获取指定编号的用户
	 * @param refUserId 指定的用户编号
	 * @return
	 */
	public User getUserById(String refUserId);
	
	
}
