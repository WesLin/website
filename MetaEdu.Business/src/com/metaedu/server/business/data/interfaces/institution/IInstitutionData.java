package com.metaedu.server.business.data.interfaces.institution;

import com.metaedu.server.business.institution.Institution;

/** 机构学校基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IInstitutionData {

	/** 获取指定编号的机构实例
	 * @param refId 机构实例的编号
	 * @return
	 */
	public Institution getInstitutionById(String refInstitutionId);
	
	
}
