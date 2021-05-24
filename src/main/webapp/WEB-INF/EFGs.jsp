<%-- 
    Document   : EFGs
    Created on : 4 mai 2021, 16:39:20
    Author     : Administrateur
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Liste d'EFGs"/>
<h1>Liste d'EFGs</h1>
<h2 class="erreur">${message}</h2>

<table>
    <thead> <!-- En-tête du tableau -->
        <tr>
            <th>N°</th>
            <th>Intitule</th>
            <th>Accès au groupe de l'EFG</th>
            <th>Créer un groupe dans l'EFG</th>
        </tr>
    </thead>
    <tbody> <!-- Corps du tableau -->
        <c:forEach items="${EFGs}" var="efg">

            <tr>
                <td>${efg.idEFG}</td>
                <td>${efg.intitule}</td>
                <td><a href="listerGroupesEfg?idEfg=${efg.idEFG}"><button type="button" class="btn-efg">Accéder aux groupes de l'EFG</button></a></td>
                <td><a href="creerGroupeEFG?idEFG=${efg.idEFG}"><button type="button" class="btn-efg">Créer un groupe</button></a></td>
            </tr>

        </c:forEach>
    </tbody>
</table>

</body>
</html>
