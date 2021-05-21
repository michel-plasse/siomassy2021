/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.QuestionDao;
import fr.siomassy2021.model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
 * @author KIMONA
 */
@WebServlet(name = "RepondreQuestionServlet", urlPatterns = {"/RepondreQuestion"})
public class RepondreQuestionServlet extends HttpServlet {
private String VUE_REPONSES = "WEB-INF/repondreQuestion.jsp";
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           request.getRequestDispatcher(VUE_REPONSES).forward(request, response);
           
           int idcanal = 1;
        //appel a la DAO
        List<Question> questions;
        questions = QuestionDao.getQuestionsByIdCanal(idcanal);
        request.setAttribute("reponses", questions);
        request.getRequestDispatcher(VUE_REPONSES).forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse question)
            throws ServletException, IOException {
         
         
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
