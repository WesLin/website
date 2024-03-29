package com.metaedu.server.business.data.interfaces.education;

import com.metaedu.server.business.complex.Record;
import com.metaedu.server.business.education.Lesson;

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
	
	/** 获取指定课次的录像
	 * @param refLessonId 指定的课次主键
	 * @return
	 */
	public Record getLessonRecordById(String refLessonId);
	
	/** 创建课次录像
	 * @param refLessonId 指定的课次主键
	 * @param refRecord 录像实体（主键和课次主键一致）
	 * @return
	 */
	public boolean createLessonRecord(String refLessonId, Record refRecord);
	
	/** 删除课次录像
	 * @param refLessonId 录像对应的课次主键
	 * @return
	 */
	public boolean removeLessonRecord(String refLessonId);
	
}
