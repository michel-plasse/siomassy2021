/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.EvaluationDao;
import fr.siomassy2021.model.Evaluation;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sana
 */
@WebServlet(name = "InfoEvaluationServlet", urlPatterns = {"/evaluation"})
public class InfoEvaluationServlet extends HttpServlet {
  private final String VUE = "WEB-INF/infoEvaluation.jsp";
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
                int idEvaluation = Integer.parseInt(request.getParameter("evaluation"));
                EvaluationDao evaluationDao = new  EvaluationDao();
      try {
          Evaluation ev = evaluationDao.getInfoEvaluation(idEvaluation);
          request.setAttribute("evaluation", ev);

      } catch (SQLException ex) {
          Logger.getLogger(InfoEvaluationServlet.class.getName()).log(Level.SEVERE, null, ex);
      }
       

    request.getRequestDispatcher(VUE).forward(request, response);
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
