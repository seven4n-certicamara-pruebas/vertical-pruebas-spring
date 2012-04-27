<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Messages</title>
</head>
<body>
<a href="message/add.html">Adicionar Mensaje</a>
<table border="1">
	<c:forEach items="${messages.elements}" var="message">
		<tr>
			<td>Message ID: <c:out value="${message.id}"></c:out></td>
			<td><a href="message/${message.id}.html">See details</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>