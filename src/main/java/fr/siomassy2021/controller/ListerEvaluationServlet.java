
package fr.siomassy2021.controller;


import fr.siomassy2021.dao.EvaluationDao;
import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.Personne;
import java.io.IOException;
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
import javax.servlet.http.HttpSession;

/**
 *
 * @author sana
 */
@WebServlet(name = "ListerEvaluation", urlPatterns = {"/evaluations"})
public class ListerEvaluationServlet extends HttpServlet {
    
    private final String VUE = "WEB-INF/listEvaluations.jsp";
   
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
        EvaluationDao evaluationDao = new EvaluationDao();
        List<Evaluation> listEvaluations =null;
        try {
            listEvaluations = evaluationDao.getListEvaluations();
        } catch (SQLException ex) {
            Logger.getLogger(ListerEvaluationServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("evaluations", listEvaluations);
     
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
