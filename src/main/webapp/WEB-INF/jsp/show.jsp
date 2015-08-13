<%@ page import="java.util.Locale" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
<form action="/PizzaService/jsp/pizza/create" method="get">
	<table border=1>
		<thead>
			<tr>
				<th><c:out value="Pizzas" /></th>
			</tr>
			<tr>
				<td><c:out value="id" /></td>
				<td><c:out value="name" /></td>
				<td><c:out value="price" /></td>
				<td><c:out value="type" /></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pizzas}" var="pizza">
				<tr>
					<td><c:out value="${pizza.id}" /></td>
					<td><c:out value="${pizza.name}" /></td>
					<td><c:out value="${pizza.price}" /></td>
					<td><c:out value="${pizza.type}" /></td>
					<td><a href="/PizzaService/jsp/pizza/edit?id=<c:out value="${pizza.id}"/>"><c:out value="edit"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<button type="submit"><c:out value="create new pizza"/></button>
</form>
</body>
</html>