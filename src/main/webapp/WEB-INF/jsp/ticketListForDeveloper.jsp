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
		
           <c:choose>
			    <c:when test="${empty successMsg}">
			    </c:when>
			    <c:otherwise>
			       <div class="alert alert-success" id="mess" name="mess" style="background-color: green;color: white;"> <strong ></strong>${successMsg}</div>
			    </c:otherwise>
			</c:choose>
			
			 <c:choose>
			    <c:when test="${empty successMsg1}">
			    </c:when>
			    <c:otherwise>
			       <div class="alert alert-success" id="mess" name="mess" style="background-color: green;color: white;"> <strong ></strong>${successMsg1}</div>
			    </c:otherwise>
			</c:choose>
			
			
			
		<!-- ##################################################subList Table Start#####################################################################  -->
	
	<c:if test="${not empty tiketListByUserId}">
	
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">DEVELOPER WORK LIST</h1>
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
					     <td><button class="btn btn-danger btn-sm" id="rdSelect" name="rdSelect" onclick="openCloseModel(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText}','${tl.assinedDateAndTimeByTl }','${tl.planStartDate }','${tl.planCompleteDate}','${tl.ticketRaisedDate }');" data-toggle="modal" data-target="#TiketCloseModal">Reopened</button></td>
			
					</c:when>
				 
				  <c:otherwise>
				          <td><button class="btn btn-primary btn-sm" id="rdSelect" name="rdSelect" onclick="openCloseModel(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText}','${tl.assinedDateAndTimeByTl }','${tl.planStartDate }','${tl.planCompleteDate}','${tl.ticketRaisedDate }');" data-toggle="modal" data-target="#TiketCloseModal">Close Ticket</button></td>
			
				  </c:otherwise>
				</c:choose>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</c:if>
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
							<input type="text" name="ticketRaisedDateHidden"  id="ticketRaisedDateHidden" class="form-control mandatory" readonly>
					 </div>	
					 
			 <label for="appDated" class="control-label col-sm-3 ">Ticket Assign Date&nbsp;</label>
       		<div class="col-sm-3">
       		<input type="text" name="hassignDate"  id="hassignDate" class="form-control mandatory" readonly>
       		</div>
       		
		</div>     		
       	</div>
       	
       	 	<div class="form-group">
		<div class="row">
       		 <label for="applicantName" class="control-label col-sm-3 ">Plan Start Date&nbsp;</label>
					<div class="col-sm-3">
						<input type="text" name="hplaneStartDate"  id="hplaneStartDate" class="form-control mandatory" readonly>
					 </div>	
					 
			 <label for="appDated" class="control-label col-sm-3 ">Plan End Date&nbsp;</label>
       		<div class="col-sm-3">
       		<input type="text" name="hplaneEndDate"  id="hplaneEndDate" class="form-control mandatory" readonly>
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
       	
       
       <div class="form-group" >
					<div class="row">
					
					
			       		<label  class="control-label col-sm-3 ">Actual Start Date: &nbsp;</label>
						  <div class="col-sm-3">
						  
					<input type="text" class="form-control" id="actualStartDate" name="actualStartDate" required placeholder="DD-MM-YYYY">
						 </div>
						 
						 
			       		<label  class="control-label col-sm-3 ">Actual End Date: &nbsp;</label>
						  <div class="col-sm-3">
							<input type="text" class="form-control" id="actalEndDate" name="actalEndDate" required placeholder="DD-MM-YYYY">
						 </div>
						
					</div>     		
          	</div>
       
       	   
       	     	<div class="form-group" >
					<div class="row">
					
					
			       		<label  class="control-label col-sm-3 ">Deployed: &nbsp;</label>
						  <div class="col-sm-3">
						 <select id="deployed" name="deployed" onchange="setdeployedDate(document.getElementById('deployed').value)" class="form-control" required>
							        <option value="0">------select------</option>
							       <option value="Y">YES</option>
							       <option value="N">NO</option>
							    
						</select>
						 </div>
						 
						 
			       		<label  class="control-label col-sm-3 ">Deployed Date: &nbsp;</label>
						  <div class="col-sm-3">
							<input type="text" class="form-control" id="deployeddate" name="deployeddate" required placeholder="DD-MM-YYYY">
						 </div>
						
					</div>     		
          	</div>
       
       
       	<div class="form-group" >
					<div class="row">
					
					
			       	
						 
			       		<label  class="control-label col-sm-3 ">Root Cause of the Problem: &nbsp;</label>
						  <div class="col-sm-9">
							<input type="text" class="form-control" id="closeRemark" name="closeRemark" required>
						 </div>
						
					</div>     		
          	</div>
             
            
             <div class="form-group">
           
           
              	<button type="button" class="btn btn-success" onclick="closeTicket(document.getElementById('hticketId').value);">Submit</button>
             	&nbsp;<button type="button" class="btn btn-danger" data-dismiss="modal">Back</button>
             </div>
             
             
             
             
          </form>
      </div>
      
    <!--    <div class="modal-footer">
		        <button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>
		      </div> -->
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

 <script >


(function($){
    $( "#actualStartDate").datepicker({
    	maxDate: '0',
        dateFormat: "dd-mm-yy",
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectDate){
            $("#actalEndDate").datepicker("option", "minDate", selectDate);
        }
    });
    $( "#actalEndDate").datepicker({
    	maxDate: '0',
        dateFormat: "dd-mm-yy",
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectDate){
            $("#actualStartDate").datepicker("option", "maxDate", selectDate);
            $("#deployeddate").datepicker("option", "maxDate", selectDate);
        }
    });
    $( "#deployeddate").datepicker({
    	maxDate: '0',
        dateFormat: "dd-mm-yy",
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectDate){
            $("#actalEndDate").datepicker("option", "minDate", selectDate);
        }
    });
    
    
    
    
    
})(jQuery);

