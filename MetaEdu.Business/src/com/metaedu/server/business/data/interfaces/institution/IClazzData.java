package com.metaedu.server.business.data.interfaces.institution;

import java.util.List;

import com.metaedu.server.business.institution.Clazz;
import com.metaedu.server.business.user.User;

/** 班级基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface IClazzData {
	
	/** 获取指定主键的一个有效班级
	 * @param refClazzId
	 * @return
	 */
	public Clazz getValidClazzById(String refClazzId);
	
	/** 获取指定课程的所有相关班级
	 * @param refCourseId
	 * @return
	 */
	public List<Clazz> getClazzsByCourseId(String refCourseId);
	
	/** 创建一个班级
	 * @param refClazz
	 * @return
	 */
	public boolean createClazz(Clazz refClazz);
	
	/** 更新一个班级
	 * @param refClazz
	 * @return
	 */
	public boolean updateClazz(Clazz refClazz);
	
	/** 移除一个班级
	 * @param refClazzId
	 * @return
	 */
	public boolean removeClazz(String refClazzId);
	
	/** 添加一个用户到班级中
	 * @param refClazzId
	 * @param refInstitutionId
	 * @param refUser
	 * @param refCharacterType
	 * @return
	 */
	public boolean addClazzUser(String refClazzId, String refInstitutionId, User refUser, int refCharacterType);
	
	/** 从班级中移除一个用户
	 * @param refClazzId
	 * @param refInstitutionId
	 * @param refUserId
	 * @return
	 */
	public boolean removeClazzUser(String refClazzId, String refInstitutionId, String refUserId, int refCharacterType);
	
	
}
