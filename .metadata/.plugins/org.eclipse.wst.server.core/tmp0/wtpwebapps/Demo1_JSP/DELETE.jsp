<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete User</title>
</head>
<body>
<%
    try {
        int id = Integer.parseInt(request.getParameter("userId"));
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3360/db1", "root", "root");

        String query = "DELETE FROM tb1 WHERE userId = "+id+"";
        PreparedStatement ps = con.prepareStatement(query);
       // ps.setInt(1, id);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            response.sendRedirect("VIEWTRIAL.jsp");
        } else {
            out.println("User not found or already deleted.");
        }
    } catch (Exception e) {
        out.println(e);
    }
%>
</body>
</html>
