<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Instance</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css">
</head>
<body>
	<br>
	<div class="container-fluid">
		<c:choose>
			<c:when test="${empty successMsg}">
			</c:when>
			<c:otherwise>
				<div class="alert alert-success" id="mess"
					style="background-color: green; color: white;">
					<strong></strong>${successMsg}</div>
			</c:otherwise>
		</c:choose>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title">Add User Instance</h1>
					</div>
					<div class="panel-body">
						<form name="instanceForm" method="post" action="addInstance"
							onsubmit=" return validate();">
							<div class="form-group">
								<label for="instance_id" class="col-sm-2 hidden">User
									Instance Id:</label>
								<div class="col-sm-3">
									<input type="hidden" name="instance_id" id="instance_id"
										class="form-control">
								</div>
								<label class="col-sm-2">User Instance:</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="instance_text"
										name="instance_text" placeholder="Please Enter User Instance">
								</div>
							</div>
							<br> <br> <br>
							<div class="row text-center">
								<div class="col-sm-12">
									<button type="submit" class="btn btn-primary btn-fill"
										id="userInstanceSave">
										Submit<span class="fa fa-check-circle"></span>
									</button>
									<button type="reset" class="btn btn-danger btn-fill">
										Reset <span class="fa fa-refresh"></span>
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title">User Instances</h1>
					</div>
					<div class="panel-body">
						<div class="table">
							<table class="table table-striped table-bordered dt-responsive"
								style="width: 100%" id="userInstanceList">
								<thead style="font-size: 12px;">
									<tr bgcolor="#337ab7" style="color: white;">
										<th>Instance Id:</th>
										<th>Instance Name:</th>
										<th>Action:</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${userInstanceList}" var="uil">
										<tr style="font-size: 12px; font-weight: bolder;">
											<td>${uil.instanceId}</td>
											<td>${uil.instanceName }</td>
											<td>
												<a class="btn btn-success btn-fill btn-xs" href = "getUpdateUserInstance?instance_id=${uil.instanceId}">Edit</a>
												<a class="btn btn-danger btn-fill btn-xs" href = "deleteUserInstance?instance_id=${uil.instanceId}">Delete</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
	<script
		src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script>
	<script type="text/javascript">
		function validate() {

			var instanceName = document.getElementById("instance_text").value;

			if (instanceName == "") {
				alert("Please Enter User Instance");
				return false;
			} else {
				return true;
			}
		}

		$("#mess").fadeOut(2000);
		
		 $('#userInstanceList').DataTable({
			 aaSorting:[[0,'desc']]
		 });
	</script>

</body>
</html>