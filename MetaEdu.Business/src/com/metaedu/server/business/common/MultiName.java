package com.metaedu.server.business.common;

/** 多语种命名类基类
 * @author Sam
 * @version 1.0
 * @since 2015.05.17
 */
public class MultiName {

	/** 命名主键（可能没有）*/
	protected String _id = "";
	
	/** 设置命名主键
	 * @param refId
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
	 * @return
	 */
	public String getName() {
		return this._name;
	}
	
	/** 命名所用语种（默认简中）*/
	protected int _languageType = LanguageType.SIMPLIFIED_CHINESE;
	
	/** 获取命名所用语种
	 * @return
	 */
	public int getLanguageType() {
		return this._languageType;
	}
	
	/** 构造函数
	 * @param refName 命名值
	 * @param refLanguageType 所用语种
	 */
	protected MultiName(String refName, int refLanguageType) {
		this._name = refName;
		this._languageType = refLanguageType;
	}
	
	/** 构造函数
	 * @param refId 命名主键
	 * @param refName 命名值
	 * @param refLanguageType 所用语种
	 */
	protected MultiName(String refId, String refName, int refLanguageType) {
		this._id = refId;
		this._name = refName;
		this._languageType = refLanguageType;
	}
	
	
}
