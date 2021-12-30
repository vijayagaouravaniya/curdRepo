package com.servlet.crudoperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dao.EmployeeDao;
import com.servlet.emp.Employee;

@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/Html");
		PrintWriter pw=response.getWriter();
		

		pw.println("<a href='index.jsp'>Add New Employee</a>");
pw.println("<h1>Employee list</h1>");
List<Employee> emplist=EmployeeDao.getAllEmployees();
pw.println("<table border='2' width='100%'");
pw.println("<tr><th>id</th> <th>Name</th><th>password</th> <th>Email </th> <th>Country</th> <th>Edit</th> <th>Delete</th></tr>");
for(Employee e:emplist){ 
	pw.print("<tr> <td>"+e.getId()+"+</td> <td>"
			+ ""+e.getName()+"</td> <td>"+e.getPassword()+" </td> <td>"+e.getEmail()+"</td> <td>"+e.getCountry()+"</td><td><a href='EditServlet?id="+e.getId()+">edit</a></td><td><a href='DeleteServlet? id="+e.getId()+"'>delete</a></td> </tr>");
	
	
}

pw.print("/table");
pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
