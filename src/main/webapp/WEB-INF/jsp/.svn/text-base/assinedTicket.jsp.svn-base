<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<title>Assigned Ticket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
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
<style type="text/css">
.modal-backdrop {
	/* bug fix - no overlay */
	display: none;
}
</style>
<style type="text/css">
 .wrapper {
	overflow-x: hidden;
}

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
	<div class="container-fluid">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h1 class="panel-title">Assigned List</h1>
			</div>
			<div class="panel-body">
				<div class="table">
					<table class="table table-striped table-bordered dt-responsive"
						style="width: 100%" id="assignedTicketList">
						<thead style="font-size: 12px;">
							<tr bgcolor="#337ab7" style="color: white;">
								<th>TicketNo:</th>
								
								<th class="hidden">email:</th>
								<th>From Instance:</th>
								<th>Issues:</th>
								<th>Ticket Raised Date:</th>
								<th>Ticket Assigned Date:</th>
								
								<th>Plan Start:</th>
								<th >Plan complete:</th>
								
								<th>Assigned To:</th>
								<th>Priority:</th>
								<th>Status:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${assinedTicketList}" var="tl">
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
									
									<td class="hidden">${tl.senderEmail }</td>
								
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRiseDateAndTime }</td>
									<td>${tl.assinedDateAndTimeByTl }</td>
									
									<td>${tl.planStartDate }</td>
									<td>${tl.planCompleteDate }</td>
									
									 <td>${tl.developerName }</td>
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

														
							        
								<!-- 	  <td><button class="btn btn-info" id="" name="">Open</button></td> -->
									    
									   <td>
									   
									 <button class="btn btn-primary btn-sm"
											
											onclick="openRplanDate(${tl.ticketId},'${tl.ticketRiseDateAndTime}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.planStartDate }','${tl.planCompleteDate }','${tl.developerName }','${tl.ticketRaisedDate }');"
											data-toggle="modal" data-target="#replanModel" style="border-radius:0px;">Open</button>
									   
									   </td>
									
								</tr>
							</c:forEach>
						</tbody>

					</table>
				</div>
			</div>
		</div>
