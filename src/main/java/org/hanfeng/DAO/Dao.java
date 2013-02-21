package org.hanfeng.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.MatchMode;

/**
 * 泛型Dao(Data Access Object)接口<br>
 * 定义通用的Create,Retrive,Update,Delete,List等操作
 * 
 * @author totong
 * @since 2007-5-13
 * 
 * @param <ENTITY>
 *            实体的类型
 * @param <ID>
 *            主键的类型
 */
public interface Dao<ENTITY, ID extends Serializable> {

	/**
	 * 通过主键标识查找某个对象
	 * 
	 * @param id
	 *            对象标识
	 * @return 实体
	 */
	ENTITY findById(ID id);

	/**
	 * 通过主键标识查找某个对象，可以锁定表中对应的记录
	 * 
	 * @param id
	 *            对象标识
	 * @param lockMode
	 *            锁定的方式
	 * @return 实体
	 */
	ENTITY findById(ID id, LockMode lockMode);

	/**
	 * 得到所有的对象
	 * 
	 * @return 实体集合
	 */
	List<ENTITY> findAll(int firstResult, int maxResults);

	/**
	 * 得到所有的对象
	 * 
	 * @return 实体集合
	 */
	List<ENTITY> findAll();

	/**
	 * 通过给定的一个对象，查找与其匹配的对象。
	 * 
	 * @param entity
	 *            实体
	 * @return 实体集合
	 */
	List<ENTITY> findByExample(ENTITY entity);

	/**
	 * 通过给定的一个对象，查找与其匹配的对象。
	 * 
	 * @param entity
	 *            实体
	 * @param firstResult
	 *            第一条记录
	 * @param maxResults
	 *            最大记录数
	 * @param matchMode
	 *            匹配模式
	 * @return 实体集合
	 */
	List<ENTITY> findByExample(ENTITY entity, int firstResult, int maxResults,
			MatchMode matchMode);

	/**
	 * 通过给定的一个对象，查找与其模糊匹配的对象。
	 * 
	 * @param entity
	 *            实体
	 * @return 实体集合
	 */
	List<ENTITY> findByExampleLikeAnyWhere(ENTITY entity);

	/**
	 * 通过给定的属性名和值，查找与其匹配的对象。
	 * 
	 * @param propertyName
	 *            属性名
	 * @param value
	 *            属性值
	 * @return 实体集合
	 */
	List<ENTITY> findByProperty(String propertyName, Object value);

	/**
	 * /** 通过给定的属性名和值的键值对，查找与其匹配的对象。
	 * 
	 * @param properties
	 *            属性映射
	 * @return 实体集合
	 */
	List<ENTITY> findByProperties(Map<String, Object> properties);

	/**
	 * 持久化对象
	 * 
	 * @param entity
	 *            实体
	 */
	void saveOrUpdate(ENTITY entity);

	/**
	 * 删除对象
	 * 
	 * @param entity
	 *            实体
	 */
	void delete(ENTITY entity);

	/**
	 * 将entity持久化
	 * 
	 * @param entity
	 *            实体
	 */
	void update(ENTITY entity);

	/**
	 * 返回entity的持久化对象，并不持久化entity
	 * 
	 * @param entity
	 *            实体
	 * @return 实体
	 */

	ENTITY merge(ENTITY entity);

	/**
	 * 持久化entity,返回对象标识
	 * 
	 * @param entity
	 *            实体
	 * @return 对象标识
	 */
	ID save(ENTITY entity);

	/**
	 * 重新读取对象
	 * 
	 * @param entity
	 *            实体
	 */
	void refresh(ENTITY entity);

	/**
	 * 取得记录数
	 * 
	 * @return 记录数
	 */
	Integer count();

	/**
	 * 根据多个属性查询
	 * 
	 * @param properties
	 *            属性映射
	 * @param firstResult
	 *            第一条记录
	 * @param maxResults
	 *            最大记录数
	 * @return 实体集合
	 */
	List<ENTITY> findByProperties(Map<String, Object> properties,
			int firstResult, int maxResults);
}
