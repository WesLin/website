package com.metaedu.server.business.complex;

import java.io.Serializable;

import com.metaedu.server.business.user.UserSexType;

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
	
	/** 与会者姓 */
	private String surname;

	/** 与会者姓 */
	public String getSurname() {
		return surname;
	}

	/** 与会者姓 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/** 与会者名 */
	private String name;

	/** 与会者名 */
	public String getName() {
		return name;
	}

	/** 与会者名 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** 与会者性别 */
	private int sex = UserSexType.UNKNOWN;

	/** 与会者性别 */
	public int getSex() {
		return sex;
	}

	/** 与会者性别 */
	public void setSex(int sex) {
		this.sex = sex;
	}
	
	
}