<%-- 
    Document   : inscription
    Created on : 7 mai 2021, 02:58:56
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulaire d'inscription</title>
    </head>
    <body>
        <h1>Formulaire d'inscription !</h1>
        
        <form method="post">
            <div>
                <label>Prenom : </label>
                <input type="text" name="prenom">
            </div>
            <div>
                <label>Nom : </label>
                <input type="text" name="nom">
            </div>
            <div>
                <label>Email : </label>
                <input type="email" name="email">
            </div>
            <div>
                <label>Mot de passe :</label>
                <input type="password" name="pwd">
            </div>
            <div>
                <label>Téléphone : </label>
                <input type="text" name="tel">
            </div>
            <div>
                <input type="submit" value="valider">
            </div>
        </form>
    </body>
</html>
