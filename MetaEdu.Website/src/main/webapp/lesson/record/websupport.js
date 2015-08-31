
/** WebSupportJS Used JavaScript
 * Auther Sam
 * Date 2015.06.12
 */

var MetaSQL = {

	/** 本框架是否被浏览器支持
	 * @returns {boolean}
	 */
	isSupport : function() {
		if (window.localStorage) { // 如果支持 sessionStorage
			return true;
		} else {
			return false;
		}
	},

	/** 初始化本地绑定的 Session */
	getDBName : function() {
		return localStorage.getItem("dbName");
	},

	/** 设置数据库名称（并清空其他数据库)
	 * @param refDBName 新的数据库名称
	 */
	setDBName : function(refDBName) {
		localStorage.clear(); // 清空其他数据库
		localStorage.setItem('dbName', refDBName);
	},

	/** 获取指定键的值
	 * @param refKey 指定取的键值
	 * @returns {string}
	 */
	get : function(refKey) {
		if (this.isSupport()) {
			if (refKey != null && refKey != '') {
				return localStorage.getItem(this.getDBName() + '-' + refKey); // 获取 Session 对应的表
			} else return null;
		} else return null;
	},

	/** 获取一张表
	 * @param refTableName 表名
	 */
	getTable : function(refTableName) {
		var tmpTableRows = this.get(refTableName);
		if (tmpTableRows == null || tmpTableRows == '') { // 如果虚拟表不存在
			tmpTableRows = [];
		} else { // 如果表内容存在
			tmpTableRows = JSON.parse(tmpTableRows);
		}
		return tmpTableRows;
	},

	/** 设置指定键的值
	 * @param refKey 指定的键
	 * @param refValue 对应的值
	 */
	set : function(refKey, refValue) {
		if (this.isSupport()) {
			var tmpValue;
			if (typeof(refValue) != 'string') {
				tmpValue = JSON.stringify(refValue);
			}
			localStorage.setItem(this.getDBName() + '-' + refKey, tmpValue);
		}
	},

	/** 查询数据表
	 * @param refTableName 查询的表名称
	 * @param refConditions 查询条件
	 * @returns {*}
	 */
	select : function(refTableName, refConditions) {
		if (this.isSupport()) {
			var tmpRtn = new Array();
			var tmpConditions = null;
			var tmpLimit = 99999999; // 设定默认的最大条件
			if (refConditions != null && refConditions != "") { // 如果设定了查询条件
				if (typeof(refConditions) == 'string') { // 将查询条件转化为对象
					tmpConditions = JSON.parse(refConditions);
				} else tmpConditions = refConditions;
				if (tmpConditions['MetaSQLLimit'] != null && tmpConditions['MetaSQLLimit'] != 0) tmpLimit = tmpConditions['MetaSQLLimit']; // 检查查询条件中有无数量限制
			}
			var tmpTableRows = this.getTable(refTableName);
			for (var i=0; i<tmpTableRows.length && i<tmpLimit; i++) { // 遍历表结构
				var isFit = true;
				if (tmpConditions != null) { // 如果查询条件不为空
					for (var propName in tmpConditions) { // 遍历
						if (propName != 'MetaSQLLimit') { // 如果属性不是 WSJLimit
							if (tmpTableRows[i][propName] != tmpConditions[propName]) {
								isFit = false;
								break;
							}
						}
					} // 属性匹配结束
				}
				if (isFit) tmpRtn.push(tmpTableRows[i]);
			}
			return tmpRtn;
		} return null;
	},

	/** 更新数据表
	 * @param refTableName 更新的表名称
	 * @param refConditions 查询条件
	 * @returns {boolean}
	 */
	update : function(refTableName, refValue, refConditions) {
		if (this.isSupport()) {
			var tmpValue;
			if (typeof(refValue) == 'string') {
				tmpValue = JSON.parse(refValue);
			} else tmpValue = refValue;
			var tmpConditions = null;
			if (refConditions != null && refConditions != "") { // 如果设定了查询条件
				if (typeof(refConditions) == 'string') { // 将查询条件转化为对象
					tmpConditions = JSON.parse(refConditions);
				} else tmpConditions = refConditions;
			}
			if (tmpConditions != null) { // 如果设置了查询条件
				var tmpTableRows = this.getTable(refTableName);
				var isUpdated = false;
				for (var i = 0; i < tmpTableRows.length; i++) { // 遍历表结构
					var isFit = false;
					if (tmpConditions != null) { // 如果查询条件不为空
						for (var propName in tmpConditions) { // 遍历属性
							if (tmpTableRows[i][propName] == tmpValue[propName]) {
								isFit = true; // 找到合适的
								break; // 退出属性循环
							}
						} // 属性匹配结束
					}
					if (isFit) { // 如果找到匹配对象
						tmpTableRows[i] = tmpValue;
						isUpdated = true;
						break; // 退出表循环
					}
				}
				if (isUpdated) { // 如果数据已经更新
					this.set(refTableName, tmpTableRows);
					return true;
				} else return false;
			} else return false;
		} else return false;
	},

	/** 向数据表插入数据
	 * @param refTableName 表名称
	 * @param refKey 表主键名称
	 * @param refValue 插入的值
	 * @returns {boolean}是否插入成功
	 */
	insert : function(refTableName, refKey, refValue) {
		if (this.isSupport()) {
			var tmpTableRows = this.getTable(refTableName);
			if (refValue != null && refValue != '') {
				var tmpValue;
				if (typeof(refValue) == 'string') {
					tmpValue = JSON.parse(refValue);
				} else tmpValue = refValue;
				if (tmpTableRows.length > 0) { // 如果当前表有数据
					for (var i = 0; i < tmpTableRows.length; i++) {
						if (tmpTableRows[i][refKey] == tmpValue[refKey]) return false;
					}
				}
				tmpTableRows[tmpTableRows.length] = tmpValue;
				this.set(refTableName, tmpTableRows);
			} else return false;
			return true;
		} return false;
	}



};

/** 初始化数据库名称 */
if (window.localStorage) {
	if (localStorage.getItem('dbName') != null) {
		MetaSQL._dbName = localStorage.getItem('dbName');
	}
}