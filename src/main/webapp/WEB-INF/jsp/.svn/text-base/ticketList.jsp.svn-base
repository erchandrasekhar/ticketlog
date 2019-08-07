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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

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

.wrapper {
	overflow-x: hidden;
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
		<!--Ticket List   -->
		<div class="panel panel-primary">

			<c:choose>
				<c:when test="${empty successMsgforSubTicket}">
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" id="mess" name="mess"
						style="background-color: green; color: white;">
						<strong></strong>${successMsgforSubTicket}</div>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${empty successMsg}">
				</c:when>
				<c:otherwise>
					<div class="alert alert-success" id="mess" name="mess"
						style="background-color: green; color: white;">
						<strong></strong>${successMsg}</div>
				</c:otherwise>
			</c:choose>

			<div class="panel-heading">
				<h1 class="panel-title">ALL TICKET LIST</h1>
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
								<th>Action:</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach items="${tiketList}" var="tl">
								<tr style="font-size: 12px; font-weight: bolder;">

									<c:choose>
										<c:when test="${tl.subticketId==null}">
											<td>${tl.ticketId }</td>
										</c:when>


										<c:otherwise>
											<td>${tl.ticketId}&nbsp;<strong style="color: red;">S</strong><strong>&nbsp;(${tl.subticketId })</strong></td>
										</c:otherwise>
									</c:choose>

									<%-- 	<td>${tl.ticketId }</td> --%>
									<td>${tl.senderName }(${tl.sorce })</td>
									<td>${tl.mobileMobile }</td>
									<td>${tl.sorce }</td>
									<td>${tl.ticketText }</td>
									<td>${tl.ticketRaisedDate }</td>

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
											<td><button class="btn btn-danger btn-sm"
													onclick="viewDeveloper('${tl.developerName}');"
													data-toggle="modal" data-target="#TiketCloseModal"
													style="border-radius: 0px;">Reopened</button></td>
										</c:when>


										<c:otherwise>
											<td>
												<button class="btn btn-primary btn-sm"
													onclick="openAsign(${tl.ticketId},'${tl.ticketRaisedDate}','${tl.senderName }','${tl.mobileMobile }','${tl.sorce }','${tl.pririty}','${tl.ticketText }','${tl.ticketRaisedDate }');"
													data-toggle="modal" data-target="#TiketAssineModal"
													style="border-radius: 0px;">assign</button> &nbsp; <c:choose>

													<c:when test="${tl.subticketId==null}">
														<a
															href="genrateSubTicket?ticketId=${tl.ticketId}+&ticketRaisedDate=${tl.ticketRaisedDate}+&sName=${tl.senderName}+&mobile=${tl.mobileMobile }+&instance=${tl.sorce}+&pririty=${tl.pririty}+&issues=${tl.ticketText }+&tType=${tl.ticketType}+&sEmail=${tl.senderEmail}+&ticketRaisedDateTime=${tl.ticketRiseDateAndTime}" data-toggle="tooltip" data-placement="top" title="Create SubTicket"><span
															class="glyphicon glyphicon-plus"></span></a>
													</c:when>
													<c:otherwise>
														<%--   //   <a href="genrateSubTicket?ticketId=${tl.ticketId}+&ticketRaisedDate=${tl.ticketRaisedDate}+&sName=${tl.senderName}+&mobile=${tl.mobileMobile }+&instance=${tl.sorce}+&pririty=${tl.pririty}+&issues=${tl.ticketText }+&tType=${tl.ticketType}+&sEmail=${tl.senderEmail}+&ticketRaisedDateTime=${tl.ticketRiseDateAndTime}"><span class="glyphicon glyphicon-plus"></span></a>
											 --%>
														<a href="deleteSubTicket?ticketId=${tl.ticketId}+&parentTicketId=${tl.subticketId}"><span
															class="glyphicon glyphicon-minus"
															style="color: red; font-size: 60;" data-toggle="tooltip" data-placement="top" title="delete SubTicket"></span></a>

													</c:otherwise>
												</c:choose>




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

		<br>

		<!-- ###################################################ticket assign model start ####################################### -->

		<div id="TiketAssineModal" class="modal fade" role="dialog">
			<div class="modal-dialog modal-lg">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header" style="background-color: #5cb85c;">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title" style="color: black;">Assign Ticket
							To Developer:</h4>
						<!-- <input type="text" id="asignlist" name="asignlist"> -->
						<div id="dvforHidden" name="dvforHidden" hidden>
							<select id="asignlist" name="asignlist" class="form-control"
								style="">
								<option value="">------select------</option>



							</select>
						</div>
						<!-- <h5>
						<a type="button" class="btn btn-success" target="_blank"
							onclick="displayAssinedList()" style="height: 36px;">
							<i class="fa fa-bars"></i> Display Assigned Developer
						</a>
					</h5> -->
					</div>
					<div class="modal-body">
						<form action="">


							<div class="form-group">
								<div class="row">
									<label class="control-label col-sm-3 ">Ticket No.
										&nbsp;</label>
									<div class="col-sm-3">
										<input type="text" name="hticketId" id="hticketId" value=""
											class="form-control mandatory" readonly>


									</div>

									<label for="applicantName" class="control-label col-sm-3 ">Ticket
										Raise Date&nbsp;</label>
									<div class="col-sm-3">
										<input type="text" name="hticketDate" id="hticketDate"
											class="form-control mandatory" readonly> <input
											type="hidden" name="ticketRaisedDateHidden"
											id="ticketRaisedDateHidden" class="form-control mandatory"
											readonly>
									</div>

								</div>
							</div>

							<div class="form-group">
								<div class="row">
									<label for="applicantName" class="control-label col-sm-3 ">Name
										&nbsp;</label>
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
											name="hissues" style="resize: vertical;" readonly></textarea>
									</div>

								</div>
							</div>

							<div class="form-group">
								<div class="row">
									<label for="applicantName" class="control-label col-sm-3 ">Plan
										Start Date&nbsp;</label>
									<div class="col-sm-3">
										<input type="text" name="planStartDate" id="planStartDate"
											class="form-control mandatory" placeholder="DD-MM-YYYY">
									</div>
									<label for="appDated" class="control-label col-sm-3 ">Plan
										Complete Date&nbsp;</label>
									<div class="col-sm-3">
										<input type="text" name="planeCompleteDate"
											id="planeCompleteDate" class="form-control mandatory"
											placeholder="DD-MM-YYYY">
									</div>
								</div>
							</div>
							<br>
							<div class="form-group">
								<div class="row">
									<label class="control-label col-sm-3 ">Select
										Developer:&nbsp;<a
										onclick="openNewVindos(document.getElementById('developerName').value)"
										id="aId" name="aId" target="_blank"><span
											class="glyphicon glyphicon-eye-open"></span></a>
									</label>
									<div class="col-sm-3">

										<select id="developerName" name="developerName"
											onchange="getDeveloperUserName(document.getElementById('developerName').value)"
											class="form-control" required>
											<option value="0">------select------</option>
											<c:forEach items="${userList}" var="userList">
												<option value="${userList.userName}">${userList.firstName}</option>

											</c:forEach>


										</select>



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
									onclick="assignToDeveloper(document.getElementById('hticketId').value);"
									style="border-radius: 0px;">Assign</button>
								&nbsp;
								<button type="button" class="btn btn-danger"
									data-dismiss="modal" style="border-radius: 0px;">Back</button>
							</div>




						</form>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-dismiss="modal"
							style="border-radius: 0px;">Close</button>
					</div>
				</div>

			</div>
		</div>

	</div>
	<!-- ######################################## ticket assign model end ####################################################3 -->





	<!-- #################################################view previous ticket details######################################## -->

	<div id="DeveloperWork" class="modal fade" role="dialog">
		<div class="modal-dialog modal-lg">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header" style="background-color: #5cb85c;">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Developer Assignment Details</h4>
					<input type="hidden" value="" name="ddId" id="ddId">
				</div>
				<div class="modal-body">
					<div class="container-fluid">
						<br>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<h1 class="panel-title">Previous Assignment Details</h1>
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
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
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
    var minDate= new Date();
    minDate.setDate(minDate.getDate());
    $( "#planeCompleteDate").datepicker({
        dateFormat: "dd-mm-yy",
        minDate : minDate,
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectDate){
            $("#planStartDate").datepicker("option", "maxDate", selectDate);
        }
    });
    
    
    var minDate= new Date();
    minDate.setDate(minDate.getDate());
    $( "#splanStartDate").datepicker({
        dateFormat: "dd-mm-yy",
        minDate : minDate,
        changeMonth: true,
        changeYear: true, 
        onSelect: function(selectDate){
            $("#splaneCompleteDate").datepicker("option", "minDate", selectDate);
        }
    });
    var minDate= new Date();
    minDate.setDate(minDate.getDate());
    $( "#splaneCompleteDate").datepicker({
        dateFormat: "dd-mm-yy",
        minDate : minDate,
        changeMonth: true,
        changeYear: true,
        onSelect: function(selectDate){
            $("#splanStartDate").datepicker("option", "maxDate", selectDate);
        }
    });
    
    
    
    
    
})(jQuery);
</script>
	<script type="text/javascript">
	
	
  function openAsign(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,raiedDateHidden)
  {      
	   
	     document.getElementById("hticketId").value = ticketId; 
	     document.getElementById("hticketDate").value = ticketDate; 
	     document.getElementById("ticketRaisedDateHidden").value=raiedDateHidden;
	     document.getElementById("hname").value = senderName; 
	     document.getElementById("hmobile").value = senderMobile; 
	     document.getElementById("hinstance").value = instance; 
	     document.getElementById("hpriority").value = priority; 
	     document.getElementById("hissues").value = issues; 
  }
  
  function openAsignSubTicket(ticketId,ticketDate,senderName,senderMobile,instance,priority,issues,raiedDateHidden,subTicketId)
  {      
	  
	   
	     document.getElementById("hsticketId").value = ticketId; 
	     document.getElementById("hsticketDate").value = ticketDate; 
	     document.getElementById("sticketRaisedDateHidden").value=raiedDateHidden;
	     document.getElementById("hsname").value = senderName; 
	     document.getElementById("hsmobile").value = senderMobile; 
	     document.getElementById("hsinstance").value = instance; 
	     document.getElementById("hspriority").value = priority; 
	     document.getElementById("hsissues").value = issues; 
	     document.getElementById("hsubTicketId").value = subTicketId; 
	     
  }
  
  
  function getDeveloperUserName(developerUserName){
	//  alert(developerUserName);
	  
	  
  }
  
  function openNewVindos(devloperUserId)
  {
	  
	  
	  if(devloperUserId==0){
		  alert("Plser Select developer First")
	  }
	  
	  else
	  {
		  $("#tableBody").empty();

			var url = "getPrivousAssignmentDeveloperList";
	        $.getJSON(
	   			url,
	   			{							
	   				'devloperUserId' : devloperUserId
	   				
	   			},
	   			function(data) {
	   		      	
	   		 	var ticketList=JSON.stringify(data);
	   		 	 
	   		     $.each(JSON.parse(ticketList), function(key, value) {
	   		    	 
	   		    	content = "<tr><td>" + value.ticketId + "</td><td>" 
						 + value.senderName + "</td><td>"
						 + value.ticketText + "</td><td>"
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
	     	});
			
		  
		 document.getElementById("ddId").value = devloperUserId; 
		 $("#DeveloperWork").modal();
		   
		  //window.open('getPrivousAssignment?devloperUserId='+devloperUserId, '_blank');
		  //window.location.href = "getPrivousAssignment?devloperUserId="+devloperUserId;
	  
	  }
  }
  
  
 function assignToDeveloper(ticketId)
  {    
	    var tlRemark= document.getElementById("tlremarks").value;
	    var developerName=document.getElementById("developerName").value;
	  //  alert("tiketId is::"+ticketId+"::AND:: TL REmarks::::::"+tlRemark+": developer name:"+developerName);
	     var planStartDate=document.getElementById("planStartDate").value;
	     var planCompleteDate=document.getElementById("planeCompleteDate").value;
	     var ticketRaisedDate=document.getElementById("ticketRaisedDateHidden").value;
	     var subTicketId="";
	    if(planStartDate=="")
		    {
		    	
		    	alert(" Please select plan start date")
		    }
	      /* else if(planStartDate<ticketRaisedDate)
	      {
	    	 alert("Plan Date cannot be less than Ticket Raised Date!");
	    	 $("#planStartDate").val("");
	      }
	       */
		    else if(planCompleteDate=="")
		    {
		    	
		    	alert(" Please select plan complete date!")
		    } 
	      
		   /*  else if(planCompleteDate<planStartDate)
		    {
		    	
		    	alert(" Plan  Complete Date Cannot be Less than Plan Start Date!")
		    	 $("#planeCompleteDate").val("");
		    }  */
		    else if(developerName==0)
		    {
		    	
		    	alert(" Please Select Developer!")
		    }
		    
		    else if(tlRemark=="")
		    {
		    	
		    	alert(" Please Enter remarks!")
		    }
		    
		   
		    
		    else{
		    	
		    	  window.location.href = "assign?ticketId="+ticketId+"&tlRemark="+tlRemark+"&developerName="+developerName+"&planStartDate="+planStartDate+"&planCompleteDate="+planCompleteDate+"&subTicketId="+subTicketId;
		    	
		    }
	
  } 
 
 
 

 
 
  
 function viewDeveloper(developerName)
 {
	 alert("Pending With::"+developerName);
 }
 
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
				
				
					     $('#asignlist')
					         .append($("<option></option>")
					         .attr("value",key)
					         .text("TicketId:::"+value.ticketId+"::DeveloperName:::"+value.developerName+":::plan Complition Date:::"+value.planCompleteDate));
					
				  
				});
			},
			error : function(e) 
			{
				console.log(result);
				alert("error");
			} 
		});
 }
  
 $('#ticketList').DataTable({
	 aaSorting:[[0,'desc']]
 });

  </script>
	<script> $( "#mess" ).fadeOut( 3000 );</script>
<script>
$(document).ready(function(){
  $('[data-toggle="tooltip"]').tooltip();   
});
</script>
</body>
</html>
