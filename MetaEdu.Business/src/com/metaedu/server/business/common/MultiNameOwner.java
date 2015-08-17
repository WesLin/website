package com.metaedu.server.business.common;

import java.util.ArrayList;

/** 多语种命名类所有者接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.17
 */
public interface MultiNameOwner<T extends MultiName> {
	
	/** 获取名称集合
	 * @return 名称集合列表
	 */
	public ArrayList<T> getNames();
	
	/** 获取指定语言类型的名称对象 */
	public T getName(int refLanguageType);
	
	/** 添加名称对象
	 * @param refName 命名对象
	 */
	public void addName(T refName);
	
	/** 获取指定语言类型的名称值
	 * @param refLanguageType 指定的语言类型
	 * @return 指定语言类型的名称字符串
	 */
	public String getNameValue(int refLanguageType);
	
}
