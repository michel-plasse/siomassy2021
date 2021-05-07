/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.model.Efg;
import fr.siomassy2021.model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "ListerEFGServlet", urlPatterns = {"/efgs"})
public class ListerEFGServlet extends HttpServlet {
    
    private final String VUE = "WEB-INF/EFGs.jsp";
    
    List<Efg> listeEFG;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        CanalDao dao = new CanalDao();    
        
        try {
            listeEFG = dao.getEFGSByIdCanal(1);
        } catch (SQLException ex) {
            Logger.getLogger(ListerEFGServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("EFGs", listeEFG);
     
        request.getRequestDispatcher(VUE).forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
