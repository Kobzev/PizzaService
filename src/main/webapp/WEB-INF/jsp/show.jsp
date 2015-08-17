<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pizzas List</title>
    </head>
    <body>
        <table border="1">
            <thead><tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Price</th>
                </tr></thead>

            <c:forEach var="pizza" items="${pizzas}">
                <tr>
                    <td>${pizza.id}</td> 
                    <td>${pizza.name}</td> 
                    <td>${pizza.type}</td>
                    <td>${pizza.price}</td>
                    <td>
                        <form method="get" action="edit" >
                            <input type="hidden" name="id" value="${pizza.id}" />
                            <input type="submit" value="Edit" />
                        </form>        
                    </td>

                </tr>            
            </c:forEach>
        </table>
        <sec:authorize access="hasRole('ADMIN')">
            <a href="create"> Create new pizza </a> <br/>
        </sec:authorize>

        <c:url var="logoutUrl" value="/logout"/>
        <form action="${logoutUrl}" method="post">
            <input type="submit" value="Log out" />
            <input type="hidden" 
                   name="${_csrf.parameterName}" 
                   value="${_csrf.token}"/>
        </form>
        
        <form>
			<h1>user</h1>
			<c:out value="${user}" />
			<h1>roles</h1>
			<c:out value="${user_roles}" />
		</form>
    </body>
</html>