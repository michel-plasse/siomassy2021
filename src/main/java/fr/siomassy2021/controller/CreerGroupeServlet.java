/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.model.Personne;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "CreerGroupeServlet", urlPatterns = {"/creerGroupeEFG"})
public class CreerGroupeServlet extends HttpServlet {

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
        try {
            int idEFG = Integer.parseInt(request.getParameter("idEFG"));
            Personne user = (Personne) request.getSession(true).getAttribute("user");
            response.sendRedirect("/EFG?idEFG=" + idEFG);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "idEFG doit etre entier");
            request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);
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
