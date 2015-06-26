package com.metaedu.server.business.data.hessian;

import com.metaedu.server.business.data.interfaces.institution.IClazzData;
import com.metaedu.server.business.data.interfaces.institution.ICourseData;
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
	
	/** 班级管理基础数据接口单例 */
	private static IClazzData _clazzDataImpl = null;
	
	/** 获取班级管理基础数据接口 */
	public synchronized static IClazzData getClazzData() {
		if (_clazzDataImpl == null) _clazzDataImpl = (IClazzData)HessianFactory.getFactory().getBean("ClazzData");
		return _clazzDataImpl;
	}
	
	/** 课程管理基础数据接口单例 */
	private static ICourseData _courseDataImpl = null;
	
	/** 获取课程管理基础数据接口 */
	public synchronized static ICourseData getCourseData() {
		if (_courseDataImpl == null) _courseDataImpl = (ICourseData)HessianFactory.getFactory().getBean("CourseData");
		return _courseDataImpl;
	}
	
	/** 业务群数据接口单例 */
	private static IGroupExternalData _groupExternalDataImpl = null;
	
	/** 获取业务群数据接口单例 */
	public synchronized static IGroupExternalData getGroupExternalData() {
		if (_groupExternalDataImpl == null) _groupExternalDataImpl = (IGroupExternalData)HessianFactory.getFactory().getBean("GroupExternalData");
		return _groupExternalDataImpl;
	}
	
	
	
	

	
}
