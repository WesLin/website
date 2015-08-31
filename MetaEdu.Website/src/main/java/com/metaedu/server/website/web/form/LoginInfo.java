package com.metaedu.server.website.web.form;

/** 登录用信息
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class LoginInfo extends BaseForm {

	
	/** 机构编号 */
	private String institutionId = "";
	
	/** 获取机构编号 */
	public String getInstitutionId() {
		return this.institutionId;
	}

	/** 设置机构编号 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/** 登录账号 */
	private String account = "";
	
	/** 获取登录账号 */
	public String getAccount() {
		return account;
	}

	/** 设置机构编号 */
	public void setAccount(String account) {
		this.account = account;
	}
	
	/** 登录密码 */
	private String password = "";
	
	/** 获取登录密码 */
	public String getPassword() {
		return password;
	}

	/** 设置登录密码 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
