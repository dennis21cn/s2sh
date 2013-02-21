package org.hanfeng.service.impl;

import java.util.List;
import java.util.Map;

import org.hanfeng.entity.Student;
import org.hanfeng.hibernateDAO.StudentDAO;
import org.hanfeng.service.StudentService;
import org.hibernate.LockMode;
import org.hibernate.criterion.MatchMode;

public class StudentServiceImpl implements StudentService {
	private StudentDAO studentDAO;

	@Override
	public Student findById(Integer id) {
		return studentDAO.findById(id);
	}

	@Override
	public Student findById(Integer id, LockMode lockMode) {
		return studentDAO.findById(id, lockMode);
	}

	@Override
	public List<Student> findAll(int firstResult, int maxResults) {
		return studentDAO.findAll(firstResult, maxResults);
	}

	@Override
	public List<Student> findAll() {
		return studentDAO.findAll();
	}

	@Override
	public List<Student> findByExample(Student entity) {
		return studentDAO.findByExample(entity);
	}

	@Override
	public List<Student> findByExample(Student entity, int firstResult,
			int maxResults, MatchMode matchMode) {
		return studentDAO.findByExample(entity, firstResult, maxResults, matchMode);
	}

	@Override
	public List<Student> findByExampleLikeAnyWhere(Student entity) {
		return studentDAO.findByExampleLikeAnyWhere(entity);
	}

	@Override
	public List<Student> findByProperty(String propertyName, Object value) {
		return studentDAO.findByProperty(propertyName, value);
	}

	@Override
	public List<Student> findByProperties(Map<String, Object> properties) {
		return studentDAO.findByProperties(properties);
	}

	@Override
	public void saveOrUpdate(Student entity) {
		studentDAO.saveOrUpdate(entity);
	}

	@Override
	public void delete(Student entity) {
		studentDAO.delete(entity);
	}

	@Override
	public void update(Student entity) {
		studentDAO.update(entity);
	}

	@Override
	public Student merge(Student entity) {
		return studentDAO.merge(entity);
	}

	@Override
	public Integer save(Student entity) {
		return studentDAO.save(entity);
	}

	@Override
	public void refresh(Student entity) {
		studentDAO.refresh(entity);
	}

	@Override
	public Integer count() {
		return studentDAO.count();
	}

	@Override
	public List<Student> findByProperties(Map<String, Object> properties,
			int firstResult, int maxResults) {
		return studentDAO.findByProperties(properties, firstResult, maxResults);
	}

	/**
	 * @param studentDAO the studentDAO to set
	 */
	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

}
