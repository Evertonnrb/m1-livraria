<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
	
	<jsp:useBean id="dao" class="br.com.livraria.service.ClienteService"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Relátorio de clientes cadastrados</h1>
	<c:forEach var="c" items="${dao.listar()}">

		${c.nome}

	</c:forEach>
</body>
</html>