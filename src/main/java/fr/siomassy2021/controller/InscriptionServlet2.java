/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.InscriptionDAO;
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
 * @author Administrateur
 */
@WebServlet(name = "InscriptionServlet2", urlPatterns = {"/InscriptionServlet2"})
public class InscriptionServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");
        
        Personne p1 = new Personne(prenom, nom, email, tel, pwd);
        
        InscriptionDAO dao = new InscriptionDAO();
    try {
        dao.registration(p1);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
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
