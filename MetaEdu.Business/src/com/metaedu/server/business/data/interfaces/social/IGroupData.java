package com.metaedu.server.business.data.interfaces.social;

import java.util.LinkedHashMap;

import com.metaedu.server.business.group.Group;

/** 群组数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IGroupData {
	
	/** 创建业务群
	 * @param refGroup
	 * @return
	 */
	public boolean createGroup(Group refGroup);
	
	/** 升级业务群
	 * @param refGroup
	 * @return
	 */
	public boolean updateGroup(Group refGroup);
	
	/** 删除业务群
	 * @param refGroup
	 * @return
	 */
	public boolean deleteGroup(Group refGroup);
	
	
	/** 获取指定群的用户集合
	 * @param refGroupId 指定群的主键
	 * @return
	 */
	public LinkedHashMap<String, Integer> getUserIdAndCharacterTypesByGroupId(String refGroupId);
	
	
}
