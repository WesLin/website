package com.metaedu.server.business.user;

import java.util.Date;

import com.metaedu.server.business.sharing.SharingLevel;

/** 角色
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Character {

	/** 角色主键 */
	private String _id;
	
	/** 获取角色主键
	 * @return
	 */
	public String getId() {
		return this._id;
	}
	
	/** 设置角色主键
	 * @param refId
	 */
	public void setId(String refId) {
		this._id = refId;
	}
	
	/** 关联机构编号 */
	private String _institutionId;
	
	/** 获取关联机构编号
	 * @return
	 */
	public String getInstitutionId() {
		return this._institutionId;
	}
	
	/** 角色类型，默认学生 */
	private int _characterType = CharacterType.STUDENT;
	
	/** 获取角色类型
	 * @return
	 */
	public int getCharacterType() {
		return this._characterType;
	}
	
	/** 学号或者工号（管理员强制为 admin）*/
	private String _characterNumber;
	
	/** 获取学号或者工号
	 * @return
	 */
	public String getCharacterNumber() {
		return this._characterNumber;
	}
	
	/** 学号工号对应密码 */ 
	private String _password;
	
	/** 获取学号工号对应密码
	 * @return
	 */
	public String getPassword() {
		return this._password;
	}
	
	/** 是否已软删除 */
	private boolean _isDeleted = false;
	
	/** 获取是否已软删除
	 * @return
	 */
	public boolean getIsDeleted() {
		return this._isDeleted;
	}
	
	/** 是否为主属机构 */
	private boolean _isHostInstitution = true;
	
	/** 获取是否为主属机构
	 * @return
	 */
	public boolean getIsHostInstitution() {
		return this._isHostInstitution;
	}
	
	/** 共享级别（对机构而言），默认私有 */
	private int _sharingLevel = SharingLevel.PRIVATE;
	
	/** 获取共享级别（对机构而言）
	 * @return
	 */
	public int getSharingLevel() {
		return this._sharingLevel;
	}
	
	/** 机构登记名 */
	private String _firstName;
	
	/** 获取机构登记名
	 * @return
	 */
	public String getFirstName() {
		return this._firstName;
	}
	
	/** 机构登记姓 */
	private String _surName;
	
	/** 获取机构登记姓
	 * @return
	 */
	public String getSurName() {
		return this._surName;
	}
	
	/** 角色使用的邮件信息 */
	private String _email;
	
	/** 获取角色使用的邮件信息
	 * @return
	 */
	public String getEmail() {
		return this._email;
	}
	
	/** 角色使用的手机信息 */
	private String _mobile;
	
	/** 获取角色使用的手机信息
	 * @return
	 */
	public String getMobile() {
		return this._mobile;
	}
	
	/** 角色创建时间 */
	private Date _createTime;
	
	/** 获取角色创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return this._createTime;
	}
	
	/** 角色更新时间 */
	private Date _updateTime;
	
	/** 获取角色更新时间
	 * @return
	 */
	public Date getUpdateTime() {
		return this._updateTime;
	}
	
	
}
