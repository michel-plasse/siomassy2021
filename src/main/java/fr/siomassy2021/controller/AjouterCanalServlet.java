package fr.siomassy2021.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.siomassy2021.dao.CanalDao;
import fr.siomassy2021.dao.Database;
import fr.siomassy2021.model.Canal;

/**
 * Servlet implementation class AjouterCanalServelet
 */
@WebServlet(name = "AjouterCanalServlet", urlPatterns = "/nouveauCanal")
public class AjouterCanalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String VUE_FORM = "WEB-INF/nouveauCanal.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VUE_FORM);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		try {
			CanalDao.insert(new Canal(1, "nom"));
			response.sendRedirect("listesCanaux.jsp");
		} catch (SQLException ex) {

		}

	}
}
