<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="index.jsp">
		<% 
		int cnt=(Integer)request.getAttribute("cnt");
		if (cnt==1)
			out.println("Data inserted successfully");
		else 
			out.println("Failed insert!!!");
		%>
 		</br><input type="submit" value="back"/>
	</form> 
	
	</body>
</html>