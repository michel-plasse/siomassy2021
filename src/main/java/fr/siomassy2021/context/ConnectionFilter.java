/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.context;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Oblige a s'identifier pour toutes les pages sous /interne/
 *
 * @author plasse
 */
@WebFilter(filterName = "ConnectionFilter", urlPatterns = {"/interne/*"})
public class ConnectionFilter implements Filter {

   /**
    *
    * @param request The servlet request we are processing
    * @param response The servlet response we are creating
    * @param chain The filter chain we are processing
    *
    * @exception IOException if an input/output error occurs
    * @exception ServletException if a servlet error occurs
    */
   public void doFilter(ServletRequest request,
           ServletResponse response,
           FilterChain chain)
           throws IOException, ServletException {
      System.out.println("filtre connexion appelé");
      final HttpServletRequest req = (HttpServletRequest) request;
      final HttpSession session = req.getSession();
      if (session != null && session.getAttribute("user") != null) {
         // Passe la main a la servlet demandee
         chain.doFilter(request, response);
      } else {
         session.setAttribute("askedUrlBeforeConnection", req.getRequestURI());
         System.out.println("Nouvelle session");
         req.getRequestDispatcher("/connexion").forward(request, response);
      }
   }

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
   }

   @Override
   public void destroy() {
   }

}
