package com.metaedu.server.business.institution;

import java.io.Serializable;

import com.metaedu.server.business.common.MultiTypeName;

/** 机构或学校名称
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class InstitutionName extends MultiTypeName implements Serializable {
	
	private static final long serialVersionUID = 518981181926642989L;

	/** 构造函数
	 * @param refName 命名值
	 * @param refNameType 命名类型
	 * @param refLanguageType 所用语种
	 */
	public InstitutionName(String refName, int refNameType, int refLanguageType) {
		super(refName, refNameType, refLanguageType);
	}
	
	/** 构造函数
	 * @param refId 命名主键
	 * @param refName 命名值
	 * @param refNameType 命名类型
	 * @param refLanguageType 所用语种
	 */
	public InstitutionName(String refId, String refName, int refNameType, int refLanguageType) {
		super(refId, refName, refNameType, refLanguageType);
	}
	
}
