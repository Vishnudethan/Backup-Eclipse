<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3360/db1";
		String uname = "root";
		String pass = "root";
		int id= Integer.parseInt(request.getParameter("userID"));
		String name = request.getParameter("userName");
		int age = Integer.parseInt(request.getParameter("userAge"));
		String email=request.getParameter("userEmail");
		Connection con = DriverManager.getConnection(url, uname, pass);
		//String query = "insert into tb1(userID,userName,userAge,userEmail) values('+id+','"+name+"','+age+','"+email+"');";
		String query = "insert into tb1(userID,userName,userAge,userEmail) values(" 
               + id + ", '" + name + "', " + age + ", '" + email + "')";

		PreparedStatement ps = con.prepareStatement(query);

		int rowCount = ps.executeUpdate();
		while (rowCount != 0) {
			response.sendRedirect("REGISTER.jsp");
		}
	} catch (Exception e) {
		out.println(e);
	}
	%>
</body>
</html>