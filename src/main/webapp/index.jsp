<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<form action="MyServlet1" method="post">
		<table>	
		<h1>GAME DATA</h1>
		<tr><td>Id</td><td><input type="text" name="id"/></td></tr>
		<tr><td>Game_id</td><td><input type="text" name="game_id"/></td></tr>
		<tr><td>Date</td><td><input type="date" name="date"/></td></tr>
		<tr><td>Play_Count</td><td><input type="text" name="play_count"/></td></tr>
		<tr><td>Sess_Count</td><td><input type="text" name="sess_count"/></td></tr>
		<tr><td>Ply_Chip</td><td><input type="text" name="ply_chip"/></td></tr>
		<tr><td>Win_Chip</td><td><input type="text" name="win_chip"/></td></tr>
		
		<tr><td><input type="submit" name="b1" value="Submit"/></td></tr>
		</table>
		
		
		</form>
		
		
		<form action="MyServlet2" method="post">
			<input type="submit" name="b2" value="View All"/>
		</form>
		<form action="JsonPrint" method="post">
			<input type="submit" name="b3" value="Json"/>
		</form>
		<form action="firebase.do" method="get">
			<input type="submit" name="b4" value="Print Firebase"/>
		</form>
		
</body>
</html>