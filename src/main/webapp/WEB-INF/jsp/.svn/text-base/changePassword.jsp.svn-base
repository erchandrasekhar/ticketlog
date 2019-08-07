<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
  <title>ChangePwd</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid">
 
  <div class="row">
   
    <c:choose>
			    <c:when test="${empty successMsg}">
			    </c:when>
			    <c:otherwise>
			       <div class="alert alert-success" id="mess" name="mess" style="background-color: green;color: white;"> <strong ></strong>${successMsg}</div>
			    </c:otherwise>
			</c:choose>
      <div class="col-sm-3"></div>
        <div class="col-sm-6">
         <h2>Change Password</h2>
         <form action="changePassword" onsubmit=" return validate();" method="post">
   <!--  <div class="form-group">
      <label for="email">Old Password:</label>
      <input type="password" class="form-control" id="oldPwd" placeholder="Enter old Password" name="oldPwd">
    </div> -->
    <input type="hidden" value="${user.id }" id="idPk" name="idPk">
    <div class="form-group">
      <label for="pwd">New Password:</label>
      <input type="password" class="form-control" id="newPwd" placeholder="Enter password" name="newPwd">
    </div>
    
     <div class="form-group">
      <label for="pwd">Retype Password:</label>
      <input type="password" class="form-control" id="retypePwd" placeholder="Retype password" name="retypePwd">
    </div>
   
    <button type="submit" class="btn btn-primary" style="border-radius: 0px;">Submit</button>
      <button type="reset" class="btn btn-danger" style="border-radius: 0px;">Clear</button>
  </form>
        
        </div>
          <div class="col-sm-3"></div>
  </div>
  
  
  
</div>
<script>
function validate() {
		
		
	var newPwd=document.getElementById("newPwd").value;
    var retypePwd=document.getElementById("retypePwd").value;
    
  if(newPwd=="")
	 {
  		alert("Please enter New Password")
  		return false;
  	}
       
	if(retypePwd==""){
  		alert("Please Retype Password")
  		
  		return false;
  	}
	
	else if(newPwd!=retypePwd){
  		alert("Retyped password and new password not matched")
  	    document.getElementById("retypePwd").value = "";
  		return false;
  	}  
	
  	else{
  		alert("Do you want to submit ");
  		return true;
  	}
  	
}
	</script>
 <script> $( "#mess" ).fadeOut( 6000 );</script>
</body>
</html>
