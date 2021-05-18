<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Connexion"/>
<form method="post" action="groupe_efg">
    <fieldset>
        <legend>Groupe</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="efg">id_efg<span class="requis"></span></label>
        <input type="text" id="efg" name="efg" value="" size="20" maxlength="60" />
        <span class="erreur">${erreurs['efg']}</span>
        <br />



        <label for="groupe">id_groupe</label>
        <input type="text" id="nom" name="groupe" value="" size="20" maxlength="20" />
        <span class="erreur">${erreurs['groupe']}</span>
        <br />

        <input type="submit" value="submit" class="sansLabel" />
        <br />
    </fieldset>
</form>
<p:footer/>