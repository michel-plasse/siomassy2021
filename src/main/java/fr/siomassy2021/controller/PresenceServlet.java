/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.PersonneDao;
import fr.siomassy2021.dao.PresenceDao;
import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.Seance;
import java.io.IOException;
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
 * @author sana
 */

@WebServlet(name = "presence", urlPatterns = {"/presence"})
public class PresenceServlet extends HttpServlet {
    private final String VUE = "WEB-INF/presence.jsp";
    private final String VUE_ERREUR= "/WEB-INF/erreur.jsp";


  

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
     HttpSession session = request.getSession();

        PresenceDao presenceDao = new PresenceDao();
        int idCanal = Integer.parseInt(request.getParameter("idCanal"));
        Seance seanceDemarre= presenceDao.getSeanceDemarre(idCanal);
        session.setAttribute("seanceDemarre", seanceDemarre);
          if(session.getAttribute("user")==null){
            request.setAttribute("message", "Vous etes pas connecté");
            request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
        } else if(seanceDemarre==null){
            request.setAttribute("message", "pas de seance disponible");
            request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
        }
          else{
         
        int idPersonne = ((Personne) session.getAttribute("user")).getId();
      
        boolean etudiantEstPresent =  presenceDao.etudiantEstPresent(seanceDemarre.getIdSeance(), idPersonne);
        session.setAttribute("etudiantEstPresent", etudiantEstPresent); 
         try {
      
             session.setAttribute("listPresenceSeance", presenceDao.getListPresenceSeance(seanceDemarre.getIdSeance())); 
         } catch (SQLException ex) {
             Logger.getLogger(PresenceServlet.class.getName()).log(Level.SEVERE, null, ex);
         
         }
         
        request.getRequestDispatcher(VUE).forward(request, response);
        

    } }
    
    @Override
     protected void doPost(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
        HttpSession session = request.getSession();
        PresenceDao presenceDao = new PresenceDao();
        int idSeance = ((Seance) session.getAttribute("seanceDemarre")).getIdSeance();
        int idPersonne = ((Personne) session.getAttribute("user")).getId();
        presenceDao.etudiantPresent(idSeance, idPersonne);
        response.sendRedirect(request.getContextPath() + "/presence?idCanal="+ Integer.parseInt(request.getParameter("idCanal")));
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
