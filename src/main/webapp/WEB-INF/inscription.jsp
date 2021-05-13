<%-- 
    Document   : inscription
    Created on : 7 mai 2021, 02:58:56
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Inscription"/>
<h1>Formulaire d'inscription !</h1>
<h2 class="erreur">${message}</h2>
<div id="formInscription">
    <form method="POST">
        <p><i>Complétez le formulaire. Les champs marqué par </i><em>*</em> sont <em>obligatoires</em></p>
        <fieldset>
            <legend>Contact</legend>
            <label for="nom">Nom <em>*</em></label>
            <input id="nom" placeholder="Berrouane" autofocus="" required="" name="nom"><br>
            <label for="prenom">Prénom <em>*</em></label>
            <input id="prenom" placeholder="Anouar" required="" name="prenom"><br>
            <label for="telephone">Portable</label>
            <input id="telephone" type="tel" placeholder="06xxxxxxxx" pattern="0[0-9]{9}" name="tel"><br>
            <label for="email">Email <em>*</em></label>
            <input id="email" type="email" placeholder="prenom.nom@greta.com" required="" pattern="^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$" name="email"><br>
            <label for="pwd">Mot de passe <em>*</em></label>
            <input id="pwd" type="password"  required=""  name="pwd"><br>
        </fieldset>
        <p><input type="submit" value="Valider"></p>
    </form>
</div>
</body>
</html>
