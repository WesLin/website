package com.metaedu.server.website.web.controller;

/**
 * 服务端对哈希校验信令的反馈
 * 
 * @author Sam
 * @version 1.0
 * @since 2015.05.25
 */
public class ServerCheckHashResp {

	/** 是否存在该哈希 */
	private boolean isExist = false;

	/** 获取是否存在该哈希 */
	public boolean getIsExist() {
		return isExist;
	}

	/** 设置是否存在该哈希 */
	public void setIsExist(boolean refIsExist) {
		this.isExist = refIsExist;
	}

	/** 文件编号 */
	private String id;

	/** 获取文件编号 */
	public String getId() {
		return this.id;
	}

	/** 设置文件编号 */
	public void setId(String refId) {
		this.id = refId;
	}

	/** 文件转换状态 */
	private int transStatus;

	/** 获取文件转换状态 */
	public int getTransStatus() {
		return this.transStatus;
	}

	/** 设置文件转换状态 */
	public void setTransStatus(int refTransStatus) {
		this.transStatus = refTransStatus;
	}

	/** 文件下载 path */
	private String path = "";

	/** 获取文件下载 URI 前缀 */
	public String getPath() {
		return this.path;
	}

	/** 设置文件下载 URI 前缀 */
	public void setPath(String refPath) {
		this.path = refPath;
	}

	/** 明细 */
	private String detail;

	/** 获取明细 */
	public String getDetail() {
		return this.detail;
	}

	/** 设置明细 */
	public void setDetail(String refDetail) {
		this.detail = refDetail;
	}

	/** 页数 */
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	/** 文件类型 */
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
