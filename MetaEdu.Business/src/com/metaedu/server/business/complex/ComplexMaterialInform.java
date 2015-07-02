package com.metaedu.server.business.complex;

import java.io.Serializable;

/** Complex 文件加载通知
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.12
 */
public class ComplexMaterialInform implements Serializable {

	private static final long serialVersionUID = 8951742206044072442L;
	
	/** 是否文档或位图类型 */
	private boolean isDocument = true;

	/** 是否文档或位图类型 */
	public boolean getIsDocument() {
		return isDocument;
	}

	/** 是否文档或位图类型 */
	public void setIsDocument(boolean isDocument) {
		this.isDocument = isDocument;
	}
	
	/** 文件名称 */
	private String name = "";

	/** 文件名称 */
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
		return this.suffix;
	}
	
	/** 设置文件后缀 */
	public void setSuffix(String refSuffix) {
		this.suffix = refSuffix;
	}
	
	/** 文件管理编号 */
	private String filefoxId = "";

	/** 获取文件管理编号 */
	public String getFilefoxId() {
		return filefoxId;
	}

	/** 设置文件管理编号 */
	public void setFilefoxId(String filefoxId) {
		this.filefoxId = filefoxId;
	}
	
	/** 文件辅助描述 */
	private String detail = "";

	/** 获取文件辅助描述 */
	public String getDetail() {
		return detail;
	}

	/** 设置文件辅助描述 */
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	/** 多媒体文件真实播放地址 */
	private String path = "";

	/** 多媒体文件真实播放地址 */
	public String getPath() {
		return path;
	}

	/** 多媒体文件真实播放地址 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/** 当前推送的页数 */
	private int page = 0;

	/** 当前推送的页数 */
	public int getPage() {
		return page;
	}

	/** 当前推送的页数 */
	public void setPage(int page) {
		this.page = page;
	}
	
	
	
	
}
