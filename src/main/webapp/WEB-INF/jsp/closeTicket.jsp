<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html lang="en">
<head>
<title>Close Ticket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css">

<style type="text/css">
.modal-backdrop {
	/* bug fix - no overlay */
	display: none;
}

.wrapper {
	overflow-y: hidden;
}

.dtr-title {
	font-size: 12px;
}

.dtr-data {
	font-size: 12px;
}
</style>
</head>
<br>
<body>

	<%
		String s = request.getContextPath();
		System.out.println(s);
	%>
	<div class="container-fluid">
		<%-- login user name:${loginEmployee.txtEmployeeName}
 --%>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">ALL TICKET LIST</h1>
			</div>
			<div class="panel-body">
				<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="closeTicketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								<th>TicketNo:</th>
								<th>Sender Name:</th>
								<th>Mobile No:</th>
								<th>From Instance:</th>
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
								<th>Priority:</th>
								<th>Action:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${assinedTicketListForClose}" var="tl">


								<tr>
									<td>${tl.ticketId }</td>
									<td>${tl.senderName }</td>
									<td>${tl.mobileMobile }</td>
									<td>${tl.sorce }</td>
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRiseDateAndTime }</td>

									<c:choose>
										<c:when test="${tl.pririty=='C' }">
											<td style="background-color: red; color: white;">Critical</td>
										</c:when>

										<c:otherwise>
											<td style="background-color: green; color: white;">Normal</td>
										</c:otherwise>
									</c:choose>


									<td><button class="btn btn-info btn-sm" id="rdSelect"
											name="rdSelect"
											onclick="openAsign(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }');"
											data-toggle="modal" data-target="#TiketAssineModal">Close</button></td>

								</tr>
							</c:forEach>
						</tbody>




					</table>
				</div>
			</div>
		</div>



		<div class="container-fluid">

			<div class="row" id="taskAssigmentDiv" name="taskAssigmentDiv" hidden>

				<form name="userForm" method="post" action="addTicket">

					<input name="persistId" type="hidden">


					<div class="panel panel-default">
						<div class="panel-heading">
							<h1 class="panel-title">TICKET FORM</h1>



						</div>

						<div class="panel-body">
							<div class="row">
								<div class="form-group">
									<div class="col-sm-1"></div>
									<!-- <input name="useIdPk" value="" type="hidden"> -->
									<label for="" class="control-label col-sm-2">EmployeeName&nbsp;<font
										size="3" color="red">*</font></label>

									<div class="col-sm-3">

										<input class="form-control" name="ticketId" id="ticketId"
											type="hidden" value="ticketId">

									</div>
									<label for="txtDob" class="control-label col-sm-2">Email:&nbsp;<font
										size="3" color="red">*</font></label>
									<div class="col-sm-3">
										<input class="form-control" name="email" id="email"
											placeholder="Enter User ID" type="text">
									</div>
									<div class="col-sm-1"></div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="form-group">
									<div class="col-sm-1"></div>
									<label for="txtUserName" class="control-label col-sm-2">Mobile
										No:&nbsp;<font size="3" color="red">*</font>
									</label>
									<div class="col-sm-3">
										<input class="form-control" name="mobile" id="mobile"
											placeholder="Enter User Name" maxlength="30" value=""
											type="text">
										<div id="txtDakSNameError"></div>
									</div>
									<label for="status" class="control-label col-sm-2">Priority:&nbsp;<font
										size="3" color="red">*</font></label>
									<div class="col-sm-3">
										<select id="priority" name="priority" onchange=""
											class="form-control" required>
											<option value="0">Select</option>
											<option value="C">Critical</option>
											<option value="N">Normal</option>
										</select>
									</div>
									<div class="col-sm-1"></div>
								</div>
							</div>
							<br>

							<div class="row">
								<div class="form-group">
									<div class="col-sm-1"></div>
									<label for="txtAddressDesc" class="control-label col-sm-2">Subject/Issues:&nbsp;</label>
									<div class="col-sm-3">
										<textarea name="subject" class="form-control" maxlength="255"
											id="subject"></textarea>

									</div>
									<label for="txtCity" class="control-label col-sm-2">From
										instance:&nbsp;</label>
									<div class="col-sm-3">
										<input class="form-control" name="instance" id="instance"
											placeholder="Enter instance name" maxlength="25" value=""
											type="text">
									</div>
									<div class="col-sm-1"></div>
								</div>
							</div>
							<br> <br>
							<div class="row" style="text-align: center;">

								<button type="submit" class="btn btn-success" id="btnSave">
									Save <span class="fa fa-check-circle"></span>
								</button>
								<button type="reset" class="btn btn-danger">
									Reset <span class="fa fa-refresh"></span>
								</button>


							</div>
						</div>
					</div>



				</form>

			</div>

		</div>

	</div>

	<div id="TiketAssineModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="color: black;">Close Ticket :</h4>
				</div>
				<div class="modal-body">
					<form action="">

						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Ticket No. &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hticketId" id="hticketId" value=""
										class="form-control mandatory" readonly>


								</div>

								<label for="applicantName" class="control-label col-sm-3 ">Ticket
									Raise Date&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hticketDate" id="hticketDate"
										class="form-control mandatory" readonly>
								</div>

							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label for="applicantName" class="control-label col-sm-3 ">Sender
									Name &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hname" id="hname"
										class="form-control mandatory" readonly>
								</div>
								<label for="appDated" class="control-label col-sm-3 ">Mobile&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hmobile" id="hmobile"
										class="form-control mandatory" readonly>
								</div>

							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label for="applicantName" class="control-label col-sm-3 ">From
									Instance&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hinstance" id="hinstance"
										class="form-control mandatory" readonly>
								</div>
								<label for="appDated" class="control-label col-sm-3 ">Priority&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hpriority" id="hpriority"
										class="form-control mandatory" readonly>
								</div>
							</div>
						</div>



						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Issues(Subject)
									&nbsp;</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" class="form-control" id="hissues"
										name="hissues" style="resize: vertical;"></textarea>
								</div>
								<!--  
			 <label for="appDated" class="control-label col-sm-3 ">Cancel Reason&nbsp;</label>
					 
					 
		       		<div class="col-sm-3">
		       			<input type="time" name="hComment"  id="hComment" class="form-control mandatory" readonly>
		       		</div> -->


							</div>
						</div>
						<br>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Remark: &nbsp;</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="closeRemark"
										name="closeRemark" required>
								</div>



							</div>
						</div>


						<br> <br>
						<div class="form-group">


							<button type="button" class="btn btn-success"
								onclick="assignToDeveloper(document.getElementById('hticketId').value);">Assign</button>
							&nbsp;
							<button type="button" class="btn btn-success">Back</button>
						</div>




					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	<!-- <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
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
  
  function openAsign(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues)
  {      
	    
	     document.getElementById("hticketId").value = ticketId; 
	     document.getElementById("hticketDate").value = ticketDate; 
	     document.getElementById("hname").value = senderName; 
	     document.getElementById("hmobile").value = senderMobile; 
	     document.getElementById("hinstance").value = instance; 
	     document.getElementById("hpriority").value = priority; 
	     document.getElementById("hissues").value = issues; 
  }
  
  
 function assignToDeveloper(ticketId)
  {    
	    var closeRemark= document.getElementById("closeRemark").value;
	    alert("tiketId is::"+ticketId+"::AND:: developer REmarks::::::"+closeRemark);
	    
	  window.location.href = "closeTicket?ticketId="+ticketId+"&closeRemark="+closeRemark;
		
	    
  } 
  
 $('#closeTicketList').DataTable();
  </script>
</body>
</html>
