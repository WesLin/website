package com.metaedu.server.business.organization;

/** 组织关系主版本
 * @author Sam
 * @version 1.0
 * @since 2015.06.20
 */
public class OrganizationTrunk {

	/** 组织关系版本主键 */
	private String id;

	/** 获取组织关系版本主键 */
	public String getId() {
		return id;
	}

	/** 设置组织关系版本主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 关联用户主键 */
	private String userId;

	/** 获取关联用户主键 */
	public String getUserId() {
		return userId;
	}

	/** 设置关联用户主键 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/** 组织关系版本号 */
	private String version;

	/** 获取组织关系版本号 */
	public String getVersion() {
		return version;
	}

	/** 设置组织关系版本号 */
	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	
	
}
