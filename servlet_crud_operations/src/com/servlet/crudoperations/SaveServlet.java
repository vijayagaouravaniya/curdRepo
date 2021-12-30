package com.servlet.crudoperations;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmployeeDao;
import com.servlet.emp.Employee;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/saveServlet")
public class SaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String country=request.getParameter("country");
		Employee e= new Employee();
		e.setName(name);
		
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country); 
		System.out.println("employee details are:"+e);
		int status=EmployeeDao.save(e);
		if(status>0){
			pw.println("record saved successfully");
			
		}else{
			pw.println("sorry unable to save record");
		}
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
