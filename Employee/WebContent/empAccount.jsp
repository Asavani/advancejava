<%
	if(request.getAttribute("msg")!=null)
	{
		String error=request.getAttribute("msg").toString();
		out.println(error);
	}
%>
<%@page import="com.niit.enitity.Skill"%>
<%@page import="java.util.List"%>
<%@page import="com.niit.repository.EmployeeDAO"%>
<%@page import="com.niit.enitity.State"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration</title>
<script src="jquery-1.8.0.min.js"></script>
</head>
<body>
<form method="post" action="./empRegist">
	<table>
		<tr>
			<td>Name:</td>
			<td><input type="text" name="ename" required="required"></td>
		</tr>
		<tr>
			<td>DOB:</td>
			<td><input type="date" name="dob" required="required" placeholder="yyyy-mm-dd"></td>
		
		</tr>
		<tr>
			<td>Gender</td>
			<td>Male<input type="radio" name="gender" value="Male">&nbsp;Female<input type="radio" name="gender" value="Female"></td>
			<td><%if(request.getAttribute("gen")!=null)
				{
		String error=request.getAttribute("gen").toString();
		out.println(error);
	}%></td>		
		</tr>
		<tr>
			<td>Address</td>
			<td><textarea rows="7" cols="15" name="address"></textarea></td>
			
		</tr>
		<tr>
			<td>Skill:</td>
			<td><%
			ArrayList<Skill> empskill=new EmployeeDAO().getSskill();
			for(int i=0;i<empskill.size();i++)
			{
				Skill skill=empskill.get(i);
			%>
				<input type="checkbox" name=skill value="<%=skill.getSkill_name() %>"><%=skill.getSkill_name() %>
			<%}
			%></td>
		</tr>
		<tr>
			<td>State:</td>
			<td><select size="1" name="state_id" id="st" required="required">
				<option value="">---STATE---</option>
				<%
					List<State> state=new EmployeeDAO().getState();
					for(int i=0;i<state.size();i++)
					{
						State list=state.get(i);
						%>
						<option value="<%=list.getState_id()%>"><%=list.getState_name() %></option> 
					<%}
				%>
				</select>
			</td>
		</tr>
		<tr>
			<td>City:</td>
			<td><select size='1' size='1' name="city_id" id="ct">
			<option value="">---CITY---</option>
			</select></td>
		</tr>
		<tr>
			<td>Mobile:</td>
			<td><input type="text" name="mob" placeholder="9925470862"></td>	
		</tr>
		<tr>
			<td>SSC Percantage:</td>
			<td><input type="text" name="sscper" required="required"></td>
		</tr>
		<tr>
			<td>HSC:</td>
			<td><input type="text" name="hsc"></td>	
		</tr>
		<tr>
			<td>HSC Percantage:</td>
			<td><input type="text" name="hscper"></td>
		</tr>
		<tr>
			<td>Graduate:</td>
			<td><input type="text" name="graduate" required="required"></td>	
		</tr>
		<tr>
			<td>Percantage:</td>
			<td><input type="text" name="graduateper" required="required"></td>
		</tr>
		<tr>
			<td>Post Graduate:</td>
			<td><input type="text" name="postgraduate"></td>	
		</tr>
		<tr>
			<td>Percantage:</td>
			<td><input type="text" name="postgradper" ></td>
		</tr>
		<tr>
			<td>Email:</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" required="required"></td>
				
		</tr>
		<tr>
			<td>Supervisor ID</td>
			<td><input type="text" name="supvid"></td>
			
		</tr>
		<tr>
			<td>Supevisor Name</td>
			<td><input type="text" name="supvname"></td>
		
		</tr>
		<tr>
			<td>IBU:</td>
			<td><select size='1' name="ibuname" required="required">
			<option value="">---IBU---</option>
			<option value="ILS">ILS</option>
			<option value="SLS">SLS</option>
			<option value="IFBI">IFBI</option>
			<option value="CEB">CEB</option>
			<option value="GRB">GRB</option>
			</select></td>
		</tr>
		<tr>
		<tr>
			<td colspan='2' align="centr"><input type="submit" value="OK"></td>
		</tr>
	</table>
</form>
</body>
</html>
<script>
$(document).ready(function(){
	
	$("#st").change(function(){
		var s=$("#st").val();
		$.ajax({
			type:'POST',
			url:'City.jsp',
			data:{ctid:s},
			datatype:'HTML',
			success:function(data)
			{
				$("#ct").html(data);
			},
			error:function()
			{
				alert("Page not Found....");
			}
		});
	});
	
});
</script>
