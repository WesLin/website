package com.metaedu.server.business.user;

import java.io.Serializable;

import com.metaedu.server.business.user.CharacterType;
import com.metaedu.server.business.user.UserSexType;


/** 用户简单登录用摘要信息（1.0 版本简化登录用）
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class UserSummary implements Serializable {

	private static final long serialVersionUID = -3884662975263772450L;
	
	/** 用户编号 */
	private String userId = "";

	/** 获取用户编号 */
	public String getUserId() {
		return userId;
	}

	/** 设置用户编号 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/** 所属机构编号 */
	private String institutionId = "";
	
	/** 获取所属机构编号 */
	public String getInstitutionId() {
		return institutionId;
	}

	/** 设置所属机构编号 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/** 用户角色类型 */
	private int characterType = CharacterType.STUDENT;

	/** 获取用户角色类型 */
	public int getCharacterType() {
		return characterType;
	}

	/** 设置用户角色类型 */
	public void setCharacterType(int characterType) {
		this.characterType = characterType;
	}
	
	/** 用户角色编号 */
	private String characterId = "";

	/** 获取用户角色编号 */
	public String getCharacterId() {
		return characterId;
	}

	/** 设置用户角色编号 */
	public void setCharacterId(String characterId) {
		this.characterId = characterId;
	}
	
	/** 用户姓名（姓和名合并显示）*/
	private String fullName = "";

	/** 获取用户姓名（姓和名合并显示）*/
	public String getFullName() {
		return fullName;
	}

	/** 设置用户姓名（姓和名合并显示）*/
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	/** 用户性别 */
	private int sexType = UserSexType.UNKNOWN;

	/** 获取用户性别 */
	public int getSexType() {
		return sexType;
	}

	/** 设置用户性别 */
	public void setSexType(int sexType) {
		this.sexType = sexType;
	}
	
	
}
