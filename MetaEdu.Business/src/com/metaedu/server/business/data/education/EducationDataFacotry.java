package com.metaedu.server.business.data.education;

import com.metaedu.server.business.data.hessian.HessianFactory;

/** Education 所属接口数据接口类工厂
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class EducationDataFacotry {

	/** 机构学校基础数据接口单例 */
	private static IInstitutionQuery _institutionQueryImpl = null;
	
	/** 获取机构学校基础数据接口
	 * @return
	 */
	public synchronized static IInstitutionQuery getIInstitutionData() {
		if (_institutionQueryImpl == null) {
			_institutionQueryImpl = (IInstitutionQuery)HessianFactory.getFactory().getBean("IInstitutionQuery");
		}
		return _institutionQueryImpl;
	}

	
}
