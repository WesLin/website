package com.metaedu.server.business.education;

import java.io.Serializable;

import com.metaedu.server.business.common.MultiName;

/** 学制名称
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class EduSystemName extends MultiName implements Serializable  {
	
	private static final long serialVersionUID = -3189834381081241979L;

	/** 构造函数
	 * @param refName 学制名称
	 * @param refLanguageType 名称语言类型
	 */
	public EduSystemName(String refName, int refLanguageType) {
		super(refName, refLanguageType);
	}
	
}
