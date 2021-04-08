/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 *
 * @author Michel
 */
@WebListener
public class ContextListener implements ServletContextListener {

   @Override
   public void contextInitialized(ServletContextEvent event) {
      ServletContext context = event.getServletContext();
      context.setAttribute("nbUtilisateurs", 0);
      context.setAttribute("nbIdentifies", 0);
   }

   @Override
   public void contextDestroyed(ServletContextEvent sce) {
   }

}
