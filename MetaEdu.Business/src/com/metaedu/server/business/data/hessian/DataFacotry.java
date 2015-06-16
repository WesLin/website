package com.metaedu.server.business.data.hessian;

import com.metaedu.server.business.data.education.IInstitutionQuery;
import com.metaedu.server.business.data.user.IUserQuery;

/** 接口数据类工厂
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class DataFacotry {

	/** 用户基础数据接口单例 */
	private static IUserQuery _userQueryImpl = null;
	
	/** 获取用户基础数据接口 */
	public synchronized static IUserQuery getUser() {
		if (_userQueryImpl == null) _userQueryImpl = (IUserQuery)HessianFactory.getFactory().getBean("IUserQuery");
		return _userQueryImpl;
	}
	
	/** 机构学校基础数据接口单例 */
	private static IInstitutionQuery _institutionQueryImpl = null;
	
	/** 获取机构学校基础数据接口 */
	public synchronized static IInstitutionQuery getInstitution() {
		if (_institutionQueryImpl == null) _institutionQueryImpl = (IInstitutionQuery)HessianFactory.getFactory().getBean("IInstitutionQuery");
		return _institutionQueryImpl;
	}

	
}
