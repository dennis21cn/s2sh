package org.hanfeng.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * �����Hibernate DataAccessObject
 * 
 * @author totong
 * @since 2008-1-7
 * 
 * @param <ENTITY>
 *            ʵ�������
 * @param <ID>
 *            ���������
 */
public abstract class AbstractDaoHibernate<ENTITY, ID extends Serializable>
		extends HibernateDaoSupport implements Dao<ENTITY, ID> {

	/**
	 * ����T��ʵ������
	 */
	protected Class<ENTITY> entityClass;

	/**
	 * ��������ͨ�����ȡT��ʵ�����ͣ��Թ�����ʹ��
	 */
	@SuppressWarnings("unchecked")
	public AbstractDaoHibernate() {
		entityClass = (Class<ENTITY>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	/**
	 * {@inheritDoc}
	 */
	public void delete(ENTITY entity) {
		getHibernateTemplate().delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByExample(ENTITY entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass).add(
				Example.create(entity));
		return getHibernateTemplate().findByCriteria(criteria);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByExample(ENTITY entity, int firstResult,
			int maxResults, MatchMode matchMode) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass).add(
				Example.create(entity).enableLike(matchMode));
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByProperty(String propertyName, Object value) {
		String queryString = "from " + entityClass.getName()
				+ " as model where model." + propertyName + "= ?";
		return getHibernateTemplate().find(queryString, value);
	}

	/**
	 * {@inheritDoc}
	 */
	public List<ENTITY> findByProperties(Map<String, Object> properties) {
		return findByProperties(properties, -1, -1);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByProperties(Map<String, Object> properties,
			int firstResult, int maxResults) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		for (Entry<String, Object> entry : properties.entrySet()) {
			criteria.add(Restrictions.eq(entry.getKey(), entry.getValue()));
		}
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}

	/**
	 * {@inheritDoc}
	 */
	public void saveOrUpdate(ENTITY entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findAll() {
		String queryString = "from " + entityClass.getName();
		return (List<ENTITY>) getHibernateTemplate().find(queryString);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findAll(int firstResult, int maxResults) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
		return getHibernateTemplate().findByCriteria(criteria, firstResult,
				maxResults);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ENTITY findById(ID id, LockMode lockMode) {
		return (ENTITY) getHibernateTemplate().load(entityClass, id, lockMode);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ENTITY findById(ID id) {
		return (ENTITY) getHibernateTemplate().load(entityClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	public void update(ENTITY entity) {
		getHibernateTemplate().update(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ENTITY merge(ENTITY entity) {
		return (ENTITY) getHibernateTemplate().merge(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public ID save(ENTITY entity) {
		return (ID) getHibernateTemplate().save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public void refresh(ENTITY entity) {
		getHibernateTemplate().refresh(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer count() {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass)
				.setProjection(Projections.rowCount());
		return (Integer) getHibernateTemplate().findByCriteria(criteria).get(0);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<ENTITY> findByExampleLikeAnyWhere(ENTITY entity) {
		DetachedCriteria criteria = DetachedCriteria.forClass(entityClass).add(
				Example.create(entity).enableLike(MatchMode.ANYWHERE));
		return getHibernateTemplate().findByCriteria(criteria);
	}
}
