package com.metaedu.server.business.education;

import java.io.Serializable;

import com.metaedu.server.business.common.MultiName;

/** 年级名称
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class GradeName extends MultiName implements Serializable  {
	
	private static final long serialVersionUID = 2372477696907378179L;

	/** 构造函数
	 * @param refName 年级名称
	 * @param refLanguageType 名称语言类型
	 */
	public GradeName(String refName, int refLanguageType) {
		super(refName, refLanguageType);
	}
	
}
