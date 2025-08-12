<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<title>Register</title>
</head>
<body>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
		crossorigin="anonymous"></script>
	<div class="container w-50 mt-5 pt-5 ">
		<div class="card">
			<div
				class="card-header d-flex justify-content-between align-items-center">
				<h1>Register Here</h1>
				<a class="bi bi-table btn btn-info" href="VIEWTRIAL.jsp"></a>
			</div>
			<form method="post" action="ACTION_REG.jsp">
				<div class="card-body">
				<input class="form-control mb-1" placeholder="Enter your ID"
						name="userID" type="number" />
					<input class="form-control mb-1" placeholder="Enter your name"
						name="userName" type="text" /> <input class="form-control mb-1"
						placeholder="Enter your age" name="userAge" type="number" />
						 <input class="form-control mb-1"
						placeholder="Enter your email" name="userEmail" type="text" />
				</div>
				<div class="card-footer">
					<button type="submit" class="btn btn-primary">Register</button>

				</div>
			</form>
		</div>
	</div>

</body>
</html>