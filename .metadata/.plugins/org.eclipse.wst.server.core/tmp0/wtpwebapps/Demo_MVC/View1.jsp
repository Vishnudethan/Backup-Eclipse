<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"
    import="controller.jsp.mvc.UserModel"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
 <div class="card">
 	<div class="card -header">
 		
 		<h2 style="color:red;" >Details</h2>
 		<a href="Register.jsp">click to go back</a>
 		
 	</div>
 	<div class="card-body">
 		<table class="table table-hover table-nordered">
 		<thead>
 		<tr>
 		<th>id</th>
 		<th style="color:green;">Name</th>
 		<th>Age</th>
 		<th>Email</th>
 		<th>File</th>
 		<th style="color:blue;">Actions</th>
 		</tr>
 		</thead>
 		<tbody>
 		<%
 			List<UserModel> userList= (List<UserModel>) session.getAttribute("userList");
 		int i=1;
 		for(UserModel um:userList){
 		%>
 		<tr>
 		<td><%=i++%></td>
 		<td><%=um.getUserName() %></td>
 		<td><%=um.getUserAge() %></td>
 		<td><%=um.getUserEmail() %></td>
 		<%
 			if(um.getFileLocation().endsWith(".jpeg") || um.getFileLocation().endsWith(".jpg") || um.getFileLocation().endsWith(".png")){
 		%>
 		<td><img style="height:100px" src="./Files/<%=um.getFileLocation() %>"></td>
 		
 		<%
 		}	else if(um.getFileLocation().endsWith(".pdf")){
 		%>
 		<td><img style="height:100px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png"></td>
 			<%
 		}	else{ 
 			 %>
 			 <td><img style="height:100px" src="https://cdn.pixabay.com/photo/2014/04/03/00/40/document-309065_640.png"></td>
 			<%
 			}
 		%>
 			<td>
    <td>
  <a class="btn btn-primary"   href="./Files/<%=um.getFileLocation() %>" 
     download="<%=um.getFileLocation() %>">
    Download File
  </a>
</td>
<td>
	<form action="Controller" method="post">
	<input type="hidden" name="userId" value="<%=um.getId()%>>" readonly/>
	<input type="hidden" name="action" value="viewone"/>
	<button class="btn btn-success bi bi-pencil">Edit</button>
	</form>
</td>

<td>
<button class="btb btn-danger">Delete</button>
</td>

</tr>
    
    

 			
 			<%
        } 
 		
     
		%>
 			</tbody>
 			
 		
 		</table>
 	</div>
 
 </div>

</body>
</html>

