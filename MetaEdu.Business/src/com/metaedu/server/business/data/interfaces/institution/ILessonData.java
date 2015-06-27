package com.metaedu.server.business.data.interfaces.institution;

import com.metaedu.server.business.institution.Lesson;

/** 课次基础数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.06.21
 */
public interface ILessonData {

	/** 获取指定编号的有效课次实体
	 * @param refLessonId
	 * @return
	 */
	public Lesson getValidLessonById(String refLessonId);
	
	
}
