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
	
	/** 创建课次
	 * @param refLesson
	 * @return
	 */
	public boolean createLesson(Lesson refLesson);
	
	/** 更新课次
	 * @param refLesson
	 * @return
	 */
	public boolean updateLesson(Lesson refLesson);
	
	/** 移除课次
	 * @param refLessonId
	 * @return
	 */
	public boolean removeLesson(String refLessonId);
	
	
	
}