</div>
		<div id="replanModel" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" style="color: black;">Re-Plan Date:</h4>
					<div id="dvforHidden" name="dvforHidden" hidden>
					 <select id="asignlist" name="asignlist"  class="form-control" style="hidden">
							        <option value="">------select------</option>
	                </select>
					</div>
					
				<!-- 	<h5>
						<button type="button" class="btn btn-success" 
							onclick="displayAssinedList();" style="height: 36px;">
							<i class="fa fa-bars"></i> Display Assigned Developer
						</button>
						
						
					</h5> -->
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
						<input type="text" name="ticketRaisedDateHidden"  id="ticketRaisedDateHidden" class="form-control mandatory" readonly>
					 </div>	
					 
				</div>     		
       	</div>
       	
       	<div class="form-group">
		<div class="row">
       		<label for="applicantName" class="control-label col-sm-3 ">Name &nbsp;</label>
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
       	    
	       	 <div class="form-group" >
					<div class="row">
			       		<label for="applicantName" class="control-label col-sm-3 ">Plan Start Date&nbsp;</label>
						<div class="col-sm-3">
							<input type="text" name="planStartDate"  id="planStartDate" value="" class="form-control mandatory">
						 </div>	
						 <label for="appDated" class="control-label col-sm-3 ">Plan Complete Date&nbsp;</label>
			       		<div class="col-sm-3">
			       			<input type="text" name="planeCompleteDate"  id="planeCompleteDate"class="form-control mandatory">
			       		</div>
					</div>     		
       	</div>
       	<br>
       	     	<div class="form-group" >
					<div class="row">
			       		<label  class="control-label col-sm-3 ">Developer Name: &nbsp;</label>
						  <div class="col-sm-3">
						
						   <input type="text" class="form-control" id="dvName" name="dvName"readonly>
							<%--   <select id="developerName" name="developerName" onchange="" class="form-control" required>
							        <option value="0">------select------</option>
							        <c:forEach items="${userList}" var="userList">
							        <option value="${userList.userName}">${userList.firstName}</option>
							        
							        </c:forEach>
									
								
									</select> --%>
									
									
								</div>

								<label class="control-label col-sm-3 ">Remark: &nbsp;</label>
								<div class="col-sm-3">
									<input type="text" class="form-control" id="tlremarks"
										name="tlremarks" required>
								</div>

							</div>
						</div>


						<br>
						<div class="form-group">


							<button type="button" class="btn btn-success"
								onclick="rePlaneDate(document.getElementById('hticketId').value);" style="border-radius:0px;">Change Plan Date</button>
							&nbsp;
							<button type="button" class="btn btn-danger" data-dismiss="modal" style="border-radius:0px;">Back</button>
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
		
		
		<script>
   
    (function($){
        var minDate= new Date();
        minDate.setDate(minDate.getDate());
        $( "#planStartDate").datepicker({
            dateFormat: "dd-mm-yy",
            minDate : minDate,
            changeMonth: true,
            changeYear: true,
            onSelect: function(selectDate){
                $("#planeCompleteDate").datepicker("option", "minDate", selectDate);
            }
        });
        minDate.setDate(minDate.getDate());
        $( "#planeCompleteDate").datepicker({
            dateFormat: "dd-mm-yy",
            minDate: minDate,
            changeMonth: true,
            changeYear: true,
            onSelect: function(selectDate){
                $("#planStartDate").datepicker("option", "maxDate", selectDate);
            }
        });
    })(jQuery);
  </script>
		
	<script type="text/javascript">
	
	function displayAssinedList()
	 {
		 
		 
		 document.getElementById('dvforHidden').style.display = 'block';
		/*  $("tbody").empty(); */
		 $.ajax({
				
				type : "GET",
				contentType : "application/json",
				url :"getAssignDev", 
				
				async: false,
				success : function(result) 
				{
				
				var ticketList=JSON.stringify(result);
				 
				
			  //   alert(ticketList);
				 $.each( result, function( key, value ) 
				{
					 $("#asignlist option[value="+key+"]").remove();
					
					  /* $.each(result, function(key, value) { */
						  //$("#selectBox option[value=]").remove();
						     $('#asignlist')
						         .append($("<option></option>")
						         .attr("value",key)
						         .text("TicketId:::"+value.ticketId+"::DeveloperName:::"+value.developerName+":::plan Complition Date:::"+value.planCompleteDate));
						/* }); */
					  
					});
				},
				error : function(e) 
				{
					console.log(result);
					alert("error");
				} 
			});
	 }
	
	function openRplanDate(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,startPlan,completePlan,dvName,raiedDateHidden,devUserId)
	  {    
		    
		     document.getElementById("hticketId").value = ticketId; 
		     document.getElementById("hticketDate").value = ticketDate; 
		     document.getElementById("hname").value = senderName; 
		     document.getElementById("hmobile").value = senderMobile; 
		     document.getElementById("hinstance").value = instance; 
		     document.getElementById("hpriority").value = priority; 
		     document.getElementById("hissues").value = issues; 
		     
		     document.getElementById("planStartDate").value = startPlan; 
		     document.getElementById("planeCompleteDate").value = completePlan; 
		     document.getElementById("dvName").value = dvName; 
		     
		     document.getElementById("ticketRaisedDateHidden").value=raiedDateHidden;
		     document.getElementById("devUserId").value=devUserId;
		     
	  }
	  
	  
	 function rePlaneDate(ticketId)
	  {    
		    var tlRemark= document.getElementById("tlremarks").value;
		    var developerName=document.getElementById("dvName").value;
		  //  alert("tiketId is::"+ticketId+"::AND:: TL REmarks::::::"+tlRemark+": developer name:"+developerName);
		     var planStartDate=document.getElementById("planStartDate").value;
		     var planCompleteDate=document.getElementById("planeCompleteDate").value;
		     
		     var ticketRaisedDate=document.getElementById("ticketRaisedDateHidden").value;
		     
		      if(planStartDate=="")
			    {
			    	
			    	alert(" Please select plan start date")
			    }
		      
		     /*  else if(planStartDate<ticketRaisedDate)
		      {
		    	 alert("Plan Date cannot be less than Ticket Raised Date!");
		    	 $("#planStartDate").val("");
		      } */
		      
			    else if(planCompleteDate=="")
			    {
			    	
			    	alert(" Please select plan complete date")
			    } 
		      
			   /*  else if(planCompleteDate<planStartDate)
			    {
			    	
			    	alert(" Plan  Complete Date Cannot be Less than Plan Start Date!")
			    	 $("#planeCompleteDate").val("");
			    }  */
		      
			    else if(developerName==0)
			    {
			    	
			    	alert(" Please Select Developer")
			    }
			    
			    else if(tlRemark=="")
			    {
			    	
			    	alert(" Please Enter remarks")
			    }
			    
			   
			    
			    else{
			    	
			    	  window.location.href = "replanDate?ticketId="+ticketId+"&tlRemark="+tlRemark+"&planStartDate="+planStartDate+"&planCompleteDate="+planCompleteDate;
			    }
		
			
		    
	  } 
		
		$('#assignedTicketList').DataTable({
			
			 aaSorting:[[0,'desc']]
		});
	</script>

</body>
</html>
