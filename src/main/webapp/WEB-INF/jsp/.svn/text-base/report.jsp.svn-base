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
	
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.5.2/css/buttons.dataTables.min.css">
	
	<link rel="stylesheet"href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

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
		<div class="row">
		    
			<div class="col-sm-12">
			         	<label style="text-align: left;"><strong style="color: black;font-size: 25px;">Search Requirements</strong></label><br><br>
					<div class="form-group">
					
					
						<div class="col-sm-2">
						    <label>Select Priority</label>
							<select id="priorityId" name="priorityId"  class="form-control" required>
								<option value="0">--Select Priority--</option>
								<option value="C">Critical</option>
								<option value="I">Immediate</option>
								<option value="N">Normal</option>
								<!-- <option value="ALL">ALL Ticket</option> -->
							</select>
						</div>
						
						
					
						<div class="col-sm-3">
						      <label>Select Developer</label>
							 <select id="developerName" name="developerName" class="form-control" required>
							        <option value="0">--Select Developer--</option>
							        <c:forEach items="${userList}" var="userList">
							        <option value="${userList.userName}">${userList.firstName}</option>
							        
							        </c:forEach>
									
								
									</select>
									
						</div>
						
						<div class="col-sm-3">
						
						  <label>Select Date Type</label>
							 <select id="dateType" name="dateType" onchange="showDate(document.getElementById('dateType').value)" class="form-control" required>
							        <option value="0">--Select Date Type--</option>
							        <option value="tr">Ticket raised </option>
							        <option value="ta">Ticket assign </option>
							        <option value="tc">Ticket complete </option>
							        
									</select>
									
						</div>
						
					
						<div class="col-sm-2" id="divForHidden" name="divForHidden">
						     <label>From Date</label>
							<input type="text" class="form-control" id="fromDate" name="fromDate" placeholder="YYYY-MM-DD">
									
						</div>
						
						<div class="col-sm-2" id="divForHidden2" name="divForHidden2">
						     <label>To Date</label>
							<input type="text" class="form-control" id="toDate" name="toDate" placeholder="YYYY-MM-DD">
									
						</div>
						
						
		                </div>
						   
					</div>
			
				
			</div>
			   <br>
			  <div class="row">
			    
			         <div class="col-sm-4">
				 </div>
			      <div class="col-sm-4">
			      		  <button class="btn btn-success" onclick="searchTicket(document.getElementById('developerName').value,document.getElementById('priorityId').value,document.getElementById('dateType').value,document.getElementById('fromDate').value,document.getElementById('toDate').value)" style="border-radius: 0px;;">Search</button>
				  
			     </div>
			      <div class="col-sm-4">
			            
			     </div>
			  </div>
		</div>
	
	
	<div class="container-fluid">
	<br>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">All User</h1>
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
						  
							<c:forEach items="${allTicketList}" var="tl">
							
								<tr style="font-size: 12px; font-weight: bolder;">
								
							
									<c:choose>
										<c:when test="${(tl.subticketId==null) and (tl.subTicketFlag==null)}">
											<td>${tl.ticketId }<a onclick="getAllSubTicket(${tl.ticketId })"><strong style="color: red;"></strong></a></td>
										</c:when>
										
										<c:when test="${(tl.subticketId==null) and (tl.subTicketFlag=='S')}">
											<td>${tl.ticketId }<a onclick="getAllSubTicket(${tl.ticketId })" data-toggle="tooltip" data-placement="top" title="View SubTicket"><strong style="color: red;">&nbsp;P</strong></a></td>
											
											
										</c:when>
										
										
										<c:otherwise>
										<td>${tl.ticketId }<a onclick="getAllSubTicket(${tl.ticketId })"><strong style="color: red;"></strong></a></td>
					
										</c:otherwise>
									</c:choose>
									
									
									
									<td>${tl.ticketText }</td>
									
									<c:choose>
									
									<c:when test="${tl.developerName==null }">
											<td ><button type="button" class="btn btn-info btn-sm" style="border-radius:0px; color: black;">NOT ASSINED</button></td>
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
									<td>${tl.planStartDate }</td>
									<td>${tl.planCompleteDate }</td>
									<%-- <td>${tl.completedDateAndTime}</td> --%>
									
										<c:choose>
										<c:when test="${empty tl.actualEnddate }">
											<td><button class="btn btn-warning btn-sm" style="border-radius:0px;" onclick="showDeveloper('${tl.developerName}')">Pending</button></td>
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

