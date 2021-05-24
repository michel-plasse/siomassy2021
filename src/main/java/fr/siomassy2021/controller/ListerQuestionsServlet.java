/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.ListerQuestionsDao;
import fr.siomassy2021.model.Question;
import java.io.IOException;
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
 * @author borelibombo
 */
@WebServlet(name = "ListerQuestionsServlet", urlPatterns = {"/questions"})
public class ListerQuestionsServlet extends HttpServlet {

    private final String VUE= "/WEB-INF/questions.jsp";
    private final String VUE_ERREUR= "/WEB-INF/erreur.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCanal=1;
        String vue= VUE;
        // appel a la DAO 
        List<Question> questions ;
        try {
            questions = ListerQuestionsDao.getQuestionsByIdCanal(idCanal);
            // mis en post'it
            request.setAttribute("questions", questions);
            // passage a la jsp
        } catch (SQLException ex) {
            Logger.getLogger(ListerQuestionsServlet.class.getName()).log(Level.SEVERE, null, ex);
            vue=VUE_ERREUR;
            request.setAttribute("message", ex.getMessage());
        }
        request.getRequestDispatcher(VUE).forward(request, response);        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
