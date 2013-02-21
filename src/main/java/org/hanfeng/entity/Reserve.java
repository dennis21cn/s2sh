package org.hanfeng.entity;

/**
 * Reserve entity. @author MyEclipse Persistence Tools
 */

public class Reserve implements java.io.Serializable {

	// Fields

	private ReserveId id;
	private Course course;
	private Student student;

	// Constructors

	/** default constructor */
	public Reserve() {
	}

	/** full constructor */
	public Reserve(ReserveId id, Course course, Student student) {
		this.id = id;
		this.course = course;
		this.student = student;
	}

	// Property accessors

	public ReserveId getId() {
		return this.id;
	}

	public void setId(ReserveId id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}