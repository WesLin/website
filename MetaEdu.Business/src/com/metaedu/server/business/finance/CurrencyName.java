package com.metaedu.server.business.finance;

import java.io.Serializable;

import com.metaedu.server.business.common.MultiName;

/** 现金名称
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class CurrencyName extends MultiName implements Serializable {

	private static final long serialVersionUID = 1812201344476923680L;

	/** 构造函数
	 * @param refName 现金名称
	 * @param refLanguageType 名称语言类型
	 */
	public CurrencyName(String refName, int refLanguageType) {
		super(refName, refLanguageType);
	}
	
}
