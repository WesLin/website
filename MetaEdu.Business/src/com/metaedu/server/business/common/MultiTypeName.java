package com.metaedu.server.business.common;

/** 多语种及类型命名类基类
 * @author Sam
 * @version 1.0
 * @since 2015.05.17
 */
public class MultiTypeName {

	/** 命名主键（可能没有）*/
	protected String _id = "";
	
	/** 设置命名主键
	 * @param refId 命名主键
	 */
	public void setId(String refId) {
		this._id = refId;
	}
	
	/** 获取命名主键（可能没有）
	 * @return 命名主键
	 */
	public String getId() {
		return this._id;
	}
	
	/** 命名 */
	protected String _name = "";
	
	/** 获取命名
	 * @return 命名字符串
	 */
	public String getName() {
		return this._name;
	}
	
	/** 命名所用语种（默认简中）*/
	protected int _languageType = LanguageType.SIMPLIFIED_CHINESE;
	
	/** 获取命名所用语种
	 * @return 所用语种类型
	 */
	public int getLanguageType() {
		return this._languageType;
	}
	
	/** 命名类型，默认正式命名 */
	protected int _nameType = NameType.FORMAL;
	
	/** 获取命名类型
	 * @return 命名类型值
	 */
	public int getNameType() {
		return this._nameType;
	}
	
	
	/** 构造函数
	 * @param refName 命名值
	 * @param refNameType 命名类型
	 * @param refLanguageType 所用语种
	 */
	protected MultiTypeName(String refName, int refNameType, int refLanguageType) {
		this._name = refName;
		this._nameType = refNameType;
		this._languageType = refLanguageType;
	}
	
	/** 构造函数
	 * @param refId 命名主键
	 * @param refName 命名值
	 * @param refNameType 命名类型
	 * @param refLanguageType 所用语种
	 */
	protected MultiTypeName(String refId, String refName, int refNameType, int refLanguageType) {
		this._id = refId;
		this._name = refName;
		this._nameType = refNameType;
		this._languageType = refLanguageType;
	}
	
}
