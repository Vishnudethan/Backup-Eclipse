<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
 crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
 integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq" crossorigin="anonymous"></script>
    <div class="container w-50 mt-5 pt-5">
        <div class="card">
            <div class="card-header d-flex align-items-center justify-content-between">
                <h1>Register Here</h1>
               <!-- <a href="View.jsp" class="btn btn-primary bi bi-table"></a> --> 
                <form action="Controller" method ="post">
                 <input type="hidden" name="action" value="view" readonly /> 
                <button class="bi bi-table btn btn-info" type="submit">View all</button>
                </form> 
            </div>
            <form method="post" action="Controller" enctype="multipart/form-data">
            <input type="hidden" name="action" value="insert" />
                <div class="card-body">
                
                
                    <input type="text" name="userName" placeholder="Enter your name" class="form-control mb-1" required />
                    <input type="email" name="userEmail" placeholder="Enter your email" class="form-control mb-1" />
                    <input type="number" name="userAge" placeholder="Enter your age" class="form-control mb-1" />
                    <input type="file" name="userFile" placeholder="Choose file" class="form-control mb-1" />
                </div>
                <div class="card-footer">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
            </form>
        </div>
    </div>
</body>

</html>