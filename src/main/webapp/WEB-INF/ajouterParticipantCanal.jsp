<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="AjouterMembreCanal"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter un membre au canal</title>
    </head>
    <body>
        <h1>Ajouter un membre au canal</h1>
        
        <form method="post">
            Email : <input type="text" name="email">
            <input type="submit" value="Soumettre" />
        </form>
    </body>
</html>
