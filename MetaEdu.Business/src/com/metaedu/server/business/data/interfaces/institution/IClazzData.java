package com.metaedu.server.business.data.interfaces.institution;

import com.metaedu.server.business.institution.Clazz;

/** 班级基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface IClazzData {
	
	/** 创建一个班级
	 * @param refClazz
	 * @return
	 */
	public boolean createClazz(Clazz refClazz);
	
	/** 更新一个班级
	 * @param refClazz
	 * @return
	 */
	public boolean updateClazz(Clazz refClazz);
	
}
