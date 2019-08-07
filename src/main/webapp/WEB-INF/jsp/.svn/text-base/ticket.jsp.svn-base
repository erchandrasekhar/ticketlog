<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>New Ticket</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
 
<body>

     <%
     
     String loginUserRole=(String)request.getSession().getAttribute("currentUserRole");
     String userInstance=(String)request.getSession().getAttribute("currentUserInstance");
     System.out.println("current instance:"+userInstance);
   
    //  System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
     %>
      <br>
      <br>
<div class="container-fluid">
   
   
   <div class="container-fluid">
         <%--   <strong>Login User Role:<%=loginUserRole%></strong> --%>
           <br>
        <c:choose>
			    <c:when test="${empty successMsg}">
			    </c:when>
			    <c:otherwise>
			       <div class="alert alert-success" id="mess" name="mess" style="background-color: green;color: white;"> <strong ></strong>${successMsg}</div>
			    </c:otherwise>
			</c:choose>
      
        <form name="userForm" method="post" action="addTicket" onsubmit=" return validate();" >
  
    <input name="persistId" type="hidden">
     
     
     <div class="panel panel-default">
      <div class="panel-heading" style="background-color: #d6d4ff;"><h1 class="panel-title" >TICKET FORM</h1>
  		         
      </div>
     
      <div class="panel-body">
      <div class="row">
        <div class="form-group">
        	<div class="col-sm-1"></div>
        	<!-- <input name="useIdPk" value="" type="hidden"> -->
        	<label class="control-label col-sm-2">User Name&nbsp;<font size="3" color="red">*</font></label>
        	
        	<div class="col-sm-3">
        		
		        <input class="form-control" name="empName" id="empName" placeholder="Enter Name"  type="text" value="${loginUserDetails.firstName}"readonly>
		       
        	</div>
        	<label for="txtDob" class="control-label col-sm-2">Email:&nbsp;<font size="3" color="red">*</font></label>
        	<div class="col-sm-3">
        		 <input class="form-control" name="email" id="email" placeholder="Enter User ID"  type="text"  value="${loginUserDetails.email}">
        	</div>
        	<div class="col-sm-1"></div>
        </div>
  		</div>
  		<br>
         <div class="row">
         	<div class="form-group">
         		<div class="col-sm-1"></div>
         		<label for="txtUserName" class="control-label col-sm-2">Mobile No:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			<input class="form-control" name="mobile" id="mobile" placeholder="Enter User Name" maxlength="30"type="text" value="${loginUserDetails.mobile}">
         			<div id="txtDakSNameError"></div>
         		</div>
         		<label for="status" class="control-label col-sm-2">Priority:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         		
         		    
         			<select id="priority" name="priority" onchange="" class="form-control" required>
										<option value="0">---Select---</option>
										<option value="C">Critical</option>
										<option value="N">Normal</option>
										<option value="I">Immediate</option>
					</select>
         		</div>
         		<div class="col-sm-1"></div>
         	</div>
        </div>
        <br>
     
         <div class="row">
       	<div class="form-group">
       		<div class="col-sm-1"></div>
       		<label for="txtAddressDesc" class="control-label col-sm-2">Ticket Types:&nbsp;<font size="3" color="red">*</font></label>
       		
       		
       		<div class="col-sm-3">
       			<!-- <input class="form-control" name="instance" id="instance" placeholder="Enter instance name" maxlength="25" value="" type="text"> -->
       			 <select id="ticketType" name="ticketType" class="form-control" required>
										<option value="0">---Select---</option>
										<option value="CR">CR</option>
										<option value="BUG">BUG</option>
										<option value="NEW DEVELOPMENT">NEW DEVELOPMENT</option>
					</select>
       		</div>
       		<label for="txtCity" class="control-label col-sm-2">From instance:&nbsp;<font size="3" color="red">*</font></label>
       		
       	<!-- 	instance for ALPO user -->
       		 <% if(userInstance.equals("ALPO")) 
     {%>
     
       <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" readonly>
       			 
       			  			         
										<option value="ALPO">ALPO</option>
									
					</select>
       		</div> 
   
        <%} 
        %>
        
         	<!-- 	instance for ADMIN user -->
         <% if(userInstance.equals("ADMIN")) 
     {%>
     
      <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" required>
       			  <option value="0">------select------</option>
							        <c:forEach items="${instanceList}" var="inList">
							        <option value="${inList.instanceName}">${inList.instanceName}</option>
							        
							        </c:forEach>
					</select>
       		</div> 
   
        <%} 
        %>
        
        	<!-- 	instance for ADMIN user -->
         <% if(userInstance.equals("DEVELOPER")) 
     {%>
     
      <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" required>
       			 
       			  			          <option value="0">------select------</option>
							        <c:forEach items="${instanceList}" var="inList">
							        <option value="${inList.instanceName}">${inList.instanceName}</option>
							       </c:forEach>
					</select>
       		</div> 
   
        <%} 
        %>
        
        	<!-- 	instance for ADMIN user -->
         <% if(userInstance.equals("FLPO")) 
     {%>
     
      <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" readonly>
       			 
       			  			           
										<option value="FLPO">FLPO</option>
					</select>
       		</div> 
   
        <%} 
        %>
        
        	<!-- 	instance for ADMIN user -->
         <% if(userInstance.equals("DHE")) 
     {%>
     
      <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" readonly>
       			 
       			  			           
										<option value="DHE">DHE</option>
					</select>
       		</div> 
   
        <%} 
        %>
       		
       		<!-- <div class="col-sm-3">
       			

       			      <select id="instance" name="instance" class="form-control" required>
       			 
       			  			            <option value="0">---Select---</option>
										<option value="DHE">DHE</option>
										<option value="ALPO">ALPO</option>
										<option value="ALPO">FLPO</option>
					</select>
       		</div> -->
       		<div class="col-sm-1"></div>
       	</div>
       </div>
       <br>
        <div class="row">
       	<div class="form-group">
       		<div class="col-sm-1"></div>
       		
       		<div class="col-sm-1"></div>
       	</div>
       </div>
       
       
          <div class="row">
       	<div class="form-group">
       		<div class="col-sm-1"></div>
       		<label for="" class="control-label col-sm-2">Subject/Issues:&nbsp;<font size="3" color="red">*</font></label>
       		<div class="col-sm-8">
       			<textarea name="subject" class="form-control" maxlength="255" id="subject" style="resize: vertical;"></textarea>
       			
       		</div>
       		
       		<div class="col-sm-1"></div>
       	</div>
       	</div>
          <br><br>
          <br><br>
              <div class="row" style="text-align: center;">
                  
        	    <button type="submit" class="btn btn-success" id="btnSave" style="border-radius:0px;">Save
        		<span class="fa fa-check-circle"></span>
        		</button>
        		<button type="reset" class="btn btn-danger" style="border-radius:0px;">Reset
        		<span class="fa fa-refresh"></span>
        		</button>
        
        
              </div>
        </div>
        </div>
    
        
        	
        </form>
  </div>
</div>
   
   <br>
   <br>
   <br>
   <br>
  <script type="text/javascript">

	function validate() {
		
		
	var subject=document.getElementById("subject").value;
    var ticketType=document.getElementById("ticketType").value;
  	var priority =document.getElementById("priority").value; 
	var instance =document.getElementById("instance").value; 
  	
	
	 if(priority==0){
  		alert("Please Select Priority")
  		return false;
  	}
       
	if(ticketType==0){
  		alert("Please Select Ticket Type")
  		
  		return false;
  	}
	
	else if(instance==0){
  		alert("Please Select Instance")
  		return false;
  	}  
	
	else if(subject==""){
  		alert("Please Enter Subject")
  		
  		return false;
  	}
	

  	
  	
  	
  
  	
  
  	
  	else{
  		//alert("Do you want to submit ");
  		return true;
  	}
  	
  	
  	
  	
  	
	}
  </script>
<script> $( "#mess" ).fadeOut( 20000 );</script>
 

</body>

</html>
