<%-- 
    Document   : sucesso.jsp
    Created on : 12/03/2020, 20:58:03
    Author     : tiago.bscarton
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sucesso! </h1>
        <c:if test="${cadastroOK}">
            <p>Cliente cadastrado com Sucesso</p>
        </c:if>
        <a href="index.html">Início</a>
    </body>
</html>
