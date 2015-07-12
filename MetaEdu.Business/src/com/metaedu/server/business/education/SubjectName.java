package com.metaedu.server.business.education;

import java.io.Serializable;

import com.metaedu.server.business.common.MultiName;


/** 科目名称
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class SubjectName extends MultiName implements Serializable {

	private static final long serialVersionUID = 4466724757024972313L;

	/** 构造函数
	 * @param refName 科目名称
	 * @param refLanguageType 科目类型
	 */
	protected SubjectName(String refName, int refLanguageType) {
		super(refName, refLanguageType);
	}

}
