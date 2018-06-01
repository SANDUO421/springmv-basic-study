<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Servlet Async Demo</title>
</head>
<body>
	<script src="static/jquery-3.3.1.js" type="text/javascript"></script>
	<script type="text/javascript" charset="UTF-8">
		deferred();
		function deferred() {
			$.get('defer',function(data){
				console.log(data);
				deferred();
			});
		}
	</script>
</body>
</html>