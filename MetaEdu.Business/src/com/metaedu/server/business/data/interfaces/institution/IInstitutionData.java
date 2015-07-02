package com.metaedu.server.business.data.interfaces.institution;

import java.util.List;

import com.metaedu.server.business.institution.Institution;
import com.metaedu.server.business.institution.InstitutionSummary;

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
	
	/** 根据机构的各类名称输出相近机构摘要信息
	 * @param refName 机构各类名称
	 * @return
	 */
	public List<InstitutionSummary> getInstitutionSummaryByName(String refName);
	
	/** 创建一个机构
	 * @param refInstitution
	 * @return
	 */
	//public boolean createInstitution(Institution refInstitution);
	
	
}
