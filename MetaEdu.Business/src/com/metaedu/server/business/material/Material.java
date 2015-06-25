package com.metaedu.server.business.material;

import java.util.Date;

import com.metaedu.server.utils.text.HashUtils;

/** 资料类
 * @author Sam
 * @date 2015-06-25
 * @version 1.0.0
 */
public class Material {

	/** 资料主键 */
	public String id = HashUtils.getUuidCompact();

	/** 获取资料主键 */
	public String getId() {
		return id;
	}

	/** 设置资料主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 文件管理云编号 */
	private String filefoxId = "";

	/** 获取文件管理云编号 */
	public String getFilefoxId() {
		return filefoxId;
	}

	/** 设置文件管理云编号 */
	public void setFilefoxId(String filefoxId) {
		this.filefoxId = filefoxId;
	}
	
	/** 文件名称 */
	private String name = "";

	/** 获取文件名称 */
	public String getName() {
		return name;
	}

	/** 设置文件名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 文件后缀 */
	private String suffix = "";

	/** 获取文件后缀 */
	public String getSuffix() {
		return suffix;
	}

	/** 设置文件后缀 */
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	/** 资料用途 */
	private int usingType = MaterialUsingType.NOT_POINTED;

	/** 获取资料用途 */
	public int getUsingType() {
		return usingType;
	}

	/** 设置资料用途 */
	public void setUsingType(int usingType) {
		this.usingType = usingType;
	}
	
	/** 文件大小 */
	private int size = 0;

	/** 获取文件大小 */
	public int getSize() {
		return size;
	}

	/** 设置文件大小 */
	public void setSize(int size) {
		this.size = size;
	}
	
	/** 资料明细（转换后数据）*/
	private String detail = "";

	/** 获取资料明细（转换后数据）*/
	public String getDetail() {
		return detail;
	}

	/** 设置资料明细（转换后数据）*/
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/** 是否有效 */
	public boolean isValid = true;

	/** 获取是否有效 */
	public boolean getIsValid() {
		return isValid;
	}

	/** 设置是否有效 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	
	/** 资料创建时间 */
	private Date createTime = new Date();
	
	/** 获取资料创建时间 */
	public Date getCreateTime() {
		return this.createTime;
	}
	
	/** 设置资料创建时间 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/** 资料更新时间 */
	private Date updateTime = new Date();
	
	/** 获取资料更新时间 */
	public Date getUpdateTime() {
		return this.updateTime;
	}

	/** 设置资料更新时间 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
	
}
