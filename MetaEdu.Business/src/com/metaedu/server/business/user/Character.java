package com.metaedu.server.business.user;

import java.util.Date;

import com.metaedu.server.business.sharing.SharingLevel;
import com.metaedu.server.utils.text.HashUtils;

/** 角色
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Character {

	/** 角色主键 */
	private String id = HashUtils.getUuidCompact();
	
	/** 获取角色主键 */
	public String getId() {
		return this.id;
	}
	
	/** 设置角色主键 */
	public void setId(String refId) {
		this.id = refId;
	}
	
	/** 关联用户编号 */
	private String userId = "";
	
	/** 获取关联用户编号 */
	public String getUserId() {
		return userId;
	}
	
	/** 设置关联用户编号 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/** 关联机构编号 */
	private String institutionId = "";
	
	/** 获取关联机构编号 */
	public String getInstitutionId() {
		return this.institutionId;
	}
	
	/** 设置关联机构编号 */
	public void setInstitutionId(String refInstitutionId) {
		this.institutionId = refInstitutionId;
	}

	/** 学号或者工号（管理员强制为 admin）*/
	private String characterNumber = "";
	
	/** 获取学号或者工号 */
	public String getCharacterNumber() {
		return this.characterNumber;
	}
	
	/** 设置学号或者工号 */
	public void setCharacterNumber(String characterNumber) {
		this.characterNumber = characterNumber;
	}
	
	/** 学号工号对应密码 */ 
	private String characterPassword = "123456";
	
	/** 获取学号工号对应密码 */
	public String getCharacterPassword() {
		return this.characterPassword;
	}
	
	/** 设置学号工号对应密码 */
	public void setCharacterPassword(String characterPassword) {
		this.characterPassword = characterPassword;
	}

	/** 角色类型，默认学生 */
	private int characterType = CharacterType.STUDENT;
	
	/** 获取角色类型 */
	public int getCharacterType() {
		return this.characterType;
	}
	
	/** 设置角色类型 */
	public void setCharacterType(int refType) {
		this.characterType = refType;
	}
	
	/** 共享级别，默认私有 */
	private int sharingLevel = SharingLevel.PRIVATE;
	
	/** 获取共享级别，默认私有 */
	public int getSharingLevel() {
		return sharingLevel;
	}

	/** 设置共享级别 */
	public void setSharingLevel(int sharingLevel) {
		this.sharingLevel = sharingLevel;
	}

	/** 角色使用的邮件信息 */
	private String email = "";
	
	/** 获取角色使用的邮件信息 */
	public String getEmail() {
		return this.email;
	}

	/** 设置角色使用的邮件信息 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 角色使用的手机信息 */
	private String mobile = "";
	
	/** 获取角色使用的手机信息 */
	public String getMobile() {
		return this.mobile;
	}
	
	/** 设置角色使用的手机信息 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/** 是否有效角色 */
	private boolean isValid = true;
	
	/** 获取是否有效角色 */
	public boolean getIsValid() {
		return this.isValid;
	}
	
	/** 设置是否有效角色 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	/** 角色创建时间 */
	private Date createTime = new Date();
	
	/** 获取角色创建时间 */
	public Date getCreateTime() {
		return this.createTime;
	}
	
	/** 设置角色创建时间 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** 角色更新时间 */
	private Date updateTime = new Date();
	
	/** 获取角色更新时间 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/** 设置角色更新时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
