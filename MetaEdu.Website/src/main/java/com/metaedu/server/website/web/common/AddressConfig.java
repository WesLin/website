package com.metaedu.server.website.web.common;

import org.springframework.context.ApplicationContext;

import com.metaedu.server.utils.file.ApplicationContextUtils;

/** 地址配置类
 * @author Sam
 * @date 2015-05-27
 * @version 1.0.0
 */
public class AddressConfig {


	/** 地址配置单例 */
	private static ApplicationContext _context = null;
	
	/** 获取地址配置单例 */
	public static ApplicationContext getContext() {
		return _context;
	}
	
	/** 静态方法 */
	static {
		_context = ApplicationContextUtils.getApplicationContextByXML("/WEB-INF/address-config.xml");
	}
	
}
