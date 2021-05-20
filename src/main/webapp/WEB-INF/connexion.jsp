<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="p" tagdir="/WEB-INF/tags/"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<p:header title="Connexion"/>
<h1>Connexion</h1>
<h3 class="success">${messageSuccess}</h3>
    <form method="POST">
      <c:if test="${sessionScope['user'] == null}">
        Login :
        <input type="text" name="login" value="${param['login']}"/>
        ${loginMsg}
        <br/>
        Mot de passe :
        <input type="password" name="pwd"/>
        ${pwdMsg}
        <br/>
        <button type="submit">Connexion</button>
        <br/>
        <c:if test="${connexionMsg != null}">
          <div class="erreur">${connexionMsg}</div>
        </c:if>
      </c:if>
      <c:if test="${sessionScope['user'] != null}">
        <button name="action" value="deconnecter">
          Déconnecter ${sessionScope["user"].getLogin()}
        </button>
      </c:if>
    </form>
  </body>
</html>
