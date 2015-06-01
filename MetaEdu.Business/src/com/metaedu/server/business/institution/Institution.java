package com.metaedu.server.business.institution;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import com.metaedu.server.business.common.MultiTypeNameOwner;
import com.metaedu.server.business.education.EduSystemType;

/** 机构或学校
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class Institution implements MultiTypeNameOwner<InstitutionName>, Serializable  {

	/** 序列化标识  */
	private static final long serialVersionUID = 7312528179357102691L;
	
	/** 机构主键 */
	private String _id;
	
	/** 获取机构主键
	 * @return
	 */
	public String getId() {
		return this._id;
	}
	
	/** 设置机构主键
	 * @param refId
	 */
	public void setId(String refId) {
		this._id = refId;
	}
	
	/** 机构名称集合 */
	private ArrayList<InstitutionName> _names = new ArrayList<InstitutionName>();
	
	/** 获取名称集合
	 * @return
	 */
	public ArrayList<InstitutionName> getNames() {
		return this._names;
	}
	
	/** 设置名称集合
	 * @param refNames
	 */
	public void setNames(ArrayList<InstitutionName> refNames) {
		this._names = refNames;
	}
	
	/** 获取指定语言类型的名称对象集合
	 * @param refLanguageType
	 * @return
	 */
	public ArrayList<InstitutionName> getLanguageNames(int refLanguageType) {
		ArrayList<InstitutionName> curRtn = new ArrayList<InstitutionName>();
		if (this._names.size() > 0) {
			for (InstitutionName tmpName : this._names) {
				if (tmpName.getLanguageType() == refLanguageType) curRtn.add(tmpName);
			}
		}
		return curRtn;
	}
	
	/** 获取指定名称类型的名称对象集合
	 * @param refNameType
	 * @return
	 */
	public ArrayList<InstitutionName> getTypeNames(int refNameType) {
		ArrayList<InstitutionName> curRtn = new ArrayList<InstitutionName>();
		if (this._names.size() > 0) {
			for (InstitutionName tmpName : this._names) {
				if (tmpName.getNameType() == refNameType) curRtn.add(tmpName);
			}
		}
		return curRtn;
	}
	
	/** 添加名称对象
	 * @param refName
	 */
	public void addName(InstitutionName refName) {
		this._names.add(refName);
	}
	
	/** 获取指定语言类型及名称类型的名称集合
	 * @param refLanguageType 指定的语言类型
	 * @param refNameType 指定的名称类型
	 * @return 多个值时取第一个值，或者返回无效字
	 */
	public ArrayList<String> getNameValues(int refLanguageType, int refNameType) {
		ArrayList<String> curRtn = new ArrayList<String>();
		if (this._names.size() > 0) {
			for (InstitutionName tmpName : this._names) {
				if (tmpName.getNameType() == refNameType && tmpName.getLanguageType() == refLanguageType) curRtn.add(tmpName.getName());
			}
		}
		return curRtn;
	}
	
	/** 获取指定语言类型及名称类型的名称值（有多个值时取第一个值）
	 * @param refLanguageType 指定的语言类型
	 * @param refNameType 指定的名称类型
	 * @return 多个值时取第一个值，或者返回无效字
	 */
	public String getNameValue(int refLanguageType, int refNameType) {
		String curRtn = "no defined multitypename";
		if (this._names.size() > 0) {
			for (InstitutionName tmpName : this._names) {
				if (tmpName.getNameType() == refNameType && tmpName.getLanguageType() == refLanguageType) {
					return tmpName.getName();
				}
			}
		}
		return curRtn;
	}
	
	/** 学制类型集合 */
	private ArrayList<EduSystemType> _eduSystemTypes = new ArrayList<EduSystemType>(); 
	
	/** 获取学制类型集合
	 * @return
	 */
	public ArrayList<EduSystemType> getEduSystemTypes() {
		return this._eduSystemTypes;
	}
	
	/** 设置学制类型集合
	 * @param refTypes
	 */
	public void setEduSystemTypes(ArrayList<EduSystemType> refTypes) {
		this._eduSystemTypes = refTypes;
	}
	
	/** 创建时间 */
	private Date _createTime = new Date();
	
	/** 获取创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return this._createTime;
	}
	
	/** 设置创建时间
	 * @param refDate
	 */
	public void setCreateTime(Date refDate) {
		this._createTime = refDate;
	}
	
	/** 更新时间 */
	private Date _updateTime = new Date();
	
	/** 获取更新时间
	 * @return
	 */
	public Date getUpdateTime() {
		return this._updateTime;
	}
	
	/** 设置更新时间
	 * @param refDate
	 */
	public void setUpdateTime(Date refDate) {
		this._updateTime = refDate;
	}
	
	/** 基本构造函数 */
	public Institution() {}
	
	/** 构造函数
	 * @param refId 机构主键
	 * @param refCreateTime 创建时间
	 * @param refUpdateTime 修改时间
	 */
	public Institution(String refId, Date refCreateTime, Date refUpdateTime) {
		this._id = refId;
		this._createTime = refCreateTime;
		this._updateTime = refUpdateTime;
	}
	
	
	
}
