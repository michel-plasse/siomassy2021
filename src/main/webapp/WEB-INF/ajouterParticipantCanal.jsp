<%-- 
    Document   : ajouterParticipantCanal
    Created on : 18 mai 2021, 13:56:15
    Author     : ben
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un membre au canal</title>
    </head>
    <body>
        <h1>Ajouter un membre au canal</h1>
        
        <<form action="AjouterMembreAuCanal" method="post">
            Email : <input type="text">
            <input type="submit" value="Soumettre" name="submit" />
        </form>
    </body>
</html>
