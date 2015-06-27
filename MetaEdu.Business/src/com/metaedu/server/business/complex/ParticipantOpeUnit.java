package com.metaedu.server.business.complex;

/** 参与者操作单元
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public class ParticipantOpeUnit {

	/** 参与者 */
	private ParticipantUnit unit = null;

	/** 获取参与者 */
	public ParticipantUnit getUnit() {
		return unit;
	}

	/** 设置参与者 */
	public void setUnit(ParticipantUnit unit) {
		this.unit = unit;
	}
	
	/** 操作类型，默认增加 */
	private int opeType = ParticipantOpeType.ADD;

	/** 获取操作类型，增加或者删除 */
	public int getOpeType() {
		return opeType;
	}

	/** 设置操作类型，增加或者删除 */
	public void setOpeType(int opeType) {
		this.opeType = opeType;
	}
	
	
	
}
