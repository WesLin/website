package com.metaedu.server.website.web.form;

/** 页面传参对象基类
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
public class BaseForm {

	/** 检查通过 */
	private boolean checkPass = true;

	/** 是否检查通过 */
	public boolean isCheckPass() {
		return checkPass;
	}

	/** 设置检查通过 */
	public void setCheckPass(boolean checkPass) {
		this.checkPass = checkPass;
	}
	
	
	
}
