package org.hanfeng.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hanfeng.entity.Student;
import org.hanfeng.service.StudentService;

public class StudentAction {
	private StudentService studentService;

	public String execute(){
		String result = "success";
		List<Student> ls = studentService.findAll();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("sls", ls);
		return result;
	}

	/**
	 * @param stuService the stuService to set
	 */
	public void setStudentService(StudentService studentService) {
		System.out.println("====================================================I am in Action now!=========================");
		this.studentService = studentService;
	}
	
}
