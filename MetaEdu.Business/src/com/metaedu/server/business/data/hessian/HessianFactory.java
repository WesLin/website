package com.metaedu.server.business.data.hessian;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metaedu.server.utils.file.ApplicationContextUtils;

/** 数据服务配置类
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class HessianFactory {

	/** Spring 容器单例 */
	private static ApplicationContext _context = null;
	
	/** 获取容器单例 */
	public static ApplicationContext getFactory() {
		return _context;
	}
	
	/** 静态方法 */
	static {
		//ApplicationContext curContext = new ClassPathXmlApplicationContext("classpath:/com/metaedu/business/data/hessian/hessian-config.xml");
		ApplicationContext curContext = ApplicationContextUtils.getApplicationContextByBackupXML("/WEB-INF/hessian-config.xml", "classpath:/com/metaedu/business/data/hessian/hessian-config.xml");
		_context = curContext;
	}
	
	
}
