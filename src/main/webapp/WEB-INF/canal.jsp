<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Canal ${idCanal}"/>
<h1>Canal ${idCanal}</h1>

<!-- Ici, les liens vers vos différentes fonctionnalités -->
<nav>
  <a href="efgs?idCanal=${idCanal}">EFGs</a>
</nav>