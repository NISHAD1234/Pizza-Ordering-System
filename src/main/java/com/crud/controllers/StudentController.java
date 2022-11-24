package com.crud.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Student;
import com.db.HibernateDatabaseConnection;

@Controller
public class StudentController {

	@RequestMapping("/add_student")
	public String getAddStudentForm() {
		return "views/student_add_form.jsp";
	}
	
	@RequestMapping(value="add_student_action", method = RequestMethod.POST)
	public void addStudent(HttpServletResponse res, 
			@ModelAttribute("student") Student std) throws IOException {
		
		System.out.println(std.getName());
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.save(std);
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping(value="edit_student_action", method = RequestMethod.POST)
	public void editStudent(HttpServletResponse res, 
			@ModelAttribute("student") Student std) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		session.saveOrUpdate(std);
		
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/delete")
	public void deleteUser(HttpServletResponse res, 
			@RequestParam("id") int id) throws IOException {
		
		System.out.println("\n\n===== Id : " + id +  "=====\n\n");
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t = session.beginTransaction();
		
		Student std_obj = new Student();
		std_obj.setId(id);
		
		session.delete(std_obj); // DELETE FROM student WHERE id = 2
		
		t.commit();
		
		res.sendRedirect("dashboard");
	}
	
	@RequestMapping("/edit")
	public String getEditForm(HttpServletResponse res, 
			Model m,
			@RequestParam("id") int id) throws IOException {
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		Query query2 = session.createQuery("FROM Student WHERE id = :id");		
		query2.setParameter("id", id);
		
		Student std_obj = (Student)query2.getSingleResult();
		
		m.addAttribute("student", std_obj);
		
		return "views/student_edit_form.jsp";
	}
	
}
