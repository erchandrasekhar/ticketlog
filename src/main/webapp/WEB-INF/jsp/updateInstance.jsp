<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update User Instance</title>
</head>
<body>
<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<form name="updateInstanceForm" method="post"
					action="updateInstance" onsubmit=" return validate();">
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h1 class="panel-title">Update User Instance</h1>
						</div>
						<div class="panel-body">
							<div class="form-group">
								<label for="updateInstanceId" class="col-sm-2 hidden"></label>
								<div class="col-sm-3">
									<input type="hidden" name="instance_id"
										id="instance_id" value="${instanceType.instanceId }">
								</div>
								<label for="updateInstanceName" class="col-sm-2">User Instance:</label>
								<div class="col-sm-3">
									<input class="form-control" type="text" id="instance_text"
										name="instance_text"
										value="${instanceType.instanceName}">
								</div>
							</div>
							<br><br><br>
							<div class="row text-center">
								<div class="col-sm-12">
									<button class="btn btn-success btn-sm btn-fill" type="submit"
										id="userInstanceUpdate">
										Update <span class="fa fa-check-circle"></span>
									</button>
									<button class="btn btn-danger btn-sm btn-fill" type="reset"
										id="userInstanceReset">
										Reset <span class="fa fa-refresh"></span>
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>