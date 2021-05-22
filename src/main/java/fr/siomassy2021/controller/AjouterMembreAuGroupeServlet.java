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

/**
 *
 * @author admin
 */
@WebServlet(name = "AjouterMembreAuGroupeServlet", urlPatterns = {"/AjouterMembreAuGroupeServlet"})
public class AjouterMembreAuGroupeServlet extends HttpServlet {

    int idEFG;
    int idGroupe;
      

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            idEFG = Integer.parseInt(request.getParameter("idEFG"));
            idGroupe = Integer.parseInt(request.getParameter("idGroupe"));
            request.setAttribute("idGroupe", idGroupe);
            request.getRequestDispatcher("/WEB-INF/ajouterMembreAuGroupe.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "idEFG doit etre entier");
            request.getRequestDispatcher("/WEB-INF/erreur.jsp").forward(request, response);

        }
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        
        EFGDao dao = new EFGDao();
        
        try {
            dao.ajouterMembreAuGroupe(email, idEFG, idGroupe);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterMembreAuGroupeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
