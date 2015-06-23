package com.metaedu.server.business.data.hessian;

import com.metaedu.server.business.data.interfaces.institution.IInstitutionData;
import com.metaedu.server.business.data.interfaces.social.IGroupExternalData;
import com.metaedu.server.business.data.interfaces.user.IUserData;

/** 接口数据类工厂
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class DataFactory {

	/** 用户基础数据接口单例 */
	private static IUserData _userDataImpl = null;
	
	/** 获取用户基础数据接口 */
	public synchronized static IUserData getUserData() {
		if (_userDataImpl == null) _userDataImpl = (IUserData)HessianFactory.getFactory().getBean("UserData");
		return _userDataImpl;
	}
	
	/** 机构学校基础数据接口单例 */
	private static IInstitutionData _institutionDataImpl = null;
	
	/** 获取机构学校基础数据接口 */
	public synchronized static IInstitutionData getInstitutionData() {
		if (_institutionDataImpl == null) _institutionDataImpl = (IInstitutionData)HessianFactory.getFactory().getBean("InstitutionData");
		return _institutionDataImpl;
	}
	
	/** 业务群数据接口单例 */
	private static IGroupExternalData _groupExternalDataImpl = null;
	
	/** 获取业务群数据接口单例 */
	public synchronized static IGroupExternalData getGroupExternalData() {
		if (_groupExternalDataImpl == null) _groupExternalDataImpl = (IGroupExternalData)HessianFactory.getFactory().getBean("GroupExternalData");
		return _groupExternalDataImpl;
	}
	
	
	
	

	
}
