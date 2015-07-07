package com.metaedu.server.business.user;

import java.io.Serializable;
import java.util.Date;

import com.metaedu.server.utils.text.TimeUtils;

/** 用户类
 * @author Sam
 * @version 1.0
 * @since 2015.06.16
 */
public class User implements Serializable {

	private static final long serialVersionUID = 2516261720714051988L;
	
	/** 用户主键 */
	//private String id = HashUtils.getUuidCompact();
	private String id = TimeUtils.getNebulaTimestamp(new Date());

	/** 获取用户主键 */
	public String getId() {
		return id;
	}

	/** 设置用户主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 用户通用登录账号 */
	private String account = "";

	/** 获取用户通用登录账号 */
	public String getAccount() {
		return account;
	}

	/** 设置用户通用登录账号 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/** 用户通用登录密码 */
	private String password = "";
	
	/** 获取用户通用登录密码 */
	public String getPassword() {
		return password;
	}

	/** 设置用户通用登录密码 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/** 用户名 */
	private String name = "";

	/** 获取用户名 */
	public String getName() {
		return name;
	}

	/** 设置用户名 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 用户姓 */
	private String surname = "";

	/** 获取用户姓 */
	public String getSurname() {
		return surname;
	}

	/** 设置用户姓 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/** 生日 */
	private Date birthday = TimeUtils.getDateFromString("1900-01-01 00:00:00");
	
	/** 获取生日 */
	public Date getBirthday() {
		return this.birthday;
	}
	
	/** 设置生日 */
	public void setBirthday(Date refBirthday) {
		this.birthday = refBirthday;
	}
	
	/** 用户性别，默认未知 */
	private int sex = -1;
	
	/** 获取用户性别 */
	public int getSex() {
		return this.sex;
	}
	
	/** 设置用户性别 */
	public void setSex(int refSex) {
		this.sex = refSex;
	}
	
	/** 用户头像（Filefox ID）*/
	private String avatar = "";
	
	/** 获取用户头像（Filefox ID）*/
	public String getAvatar() {
		return avatar;
	}

	/** 设置用户头像（Filefox ID）*/
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	/** 用户昵称 */
	private String nickname = "";

	/** 获取用户昵称 */
	public String getNickname() {
		return nickname;
	}

	/** 设置用户昵称 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/** 是否有效用户（用户无效有两种情况：被屏蔽或者被账号合并） */
	private boolean isValid = true;

	/** 获取是否有效用户（用户无效有两种情况：被屏蔽或者被账号合并） */
	public boolean getIsValid() {
		return isValid;
	}

	/** 设置是否有效用户（用户无效有两种情况：被屏蔽或者被账号合并） */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/** 是否屏蔽账户 */
	private boolean isForbidden = false;

	/** 获取是否屏蔽账户 */
	public boolean getIsForbidden() {
		return isForbidden;
	}

	/** 设置是否屏蔽账户 */
	public void setIsForbidden(boolean isForbidden) {
		this.isForbidden = isForbidden;
	}
	
	/** 被合并至的账号 */
	private String mergeId = "";

	/** 获取被合并至的账号 */
	public String getMergeId() {
		return mergeId;
	}

	/** 设置被合并至的账号 */
	public void setMergeId(String mergeId) {
		this.mergeId = mergeId;
	}
	
	/** 创建时间 */
	private Date createTime = new Date();

	/** 获取创建时间 */
	public Date getCreateTime() {
		return createTime;
	}

	/** 设置创建时间 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** 更新时间 */
	private Date updateTime = new Date();

	/** 获取更新时间 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/** 设置更新时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
