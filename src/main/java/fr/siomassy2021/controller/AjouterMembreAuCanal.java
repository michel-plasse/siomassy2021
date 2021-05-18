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
public class AjouterMembreAuCanal extends HttpServlet {

    private final String VUE= "/WEB-INF/ajouterParticipantCanal.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCanal = 0;
        try {
            idCanal = Integer.parseInt(request.getParameter("idCanal"));
        }
        catch(NumberFormatException ex) {
            System.err.println("Canal n'est pas un entier");
        }
        try {
            idCanal = CanalDao.getById(idCanal);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterMembreAuCanal.class.getName()).log(Level.SEVERE, null, ex);
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
        } 
        catch (NumberFormatException e) {
            System.out.println("idCanal n'est pas un entier");
        }
        email = request.getParameter("email");
        try {
            p = PersonneDao.getByEmail(email);
        } 
        catch (SQLException ex) {
            Logger.getLogger(AjouterMembreAuCanal.class.getName()).log(Level.SEVERE, null, ex);
        }
        idPersonne = p.getId();
        try {
            CanalDao.ajouterMembreCanal(idCanal, idPersonne);
        } 
        catch (Exception e) {
            
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
