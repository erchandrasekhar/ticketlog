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
 <br><br>
  <div class="row">
   
            <c:choose>
			    <c:when test="${empty successMsg}">
			    </c:when>
			    <c:otherwise>
			       <div class="alert alert-success" id="mess" name="mess" style="background-color: green;color: white;"> <strong ></strong>${successMsg}</div>
			    </c:otherwise>
			</c:choose>
               <form action="resetPassword" onsubmit=" return validate();"method="post">
               
             <label for="status" class="control-label col-sm-2">Select User:&nbsp;<font size="3" color="red">*</font></label>
         		<div class="col-sm-4">
         			<select id="userIdPk" name="userIdPk" class="form-control" required>
										<option value="0">---Select User---</option>
										 <c:forEach items="${userMasterList}" var="userList">
							            <option value="${userList.id}">${userList.firstName}</option>
							             </c:forEach>
					</select>
					 
         		</div>
                     
                     <div class="col-sm-4">
					<button type="submit" class="btn btn-primary">Submit</button>
					</div>
               </form>
           
		</div>
        </div>
        
        <br><br>
          <br><br>
            <br><br>
         
<script>
function validate() {
		
		
	var userIdPk=document.getElementById("userIdPk").value;
  
    
  if(userIdPk==0)
	 {
  		alert("Select User")
  		return false;
  	}
   
  	else{
  		  
  		return true;
  	}
  	
}
	</script>
 <script> $( "#mess" ).fadeOut( 6000 );</script>

</body>
</html>
