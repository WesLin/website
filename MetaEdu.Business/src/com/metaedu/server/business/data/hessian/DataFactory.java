package com.metaedu.server.business.data.hessian;

import com.metaedu.server.business.data.interfaces.institution.IInstitutionData;
import com.metaedu.server.business.data.interfaces.social.ISimpleGroupOpe;
import com.metaedu.server.business.data.interfaces.user.IUserData;

/** 接口数据类工厂
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class DataFactory {

	/** 用户基础数据接口单例 */
	private static IUserData _userQueryImpl = null;
	
	/** 获取用户基础数据接口 */
	public synchronized static IUserData getUserQuery() {
		if (_userQueryImpl == null) _userQueryImpl = (IUserData)HessianFactory.getFactory().getBean("IUserQuery");
		return _userQueryImpl;
	}
	
	/** 机构学校基础数据接口单例 */
	private static IInstitutionData _institutionQueryImpl = null;
	
	/** 获取机构学校基础数据接口 */
	public synchronized static IInstitutionData getInstitutionQuery() {
		if (_institutionQueryImpl == null) _institutionQueryImpl = (IInstitutionData)HessianFactory.getFactory().getBean("IInstitutionQuery");
		return _institutionQueryImpl;
	}
	
	/** 业务群数据接口单例 */
	private static ISimpleGroupOpe _groupQueryImpl = null;
	
	/** 获取业务群数据接口单例 */
	public synchronized static ISimpleGroupOpe getGroupQuery() {
		if (_groupQueryImpl == null) _groupQueryImpl = (ISimpleGroupOpe)HessianFactory.getFactory().getBean("IGroupQuery");
		return _groupQueryImpl;
	}
	
	
	
	

	
}
