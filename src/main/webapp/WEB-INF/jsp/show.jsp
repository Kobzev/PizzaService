<%@ page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
						<sec:authorize access="hasRole('ROLE_ADMIN')">
						<td><a href="/PizzaService/jsp/pizza/edit?id=<c:out value="${pizza.id}"/>"><c:out
									value="edit" /></td>
						</sec:authorize>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<button type="submit">
			<c:out value="create new pizza" />
		</button>
	</form>
	<c:url var="logoutUrl" value="/logout"/>
		<form method="post" action="${logoutUrl}">
			<input type="submit" value="log out" />
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	<form>
		<h1>user</h1>
		<c:out value="${user}" />
		<h1>roles</h1>
		<c:out value="${user_roles}" />
	</form>
</body>
</html>