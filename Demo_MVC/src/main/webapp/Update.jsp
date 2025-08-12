<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="controller.jsp.mvc.UserModel"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update User</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
 crossorigin="anonymous">
</head>
<body>
<%
	UserModel user=(UserModel) session.getAttribute("updateUser");
%>
    <div class="container mt-5">
        <div class="card">
            <div class="card-header">
            <form action="Controller" method="post">
            	<input type="hidden" name="action" value="view" readonly/>
            	<button class="bi bi-arrow-left btn btn-warning" type="submit">go back</button>
            </form>
                <h1 class="text-center">
                    Update Details of ID : <%=user.getId()%> here
                </h1>
            </div>
            <div class="d-flex align-items-center justify-content-center">
                <%
    String fileLocation = user.getFileLocation();
    if (fileLocation != null) {
        if (fileLocation.endsWith(".jpeg")  || fileLocation.endsWith(".txt") || fileLocation.endsWith(".jpg") || fileLocation.endsWith(".png")) {
%>
            <img style="width: 300px; border: 5px solid black; border-radius: 10px;" src="./Files/<%=fileLocation%>">
            
            
<%
        } else if (fileLocation.endsWith(".pdf")) {
%>
            <img style="width: 300px;" src="https://upload.wikimedia.org/wikipedia/commons/thumb/8/87/PDF_file_icon.svg/1200px-PDF_file_icon.svg.png">
<%
        } else {
%>
            <img src="https://cdn-icons-png.flaticon.com/512/6747/6747196.png" style="width: 300px;" />
<%
        }
    } else {
%>
        <img src="https://cdn-icons-png.flaticon.com/512/6747/6747196.png" style="width: 300px;" />
<%
    }
%>
                
            </div>

            <form action="Controller" method="post" enctype="multipart/form-data">
                <div class="card-body">
                    <input type="hidden" name="userId" value="<%=user.getId()%>" readonly />
                    <input class="form-control mb-1" type="text" name="userName"
                           value="<%=user.getUserName()%>"  />
                    <input class="form-control mb-1" type="email" name="userEmail"
                           value="<%=user.getUserEmail()%>"  />
                    <input class="form-control mb-1" type="number" name="userAge"
                           value="<%=user.getUserAge()%>" />
                    <input class="form-control mb-1" type="file" name="userFile" />
                    <input type="hidden" name="action" value="update" /> 
                </div>
                <div class="card-footer text-center">
                    <button class="btn btn-success" type="submit">Update</button>
                </div>
            </form>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-VvpcrYf0tY3LHBO6NWmXc5s9fDVZLEsAaA5NDzOxhy96kcIdsLk1eN7N6j1eHz"
            crossorigin="anonymous"></script>
</body>
</html>