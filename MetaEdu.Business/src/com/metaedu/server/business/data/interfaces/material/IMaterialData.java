package com.metaedu.server.business.data.interfaces.material;

import com.metaedu.server.business.material.Material;

/** 资料数据接口
 * @author Sam
 * @version 1.0
 * @since 2015.05.18
 */
public interface IMaterialData {

	
	/** 根据主键获取一个有效资料
	 * @param refMaterialId 指定的资料主键
	 * @return 资料实体或 Null
	 */
	public Material getValidMaterialById(String refMaterialId);
	
	
	/** 根据主键值获取一个资料实体
	 * @param refMaterialId 指定的资料主键
	 * @param refValidLimited 是否限定必须为有效资料
	 * @return 资料实体或 Null
	 */
	public Material getMaterialById(String refMaterialId, boolean refValidLimited);
	
	
	/** 根据 Filefox ID 获取文件资料
	 * @param refFilefoxId 指定资料数据的 FileFox 主键
	 * @return 资料实体或 Null
	 */
	public Material getMaterialByFilefoxId(String refFilefoxId);
	
	
	/** 创建一个资料
	 * @param refMaterial 待创建的资料实体
	 * @return 是否创建成功
	 */
	public boolean createMaterial(Material refMaterial);
	
	
	/** 更新一个资料
	 * @param refMaterial 待更新的资料实体
	 * @return 是否更新成功
	 */
	public boolean updateMaterial(Material refMaterial);
	
	
}
