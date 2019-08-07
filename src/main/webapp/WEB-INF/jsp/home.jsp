<%-- <img alt="" src="${pageContext.request.contextPath}/static/img/purple.jpg" width="1089px" style="background-position: center; background-repeat: no-repeat;"> --%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<title>TicketLog</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css">
<style>
.zoom {
	padding: 20px;
	transition: transform .2s;
	width: 120px;
	height: 30px;
	margin: 0 auto;
}

.zoom:hover {
	-ms-transform: scale(1.0); /* IE 9 */
	-webkit-transform: scale(1.5); /* Safari 3-8 */
	transform: scale(1.1);
}
</style>
</head>
<%
     
     String loginUserRole=(String)request.getSession().getAttribute("currentUserRole");
     
   
    System.out.println(loginUserRole);
     %>
    
    <% if(loginUserRole.equals("ADMIN")) 
     {%>
     
       <div class="content" style="background-color: #e5d1fd;">
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4">

				<div class="panel status panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title text-center">
							<a onclick="getLIst(1)"> <i style="font-size: 80px;"
								class="pe-7s-check zoom"></i>
								<h1 class="panel-title">Completed</h1>
							</a>
						</h1>
					</div>
					<div class="panel-body text-center">
						<h5>
							<strong>${fn:length(closedTicketList)}</strong>
						</h5>
					</div>
				</div>

			</div>
			<div class="col-md-4">

				<div class="panel status panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title text-center">
							<a onclick="getLIst(2)"> <i style="font-size: 80px;"
								class="pe-7s-close-circle zoom"></i>
								<h1 class="panel-title">New Ticket</h1>
							</a>
						</h1>
					</div>
					<div class="panel-body text-center">
						<h5>
							<strong>${fn:length(openTicketList)}</strong>
						</h5>
					</div>
				</div>

			</div>
			<div class="col-md-4">

				<div class="panel status panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title text-center">
							<a onclick="getLIst(3)"> <i style="font-size: 80px;"
								class="pe-7s-display2 zoom"></i>
								<h1 class="panel-title">Assigned</h1>
							</a>
						</h1>
					</div>
					<div class="panel-body text-center">
						<h5>
							<strong>${fn:length(assinedTicketList)}</strong>
						</h5>
					</div>
				</div>


			</div>
		</div>
           <c:if test="${not empty completedTl}">
		<div class="row" id="onDiv">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<div class="panel-heading"></div>
					</div>
					<div class="panel-body">
						<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="ticketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								        <th>Ticket Id</th>
										<th>Issue:</th>
										<th>Developer Name</th>
										<th>Priority</th>
										<th>Raised Date</th>
										<th>Plan Date</th>
										<th>Plan Completion Date</th>
									    <th>Actual Completion Date</th>
									    <th>Root Cause</th>
								
							</tr>
						</thead>

						<tbody>
						  
							<c:forEach items="${completedTl}" var="tl">
							
								<tr style="font-size: 12px; font-weight: bolder;">
								
							
									<td>${tl.ticketId }</td>
									
									
									
									<td>${tl.ticketText }</td>
									
									<c:choose>
									
									<c:when test="${tl.developerName==null }">
											<td >Not Assigned</td>
										</c:when>
										<c:otherwise>
										<td>${tl.developerName }</td>
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
									<td>${tl.ticketRaisedDate }</td>
									
										<c:choose>
										<c:when test="${empty tl.planStartDate }">
											<td>NA</td>
										</c:when>
										
									
										<c:otherwise>
											<td>${tl.planStartDate }</td>
										</c:otherwise>
									</c:choose>
									
									
								
									
									<c:choose>
										<c:when test="${empty tl.planCompleteDate }">
											<td>NA</td>
										</c:when>
										
									
										<c:otherwise>
											<td>${tl.planCompleteDate }</td>
										</c:otherwise>
									</c:choose>
									
									
										<c:choose>
										<c:when test="${empty tl.actualEnddate }">
											<td>Pending</td>
										</c:when>
										
									
										<c:otherwise>
											<td>${tl.actualEnddate}</td>
										</c:otherwise>
									</c:choose>
										<td>${tl.closeRemark}</td>
								</tr>
								
							</c:forEach>
						</tbody>
					</table>
				</div>
					</div>
				</div>
			</div>
		</div>
		
		</c:if>

	</div>
</div>
   
        <%} 
        %>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>

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
<script>
$('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
});	

</script>
 

<script>
	
	function getLIst(cid) {
		//document.getElementById('onDiv').style.display = 'block';
        if(cid==1)  
        {
        	
        	 window.location.href = "getCompletedList";
        }
        else if(cid==2)
        {
        	
        	 window.location.href = "getNewList";
        	
        }
        else if(cid==3)
        {
        	 window.location.href = "getAssined";
        }
		
	}
</script>



