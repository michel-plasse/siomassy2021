/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.model.Question;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idCanal= 1;
        // appel a la DAO 
        List<Question> questions = CanalDao.getQuestionsByIdCanal(idCanal) ;
        // mis en post'it
        request.setAttribute("questions", questions);
        // passage a la jsp
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
