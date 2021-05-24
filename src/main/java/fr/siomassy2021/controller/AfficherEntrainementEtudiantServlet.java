/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.dao.EntrainementDao;
import fr.siomassy2021.dao.QuestionDao;
import fr.siomassy2021.model.EntrainementEtudiant;
import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Karolawski
 */
@WebServlet(name = "AfficherEntrainementEtudiant", urlPatterns = {"/afficherEntrainementEtudiant"})
public class AfficherEntrainementEtudiantServlet extends HttpServlet {

  private final String VUE = "/WEB-INF/afficheEntrainementEtudiant.jsp";
  private final String VUE_ERREUR = "/WEB-INF/erreur.jsp";

  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int idCanal = 1;
    // appel a la DAO 
    List<Question> questions = CanalDao.getQuestionsByIdCanal(idCanal);
    // mis en post'it
    request.setAttribute("questions", questions);
    // passage a la jsp
    request.getRequestDispatcher(VUE).forward(request, response);
  }
  /**
   *
   * @param request
   * @param response
   * @throws ServletException
   * @throws IOException
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
      /* TODO output your page here. You may use following sample code. */
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Servlet AfficherEntrainementEtudiantServlet</title>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>Servlet AfficherEntrainementEtudiantServlet at " + request.getContextPath() + "questions" + "</h1>");
      //out.println();
      out.println("</body>");
      out.println("</html>");
    }
  }

  

  @Override
  public String getServletInfo() {
    return "Short description";
  }
}
