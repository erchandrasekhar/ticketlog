<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>My Ticket</title>
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

	<%
		String s = request.getContextPath();
		System.out.println(s);
	%>
	<div class="container-fluid">
	<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">Previous Assignment Details</h1>
			</div>
			<div class="panel-body">
				<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="ticketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								<th>TicketNo:</th>
								<th>Sender Name:</th>
								<th class="hidden">Mobile No:</th>
								<th class="hidden">From Instance:</th>
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
								<th>Assign Date:</th>
								<th>Completed Date:</th>
								<th>Priority:</th>
								<th>Status:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${assignTicketList}" var="tl">
								<tr style="font-size: 12px; font-weight: bolder;">
									<td>${tl.ticketId }</td>
									<td>${tl.senderName }&nbsp;(${tl.sorce })</td>
									<td class="hidden">${tl.mobileMobile }</td>
									<td class="hidden">${tl.sorce }</td>
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRiseDateAndTime }</td>
									<td>${tl.assinedDateAndTimeByTl}</td>
									
									<c:choose>
										<c:when test="${empty tl.actualEnddate }">
											<td><button class="btn btn-warning btn-sm" style="border-radius:0px;" onclick="showDeveloper('${tl.developerName}')">Pending</button></td>
										</c:when>
										
									
										<c:otherwise>
											<td>${tl.actualEnddate}</td>
										</c:otherwise>
									</c:choose>
                                    
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

                                      
                                     <c:choose>
										<c:when test="${tl.status=='RO' }">
											<td><button class="btn btn-danger btn-xs"  onclick="viewDeveloper('${tl.developerName}');" data-toggle="modal" data-target="#TiketCloseModal" style="border-radius:0px;">Reopened</button></td>
										</c:when>
										
											<c:when test="${tl.status=='O' }">
											<td><button class="btn btn-primary btn-xs"  onclick="viewDeveloper('${tl.developerName}');" data-toggle="modal" data-target="#TiketCloseModal" style="border-radius:0px;">Open</button></td>
										</c:when>
										
										<c:otherwise>
										
										    <td><button class="btn btn-success btn-xs"  onclick="viewDeveloper('${tl.developerName}');" data-toggle="modal" data-target="#TiketCloseModal" style="border-radius:0px;">Completed</button></td>
											
										</c:otherwise>
									</c:choose>
                                     

									

								</tr>
							</c:forEach>
						</tbody>
					</table>
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
  
	
 /*  function updateUser(IdPk)
  {
	  alert(IdPk)
	  
  } */
 
 
  
 $('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
 });
  </script>
</body>
</html>
