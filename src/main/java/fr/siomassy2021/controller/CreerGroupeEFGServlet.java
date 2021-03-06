/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.EFGDao;
import fr.siomassy2021.model.Personne;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "CreerGroupeEFGServlet", urlPatterns = {"/creerGroupeEFG"})
public class CreerGroupeEFGServlet extends HttpServlet {

    private static final String VUE = "/WEB-INF/groupe.jsp";

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idGroupe = 4;
        HttpSession session = request.getSession(true);
        Personne user = (Personne) session.getAttribute("user");
        // on récupére l'idEFG qui est envoyé dans l'url
        int idEFG = Integer.parseInt(request.getParameter("idEFG"));
        
        if (user == null) {
            request.setAttribute("message", "Vous devez être connecté pour pouvoir créer un groupe !");
            request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);
        } 
        else {
           
            try {

                try {
                    EFGDao dao = new EFGDao();
                    idGroupe = dao.creerGroupe(idEFG, user.getId());
                    response.sendRedirect("AjouterMembreAuGroupeServlet?idEFG=" + idEFG + "&idGroupe=" + idGroupe);
                } catch (SQLException ex) {
                    Logger.getLogger(CreerGroupeEFGServlet.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (NumberFormatException e) {
                request.setAttribute("message", "idEFG doit etre entier");
                request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);

            }
        }

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
