<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes canaux"/>
<h1>Mes questions</h1>
<ol>
  <c:forEach items="${questions}" var="question">
      <li>${question.libelle} (manque ${question.nbNonReponses} réponses) </li>
  </c:forEach>
</ol>
