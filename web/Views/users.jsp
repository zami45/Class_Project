<%-- 
    Document   : users
    Created on : Oct 16, 2017, 2:56:19 AM
    Author     : shimantta
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
    </head>
    <body>
        

<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
    </tr>
    <c:forEach items="${userList}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
         
        </tr>
    </c:forEach>
</table>

    </body>
</html>
