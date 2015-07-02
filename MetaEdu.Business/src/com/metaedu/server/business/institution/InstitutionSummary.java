package com.metaedu.server.business.institution;

/** 机构或学校信息摘要
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class InstitutionSummary {

	/** 机构编号 */
	private String id = "";

	/** 获取机构编号 */
	public String getId() {
		return id;
	}

	/** 设置机构编号 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 机构名称 */
	private String name = "";

	/** 获取机构名称 */
	public String getName() {
		return name;
	}

	/** 设置机构名称 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 缩写 */
	private String abbr = "";

	/** 获取缩写 */
	public String getAbbr() {
		return abbr;
	}

	/** 设置缩写 */
	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}
	
	
	
	
	
}
