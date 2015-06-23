package com.metaedu.server.business.data.interfaces.social;


import com.metaedu.server.business.institution.Clazz;
import com.metaedu.server.business.user.User;

/** 群组数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IGroupExternalData {
	
	/** 创建业务群
	 * @param refGroup
	 * @return
	 */
	public boolean createGroupOfClazz(Clazz refClazz);
	
	/** 更新业务群
	 * @param refGroup
	 * @return
	 */
	public boolean updateGroupOfClazz(Clazz refClazz);
	
	/** 添加一个群用户
	 * @param refUser 待添加的用户
	 * @param refCharacterType 用户的角色类型
	 * @return
	 */
	public boolean addGroupUser(User refUser, int refCharacterType);
	
	/** 移除一个群用户
	 * @param refUser 待移除的用户
	 * @return
	 */
	public boolean removeGroupUser(User refUser);

	
	
	
	
	
	
	
}
