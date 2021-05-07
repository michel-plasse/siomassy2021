<%-- 
    Document   : EFGs
    Created on : 4 mai 2021, 16:39:20
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Erreur"/>
    <h1>Liste d'EFGs</h1>

    <ol>
        <c:forEach items="${EFGs}" var="efg">
            <li>${efg.intitule}</li>
            </c:forEach>
    </ol>
    </body>
</html>
