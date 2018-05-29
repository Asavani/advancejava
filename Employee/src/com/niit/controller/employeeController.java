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
 * Servlet implementation class employee_Controller
 */
@WebServlet("/employee_Controller")
public class employeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int flg=1;
		employeesValid empvalid=new employeesValid();
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out=response.getWriter();
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		 flg=empvalid.emailCheck(email);
		if(flg==0)
		{
			flg=empvalid.name_IsEmpty(password);
			if(flg==0)
			{
				List<Employee> emp=new EmployeeDAO().checkLogin(email, password);
				for(int i=0;i<emp.size();i++)
				{
					Employee empRec=emp.get(i);
					if(email.equals(empRec.getEmail()) && password.equals(empRec.getPassword()))
					{
						flg=0;
						break;
					}
					
				}
			}
		}
		if(flg==1)
		{
			response.sendRedirect("./index.html");
		}
		else
		{
			request.setAttribute("email",email);
			RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
			rd.forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
