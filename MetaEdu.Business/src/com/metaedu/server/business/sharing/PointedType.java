package com.metaedu.server.business.sharing;

/** 指定共享类型
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class PointedType {

	/** 共享至指定个人 */
	public static final int PERSON = 1;
	
	/** 共享至指定班级关系范围 */
	public static final int CLAZZ = 2;
	
	/** 共享至指定课程关系范围 */
	public static final int COURSE = 3;
	
	/** 共享至机构或者资源联盟，教务或管理员默认机构内使用 */
	public static final int INSTITUTION = 4;
	
}
