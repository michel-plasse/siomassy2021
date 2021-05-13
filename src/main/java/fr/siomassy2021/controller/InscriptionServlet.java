/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.PersonneDao;
import fr.siomassy2021.model.Personne;
import static java.awt.SystemColor.window;
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
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    final String VUE = "WEB-INF/inscription.jsp";
    private final String VUE_ERREUR ="WEB-INF/erreur.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");

        PersonneDao dao = new PersonneDao();
        
        try {
            if(dao.verificationExistant(email)){
                request.setAttribute("message", "Cet email existe déjà !");
                request.getRequestDispatcher(VUE).forward(request, response);
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Personne p1 = new Personne(prenom, nom, email, tel, pwd);
        try {
            dao.insert(p1);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("WEB-INF/connexion.jsp").forward(request, response);
    }
}
