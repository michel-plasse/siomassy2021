/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.EntrainementDao;
import fr.siomassy2021.model.Entrainement;
import fr.siomassy2021.model.EntrainementEtudiant;
import java.io.IOException;
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
@WebServlet(name = "ListerEntrainementEtudiantServlet", urlPatterns = {"/ListerEntrainementEtudiant"})

public class ListerEntrainementEtudiantServlet extends HttpServlet {
  
    private final String VUE = "WEB-INF/ListerEntrainementEtudiant.jsp";
   
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
        EntrainementDao entrainementDao = new EntrainementDao();
        List<EntrainementEtudiant> entrainements = null;
        try {
            entrainements = EntrainementDao.getByIdEntrainement(1);
        } catch (SQLException ex) {
            Logger.getLogger(ListerEntrainementEtudiantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("entrainement", entrainements);
     
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}









