<%@page import="java.util.List"%>
<%@page import="com.niit.repository.EmployeeDAO"%>
<%@page import="com.niit.enitity.Employee"%>
<%@page import="java.util.ArrayList"%>
<%
String email=request.getAttribute("email").toString();
List<Employee> emplist=new EmployeeDAO().profile_emp(email);
for(int i=0;i<emplist.size();i++)
{
	Employee emp=emplist.get(i);
	out.println("<br>"+emp.getEname());
	out.println("<br>"+emp.getDob());
	out.println("<br>"+emp.getAddress());
}
%>