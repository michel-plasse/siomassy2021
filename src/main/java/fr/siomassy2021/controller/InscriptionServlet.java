/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.controller;

import fr.siomassy2021.dao.Database;
import fr.siomassy2021.dao.PersonneDao;
import fr.siomassy2021.model.Personne;
import static java.awt.SystemColor.window;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    final String VUE = "WEB-INF/inscription.jsp";
    private final String VUE_ERREUR = "WEB-INF/erreur.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE;
        String prenom = request.getParameter("prenom");
        String nom = request.getParameter("nom");
        String email = request.getParameter("email");
        String pwd = request.getParameter("pwd");
        String tel = request.getParameter("tel");

        boolean valide = true;

        //test de validation 
        // compilation de la regex
        Pattern regexTel = Pattern.compile("0[0-9]{9}");
        // création d'un moteur de recherche
        Matcher matcherTel = regexTel.matcher(tel);
        // lancement de la recherche de toutes les occurrences
        boolean booleanTel = matcherTel.matches();

        // compilation de la regex
        Pattern regexEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        // création d'un moteur de recherche
        Matcher matcherEmail = regexEmail.matcher(email);
        // lancement de la recherche de toutes les occurrences
        boolean booleanEmail = matcherEmail.matches();

        // compilation de la regex
        Pattern regexPrenom = Pattern.compile("^ *$");
        // création d'un moteur de recherche
        Matcher matcherPrenom = regexPrenom.matcher(prenom);
        // lancement de la recherche de toutes les occurrences
        boolean booleanPrenom = matcherPrenom.matches();

        // compilation de la regex
        Pattern regexNom = Pattern.compile("^ *$");
        // création d'un moteur de recherche
        Matcher matcherNom = regexNom.matcher(nom);
        // lancement de la recherche de toutes les occurrences
        boolean booleanNom = matcherNom.matches();

        // compilation de la regex
        Pattern regexMdp = Pattern.compile("^ *$");
        // création d'un moteur de recherche
        Matcher matcherMdp = regexMdp.matcher(pwd);
        // lancement de la recherche de toutes les occurrences
        boolean booleanMdp = matcherMdp.matches();

        if (!booleanEmail) {
            request.setAttribute("erreur_email", "Votre email est invalide");
            valide = false;
        }
        if (!booleanTel) {
            request.setAttribute("erreur_tel", "Votre téléphone est invalide");
            valide = false;
        }
        if (booleanPrenom) {
            request.setAttribute("erreur_prenom", "Veuillez remplir le champs prénom correctement");
            valide = false;
        }
        if (booleanNom) {
            request.setAttribute("erreur_nom", "Veuillez remplir le champs nom correctement");
            valide = false;
        }
        if (booleanMdp) {
            request.setAttribute("erreur_mdp", "Veuillez remplir le champs mot de passe correctement");
            valide = false;
        }

        if (valide) {
            PersonneDao dao = new PersonneDao();

            Personne p1 = new Personne(prenom, nom, email, tel, pwd);
            try {
                dao.insert(p1);

            } catch (SQLException ex) {
                if (ex.getErrorCode() == 1062) {
                    request.setAttribute("message", "Cet email existe déjà !");
                } else {
                    request.setAttribute("message", "Problème interne !");
                }
                Logger.getLogger(InscriptionServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            vue = "WEB-INF/connexion.jsp";

        }
        request.getRequestDispatcher(vue).forward(request, response);

    }
}
