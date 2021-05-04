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

/**
 *
 * @author KIMONA
 */
@WebServlet(name = "ReponsesQuestionServlet", urlPatterns = {"/reponses"})
public class ReponsesQuestionServlet extends HttpServlet {
    private String VUE_REPONSES = "WEB-INF/reponses.jsp";

   
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher(VUE_REPONSES).forward(request, response); 
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
