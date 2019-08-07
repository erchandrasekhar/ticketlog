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
				<h1 class="panel-title">MY TICKET LIST</h1>
			</div>
			<div class="panel-body">
				<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="ticketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								<th>TicketNo:</th>
								<th>Sender Name:</th>
								<th>Mobile No:</th>
								<th>From Instance:</th>
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
								<th>Priority:</th>
								<th>Status:</th>
							</tr>
						</thead>

						<tbody>
						  
							<c:forEach items="${tiketListBySenderName}" var="tl">
							
								<tr style="font-size: 12px; font-weight: bolder;">
									<c:choose>
										<c:when test="${tl.subticketId==null}">
											<td>${tl.ticketId }</td>
										</c:when>
										
										
										<c:otherwise>
													<td >${tl.ticketId}&nbsp;<strong style="color:red;">S</strong><strong>&nbsp;(${tl.subticketId })</strong></td>
										</c:otherwise>
									</c:choose>			
									<td>${tl.senderName }</td>
									<td>${tl.mobileMobile }</td>
									<td>${tl.sorce }</td>
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRiseDateAndTime }</td>

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
										<c:when test="${tl.status=='C'}">
											<td>
											<button class="btn btn-primary btn-xs"
										
											onclick="showCompleted(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.developerName }','${tl.closeRemark}','${tl.assinedDateAndTimeByTl}','${tl.completedDateAndTime }');"
											data-toggle="modal" data-target="#TiketAssineModal">Completed</button>
											
											<button class="btn btn-danger btn-xs" onclick="ReopenTicket(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.developerName }','${tl.closeRemark}','${tl.assinedDateAndTimeByTl}','${tl.completedDateAndTime }');"
											data-toggle="modal" data-target="#ReopenTicketModel">R</button>
											</td>
										</c:when>

                                      	<c:when test="${tl.status=='RO'}">
											<td>
											     <button class="btn btn-danger btn-xs" 
										
											onclick="showCompleted(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.developerName }','${tl.closeRemark}','${tl.assinedDateAndTimeByTl}','${tl.completedDateAndTime }');"
											data-toggle="modal" data-target="#TiketAssineModal">Reopened</button>
											</td>
										</c:when>
										
										<c:otherwise>
											<td><button class="btn btn-primary btn-xs"
											onclick="showCompleted(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.developerName }','${tl.closeRemark}','${tl.assinedDateAndTimeByTl}','${tl.completedDateAndTime }');"
											data-toggle="modal" data-target="#TiketAssineModal">Pending</button>
											</td>
											
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

	<div id="TiketAssineModal" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
				    <h4 class="modal-title" style="color: black;">My Ticket
						</h4>
				</div>
				<div class="modal-body">
					<form action="">

					
             <div class="form-group">
				<div class="row">
		  		 <label  class="control-label col-sm-3 ">Ticket No. &nbsp;</label>
			     <div class="col-sm-3">
				<input type="text" name="hticketId"  id="hticketId" value="" class="form-control mandatory" readonly>
				
				
			 </div>
			 
			 <label for="applicantName" class="control-label col-sm-3 ">Ticket Raise Date&nbsp;</label>
					<div class="col-sm-3">
						<input type="text" name="hticketDate"  id="hticketDate" class="form-control mandatory" readonly>
					 </div>	
					 
				</div>     		
       	</div>
       	
       	<div class="form-group">
		<div class="row">
       		<label for="applicantName" class="control-label col-sm-3 ">Sender Name &nbsp;</label>
			<div class="col-sm-3">
				<input type="text" name="hname"  id="hname" class="form-control mandatory" readonly>
			 </div>	
			 <label for="appDated" class="control-label col-sm-3 ">Mobile&nbsp;</label>
       		<div class="col-sm-3">
       			<input type="text" name="hmobile"  id="hmobile" class="form-control mandatory" readonly>
       		</div>
       		
		</div>     		
       	</div>
       	<div class="form-group" >
		<div class="row">
       		<label for="applicantName" class="control-label col-sm-3 ">From Instance&nbsp;</label>
			<div class="col-sm-3">
				<input type="text" name="hinstance"  id="hinstance" class="form-control mandatory" readonly>
			 </div>	
			 <label for="appDated" class="control-label col-sm-3 ">Priority&nbsp;</label>
       		<div class="col-sm-3">
       			<input type="text" name="hpriority"  id="hpriority" class="form-control mandatory" readonly>
       		</div>
		</div>     		
       	</div>
       	
       		
       	
       	<div class="form-group" >
		<div class="row">
       		<label  class="control-label col-sm-3 ">Issues(Subject) &nbsp;</label>
			  <div class="col-sm-9">
				<textarea rows="" cols="" class="form-control" id="hissues" name="hissues" style="resize: vertical;" readonly></textarea>
			 </div>

		</div>     		
       	</div>
       	     <br>
       	     <div class="form-group" id="divForHidden1" name="divForHidden1">
					<div class="row">
			       		<label  class="control-label col-sm-3 ">Assign Date: &nbsp;</label>
						  <div class="col-sm-3">
							 <input type="text" name="assignedDate"  id="assignedDate" class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Completed Date: &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="completedDate"name="completedDate" readonly>
								</div>

							</div>
			</div>
						<br>
       	     	<div class="form-group" id="divForHidden2" name="divForHidden2">
					<div class="row">
			       		<label  class="control-label col-sm-3 ">Completed by(Developer): &nbsp;</label>
						  <div class="col-sm-3">
							 <input type="text" name="developerName"  id="developerName" class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Developer Remark:<input type="checkbox" onclick="getAllDeveloperRemaks();" id="chId"></label>
								
								
								<div class="col-sm-3">
									<input type="text" class="form-control" id="developerRemark"name="developerRemark" readonly>
								</div>

							</div>
			  </div>

                 <p id="labelForAllRemaks" name="labelForAllRemaks" style="color: black;"></p>
					
					</form>
				</div>

				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>
	
	
	<!-- Reopen Ticket Model start -->
	
	<div id="ReopenTicketModel" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
				    <h4 class="modal-title" style="color: black;">Reopen Ticket
						</h4>
				</div>
				<div class="modal-body">
					<form action="#">

					
             <div class="form-group">
				<div class="row">
		  		 <label  class="control-label col-sm-3 ">Ticket No. &nbsp;</label>
			     <div class="col-sm-3">
				<input type="text" name="rhticketId"  id="rhticketId" value="" class="form-control mandatory" readonly>
				
				
			 </div>
			 
			 <label for="applicantName" class="control-label col-sm-3 ">Ticket Raise Date&nbsp;</label>
					<div class="col-sm-3">
						<input type="text" name="rhticketDate"  id="rhticketDate" class="form-control mandatory" readonly>
					 </div>	
					 
				</div>     		
       	</div>
       	
       	<div class="form-group">
		<div class="row">
       		<label for="applicantName" class="control-label col-sm-3 ">Sender Name &nbsp;</label>
			<div class="col-sm-3">
				<input type="text" name="rhname"  id="rhname" class="form-control mandatory" readonly>
			 </div>	
			 <label for="appDated" class="control-label col-sm-3 ">Mobile&nbsp;</label>
       		<div class="col-sm-3">
       			<input type="text" name="rhmobile"  id="rhmobile" class="form-control mandatory" readonly>
       		</div>
       		
		</div>     		
       	</div>
       	<div class="form-group" >
		<div class="row">
       		<label for="applicantName" class="control-label col-sm-3 ">From Instance&nbsp;</label>
			<div class="col-sm-3">
				<input type="text" name="rhinstance"  id="rhinstance" class="form-control mandatory" readonly>
			 </div>	
			 <label for="appDated" class="control-label col-sm-3 ">Priority&nbsp;</label>
       		<div class="col-sm-3">
       			<input type="text" name="rhpriority"  id="rhpriority" class="form-control mandatory" readonly>
       		</div>
		</div>     		
       	</div>
       	
       		
       	
       	<div class="form-group" >
		<div class="row">
       		<label  class="control-label col-sm-3 ">Issues(Subject) &nbsp;</label>
			  <div class="col-sm-9">
				<textarea rows="" cols="" class="form-control" id="rhissues" name="rhissues" style="resize: vertical;" readonly></textarea>
			 </div>

		</div>     		
       	</div>
       	     <br>
       	     <div class="form-group" >
					<div class="row">
			       		<label  class="control-label col-sm-3 ">Assign Date: &nbsp;</label>
						  <div class="col-sm-3">
							 <input type="text" name="rassignedDate"  id="rassignedDate" class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Completed Date: &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="rcompletedDate"name="rcompletedDate" readonly>
								</div>

							</div>
						</div>
						<br>
       	     	<div class="form-group" >
					<div class="row">
			       		<label  class="control-label col-sm-3 ">Completed by(Developer): &nbsp;</label>
						  <div class="col-sm-3">
							 <input type="text" name="rdeveloperName"  id="rdeveloperName" class="form-control mandatory" readonly>
								</div>

								<label class="control-label col-sm-3 "> Developer Remark: &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="rdeveloperRemark"name="rdeveloperRemark" readonly>
								</div>

							</div>
						</div>
					
							<div class="form-group">
							
					<div class="row">
			       		<label  class="control-label col-sm-3">Reopen Ticket&nbsp;</label>
						  <div class="col-sm-3">
							<select id="reopenFlage" name="reopenFlage"class="form-control">
							        <option value="0">------select------</option>
							        <option value="O">YES</option>
							   
							</select>	
						</div>
                          <label  class="control-label col-sm-3">Remarks:&nbsp;</label>
                          <div class="col-sm-3">
							<input type="text" class="form-control" id="reopenRemark"name="reopenRemark">
						 </div>
						
						
						</div>
                         
							<br>
								<div class="row">
								
								<div class="col-sm-6">
									 <a class="btn btn-primary" onclick="sendReopenTicketDetails();">Submit</a>
								
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
  
	var flag=false;
  function showCompleted(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,developerName,developerRemark,assignedDate,completedDate)
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
	     
	  	/*  hideSomePartOfModel */
	  	 if(developerName=="" || completedDate=="")
	     {
	    	
	  		flag=true;
	        
	    	if(flag==true)
	    	{
	    		document.getElementById('divForHidden1').style.display = 'none';
	    		document.getElementById('divForHidden2').style.display = 'none';
	    		
	    	}
	    	
	    	 
	     }
	  	else{
    		document.getElementById('divForHidden1').style.display = 'block';
    		document.getElementById('divForHidden2').style.display = 'block';
    		
    	}
	  
  }
  
  
  function ReopenTicket(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,developerName,developerRemark,assignedDate,completedDate)
  {      
	   
	     document.getElementById("rhticketId").value = ticketId; 
	     document.getElementById("rhticketDate").value = ticketDate; 
	     document.getElementById("rhname").value = senderName; 
	     document.getElementById("rhmobile").value = senderMobile; 
	     document.getElementById("rhinstance").value = instance; 
	     document.getElementById("rhpriority").value = priority; 
	     document.getElementById("rhissues").value = issues; 
	     document.getElementById("rdeveloperName").value = developerName; 
	  	 document.getElementById("rdeveloperRemark").value = developerRemark; 
	  	 document.getElementById("rassignedDate").value = assignedDate; 
	  	 document.getElementById("rcompletedDate").value = completedDate; 
	     
	  	
  }
  
  /*sending reopend data to controller */
 function sendReopenTicketDetails()
  
  {  
	  var ticketId= document.getElementById("rhticketId").value; 
  
      var reopenFlage= document.getElementById("reopenFlage").value; 
      var reopenRemark= document.getElementById("reopenRemark").value; 
  
	  
	  if(reopenFlage==0)
	  {
		  alert("select select yes for reopen ticket");
	  }
	  else if(reopenRemark=="")
	  {
		  
		  alert("plese enter you remarks");
	  }
	  
	  else{
		 
		  window.location.href = "reopenTicket?ticketId="+ticketId+"&reopenFlage="+reopenFlage+"&reopenRemark="+reopenRemark;
		 		
		  
	  }

 
	    
  } 
  
  
 function getAllDeveloperRemaks()
 {
	 var ticketId=document.getElementById("hticketId").value;
	 var ch = $('#chId').is(':checked');
	 
	
	 
	if(ch==true)
	{
		var url = "getAllDeveloperRemaks";
	    $.getJSON(
				url,
				{							
					'ticketId' : ticketId
					
				},
				function(data) 
				{
			      	
			 	var remarkList=JSON.stringify(data);
			   
			    $("#labelForAllRemaks").empty();
			    $.each( data, function( key, value ) 
						{
							   $("#labelForAllRemaks").append("<p>"+value.developerRemarks+"</p>");
							 
							
							});
			    
			 	
	 	});
			
		
	}
	
	else{
		 $("#labelForAllRemaks").empty();
	}
	
 }
  
  
 $('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
 });
  </script>
</body>
</html>
