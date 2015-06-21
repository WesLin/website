package com.metaedu.server.business.data.interfaces.social;

import com.metaedu.server.business.group.Group;


public interface IGroupTrunkData {
	
	/** 创建一个用户的群主干 */
	public boolean createGroupTrunk(String refUserId);
	
	/** 添加一个群组
	 * @param refGroup 待添加的群组
	 * @param refCharacterType 角色类型
	 * @return
	 */
	public boolean addGroup(Group refGroup, int refCharacterType);
	
	
	
	
}
