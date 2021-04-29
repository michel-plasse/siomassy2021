<%@taglib prefix="p" tagdir="/WEB-INF/tags" %>
<p:header title="SIO Massy 2021"/>
<%-- Message d'erreur ou pas, au cas où --%>
${msg}
<h1>SIO Massy 2021</h1>
<section class="flexh">
  <p>Cette application est le projet final des BTS SIO 2021 du Greta de Massy, 
    étudiants de formation continue qui le préparent en un an.</p>
  <p>Elle explore un support à la formation en ligne, complémentaire
    aux moyens audio/vidéo/partage d'écran.</p>
  <p>Elle est développée en Java.  
    <a href="http://54.37.157.233:8080/siomassy2021/">Version en ligne</a>
  </p>
</section>
<h2>Quelques points techniques</h2>
<section id="index_articles">
  <article>
    <h3>MVC</h3>
    <p>A chaque URL est associée un contrôleur, implémenté par une servlet. 
      Par exemple, <code>servlet.ConnexionServlet</code>, classe héritant de
      <code>javax.servlet.http.HttpServlet</code>. L'association entre l'URL
      et la servlet se fait via l'annotation
      <code>@WebServlet(urlPatterns = {"/connexion"})</code> placée au-desuss
      de la déclaration de la classe.</p>
    <p>Le controleur fait appel au modèle pour accéder à la base de données, et
      passe la main à une JSP, qui affiche les données, après avoir ajouté
      à l'objet requête HTTP des attributs (des "post-it") contenant ces données.
      Ex : <code>request.setAttribute("user", user)</code>, où
      <code>user</code> est une instance de la classe <code>Personne</code>.</p>
    <p>La vue (la JSP) accède à ces données via <code>&dollar;{user}</code>. Elle
      peut aussi accéder aux paramètres de la requête via
      <code>&dollar;{param["unParametre"]}</code>, de la session via
      <code>&dollar;{sessionScope["uneVariableDeSession"]}</code>, ou de l'application
      via <code>&dollar;{applicationScope["uneVariableDApplication"]}</code>.</p>
  </article>

  <article>
    <h3>Mise en commun de menus et bas de page</h3>
    <p>Toutes les pages de l'application affichent le même menu en haut et le
      même bas de page.
      <br/>Le naut de page et le bas de page sont écrits dans les fichiers 
      <code>header.tag</code> et <code>footer.tag</code> situés dans 
      <code>WEB-INF/tags/</code>.
      <br/>Ils sont inclus dans les JSP via <code>&lt;p:header/></code> et 
      <code>&lt;p:footer/></code>.</p>
  </article>

  <article>
    <h3>Pages à accès protégé</h3>
    <p>Excepté quelques pages d'accès public, la plupart nécessitent une 
      authentification.
    </p>
    <p>Ceci est contrôlé par la classe <code>context.ConnectionFilter</code>,
      qui, implémentant l'interface <code>javax.servlet.Filter</code>, intercepte 
      toutes les requêtes HTTP avant de les passer à la servlet correspondante.</p>
  </article>

  <article style="clear:left;">
    <h3>Initialisations au démarrage de l'application</h3>
    <p>La classe <code>context.ContextListener</code>, qui implémente l'interface
      <code>javax.servlet.ServletContextListener</code>, initialise les deux
      compteurs (nombre d'utilisateurs et nombre de ceux identifiés après une
      connexion réussie).</p>
    <p>Ces deux compteurs ont pour portée application, et sont
      accessible dans les servlets et les JSP. Par exemple, dans une servlet :</p>
    <pre>
nb = getServletContext().getAttribute("nbUtilisateurs");
setAttribute("nbUtilisateurs", unEntier)</pre>
    Et dans une JSP :
    <pre>&dollar;{applicationScope["nbUtilisateurs"]}</pre>
  </article>

  <article>
    <h3>Démarrage/fin de session</h3>
    <p>Le nombre d'utilisateurs (nombre de navigateurs consultant l'application)
      est incrémenté/décrémenté à chaque création/fin
      d'une session utilisateur, dans la classe <code>context.SessionListener</code> 
      qui implémente l'interface <code>javax.servlet.http.HttpSessionListener</code>.
    </p>
    <p>Le nombre d'utilisateurs connectés est quant à lui incrémenté/décrémenté
      dans la servlet <code>ConnexionServlet</code> :
    <pre>int nb = (int) context.getAttribute("nbIdentifies");
context.setAttribute("nbIdentifies", nb + 1);</pre>
  </article>
</section>

<section>
  <h1>Référence technique</h1>
  <ul>
    <li><a href="https://www.alsacreations.com/article/lire/1376-html5-section-article-nav-header-footer-aside.html">Les balises section, article, nav, 
        aside, header, footer</a> de HTML5.</li>
    <li><a href="https://www.alsacreations.com/tuto/lire/1493-css3-flexbox-layout-module.html">Le modèle flexbox</a> des CSS.</li>
</section>
<p:footer/>