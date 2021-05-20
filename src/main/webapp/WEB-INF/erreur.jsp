<%-- 
    Document   : erreur
    Created on : 7 mai 2021, 19:56:46
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Erreur"/>
<h1 class="erreur">ERREUR</h1>
<h1 class="erreur">${message}</h1>
<p><c:out value="${message}"></c:out></p>
