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

<ul>
    <c:forEach items="${EFGs}" var="efg">
        <li>${efg.intitule} : <a href="listerGroupesEfg?idEfg=${efg.idEFG}"><button type="button" class="btn-efg">Accéder aux groupes de l'EFG</button></a></li>
        </c:forEach>
</ul>
</body>
</html>
