<%@page import="com.niit.repository.EmployeeDAO"%>
<%@page import="com.niit.enitity.City"%>
<%@page import="java.util.List"%>
<select size='1' size='1' name="city_id" id="ct">
<option value="">----CITY----</option>
<%
	
	int state_id=Integer.parseInt(request.getParameter("ctid"));
	List<City> list=new EmployeeDAO().getCity(state_id);
	for(int i=0;i<list.size();i++)
	{
		City t=list.get(i);
		%>
		
		<option value="<%=t.getCity_id()%>"><%=t.getCity_name() %></option>
	<%}
%>
</select>