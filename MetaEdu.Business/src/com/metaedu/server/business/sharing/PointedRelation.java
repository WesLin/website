package com.metaedu.server.business.sharing;

import java.util.Date;

/** 指定共享关系
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public class PointedRelation {

	/** 共享关系主键 */
	private String _id;
	
	/** 获取共享关系主键
	 * @return
	 */
	public String getId() {
		return this._id;
	}
	
	/** 指定共享类型，默认机构 */
	private int _pointedType = PointedType.INSTITUTION;
	
	/** 获取指定共享类型
	 * @return
	 */
	public int getPointedType() {
		return this._pointedType;
	}
	
	/** 指定共享对象的主键 */
	private String _pointedTargetId;
	
	/** 获取指定共享对象的主键
	 * @return
	 */
	public String getPointedTargetId() {
		return this._pointedTargetId;
	}
	
	/** 关系是否已经删除，默认否 */
	private boolean _isDeleted = false;
	
	/** 获取关系是否已经删除
	 * @return
	 */
	public boolean getIsDeleted() {
		return this._isDeleted;
	}
	
	/** 关系创建时间 */
	private Date _createTime;
	
	/** 获取关系创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return this._createTime;
	}
	
	/** 关系修改时间 */
	private Date _updateTime;
	
	/** 获取关系修改时间
	 * @return
	 */
	public Date getUpdateTime() {
		return this._updateTime;
	}
	
	
	
}
