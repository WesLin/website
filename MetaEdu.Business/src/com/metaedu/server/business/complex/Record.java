package com.metaedu.server.business.complex;

import java.io.Serializable;

/** Complex 会话录像类
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public class Record implements Serializable {

	private static final long serialVersionUID = -3609919487560171818L;
	
	/** 录像（会话）主键 */
	private String id;

	/** 录像（会话）主键 */
	public String getId() {
		return id;
	}

	/** 录像（会话）主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 录像内容 */
	private String content;

	/** 录像内容 */
	public String getContent() {
		return content;
	}

	/** 录像内容 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	
}
