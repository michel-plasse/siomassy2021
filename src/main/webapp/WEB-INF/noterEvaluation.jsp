<%-- 
    Document   : notesEvaluations
    Created on : 7 mai 2021, 17:53:09
    Author     : borelibombo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Lister Questions"/>
<h1>Noter Evaluation</h1>
<h3> ${eval1.intitule} du : ${eval1.datePassage}</h3>
<ol>
    <c:forEach items="${eval1.listeEtudiant}" var="listeEtudiant">
        <li>
            ${listeEtudiant.nom} ${listeEtudiant.prenom} <input type="number" min="0" max="20"><br>
        </li>
    </c:forEach>   
</ol>

 
