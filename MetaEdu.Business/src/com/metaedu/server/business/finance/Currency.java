package com.metaedu.server.business.finance;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import com.metaedu.server.business.common.LanguageType;
import com.metaedu.server.business.common.MultiNameOwner;

/** 货币类型（并初始化各个年级类型数据）
 * @author Sam
 * @version 1.0
 * @since 2015.05.14
 */
public class Currency implements MultiNameOwner<CurrencyName>, Serializable {

	private static final long serialVersionUID = -1436268817630772283L;
	
	/** 货币值：人民币 */
	public static final int ID_CNY = 0; 
	/** 货币类型：人民币 */
	public static Currency CURRENCY_CNY = null;
	
	/** 货币值：美元 */
	public static final int ID_USD = 1; 
	/** 货币类型：美元 */
	public static Currency CURRENCY_USD = null;
	
	/** 静态货币类型表 */
	private static HashMap<Integer, Currency> currencyMap = new HashMap<Integer, Currency>();
	
	/** 获取指定货币标识的货币对象
	 * @param refCurrencyId
	 * @return
	 */
	public static Currency getCurrency(Integer refCurrencyId) {
		return currencyMap.get(refCurrencyId);
	}
	
	
	/** 构造函数
	 * @param refId 货币编号
	 */
	public Currency(int refId) {
		this.id = refId;
	}
	
	/** 货币主键 */
	private int id = -1;

	/** 货币主键 */
	public int getId() {
		return id;
	}

	/** 货币主键 */
	public void setId(int id) {
		this.id = id;
	}
	
	/** 货币名称集合 */
	private ArrayList<CurrencyName> names = new ArrayList<CurrencyName>();

	/** 获取货币名称集合 */
	public ArrayList<CurrencyName> getNames() {
		return null;
	}

	/** 获取指定语言类型的货币名称
	 * @param refLanguage 语言种类
	 */
	public CurrencyName getName(int refLanguageType) {
		for (CurrencyName curName : this.names) {
			if (curName.getLanguageType() == refLanguageType) return curName;
		}
		return null;
	}

	/** 添加一个货币的名称
	 * @param refName 待添加的货币名称
	 */
	public void addName(CurrencyName refName) {
		this.names.add(refName);
	}

	/** 获取指定语言类型的货币名称值
	 * @param refLanguageType 指定语言类型
	 */
	public String getNameValue(int refLanguageType) {
		for (CurrencyName curName : this.names) {
			if (curName.getLanguageType() == refLanguageType) return curName.getName();
		}
		return null;
	}
	
	
	static {
		Currency.CURRENCY_CNY = new Currency(Currency.ID_CNY);
		currencyMap.put(Currency.ID_CNY, Currency.CURRENCY_CNY);
		Currency.CURRENCY_CNY.addName(new CurrencyName("人民币", LanguageType.SIMPLIFIED_CHINESE));
		Currency.CURRENCY_CNY.addName(new CurrencyName("人民幣", LanguageType.TRADTIONAL_CHINESE));
		Currency.CURRENCY_CNY.addName(new CurrencyName("CNY", LanguageType.SIMPLIFIED_CHINESE));
		
		Currency.CURRENCY_USD = new Currency(Currency.ID_USD);
		currencyMap.put(Currency.ID_USD, Currency.CURRENCY_USD);
		Currency.CURRENCY_USD.addName(new CurrencyName("美元", LanguageType.SIMPLIFIED_CHINESE));
		Currency.CURRENCY_USD.addName(new CurrencyName("美元", LanguageType.TRADTIONAL_CHINESE));
		Currency.CURRENCY_USD.addName(new CurrencyName("USD", LanguageType.SIMPLIFIED_CHINESE));
		
	}
	
	
}
