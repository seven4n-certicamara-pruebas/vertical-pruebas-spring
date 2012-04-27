<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Message details</title>
</head>
<body>
<a href="../message.html">Ver todos los mensajes</a>
<table border="1">
    <tr>
        <td>Property</td>
        <td>Value</td>
    </tr>
    <tr>
        <td>ID</td>
        <td><c:out value="${message.id}" /></td>
    </tr>
    <tr>
        <td>To</td>
        <td><c:out value="${message.to}" /></td>
    </tr>
    <tr>
        <td>Body</td>
        <td><c:out value="${message.body}" /></td>
    </tr>
</table>
</body>
</html>