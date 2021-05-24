<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${idCanal}"/>
<h1>Canal ${idCanal}</h1>

<!-- Ici, les liens vers vos différentes fonctionnalités -->
<nav>
  <a href="efgs?idCanal=${idCanal}">EFGs</a>
  <a href="evaluations?idCanal=${idCanal}">Évaluations</a>
  <a href="presence?idCanal=${idCanal}">Présence</a>
  <a href="questionnaires?idCanal=${idCanal}">Questionnaires</a>
  <a href="questions?idCanal=${idCanal}">Questions</a>
  <hr/>
  <a href="AjouterMembreAuCanal?idCanal=${idCanal}">Ajouter un membre au canal</a>
  <a href="entrainementsEtudiant?idCanal=${idCanal}">Entrainements étudiant</a>

</nav>