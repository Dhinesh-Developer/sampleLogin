<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
	<form action="./Register" method="post">
			<label for="name">Name:</label> 
			<input type="text" id="name" name="name" required><br><br>
			 <label for="password">Password:</label> 
			 <input type="text" id="name" name="password" required><br><br>
				
			 <label for="email">Email:</label> 
			 <input type="text" id="name" name="email" required><br><br>
		
		<input type = "submit" value = "submit">

	</form>
</body>
</html>