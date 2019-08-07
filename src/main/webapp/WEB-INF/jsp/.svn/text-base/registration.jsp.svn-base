<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="en">
<head>
  <title>Create New User</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
 
<body>

     <%
     
     String loginUserRole=(String)request.getSession().getAttribute("currentUserRole");
    
      System.out.println(request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
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
      
         <a href="allUser">All User</a> || <a href="resetPwd">Reset Password</a> || <a href="getUserInstance">Create User Instance</a> || <a href="getDelete">Delete Ticket</a>
        <form name="userForm" method="post" action="addUser" onsubmit=" return validate();" >
  
     <div class="panel panel-default">
      <div class="panel-heading" style="background-color: #d6d4ff;"><h1 class="panel-title" >User Registration Form</h1>
  		         
      </div>
     
      <div class="panel-body">
      <div class="row">
        <div class="form-group">
        	<div class="col-sm-1"></div>
        	<!-- <input name="useIdPk" value="" type="hidden"> -->
        	<label class="control-label col-sm-2">User Id&nbsp;<font size="3" color="red">*</font></label>
        	
        	<div class="col-sm-3">
        		
		        <input class="form-control" name="userId" id="userId" placeholder="Enter Name"  type="text">
		       
        	</div>
        	<label for="txtDob" class="control-label col-sm-2">Email:&nbsp;<font size="3" color="red">*</font></label>
        	<div class="col-sm-3">
        		 <input class="form-control" name="email" id="email" placeholder="Enter User ID"  type="text" >
        	</div>
        	<div class="col-sm-1"></div>
        </div>
  		</div>
  		<br>
  		 <div class="row">
         	<div class="form-group">
         		<div class="col-sm-1"></div>
         		<label for="txtUserName" class="control-label col-sm-2">First Name :&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			<input class="form-control" name="firstName" id="firstName" placeholder="Enter User Name" maxlength="30"type="text" >
         			<div id="txtDakSNameError"></div>
         		</div>
         		<label for="status" class="control-label col-sm-2">Last Name:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			<input class="form-control" name="lastName" id="lastName" placeholder="Enter User Name" maxlength="30"type="text" >
         		</div>
         		<div class="col-sm-1"></div>
         	</div>
  		<br>
  		<br>
         <div class="row">
         	<div class="form-group">
         		<div class="col-sm-1"></div>
         		<label for="txtUserName" class="control-label col-sm-2">Mobile No:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			<input class="form-control" name="mobile" id="mobile" placeholder="Enter User Name" maxlength="30"type="text" value="${loginUserDetails.mobile}">
         			<div id="txtDakSNameError"></div>
         		</div>
         		<label for="status" class="control-label col-sm-2">Role:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			<select id="roleId" name="roleId" onchange="" class="form-control" required>
										<option value="0">---Select---</option>
										<option value="1">DEVELOPER</option>
										<option value="2">USER</option>
					</select>
         		</div>
         		<div class="col-sm-1"></div>
         	</div>
        </div>
         <br>
         <div class="row">
         	<div class="form-group">
         		
         	    <div class="col-sm-1"></div>
         		<label for="status" class="control-label col-sm-2">User Instance:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-3">
         			 <select id="instanceName" name="instanceName" class="form-control">
							        <option value="0">------select------</option>
							        <c:forEach items="${instanceList}" var="inList">
							        <option value="${inList.instanceName}">${inList.instanceName}</option>
							        
							        </c:forEach>
									
								
							</select>
         		</div>
         		<div class="col-sm-6"></div>
         	</div>
        </div>
        
        <br>
     
        <div class="row">
       	<div class="form-group">
       		<div class="col-sm-1"></div>
       		
       		<div class="col-sm-1"></div>
       	</div>
       </div>
       
       
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
    
        </div>
      <!--   dsfsdfd	 -->
        </form>
  </div>
</div>
   
   <br>
   <br>
   <br>
   <br>
  <script type="text/javascript">

	function validate() {
		
		
	var userId=document.getElementById("userId").value;
    var email=document.getElementById("email").value;
  	var mobile =document.getElementById("mobile").value; 
	var roleId =document.getElementById("roleId").value; 
	
	var userInstance =document.getElementById("instanceName").value; 
  	
	
	 if(userId==0)
	 {
  		alert("Please enter user id")
  		return false;
  	}
       
	if(email==0){
  		alert("Please enter email")
  		
  		return false;
  	}
	
	else if(mobile==0){
  		alert("Please enter mobile")
  		return false;
  	}  
	
	else if(roleId==""){
  		alert("Please select role User Role")
  		
  		return false;
  	}
	
	else if(userInstance==0)
	{
		alert("Please select User Instance!");
	}

  	else{
  		alert("Do you want to submit ");
  		return true;
  	}
  	
  	
  	
  	
  	
	}
  </script>
  <script> $( "#mess" ).fadeOut( 4000 );</script>
 

</body>

</html>
