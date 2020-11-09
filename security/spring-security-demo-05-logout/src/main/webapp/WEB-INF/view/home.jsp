<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Home Page</title>
</head>

<body>
	<h2>Home Page</h2>
	<hr>
	<p>
	Welcome to the home page
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			method="POST">
			
		<input type="submit" value="Logout" />
		
	</form:form>
</body>
</html>