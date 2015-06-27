package com.metaedu.server.business.data.interfaces.complex;

import java.util.Date;

import com.metaedu.server.business.complex.ComplexInitPackage;
import com.metaedu.server.business.complex.ParticipantOpeUnit;

/** Complex 实时数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface IComplexExternalData {

	/** 初始化 Complex 会话
	 * @param refPackage
	 */
	public void initComplex(ComplexInitPackage refPackage);
	
	/** 会话参与者变更操作，增加或者删除
	 * @param refComplexId
	 * @param refUnit
	 */
	public void updateParticipant(String refComplexId, ParticipantOpeUnit refUnit);
	
	/** 变更会话结束时间
	 * @param refComplexId
	 * @param refDate
	 */
	public void updateOverTime(String refComplexId, Date refDate);
	
}
