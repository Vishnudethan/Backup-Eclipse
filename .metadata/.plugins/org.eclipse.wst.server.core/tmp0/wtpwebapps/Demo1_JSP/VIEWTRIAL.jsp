<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View All Users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header bg-primary text-white">
                <h3 class="mb-0">All Registered Users</h3>
            </div>
            <div class="card-body">
                <table class="table table-bordered table-striped table-hover">
                    <thead >
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Age</th>
                            <th>Email</th>
                            <th>Update</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3360/db1", "root", "root");
                                Statement stmt = con.createStatement();
                                ResultSet rs = stmt.executeQuery("SELECT * FROM tb1");

                                while(rs.next()) {
                        %>
                        <tr>
                            <td><%= rs.getInt("userID") %></td>
                            <td><%= rs.getString("userName") %></td>
                            <td><%= rs.getInt("userAge") %></td>
                            <td><%= rs.getString("userEmail") %></td>
                            	<!-- <td><button class="btn btn-primary bi bi-pencil">
								Edit</button></td> -->
								<td>
   				 <a href="UPDATE.jsp?userId=<%= rs.getInt("userID") %>" class="btn btn-primary bi bi-pencil"> Edit</a>
   				 
</td>
								
						<!-- <td><button class="btn btn-danger bi bi-trash">
								Delete</button></td> -->
								<td>
    <a href="DELETE.jsp?userId=<%= rs.getInt("userId") %>" 
       class="btn btn-danger bi bi-trash"> Delete</a>
</td>
								
								
								
                        </tr>
                        <%
                                }
                                rs.close();
                                stmt.close();
                                con.close();
                            } catch (Exception e) {
                                out.println("<tr><td colspan='4' class='text-danger'>Error: " + e.getMessage() + "</td></tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
