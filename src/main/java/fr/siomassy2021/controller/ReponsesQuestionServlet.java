/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.ReponsesQuestionDao;
import fr.siomassy2021.model.Reponse;
import java.io.IOException;
import java.util.List;
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
        int canalid = 1;
        //appel a la DAO
        List<Reponse> reponses = ReponsesQuestionDao.getReponsesByIdCanal(canalid);
        request.setAttribute("reponses", reponses);
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
