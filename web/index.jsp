<%-- 
    Document   : index
    Created on : Oct 20, 2017, 1:15:49 AM
    Author     : shimantta
--%>

<%@page import="Helper.DB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%


if(session != null && session.getAttribute("id") == null){
    Cookie[] cookies = request.getCookies();

    if (cookies != null) {
     for (Cookie cookie : cookies) {
       if (cookie.getName().equals("id_hash")) {
           int user_id = DB.GetUserFromHash(cookie.getValue());
           session.setAttribute("id",String.valueOf(user_id));
        }
      }
     if(session.getAttribute("id") == null){
        response.sendRedirect(request.getContextPath()+"/Views/Login.jsp");    
     }
    }

}
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
