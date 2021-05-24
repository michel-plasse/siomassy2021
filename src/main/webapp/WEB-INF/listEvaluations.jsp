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
          </tr>
           <c:forEach items="${evaluations}" var="evaluation">
           <tr>
            <td>${evaluation.intitule}</td>
            <td>${evaluation.passeeA}</td>
            <td>${evaluation.duree}</td>
            <td>${evaluation.estCorrigee ? 'Oui' : 'Non'}</td>
          </tr>
           </c:forEach>
        </table>
    </body>
</html>
<p:footer/>