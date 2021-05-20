<%-- 
    
    Author     : Karolawski
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Mes entrainements"/>
<h1>Liste les entrainements étudiant</h1>  
<ul>
  <c:forEach items="${entrainements}" var="entrainement">
    <li><a href="monEntrainement?idEntrainement=${entrainement.idEntrainement}">
        ${entrainement.libelle}</a>
    </li>   
  </c:forEach>
</ul>
</body>
</html>
<p:footer/>



