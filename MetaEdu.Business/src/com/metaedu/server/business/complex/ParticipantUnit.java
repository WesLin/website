package com.metaedu.server.business.complex;

import java.io.Serializable;

/** 参与者单元
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public class ParticipantUnit implements Serializable {

	private static final long serialVersionUID = -250640071970788276L;
	
	/** 参与用户主键 */
	private String id="";

	/** 获取参与用户主键 */
	public String getId() {
		return id;
	}

	/** 设置参与用户主键 */
	public void setId(String id) {
		this.id = id;
	}
	
	/** 会话参与者类型，默认参与者 */
	private int type = ParticipantType.JOINER;
	
	/** 获取会话参与者类型 */
	public int getType() {
		return this.type;
	}
	
	/** 设置会话参与者类型 */
	public void setType(int refType) {
		this.type = refType;
	}
	
	
}
