<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Completed Ticket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
</style>
<style>
.dtr-title {
	font-size: 12px;
}

.dtr-data {
	font-size: 12px;
}
</style>
</head>

<body>
   <br>
	<%
		String s = request.getContextPath();
		System.out.println(s);
	%>
	<div class="container-fluid">
		<%-- login user name:${loginEmployee.txtEmployeeName}
 --%>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">All Completed Ticket List</h1>
			</div>
			<div class="panel-body">
				<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="ticketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								<th>TicketNo:</th>
								<th>Sender Name:</th>

							
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
								<th>Ticket Assign Date:</th>
								<th>Ticket Close Date:</th>
								<th>Completed by</th>
								<th>Priority:</th>
								<th>Status:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${completedTicketList}" var="tl">
								<tr style="font-size: 12px; font-weight: bolder;">
									<c:choose>
										<c:when test="${tl.subticketId==null}">
											<td>${tl.ticketId }</td>
										</c:when>
										
										
										<c:otherwise>
													<td >${tl.ticketId}&nbsp;<strong style="color:red;">S</strong><strong>&nbsp;(${tl.subticketId })</strong></td>
										</c:otherwise>
									</c:choose>									
                                    <td>${tl.senderName }(${tl.sorce })</td>
								
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRaisedDate }</td>
									<td>${tl.assinedDate }</td>
									<td>${tl. completedDateAndTime}</td>
									<td>${tl.developerName}</td>

										<c:choose>
										<c:when test="${tl.pririty=='C' }">
											<td style="background-color: yellow; color: black;">Critical</td>
										</c:when>
										
										<c:when test="${tl.pririty=='I' }">
											<td style="background-color: red; color: black;">Immediate</td>
										</c:when>

										<c:otherwise>
											<td style="background-color: green; color: black;">Normal</td>
										</c:otherwise>
									</c:choose>



									<td><button class="btn btn-primary btn-sm" 
			
											onclick="openAsign(${tl.ticketId},'${tl.ticketRaisedDate}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.developerName }','${tl.closeRemark}','${tl.assinedDateAndTimeByTl}','${tl.completedDateAndTime }','${tl.deploymentFlage }');"
											data-toggle="modal" data-target="#TiketAssineModal"  style="border-radius:0px;">Completed</button></td>

								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	</div>

	<div id="TiketAssineModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>

					<h5>
						<button type="button" class="btn btn-success"
							onclick="displayRemainingLeaves()" style="height: 36px;">
							<i class="fa fa-bars"></i>Completed Ticket
						</button>
					</h5>
				</div>
				<div class="modal-body">
					<form action="">


						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Ticket No:&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hticketId" id="hticketId" value=""
										class="form-control mandatory" readonly>


								</div>

								<label for="applicantName" class="control-label col-sm-3 ">Ticket
									Raise Date:&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hticketDate" id="hticketDate"
										class="form-control mandatory" readonly>
								</div>

							</div>
						</div>

						<div class="form-group">
							<div class="row">
								<label for="applicantName" class="control-label col-sm-3 ">Sender
									Name :&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hname" id="hname"
										class="form-control mandatory" readonly>
								</div>
								<label for="appDated" class="control-label col-sm-3 ">Mobile:&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hmobile" id="hmobile"
										class="form-control mandatory" readonly>
								</div>

							</div>
						</div>
						<div class="form-group">
							<div class="row">
								<label for="applicantName" class="control-label col-sm-3 ">From
									Instance:&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hinstance" id="hinstance"
										class="form-control mandatory" readonly>
								</div>
								<label for="appDated" class="control-label col-sm-3 ">Priority:&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="hpriority" id="hpriority"
										class="form-control mandatory" readonly>
								</div>
							</div>
						</div>



						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Issues(Subject):
									&nbsp;</label>
								<div class="col-sm-9">
									<textarea rows="" cols="" class="form-control" id="hissues"
										name="hissues" style="resize: vertical;" readonly></textarea>
								</div>

							</div>
						</div>
						<br>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Assign Date:
									&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="assignedDate" id="assignedDate"
										class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Completed Date:
									&nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="completedDate"
										name="completedDate" readonly>
								</div>

							</div>
						</div>
						<br>
						<div class="form-group">
							<div class="row">
								<label class="control-label col-sm-3 ">Completed
									by(Developer): &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" name="developerName" id="developerName"
										class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Deploy On
									Server: &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="deployId"
										name="deployId" readonly>
								</div>

							</div>
						</div>

						<br>

						<div class="form-group">
							<div class="row">


								<label class="control-label col-sm-3 "> Developer
									Remark: &nbsp;</label>
								<div class="col-sm-9">
									<input type="text" class="form-control" id="developerRemark"
										name="developerRemark" readonly>
								</div>

							</div>
						</div>

					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
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
  
  function openAsign(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,developerName,developerRemark,assignedDate,completedDate,deployeFlage)
  {      
	    
	     document.getElementById("hticketId").value = ticketId; 
	     document.getElementById("hticketDate").value = ticketDate; 
	     document.getElementById("hname").value = senderName; 
	     document.getElementById("hmobile").value = senderMobile; 
	     document.getElementById("hinstance").value = instance; 
	     document.getElementById("hpriority").value = priority; 
	     document.getElementById("hissues").value = issues; 
	     document.getElementById("developerName").value = developerName; 
	     document.getElementById("developerRemark").value = developerRemark; 
	     
	     document.getElementById("assignedDate").value = assignedDate; 
	     document.getElementById("completedDate").value = completedDate; 
	     document.getElementById("deployId").value = deployeFlage; 
	     
  }
  
  
 function assignToDeveloper(ticketId)
  {    
	    var tlRemark= document.getElementById("tlremarks").value;
	    var developerName=document.getElementById("developerName").value;
	    alert("tiketId is::"+ticketId+"::AND:: TL REmarks::::::"+tlRemark+": developer name:"+developerName);
	    
	  window.location.href = "assign?ticketId="+ticketId+"&tlRemark="+tlRemark+"&developerName="+developerName;
		
	    
  } 
  
 $('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
 });
  </script>
</body>
</html>
