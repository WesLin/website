package com.metaedu.server.business.common;

import java.util.Date;

import com.metaedu.server.utils.text.TimeUtils;

/** 基础比较值
 * @author Sam
 * @version 1.0
 * @since 2015.05.17
 */
public class BasicValue {

	/** 未定义时间，基准值为 1900-01-01，用于未指定或者未限定的时间 */
	public static final Date UNDEFINED_DATE = TimeUtils.getDateFromString("1900-01-01 00:00:00");
	
	
}
