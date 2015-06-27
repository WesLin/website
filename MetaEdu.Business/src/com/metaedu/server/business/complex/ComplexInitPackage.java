package com.metaedu.server.business.complex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/** Complex 初始化数据包
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public class ComplexInitPackage implements Serializable {

	private static final long serialVersionUID = 2847220458784536099L;
	
	/** 会话主键（如果来自某个课次，即课次的主键）*/
	private String id="";
	
	/** 获取会话主键（如果来自某个课次，即课次的主键）*/
	public String getId() {
		return id;
	}

	/** 设置会话主键（如果来自某个课次，即课次的主键）*/
	public void setId(String id) {
		this.id = id;
	}
	
	/** 会话名称（如果来自某个课次，即课次的名称）*/
	private String name="";
	
	/** 获取会话名称（如果来自某个课次，即课次的名称）*/
	public String getName() {
		return name;
	}

	/** 设置会话名称（如果来自某个课次，即课次的名称）*/
	public void setName(String name) {
		this.name = name;
	}
	
	/** 开始时间 */
	private Date beginTime = new Date();
	
	/** 获取开始时间 */
	public Date getBeginTime() {
		return beginTime;
	}

	/** 设置开始时间 */
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	
	/** 结束时间 */
	private Date overTime = new Date();
	
	/** 获取结束时间 */
	public Date getOverTime() {
		return overTime;
	}

	/** 设置结束时间 */
	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}
	
	/** 会话参与者集合（包括主讲） */
	private ArrayList<ParticipantUnit> participants = new ArrayList<ParticipantUnit>();

	/** 获取会话参与者集合（包括主讲） */
	public ArrayList<ParticipantUnit> getParticipants() {
		return participants;
	}

	/** 设置会话参与者集合（包括主讲） */
	public void setParticipants(ArrayList<ParticipantUnit> participants) {
		this.participants = participants;
	}
	
	/** 添加一个会话参与者
	 * @param refUnit
	 */
	public void addParticipant(ParticipantUnit refUnit) {
		this.participants.add(refUnit);
	}
	
	
	
}
