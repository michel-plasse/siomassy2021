<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<h1>Mes canaux</h1>
<nav>
  <c:forEach items="${canaux}" var="canal">
    <a href="canal?idCanal=${canal.id}">${canal.nom}</a>
  </c:forEach>
</nav>