<!DOCTYPE html>
<html lang="en">
<%@include file="head.jsp"%>
<body>
	<div class="wrapper">
		<%@include file="sidebar.jsp"%>
		<div class="main-panel">
			<%@include file="mainheader.jsp"%>
			<jsp:include page="assinedTicket.jsp"></jsp:include>
			<br><br><br><br><br><br><br><br><br><br><br>
			<%@include file="mainfooter.jsp"%>
		</div>
	</div>
</body>
<%@include file="footer.jsp"%>
</html>