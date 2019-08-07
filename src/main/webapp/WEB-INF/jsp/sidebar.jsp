
<div class="sidebar" data-color="purple"
	data-image="${pageContext.request.contextPath}/static/img/sidebar-5.jpg">

	<!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->
    
    <%
     
     String loginUserRole=(String)request.getSession().getAttribute("currentUserRole");
    // System.out.println("from sidebar:::::;"+loginUserRole);
     %>
      
     
     
	<div class="sidebar-wrapper">
		<div class="logo">
			<a href="home" class="simple-text">
				Ticket Log </a>
		</div>

		<ul class="nav">
		
			<li class="active"><a href="home"> <i
					class="pe-7s-graph"></i>
					<p>Dashboard</p>
			</a></li>
			
			
			
			<li><a href="raise"> <i class="pe-7s-ticket"></i>
					<p>Raise New Ticket</p>
			</a></li>
			<!-- <li><a href="getAllTicket"> <i class="pe-7s-note2"></i>
					<p>Ticket List</p>
			</a></li>
			<li><a href="getAssignedTicket"> <i class="pe-7s-news-paper"></i>
					<p>Assigned Ticket</p>
			</a></li> -->
			
			
		<!-- admin sidebar -->
		
			   <% if(loginUserRole.equals("ADMIN")) 
     {%>
     
        <li><a href="getAllTicket"> <i class="pe-7s-note2"></i>
					<p>Work List</p>
			</a></li>
			<li><a href="getAssignedTicket"> <i class="pe-7s-id"></i>
					<p>Assigned Ticket</p>
			</a></li>
			
			<!-- <li><a href="getCompletedTicket"> <i class="pe-7s-check"></i>
					<p>Completed Ticket</p>
			</a></li> -->
			
			<li><a href="search"> <i class="pe-7s-note"></i>
					<p>Reports</p>
			</a></li>
			
			 <li><a href="getAllTicketByName"> <i class="pe-7s-bell"></i>
					<p>My Ticket</p>
			</a></li>
       
             <li><a href="gerReg"> <i class="pe-7s-user"></i>
					<p>Create New User</p>
			</a></li>
			
			<li><a href="changePwd"> <i class="pe-7s-news-paper"></i>
					<p>Change Password</p>
			</a></li>
   
        <%} 
        %>
        
        <!-- developer sidebar -->
         <% if(loginUserRole.equals("DEVELOPER")) 
     {%>
    
			<!-- <li><a href="getclose"> <i class="pe-7s-science"></i>
					<p>Close Ticket</p>
			</a></li>
			 -->
				<li><a href="getAllTicketByUserId"> <i class="pe-7s-map-marker"></i>
					<p>Developer WorkList</p>
			</a></li>
			
			<li><a href="getAllcompletedTicketByDeveloper"> <i class="pe-7s-map-marker"></i>
					<p>Completed </p>
			</a></li>
			
			 <li><a href="getAllTicketByName"> <i class="pe-7s-bell"></i>
					<p>My Ticket</p>
			</a></li>
			
			<!-- <li><a href="help"> <i class="pe-7s-map-marker"></i>
					<p>Help</p>
			</a></li> -->
			<li><a href="changePwd"> <i class="pe-7s-news-paper"></i>
					<p>Change Password</p>
			</a></li>
       
       
        <%} 
        %> 
        
        <!-- user sideBar -->
         <% if(loginUserRole.equals("USER")) 
     {%>
     <li><a href="getAllTicketByName"> <i class="pe-7s-bell"></i>
					<p>My Ticket</p>
			</a></li>
       
       <li><a href="changePwd"> <i class="pe-7s-news-paper"></i>
					<p>Change Password</p>
			</a></li>
      <!--  <li><a href="help"> <i class="pe-7s-map-marker"></i>
					<p>Help</p>
			</a></li> -->
			
        <%} 
        %> 
        
	<!-- <li class="active-pro"><a href="logout"> <i
					class="pe-7s-rocket"></i>
					<p>Log out</p>
			</a></li> -->
		</ul>
	</div>
</div>