</script>

<script type="text/javascript">
  
  /* ###########getting data from table to close model###########*/
  
  function openCloseModel(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,assignDate,planStartDate,planEndDate,raiedDateHidden)
  {      
	
	
	     document.getElementById("hticketId").value = ticketId; 
	     document.getElementById("hticketDate").value = ticketDate; 
	     document.getElementById("hname").value = senderName; 
	  
	     document.getElementById("hinstance").value = instance; 
	     document.getElementById("hpriority").value = priority; 
	     document.getElementById("hissues").value = issues; 
	     document.getElementById("hassignDate").value = assignDate; 
	     
	     document.getElementById("hplaneStartDate").value = planStartDate; 
	     document.getElementById("hplaneEndDate").value = planEndDate; 
	     
	     document.getElementById("ticketRaisedDateHidden").value=raiedDateHidden;
  }
  
  
  function openCloseModelforSubTicket(ticketId,senderName,ticketRaisedDate,assignDate,planStartDate,PlanEndDate,sorce,pririty,issuesText,subTicketId)
  {      
  //  alert("ticketId:"+ticketId+"ticketRaiseddate:"+ticketRaisedDate+"assibgnDate:"+assignDate);
    
    document.getElementById("shticketId").value = ticketId; 
    
    document.getElementById("shsname").value = senderName; 
    document.getElementById("shticketDate").value = ticketRaisedDate; 
    document.getElementById("shasignDate").value = assignDate; 
    
    document.getElementById("shplaneStartDate").value = planStartDate; 
    document.getElementById("shplaneEndDate").value = PlanEndDate; 
    
    document.getElementById("shinstance").value = sorce; 
    document.getElementById("shpriority").value = pririty; 
    document.getElementById("shissues").value = issuesText; 
    document.getElementById("subTicketId").value = subTicketId; 
      
  }
  
  
 function closeTicket(ticketId)
  {    
	    var closeRemark= document.getElementById("closeRemark").value;
	    var deployed= document.getElementById("deployed").value;
	   
	    var actualStartDate= document.getElementById("actualStartDate").value;
	    var actualEndDate= document.getElementById("actalEndDate").value;
	    
	    var deployedDate= document.getElementById("deployeddate").value;
	    var ticketRaisedDate=document.getElementById("ticketRaisedDateHidden").value;
	    
	   // alert("tiketId is::"+ticketId+"::AND:: developer REmarks::::::"+closeRemark+"deployed:"+deployed);
	    
	   
	   if(actualStartDate=="")
	    {
	    	
	    	alert("Please Select Actual Start Date!")
	    }
	
	    
	    else if(actualEndDate=="")
	    {
	    	
	    	alert("Please Select Actual End Date!")
	    }
	  
	    else if(deployed==0)
	    {
	    	
	    	alert("Select deployed yes to complete!")
	    }
	   
	    
	    
	    else if((deployedDate=="") &&(deployed=="Y"))
	    {
	    	
	    	alert("Please Select Deployed Date!")
	    }
	   
	 
	   
	    else if(closeRemark=="")
	    {
	    	
	    	alert("Enter close Remarks!")
	    }
	    
	    
	    
	    else
	    {
	        window.location.href = "closeTicket?ticketId="+ticketId+"&closeRemark="+closeRemark+"&deployed="+deployed+"&actualStartDate="+actualStartDate+"&actualEndDate="+actualEndDate+"&deployedDate="+deployedDate;
	    }

  } 
 
 function setdeployedDate(deployedId){
	 
	 if(deployedId=="N")
	 {
		
		 document.getElementById('deployeddate').style.display = 'none';
	 }
	 if(deployedId=="Y")
	 {
		 
		 document.getElementById('deployeddate').style.display = 'block';
	 }
	 
 }
 
 function closeTicketSubTicket(ticketId)
 {    
	     var subTicketId=document.getElementById("subTicketId").value;
	    var closeRemark= document.getElementById("scloseRemark").value;
	    var deployed= document.getElementById("sdeployed").value;
	   
	    var actualStartDate= document.getElementById("sactualStartDate").value;
	    var actualEndDate= document.getElementById("sactalEndDate").value;
	    
	    var deployedDate= document.getElementById("sdeployeddate").value;
	    var ticketRaisedDate=document.getElementById("shticketDate").value;
	    
	    
	   
	   if(actualStartDate=="")
	    {
	    	
	    	alert("Please Select Actual Start Date!")
	    }
	
	    
	    else if(actualEndDate=="")
	    {
	    	
	    	alert("Please Select Actual End Date!")
	    }
	  
	    else if(deployed==0)
	    {
	    	
	    	alert("Select deployed yes to complete!")
	    }
	   
	    
	    
	    else if(deployedDate=="")
	    {
	    	
	    	alert("Please Select Deployed Date!")
	    }
	   
	 
	   
	    else if(closeRemark=="")
	    {
	    	
	    	alert("Enter close Remarks!")
	    }
	    
	    
	    
	    else
	    {
	    	 /*  alert("tiketId is::"+ticketId+"::AND:: developer REmarks::::::"+closeRemark+"deployed:"+deployed); */
	    		 
	      window.location.href = "closeSubTicket?ticketId="+ticketId+"&closeRemark="+closeRemark+"&deployed="+deployed+"&actualStartDate="+actualStartDate+"&actualEndDate="+actualEndDate+"&deployedDate="+deployedDate+"&subTicketId="+subTicketId;
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
 
 $('#subticketList').DataTable({
	 aaSorting:[[1,'desc']]
 });
  </script>
	 <script> $( "#mess" ).fadeOut( 4000 );</script>
</body>
</html>
