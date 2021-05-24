<%-- 
    Document   : Evaluation
    Author     : Sana
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p:header title="Info Evaluation"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
       <link rel="stylesheet" type="text/css" href="listEvaluation.css"/>
    </head>
    <body>
        <h1>Info Evaluation</h1>     
       <body>
        <body>
        <table id="evaluations">
          <tr>
            <th>Intitulé</th>
            <th>Note moyenne</th>
            <th>Note Maximale</th>
            <th>Note Minimale</th>
          </tr>
           <tr>
            <td>${evaluation.intitule}</td>
            <td>${evaluation.moyenne}</td>
            <td>${evaluation.noteMax }</td>
            <td>${evaluation.noteMin }</td>
          </tr>
        </table>
        
    </body>
        
    </body>
    </body>
</html>
<p:footer/>