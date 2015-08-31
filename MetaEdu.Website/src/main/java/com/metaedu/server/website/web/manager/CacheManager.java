package com.metaedu.server.website.web.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.metaedu.server.business.data.hessian.DataFactory;
import com.metaedu.server.business.metaweb.InstitutionSummary;
import com.metaedu.server.log.LogPak;

/** 缓存管理类
 * @author Sam
 * @version Pre_1.0
 * @since 2015.05.14
 */
public class CacheManager {

	/** 日志类 */
	private static LogPak log = new LogPak(CacheManager.class);
	
	/** 缓存管理类 */
	private static CacheManager instance = null;
	
	/** 获取缓存管理类单例 */
	public synchronized static CacheManager getInstance() {
		if (instance == null) instance = new CacheManager();
		return instance;
	}
	
	/** 机构摘要信息缓存表 */
	private ConcurrentHashMap<String, List<InstitutionSummary>> institutionSummaryCache = new ConcurrentHashMap<String, List<InstitutionSummary>>();
	
	/** 缓存指定名称的机构摘要集合 */
	public void setInstitutionSummary(String refName, List<InstitutionSummary> refData) {
		this.institutionSummaryCache.putIfAbsent(refName, refData);
	}
	
	/** 空机构信息数据引用 */
	private List<InstitutionSummary> institutionEmptyList = new ArrayList<InstitutionSummary>();
	
	/** 获取指定查询名称的相关机构摘要集合
	 * @param refName
	 * @return
	 */
	public List<InstitutionSummary> getInstitutionSummary(String refName) {
		//if (refName != null && refName.length() > 0) {
		log.debug("getInstitutionSummary", "获取指定名称为 " + refName + " 的相关机构信息");
		if (refName != null) {
			if (this.institutionSummaryCache.containsKey(refName)) return this.institutionSummaryCache.get(refName);
			else {
				List<InstitutionSummary> tmpData = DataFactory.getMetaWebData().getInstitutionSummaryByName(refName);
				if (tmpData != null && tmpData.size() > 0) { // 如果返回数据有效
					this.institutionSummaryCache.put(refName, tmpData);
					return tmpData;
				} else {
					this.institutionSummaryCache.put(refName, this.institutionEmptyList);
					return this.institutionEmptyList;
				}
			}
		} else log.debug("getInstitutionSummary", "指定的机构名称信息有误");
		return null;
	}
	
	
	
	
	
	
}
