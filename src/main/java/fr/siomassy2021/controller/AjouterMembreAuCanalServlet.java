/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.dao.PersonneDao;
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
 * @author ben
 */
@WebServlet(name = "AjouterMembreAuCanal", urlPatterns = {"/AjouterMembreAuCanal"})
public class AjouterMembreAuCanalServlet extends HttpServlet {

    private final String VUE= "/WEB-INF/ajouterParticipantCanal.jsp";
    private final String VUE_ERREUR= "/WEB-INF/erreur.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCanal = 0;
        String vue = VUE;
        try {
            idCanal = Integer.parseInt(request.getParameter("idCanal"));
            idCanal = CanalDao.getById(idCanal);
        }
        catch(NumberFormatException ex) {
            request.setAttribute("message", "idCanal n'est pas un entier");
            vue = VUE_ERREUR;
        }
         catch (SQLException ex) {
            Logger.getLogger(AjouterMembreAuCanalServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
            vue = VUE_ERREUR;
        }
        request.setAttribute("idCanal", idCanal);
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
        int idCanal = 0;
        String email = "";
        int idPersonne = 0;
        Personne p = new Personne();
        try {
            idCanal = Integer.parseInt(request.getParameter("idCanal"));
            email = request.getParameter("email");
            p = PersonneDao.getByEmail(email);
            idPersonne = p.getId();
            CanalDao.ajouterMembreCanal(idCanal, idPersonne);
        } 
        catch (NumberFormatException e) {
            System.out.println("idCanal n'est pas un entier");
            request.setAttribute("message", "idCanal n'est ps un entier");
        } 
        catch (SQLException ex) {
            Logger.getLogger(AjouterMembreAuCanalServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
        }

  }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
