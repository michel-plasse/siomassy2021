/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.QuestionDao;
import fr.siomassy2021.model.Reponse;
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
 * @author KIMONA
 */
@WebServlet(name = "ReponsesQuestionServlet", urlPatterns = {"/ReponsesQuestion"})
public class ReponsesQuestionServlet extends HttpServlet {

    private String VUE_REPONSES = "WEB-INF/reponsesQuestion.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idcanal = 1;
        //appel a la DAO
        List<Reponse> reponses;
        try {
            reponses = QuestionDao.getReponsesByIdCanal(idcanal);
            request.setAttribute("reponses", reponses);
        } 
        catch (SQLException ex) {
            request.setAttribute("erreur", ex.getMessage());
            Logger.getLogger(ReponsesQuestionServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