<!-- #####################################################ticket and subTicket Model ####################################-->

	<div id="DeveloperWork" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Sub Ticket Details</h4>
					<input type="hidden" value="" name="ddId" id="ddId">
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<br>
						<div class="panel panel-primary">
							<div class="panel-heading">
							
							</div>
							<div class="panel-body">
								<div class="table">
									<table class="table table-striped table-bordered "
										style="width: 100%" id="ticket_reports">
										<thead style="font-size: 12px;">
											<tr bgcolor="#337ab7" style="color: white;">
												<th>TicketNo:</th>
												<th>Sender Name:</th>
												<!-- <th class="hidden">Mobile No:</th>
													<th class="hidden">From Instance:</th> -->
												<th>Issues:</th>
												<th>Assigned To:</th>
												<th>Ticket Raised Date:</th>
												<th>Assign Date:</th>
												<th>Completed Date:</th>
												<th>Priority</th>
												<th>Status:</th>
												<!-- <th>Action:</th> -->

											</tr>
										</thead>
										<tbody id="tableBody">
											<tr></tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius: 0px;">Close</button>
				</div>
			</div>

		</div>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.1.1.js"></script>
	
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

	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/dataTables.buttons.min.js"></script>
	
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/pdfmake.min.js"></script>
		
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.36/vfs_fonts.js"></script>
		
	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.html5.min.js"></script>
		
	<script
		src="https://cdn.datatables.net/buttons/1.5.2/js/buttons.print.min.js"></script>	
	
	<script>

	

    (function($){
        $( "#fromDate").datepicker({
            dateFormat: "yy-mm-dd",
            changeMonth: true,
            changeYear: true,
            onSelect: function(selectDate){
                $("#toDate").datepicker("option", "minDate", selectDate);
            }
        });
        $( "#toDate").datepicker({
            dateFormat: "yy-mm-dd",
            changeMonth: true,
            changeYear: true,
            onSelect: function(selectDate){
                $("#fromDate").datepicker("option", "maxDate", selectDate);
            }
        });
        
    })(jQuery);
    
    </script>
	
	<script type="text/javascript">
  
	flag=true;
	if(flag==true)
	{
		document.getElementById('divForHidden').style.display = 'none';
		document.getElementById('divForHidden2').style.display = 'none';
		
		
	}
	
	function showDate(dateType)
	{
		 if(!dateType==0)
		 {    
			 document.getElementById('divForHidden').style.display = 'block';
			 document.getElementById('divForHidden2').style.display = 'block';
			 
		 }
		
	}
	
	function showDeveloper(a)
	{
		//alert("Pending With:"+a);
	}
	
	
	function searchTicket(userName,priority,dateType,fromDate,toDate)
	{
	
	    
		if((userName==0) && (priority==0) && (dateType==0))
		{
			alert("Select At Least One Parameter!");
			
		}
		
	
		else if((!priority==0)&&(userName==0)&&(dateType==0))
			{
			 window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
				
				
			}
		 
		else if((priority==0)&&(!userName==0)&&(dateType==0))
			{
			 window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
				
				
			}
		 
		else if((priority==0)&&(userName==0)&&(!dateType==0))
			 
			{
			   if((fromDate==""))
			   {
				   alert("Select From Date!")
			   }
			   else if((toDate==""))
			   {
				   alert("Select To Date!")
			   }
			   
			   else{
				   window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
					 
			   }
				
				
			}
		 
		else if((!priority==0)&&(!userName==0)&&(dateType==0))
			{
			 window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
				
				
			}
		 
		else if((priority==0)&&(!userName==0)&&(!dateType==0))
			{
				
			if((fromDate==""))
			   {
				   alert("Select From Date!")
			   }
			   else if((toDate==""))
			   {
				   alert("Select To Date!")
			   }
			   else{
				   window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
					 
			   }
				
			}
		 
		else if((!priority==0)&&(userName==0)&&(!dateType==0))
			{
			if((fromDate==""))
			   {
				   alert("Select From Date!")
			   }
			   else if((toDate==""))
			   {
				   alert("Select To Date!")
			   }
			   else
			   {
				   window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
					 
			   }
			}
		 
		else if((!priority==0)&&(!userName==0)&&(!dateType==0))
			{
			if((fromDate==""))
			   {
				   alert("Select From Date!")
			   }
			   else if((toDate==""))
			   {
				   alert("Select To Date!")
			   }
			   else
			   {
				   window.location.href = "getReport?userName="+userName+"&priority="+priority+"&dateType="+dateType+"&fromDate="+fromDate+"&toDate="+toDate;
					 
			   }
			}
		 

	
	}
 
	
	function getAllSubTicket(parentTicketId)
	{
		
		/* alert("parent Ticket Id:::"+parentTicketId); */
            $("#tableBody").empty();
		var url = "getAllSubTicket";
        $.getJSON(
   			url,
   			{							
   				'parentTicketId' : parentTicketId
   				
   			},
   			function(data) {
   		      	
   		 	var ticketList=JSON.stringify(data);
   		   $.each(JSON.parse(ticketList), function(key, value) {
 		    	 
  		    	content = "<tr><td>" + value.ticketId + "</td><td>" 
					 + value.senderName + "</td><td>"
					 + value.ticketText + "</td><td>"
					 +value.developerName+"</td><td>"
					 + value.ticketRaisedDate + "</td><td>"
					 + value.assinedDate + "</td><td>"
	
if (value.completedDateAndTime == null){
	content += "<button type='button' class='btn btn-info btn-sm'>Pending</button></td><td>"
}
else{
	content += value.completedDateAndTime + "</td><td>"
}

if (value.pririty == "I"){
	content += "<button type='button' class='btn btn-warning btn-sm'>Immediate</button></td><td>"
}
else if(value.pririty == "C"){
	content += "<button type='button' class='btn btn-danger btn-sm'>Critical</button></td><td>"
}
else{
	content += "<button type='button' class='btn btn-primary btn-sm'>Normal</button></td><td>"
}
					 
if (value.status == "O"){
	content += "<button type='button' class='btn btn-warning btn-sm'>Open</button></td></tr>";
}
else{ 
content += "<button type='button' class='btn btn-success btn-sm'>Closed</button></td></tr>" ;
}
					 					 
$("#tableBody").
append(/* "<tr> \ <td>"  +  value.ticketId + "</td> \ <td>" 
				  +  value.subTicketId + "</td> \ <td>" 
				  +  value.senderName + "</td> \ <td>" 
				  +  value.ticketText + "</td> \ <td>" 
				  +  value.ticketRaisedDate + "</td> \ <td>" 
				  +  value.assinedDate + "</td> \ <td>" 
				  +  value.completedDateAndTime + "</td> \ <td>" 
				  +  value.pririty + "</td> \ <td>" 
				  +  value.status + "</td> \
  </tr>" */content); 
			}); 
   		 	
   		  $("#DeveloperWork").modal();
   		     
     	});
	
	}
  
 /* $('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
 }); */
 
 $('#ticketList').DataTable( {
     dom: 'Bfrtip',
     aaSorting:[[0,'desc']],
     buttons: [
         { extend:'copy', attr: { id: 'allan' } }, 'csv', 'excel', 'pdf', 'print'
     ]
 } );
  </script>
  <script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});
</script>
  
</body>
</html>
