package com.servlet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.servlet.emp.Employee;

public class EmployeeDao {
	private static final String INSERTQuery="INSERT INTO EMPLOYEE2(id,name,password,email,country)values(?,?,?,?,?)";
	private static final String SELECTQuery="SELECT *FROM EMPLOYEE2";
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Xe","system","system");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
		
		
	}
	public static int save(Employee e){
		int status=0;
		
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement(INSERTQuery);
			ps.setInt(1, getSequence());
			ps.setString(2, e.getName() );
			ps.setString(3, e.getPassword());
			ps.setString(4, e.getEmail());
			ps.setString(5, e.getCountry());
			status=ps.executeUpdate();
			
			
		}catch(Exception e1){
			e1.printStackTrace();
		}
		
		
		return status;
		
	}
	private static int getSequence() {
		ResultSet rs=null;
		String sequence_val=null;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select Emp_seq.nextval as seq_val from dual");
			rs=ps.executeQuery();
			while(rs.next()){
				sequence_val=rs.getString("seq_val");
				
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		return Integer.parseInt(sequence_val)  ;
	}
	
public static List<Employee> getAllEmployees( ){
	List<Employee> emplist= new ArrayList<Employee>();
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement(SELECTQuery);
		ResultSet rs=ps.executeQuery();
        while(rs.next()){ 
            Employee e=new Employee();  
            e.setId(rs.getInt(1));  
            e.setName(rs.getString(2));  
            e.setPassword(rs.getString(3));  
            e.setEmail(rs.getString(4));  
            e.setCountry(rs.getString(5));  
           emplist.add(e);  
        }  
        con.close();  
    }catch(Exception e){e.printStackTrace();}  
		
	return emplist ;
	
}
}
