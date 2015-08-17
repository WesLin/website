package com.metaedu.server.business.common;

import java.util.ArrayList;

/** 多语种及类型命名类所有者类
 * @author Sam
 * @version 1.0
 * @since 2015.05.17
 */
public interface MultiTypeNameOwner<T extends MultiTypeName> {
	
	/** 获取名称集合
	 * @return 名称集合
	 */
	public ArrayList<T> getNames();
	
	/** 获取指定语言类型的名称对象集合
	 * @param refLanguageType
	 * @return 指定语言类型的名称对象集合
	 */
	public ArrayList<T> getLanguageNames(int refLanguageType);
	
	/** 获取指定名称类型的名称对象集合
	 * @param refNameType
	 * @return 指定名称类型的名称对象集合
	 */
	public ArrayList<T> getTypeNames(int refNameType);
	
	/** 添加名称对象
	 * @param refName 待添加的名称对象
	 */
	public void addName(T refName);
	
	/** 获取指定语言类型及名称类型的名称集合
	 * @param refLanguageType 指定的语言类型
	 * @param refNameType 指定的名称类型
	 * @return 多个值时取第一个值，或者返回无效字
	 */
	public ArrayList<String> getNameValues(int refLanguageType, int refNameType);
	
	/** 获取指定语言类型及名称类型的名称值（有多个值时取第一个值）
	 * @param refLanguageType 指定的语言类型
	 * @param refNameType 指定的名称类型
	 * @return 多个值时取第一个值，或者返回无效字
	 */
	public String getNameValue(int refLanguageType, int refNameType);
	
	
	
}
