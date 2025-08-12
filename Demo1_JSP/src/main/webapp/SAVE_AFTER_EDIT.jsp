<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert EDIT here</title>
</head>
<body>
 	<%
 		try{
 			int id =Integer.parseInt( request.getParameter("userId"));
 			String name =request.getParameter("userName");
 			String email =request.getParameter("userEmail");
 			int age = Integer.parseInt(request.getParameter("userAge"));
 			Class.forName("com.mysql.cj.jdbc.Driver");
 			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3360/db1","root","root");
 			String query ="update tb1 set userName='"+name+"', userAge ="+age+" ,userEmail='"+email+"' Where userId = "+id+";";
 			PreparedStatement ps = con.prepareStatement(query);
 			int rowCount = ps.executeUpdate();
 			while(rowCount !=0){
 				response.sendRedirect("VIEWTRIAL.jsp");
 				
 			}
 		}catch(Exception e){
 			out.println(e);
 		}
 	%>
</body>
</html>