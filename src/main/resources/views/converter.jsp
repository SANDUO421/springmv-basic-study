<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Convert Demo</title>
</head>
<body>
	<div id="resp"></div>
	<input type="button" onclick="req()" value="请求"/>
	
	<script src="static/jquery-3.3.1.js" type="text/javascript"></script>
	<script>
		function req() {
			$.ajax({
				url: "convert",
				data: "1-sanduo123",
				type:"POST",
				contentType:"application/x-sanduo",
				success: function(data) {
					$("#resp").html(data);
				}
				
			});
		}
	</script>
	<%-- <%out.clear(); out=pageContext.pushBody(); %> --%>
</body>
</html>