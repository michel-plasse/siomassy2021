/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.siomassy2021.dao.GroupesEfg;
import fr.siomassy2021.dao.PersonneDao;
import fr.siomassy2021.model.Groupe;
import fr.siomassy2021.model.Personne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ben
 */
@WebServlet(name = "listerGroupesEfg", urlPatterns = {"/listerGroupesEfg"})
public class listerGroupesEfgServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final String VUE= "/WEB-INF/listeGroupesEfg.jsp";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int idEfg = 1;
        List<Groupe> listeGroupesEfg = new ArrayList<Groupe>();
        try {
            listeGroupesEfg = GroupesEfg.getMembresByIdEfg(idEfg);
        } catch (SQLException ex) {
            Logger.getLogger(listerGroupesEfgServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", ex.getMessage());
        }
        request.setAttribute("listeGroupesEfg", listeGroupesEfg);
        request.setAttribute("efg", idEfg);
        request.getRequestDispatcher(VUE).forward(request, response);
    }// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">ing containing servlet description
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
