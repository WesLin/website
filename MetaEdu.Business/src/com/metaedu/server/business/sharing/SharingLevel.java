package com.metaedu.server.business.sharing;

/** 共享级别
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class SharingLevel {

	/** 完全共享 */
	public static final int OPEN = 0;
	
	/** 私有（仅创建者，包括机构和个人可以使用，个人上传资源默认私人使用）*/
	public static final int PRIVATE = 1;
	
	/** 指定共享（可以选择机构或协作体与资源联盟内共享）*/
	public static final int POINTED = 2;
	
}
