package com.niit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.enitity.Employee;
import com.niit.repository.EmployeeDAO;
import com.niit.validation.employeesValid;

/**
 * Servlet implementation class empRegist
 */
@WebServlet("/empRegist")
public class empRegist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public empRegist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		doGet(request, response);
		String ename=request.getParameter("ename");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String skill[]=request.getParameterValues("skill");
		String emp_skill=null;
		
		for(int i=0;i<skill.length;i++)
		{
			if(emp_skill==null)
			{
				emp_skill=skill[i];
			}
			else if(emp_skill!=null)
			{
				emp_skill=emp_skill+" "+skill[i];
			}
		}
		int state_id=Integer.parseInt(request.getParameter("state_id"));
		int city_id=Integer.parseInt(request.getParameter("city_id"));
		String mob=request.getParameter("mob");
		float sscper=Float.parseFloat(request.getParameter("sscper"));
		String hsc=request.getParameter("hsc");
		float hscper=Float.parseFloat(request.getParameter("hscper"));
		String graduate=request.getParameter("graduate");
		float graduateper=Float.parseFloat(request.getParameter("graduateper"));
		String postgraduate=request.getParameter("postgraduate");
		float postgradper=Float.parseFloat(request.getParameter("postgradper"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String error=null;
		
			int supvid=Integer.parseInt(request.getParameter("supvid"));
	
		String spuvname=request.getParameter("supvname");
		String ibuname=request.getParameter("ibuname");
		Employee employee=new Employee();
		employee.setEname(ename);
		employee.setDob(dob);
		employee.setGender(gender);
		employee.setAddress(address);
		employee.setState_id(state_id);
		employee.setSkill(emp_skill);
		employee.setCity_id(city_id);
		employee.setEmpMob(mob);
		employee.setSscper(sscper);
		employee.setHsc(hsc);
		employee.setHscper(hscper);
		employee.setGrad(graduate);
		employee.setGrad_per(graduateper);
		employee.setPostgrad(postgraduate);
		employee.setPostGradper(postgradper);
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setSupid(supvid);
		employee.setSuprvname(spuvname);
		employee.setIbuname(ibuname);
		employeesValid emp_valid=new employeesValid();
	

	
		int flg=1;
		 flg=emp_valid.name_IsEmpty(employee.getEname());
		if(flg==0)
		{
			flg=emp_valid.name_IsEmpty(employee.getGender());
			if(flg==0)
			{
				request.setAttribute("address","Select Address");
				flg=emp_valid.name_IsEmpty(employee.getAddress());
			}
			if(flg==0)
			{
				
				flg=emp_valid.num_IsEmpty(employee.getState_id());
			}
			if(flg==0)
			{
				
				flg=emp_valid.num_IsEmpty(employee.getCity_id());
			}
			if(flg==0)
			{
				request.setAttribute("email","Email Address Required");
				flg=emp_valid.name_IsEmpty(employee.getEmail());
				flg=emp_valid.emailCheck(employee.getEmail());
			}
			if(flg==0)
			{
				request.setAttribute("mob","Mobilenumber Required");
				flg=emp_valid.mobileCheck(employee.getEmpMob());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsNull(employee.getSkill());
			}
			if(flg==0)
			{
				
				flg=emp_valid.Float_IsEmpty(employee.getSscper());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getHsc());
			}
			if(flg==0)
			{
				
				flg=emp_valid.Float_IsEmpty(employee.getHscper());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getGrad());
			}
			if(flg==0)
			{
				
				flg=emp_valid.Float_IsEmpty(employee.getGrad_per());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getPostgrad());
			}
			if(flg==0)
			{
				
				flg=emp_valid.Float_IsEmpty(employee.getPostGradper());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getPassword());
			}
			if(flg==0)
			{
				
				flg=emp_valid.num_IsEmpty(employee.getSupid());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getSuprvname());
			}
			if(flg==0)
			{
				
				flg=emp_valid.name_IsEmpty(employee.getDob());
				flg=emp_valid.dobCheck(employee.getDob());
			
			}
			if(flg==0)
			{
				
				 flg=emp_valid.Float_IsEmpty(employee.getGrad_per());
			}
			
			if(flg==0)
			{
				
				 flg=emp_valid.name_IsEmpty(employee.getIbuname());
			}
		}
		
		if(flg==0)
		{
			new EmployeeDAO().AddEmp(employee);
			response.sendRedirect("./index.html");
		}
		else
		{
			RequestDispatcher rd=request.getRequestDispatcher("./empAccount.jsp");
			rd.forward(request, response);
		}
		
		
	}

}
