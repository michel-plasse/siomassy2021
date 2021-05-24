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
            idEFG =  Integer.parseInt(request.getParameter("idEFG"));
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
        boolean valide = true;

        EFGDao dao = new EFGDao();

        try {
            dao.ajouterMembreAuGroupe(email, idEFG, idGroupe);
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                request.setAttribute("message", "Ce participant fait déjà parti du groupe !");
                valide = false;
            }
            if (ex.getErrorCode() == 1452) {
                request.setAttribute("message", "Cette email est inconnu dans la base de données !");
                valide = false;
            }
            Logger.getLogger(AjouterMembreAuGroupeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(valide){
            request.setAttribute("messageSuccess", "Le participant a été ajouté avec succès !");
        }
        
        request.getRequestDispatcher("/WEB-INF/ajouterMembreAuGroupe.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
