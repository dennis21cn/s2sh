package org.hanfeng.DAO;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.LockMode;
import org.hibernate.criterion.MatchMode;

/**
 * ����Dao(Data Access Object)�ӿ�<br>
 * ����ͨ�õ�Create,Retrive,Update,Delete,List�Ȳ���
 * 
 * @author totong
 * @since 2007-5-13
 * 
 * @param <ENTITY>
 *            ʵ�������
 * @param <ID>
 *            ����������
 */
public interface Dao<ENTITY, ID extends Serializable> {

	/**
	 * ͨ��������ʶ����ĳ������
	 * 
	 * @param id
	 *            �����ʶ
	 * @return ʵ��
	 */
	ENTITY findById(ID id);

	/**
	 * ͨ��������ʶ����ĳ�����󣬿����������ж�Ӧ�ļ�¼
	 * 
	 * @param id
	 *            �����ʶ
	 * @param lockMode
	 *            �����ķ�ʽ
	 * @return ʵ��
	 */
	ENTITY findById(ID id, LockMode lockMode);

	/**
	 * �õ����еĶ���
	 * 
	 * @return ʵ�弯��
	 */
	List<ENTITY> findAll(int firstResult, int maxResults);

	/**
	 * �õ����еĶ���
	 * 
	 * @return ʵ�弯��
	 */
	List<ENTITY> findAll();

	/**
	 * ͨ��������һ�����󣬲�������ƥ��Ķ���
	 * 
	 * @param entity
	 *            ʵ��
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByExample(ENTITY entity);

	/**
	 * ͨ��������һ�����󣬲�������ƥ��Ķ���
	 * 
	 * @param entity
	 *            ʵ��
	 * @param firstResult
	 *            ��һ����¼
	 * @param maxResults
	 *            ����¼��
	 * @param matchMode
	 *            ƥ��ģʽ
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByExample(ENTITY entity, int firstResult, int maxResults,
			MatchMode matchMode);

	/**
	 * ͨ��������һ�����󣬲�������ģ��ƥ��Ķ���
	 * 
	 * @param entity
	 *            ʵ��
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByExampleLikeAnyWhere(ENTITY entity);

	/**
	 * ͨ����������������ֵ����������ƥ��Ķ���
	 * 
	 * @param propertyName
	 *            ������
	 * @param value
	 *            ����ֵ
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByProperty(String propertyName, Object value);

	/**
	 * /** ͨ����������������ֵ�ļ�ֵ�ԣ���������ƥ��Ķ���
	 * 
	 * @param properties
	 *            ����ӳ��
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByProperties(Map<String, Object> properties);

	/**
	 * �־û�����
	 * 
	 * @param entity
	 *            ʵ��
	 */
	void saveOrUpdate(ENTITY entity);

	/**
	 * ɾ������
	 * 
	 * @param entity
	 *            ʵ��
	 */
	void delete(ENTITY entity);

	/**
	 * ��entity�־û�
	 * 
	 * @param entity
	 *            ʵ��
	 */
	void update(ENTITY entity);

	/**
	 * ����entity�ĳ־û����󣬲����־û�entity
	 * 
	 * @param entity
	 *            ʵ��
	 * @return ʵ��
	 */

	ENTITY merge(ENTITY entity);

	/**
	 * �־û�entity,���ض����ʶ
	 * 
	 * @param entity
	 *            ʵ��
	 * @return �����ʶ
	 */
	ID save(ENTITY entity);

	/**
	 * ���¶�ȡ����
	 * 
	 * @param entity
	 *            ʵ��
	 */
	void refresh(ENTITY entity);

	/**
	 * ȡ�ü�¼��
	 * 
	 * @return ��¼��
	 */
	Integer count();

	/**
	 * ���ݶ�����Բ�ѯ
	 * 
	 * @param properties
	 *            ����ӳ��
	 * @param firstResult
	 *            ��һ����¼
	 * @param maxResults
	 *            ����¼��
	 * @return ʵ�弯��
	 */
	List<ENTITY> findByProperties(Map<String, Object> properties,
			int firstResult, int maxResults);
}
