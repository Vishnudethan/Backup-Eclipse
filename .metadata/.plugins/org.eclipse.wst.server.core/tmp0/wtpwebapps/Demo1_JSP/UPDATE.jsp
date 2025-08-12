<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
<title>Update title here</title>
</head>
<body>

	<%
		try{
			int id=Integer.parseInt(request.getParameter("userId"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url ="jdbc:mysql://localhost:3360/db1";
			String name="root";
			String pass="root";
			Connection con = DriverManager.getConnection(url,name,pass);
			String query = "select * from tb1 where userId = "+id+";";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()){
				%>	
				<div class="container w-50">
					<div class="card">
						<div class="card-header d-flex align-items-center">
							<a class="btn btn-warning bi bi-arrow-left me-2" href="VIEWTRIAL.jsp"></a>
							<h2>Update details here</h2>
						</div>
						<form action="SAVE_AFTER_EDIT.jsp" method="post">
						   <div class="card-body">
							
								<input type="number" class="form-control mb-1" name="userId" value="<%= rs.getInt("userID") %>" readonly />
<input type="text" class="form-control mb-1" name="userName" value="<%= rs.getString("userName") %>" required />
<input type="number" class="form-control mb-1" name="userAge" value="<%= rs.getInt("userAge") %>" required />
<input type="text" class="form-control" name="userEmail" value="<%= rs.getString("userEmail") %>" required />
								
							
						  </div>
						  <div class="card-footer">
							<button type="submit" class="bi bi-floppy btn btn-success">Save</button>
						  </div>
						</form>
					</div>
				</div>
			<%
			}
			
		}		
		catch(Exception e){
			out.println(e);
		}
	 %>


<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
		crossorigin="anonymous"></script>
</body>
</html>