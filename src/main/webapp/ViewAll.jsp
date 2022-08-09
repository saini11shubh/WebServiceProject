<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All data</title>
</head>
<body>
	<table border='1' width='100%'>
			<%
				
				ResultSet rst=(ResultSet)request.getAttribute("rst");
			%>	
			<tr><th>cl_id</th>
				<th>Game_id</th>				
				<th>Date</th>
				<th>Play Count</th>
				<th>Session Count</th>
				<th>Play Chip</th>
				<th>Win Chip</th>
			</tr>	
		<% 	while (rst.next()){	%>
					
				<tr>
					<td><%=rst.getInt(1) %></td>
					<td><%=rst.getInt(2) %></td>
					<td><%=rst.getString(3) %></td>
					<td><%=rst.getInt(4) %></td>
					<td><%=rst.getInt(5) %></td>
					<td><%=rst.getInt(6) %></td>
					<td><%=rst.getInt(7) %></td>
				</tr>
				<%}%>
			
	</table>
	
	<form action="index.jsp" method="post">
		<input type="submit" value="Back"/>
	</form>
</body>
</html>