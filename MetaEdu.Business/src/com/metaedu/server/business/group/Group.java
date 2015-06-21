package com.metaedu.server.business.group;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.user.User;

/** 业务群核心类
 * @author Sam
 * @version 1.0
 * @since 2015.06.20
 */
public class Group {

	/** 群主键 */
	public String id;

	/** 获取群主键 */
	public String getId() {
		return id;
	}

	/** 设置群主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 群名称 */
	private String name;

	/** 设置群名称 */
	public String getName() {
		return name;
	}

	/** 设置群名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 群类型 */
	private int type = GroupType.CLAZZ;

	/** 获取群类型 */
	public int getType() {
		return type;
	}

	/** 设置群类型 */
	public void setType(int type) {
		this.type = type;
	}
	
	/** 创建时间 */
	public String createTime;

	/** 获取创建时间 */
	public String getCreateTime() {
		return createTime;
	}

	/** 设置创建时间 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	/** 变更时间 */
	private String updateTime;

	/** 获取变更时间 */
	public String getUpdateTime() {
		return updateTime;
	}

	/** 设置变更时间 */
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}
