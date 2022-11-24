package com.crud.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.Student;
import com.db.HibernateDatabaseConnection;

@Controller
public class DashboardController {

	@RequestMapping("/dashboard")
	public String loadDashboard(Model m, 
			HttpServletRequest req, 
			HttpServletResponse res) throws IOException {
		
		
		String username = (String)req.getSession().getAttribute("username");
		
		if(username == null) {
			res.sendRedirect("login");
		}
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		System.out.println(session);
		Query query2 = session.createQuery("FROM Student");
		List students = query2.list();
		
		m.addAttribute("name", "Ravi");
		m.addAttribute("students_list", students);
		
		return "views/dashboard.jsp";
		
	}
	
	@RequestMapping(" /delete")
	public void deleteUser(HttpServletResponse res, @RequestParam("id") int id ) throws IOException {
		
		System.out.println("\n\n===== Id:"+ id + "=====\n\n");
		
		Session session = null;
		session = HibernateDatabaseConnection.getSessionFactory().openSession();
		
		Transaction t =session.beginTransaction();
		
		Student std_obj = new Student();
		std_obj.setId(id);
		
		session.delete(std_obj);
		
		t.commit();
		
		res.sendRedirect("dashboard");
		
	}
	
	
	
	
}

