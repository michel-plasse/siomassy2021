<%-- 
    Document   : EFGs
    Created on : 4 mai 2021, 16:39:20
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Ajouter membre au groupe"/>

    <h1 class="success">Félicitation ! Vous venez de créer le groupe ${idGroupe}</h1>
    <h3>Ajouter un membre au groupe ${idGroupe}</h3>
    
        <form method="post">
            Email : <input type="text" name="email">
            <input type="submit" value="Soumettre" />
        </form>
    </body>
</html>
