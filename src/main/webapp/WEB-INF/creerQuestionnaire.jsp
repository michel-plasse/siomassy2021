<%-- 
    Document   : Créer Questionnaire
    Author     : Sandra
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<p:header title="Créer des questionnaires"/>

        <h1>Création de Questionnaire</h1>     
        <form id="creerquestionnaire" method="POST" >
            <label for="titre">Titre du questionnaire</label>
            <input id=""titre" type="text" name="titre">
            /* faire les ajouts de questions avec Javascript
             faire les ajouts de réponses pour chaque questions*/
            <button type="submit">Valider</button>
        
        </form>
    </body>
</html>
<p:footer/>
