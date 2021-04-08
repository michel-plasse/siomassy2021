/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.Database;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author plasse
 */
@WebServlet(urlPatterns = {"/resetDb"})
public class ResetDBServlet extends HttpServlet {

  private static final String VUE = "index.jsp";
  private static final String MSG_OK = "Base réinitialisée";

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    try {
      Database.reset();
      request.setAttribute("msg", MSG_OK);
    } catch (SQLException ex) {
      Logger.getLogger(ResetDBServlet.class.getName()).log(Level.SEVERE, null, ex);
      request.setAttribute("msg", ex.getMessage());
    }
    request.getRequestDispatcher(VUE).forward(request, response);
  }
}
