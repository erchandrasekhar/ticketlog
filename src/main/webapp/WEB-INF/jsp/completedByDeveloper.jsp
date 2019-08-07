<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Worklist</title>
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
		<%-- login user name:${loginEmployee.txtEmployeeName}
 --%>
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">Completed Ticket List</h1>
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
								
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
							<!-- 	<th>Ticket Assign Date:</th> -->
							
								<th>Start Plan</th>
								<th>End Plan</th>
								<th>Completed Date:</th>
								<th>Priority:</th>
								<th>Action:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${tiketListByUserId}" var="tl">
								<tr style="font-size: 12px; font-weight: bolder;">
								<c:choose>
										<c:when test="${tl.subticketId==null}">
											<td>${tl.ticketId }</td>
										</c:when>
										
										
										<c:otherwise>
												<td >${tl.ticketId}&nbsp;<strong style="color:red;">S</strong><strong>&nbsp;(${tl.subticketId })</strong></td>
										</c:otherwise>
									</c:choose>
									<td>${tl.senderName}(${tl.sorce})</td>
									<td class="hidden">${tl.mobileMobile }</td>
									
									<td>${tl.ticketText}</td>
									<td>${tl.ticketRiseDateAndTime }</td>
									<%-- <td>${tl.assinedDateAndTimeByTl }</td> --%>
									<td style="color: red;">${tl.planStartDate }</td>
									<td style="color: red;">${tl.planCompleteDate}</td>
                                    <td>${tl.actualEnddate }</td>
									<c:choose>
										<c:when test="${tl.pririty=='C' }">
											<td style="background-color: red; color: white;">Critical</td>
										</c:when>

										<c:otherwise>
											<td style="background-color: green; color: white;">Normal</td>
										</c:otherwise>
									</c:choose>


									<c:choose>
				  <c:when test="${tl.status=='C' }">
				        <td style="background-color:;color: black;"><strong>completed</strong></td>
				  </c:when>
				 
					<c:when test="${tl.status=='RO'}">
					     <td><button class="btn btn-danger btn-sm" id="rdSelect" name="rdSelect" onclick="openCloseModel(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText}','${tl.assinedDateAndTimeByTl }');" data-toggle="modal" data-target="#TiketCloseModal">Reopened</button></td>
			
					</c:when>
				 
				  <c:otherwise>
				          <td><button class="btn btn-primary btn-sm" id="rdSelect" name="rdSelect" onclick="openCloseModel(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText}','${tl.assinedDateAndTimeByTl }');" data-toggle="modal" data-target="#TiketCloseModal">Close Ticket</button></td>
			
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


	<!--  ###############ticketCloseModel start ################-->
	
  <div id="TiketCloseModal" class="modal fade" role="dialog">
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
		  		 <label  class="control-label col-sm-3 ">Ticket No. &nbsp;</label>
			     <div class="col-sm-3">
				<input type="text" name="hticketId"  id="hticketId" value="" class="form-control mandatory" readonly>
				
				
			 </div>
			 
			
					 <label for="applicantName" class="control-label col-sm-3 ">Sender Name &nbsp;</label>
			<div class="col-sm-3">
				<input type="text" name="hname"  id="hname" class="form-control mandatory" readonly>
			 </div>	
					 
				</div>     		
       	</div>
       	
       	<div class="form-group">
		<div class="row">
       		 <label for="applicantName" class="control-label col-sm-3 ">Ticket Raise Date&nbsp;</label>
					<div class="col-sm-3">
						<input type="text" name="hticketDate"  id="hticketDate" class="form-control mandatory" readonly>
					 </div>	
					 
			 <label for="appDated" class="control-label col-sm-3 ">Ticket Assign Date&nbsp;</label>
       		<div class="col-sm-3">
       		<input type="text" name="hassignDate"  id="hassignDate" class="form-control mandatory" readonly>
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
		<div class="col-sm-3">
		<label  class="control-label  ">Issues(Subject) &nbsp;</label><br>
       		<label  class="control-label">All remarks&nbsp;<input type="checkbox" onclick="getAllRemaks();" id="chId"></label>
		</div>
       		
			  <div class="col-sm-9">
				<textarea rows="" cols="" class="form-control" id="hissues" name="hissues" style="resize: vertical;"readonly></textarea>
				 <p id="labelForAllRemaks" name="labelForAllRemaks" style="color: black;"></p>
			 </div>
			 
			
					
		</div>     		
       	</div>
       	
       
       	     <br>
       	     	<div class="form-group" >
					<div class="row">
					
					
			       		<label  class="control-label col-sm-3 ">Deployed: &nbsp;</label>
						  <div class="col-sm-3">
						 <select id="deployed" name="deployed" onchange="" class="form-control" required>
							        <option value="0">------select------</option>
							       <option value="Y">YES</option>
							     <!--    <option value="N">NO</option> -->
							    
						</select>
						 </div>
						 
						 
			       		<label  class="control-label col-sm-3 ">Close Remark: &nbsp;</label>
						  <div class="col-sm-3">
							<input type="text" class="form-control" id="closeRemark" name="closeRemark" required>
						 </div>
						
					</div>     		
          	</div>
       
             
             <br><br>
             <div class="form-group">
           
           
              	<button type="button" class="btn btn-success" onclick="closeTicket(document.getElementById('hticketId').value);">Submit</button>
             	&nbsp;<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
             </div>
             
             
             
             
          </form>
      </div>
      
       <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div>
    </div>

  </div>
</div>

<!-- /*ticketCloseModelEnd*/ -->

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
  
  /* ###########getting data from table to close model###########*/
  
  function openCloseModel(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,assignDate)
  {      
	
	     document.getElementById("hticketId").value = ticketId; 
	     document.getElementById("hticketDate").value = ticketDate; 
	     document.getElementById("hname").value = senderName; 
	  
	     document.getElementById("hinstance").value = instance; 
	     document.getElementById("hpriority").value = priority; 
	     document.getElementById("hissues").value = issues; 
	     document.getElementById("hassignDate").value = assignDate; 
  }
  
  
 function closeTicket(ticketId)
  {    
	    var closeRemark= document.getElementById("closeRemark").value;
	    var deployed= document.getElementById("deployed").value;
	   // alert("tiketId is::"+ticketId+"::AND:: developer REmarks::::::"+closeRemark+"deployed:"+deployed);
	    
	    if(deployed==0){
	    	
	    	alert("Select deployed yes to complete")
	    }
	    
	    else if(closeRemark=="")
	    {
	    	
	    	alert("Enter close Remarks")
	    }
	    else
	    {
	        window.location.href = "closeTicket?ticketId="+ticketId+"&closeRemark="+closeRemark+"&deployed="+deployed;
	    }
	
		
	    
  } 
 
 function getAllRemaks()
 {
	 var ticketId=document.getElementById("hticketId").value;
	 var ch = $('#chId').is(':checked');
	 
	
	 
	if(ch==true){
		var url = "getAllRemaks";
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
							   $("#labelForAllRemaks").append("<p>"+value.userRemarks+"</p>");
							 
							
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
