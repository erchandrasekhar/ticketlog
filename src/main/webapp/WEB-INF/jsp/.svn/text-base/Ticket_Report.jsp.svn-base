<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reports</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdn.datatables.net/responsive/2.2.3/css/responsive.bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<br>
	<div class="container-fluid">
		<div class="row">
		    
			<div class="col-sm-12">
			         	<label style="text-align: left;"><strong style="color: black;font-size: 25px;">Report Requirements</strong></label><br>
					<div class="form-group">
					
					
						<div class="col-sm-2">
							<select id="priorityId" name="priorityId" onchange="getPriorityList(document.getElementById('priorityId').value);" class="form-control" required>
								<option value="0">--Select Priority--</option>
								<option value="C">Critical</option>
								<option value="I">Immediate</option>
								<option value="N">Normal</option>
								<option value="ALL">ALL Ticket</option>
							</select>
						</div>
						
						
					
						<div class="col-sm-3">
							 <select id="developerName" name="developerName" onchange="getUserId(document.getElementById('developerName').value);" class="form-control" required>
							        <option value="0">--Select Developer--</option>
							        <c:forEach items="${userList}" var="userList">
							        <option value="${userList.userName}">${userList.firstName}</option>
							        
							        </c:forEach>
									
								
									</select>
									
						</div>
						
						<div class="col-sm-2">
							 <select id="developerName" name="developerName" onchange="getUserId(document.getElementById('developerName').value);" class="form-control" required>
							        <option value="0">--Select Date--</option>
							        <option value="0">Ticket raised </option>
							        <option value="0">Ticket assign </option>
							         <option value="0">Ticket complete </option>
							        
									</select>
									
						</div>
						
					
						<div class="col-sm-3">
							<input type="date" class="form-control" id="randomDate" name="randomDate"placeholder="Date">
									
						</div>
						
						<div class="col-sm-2">  
						  <button class="btn btn-success" onclick="searchTicketDate(document.getElementById('developerName').value,document.getElementById('priorityId').value,document.getElementById('randomDate').value)" style="border-radius: 0px;;">Search</button></div>
		                </div>
						   
					</div>
			
				
			</div>
		</div>
		
	
		<br>
		<div class="row">
			<div class="col-sm-12">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h1 class="panel-title">Ticket Report</h1>
					</div>
					<div class="panel-body">
						<div class="table">
							<table 
								class="table table-striped table-bordered "
								style="width: 100%" id="ticket_reports">
								<thead style="font-size: 12px;">
									<tr bgcolor="#337ab7" style="color: white;">
										<th>Ticket Id</th>
										<th>Issue:</th>
										<th>Developer Name</th>
											<th>Priority</th>
										<th>Plan Date</th>
										<th>Plan Completion Date</th>
									     <th>Actual Completion Date</th>
										<!-- <th>Action:</th> -->
										
									</tr>
								</thead>
								<tbody id="tableBody">
								<tr>
								</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>

	<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/responsive/2.2.3/js/dataTables.responsive.min.js"></script>
	<script
		src="https://cdn.datatables.net/responsive/2.2.3/js/responsive.bootstrap.min.js"></script>
	<script>
	
	
	function searchTicketDate(userName,priority,randomDate){
		alert(userName+"::"+priority+"::"+randomDate);
	}
	
	function getPriorityList(priority)
	{
		
		 $("tbody").empty();
		
		var url = "priotityList";
        $.getJSON(
   			url,
   			{							
   				'priority' : priority
   				
   			},
   			function(data) {
   		      	
   		 	var ticketList=JSON.stringify(data);
   		 	/*  alert(ticketList) */
   		     $.each(JSON.parse(ticketList), function(key, value) {
   		    	 
   		    	 
				 $("#tableBody").
                append("<tr> \
                		<td>" +  value.ticketId + "</td> \
                            <td>" +  value.ticketText + "</td> \
                            <td>" +  value.developerName + "</td> \
                            <td>" +  value.pririty + "</td> \
                            <td>" +  value.planStartDate + "</td> \
                            <td>" +  value.planCompleteDate + "</td> \
                            <td>" +  value.completedDateAndTime + "</td> \
                        </tr>"); 
			}); 
     	});
		
	}
	
	function getUserId(userId)
	{
		//alert(userId);
		

		 $("tbody").empty();
		
		var url = "ticketListByUserId";
       $.getJSON(
  			url,
  			{							
  				'userId' : userId
  				
  			},
  			function(data) {
  		      	
  		 	var ticketList=JSON.stringify(data);
  		 	/*  alert(ticketList) */
  		     $.each(JSON.parse(ticketList), function(key, value) {
  		    	 
  		    	 
				 $("#tableBody").
               append("<tr> \
               		<td>" +  value.ticketId + "</td> \
                           <td>" +  value.ticketText + "</td> \
                           <td>" +  value.developerName + "</td> \
                           <td>" +  value.pririty + "</td> \
                           <td>" +  value.planStartDate + "</td> \
                           <td>" +  value.planCompleteDate + "</td> \
                           <td>" +  value.completedDateAndTime + "</td> \
                       </tr>"); 
			}); 
    	});
		
		
	}
		$('#ticket_reports').DataTable();
	</script>
	
	
</body>
</html>