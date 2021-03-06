package fr.siomassy2021.controller;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Montre comment récupérer le id de l'utilisateur connecté
 * @author michel
 */
@WebServlet(name = "MesCanauxServlet", urlPatterns = {"/mescanaux"})
public class MesCanauxServlet extends HttpServlet {

  private String VUE_CANAUX = "WEB-INF/canaux.jsp";

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    // Recuperer le id de l'utilisateur connecte
    HttpSession session = request.getSession(true);
    Personne user = (Personne) session.getAttribute("user");
    if (user == null) {
      // Se rappeler la page demandee, pour rediriger le user vers elle apres connection
      session.setAttribute("askedUrlBeforeConnection", request.getRequestURI());
      // rediriger vers la connexion
      response.sendRedirect("connexion");
    } else {
      // Recuperer les canaux 
      List<Canal> canaux = CanalDao.getByMemberId(user.getId());
      // Mettre les données (les canaux) en post-it de la requête
      // avec le nom "canaux"
      request.setAttribute("canaux", canaux);
      // afficher la JSP
      request.getRequestDispatcher(VUE_CANAUX).forward(request, response);
    }
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
