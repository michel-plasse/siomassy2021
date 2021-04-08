package fr.siomassy2021.context;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author Michel
 */
@WebListener
public class SessionListener implements HttpSessionListener {

   @Override
   public void sessionCreated(HttpSessionEvent event) {
      System.out.println("connexion");
      ajouteANbUtilisateurs(event, 1);
   }

   @Override
   public void sessionDestroyed(HttpSessionEvent event) {
      System.out.println("deconnexion");
      ajouteANbUtilisateurs(event, -1);
   }

   private void ajouteANbUtilisateurs(HttpSessionEvent event, int increment) {
      ServletContext context = event.getSession().getServletContext();
      int nbUtilisateurs = (int) context.getAttribute("nbUtilisateurs");
      nbUtilisateurs += increment;
      context.setAttribute("nbUtilisateurs", nbUtilisateurs);
      System.out.println("nbUtilisateurs : " + context.getAttribute("nbUtilisateurs"));
   }
}
