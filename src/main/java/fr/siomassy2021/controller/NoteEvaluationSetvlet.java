/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.model.Etudiant;
import fr.siomassy2021.model.Evaluation;
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
@WebServlet(name = "NoteEvaluationSetvlet", urlPatterns = {"/noterEvaluation"})
public class NoteEvaluationSetvlet extends HttpServlet {
    
    private final String VUE  = "/WEB-INF/noterEvaluation.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        List<Etudiant> listeEtudiant = new ArrayList();
        listeEtudiant.add(new Etudiant("IBOMBO GAKOSSO", "Borel"));
        listeEtudiant.add(new Etudiant("BAKONGO MPOLO", "Grace-Chelsea"));
        listeEtudiant.add(new Etudiant("IBOMBO GAKOSSO", "Camille"));
        listeEtudiant.add(new Etudiant("IBOMBO GAKOSSO", "Joss-Alexandre"));
        Evaluation eval1 = new Evaluation("Evaluation N°1","16/05/2021",listeEtudiant, 12.75F);
        request.setAttribute("eval1", eval1);
        request.getRequestDispatcher(VUE).forward(request,response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
