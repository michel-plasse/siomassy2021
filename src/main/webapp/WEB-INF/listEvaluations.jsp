<%-- 
    Document   : Evaluation
    Author     : Sana
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p:header title="liste des évaluations"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" type="text/css" href="listEvaluation.css"/>
    </head>
    <body>
        <h1>Liste des evaluations</h1>     
        <table id="evaluations">
          <tr>
            <th>Intitulé</th>
            <th>La date</th>
            <th>Durée</th>
            <th>Est corrigée</th>
            <th>Ma note</th>
          </tr>
           <c:forEach items="${evaluations}" var="evaluation">
           <tr>
            <td>
                   <c:if  test="${evaluation.estCorrigee == true}">
                <a href="evaluation?evaluation=${evaluation.idEvaluation}">${evaluation.intitule}</a>
                    </c:if>
                 <c:if  test="${evaluation.estCorrigee == false}">
                ${evaluation.intitule}
                    </c:if></td>
            <td>${evaluation.passeeA}</td>
            <td>${evaluation.duree}</td>
            <td>${evaluation.estCorrigee ? 'Oui' : 'Non'}</td>
            <td>${evaluation.estCorrigee ? evaluation.note : 'pas encore corrigé'}</td>
          </tr>
           </c:forEach>
        </table>
        
    </body>
</html>
<p:footer/>