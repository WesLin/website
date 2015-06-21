package com.metaedu.server.business.group;

/** 业务群关系主版本
 * @author Sam
 * @version 1.0
 * @since 2015.06.20
 */
public class GroupTrunk {

	/** 群关系主版本 */
	public String id;

	/** 获取群关系主版本 */
	public String getId() {
		return id;
	}

	/** 设置群关系主版本 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 用户主键 */
	private String userId;

	/** 获取用户主键 */
	public String getUserId() {
		return userId;
	}

	/** 设置用户主键 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/** 群关系版本号 */
	private String version;

	/** 获取群关系版本号 */
	public String getVersion() {
		return version;
	}

	/** 设置群关系版本号 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	
}
