<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
	<head></head>
	
	<body>
		<h1>Inicio</h1>
		<div>
			<sec:authorize access = 'hasAuthority("USER")'>
				<div><a href = "usuarios">Para usuarios</a></div>	
			</sec:authorize>
			<sec:authorize access = 'hasAuthority("ADMIN")'>
				<div><a href = "administradores">Para administradores</a></div>	
			</sec:authorize>
		</div>	
		
	</body>
</html>