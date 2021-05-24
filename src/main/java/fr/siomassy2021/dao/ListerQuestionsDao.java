/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

/**
 *
 * @author borelibombo
 */
import java.util.List;
import fr.siomassy2021.model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ListerQuestionsDao {

    public static List<Question> getQuestionsByIdCanal(int idCanal) throws SQLException {

        Connection connection = Database.getConnection();
        List<Question> result = new ArrayList();
        HashMap<String, Integer> reponses = new HashMap();;

        String sql ="SELECT * FROM stat_sur_reponses WHERE id_canal=?";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        ResultSet res = stmt.executeQuery();
        int idQuestionCourante = 0;
        Question questionCourante = null;
        int nbNonReponse = 0;
        while (res.next()) {
            int idQuestion = res.getInt("id_question");
            if (idQuestion != idQuestionCourante) {
                nbNonReponse = res.getInt("nb_non_reponse");
                String libelle = res.getString("libelle");
                questionCourante = new Question(libelle, nbNonReponse, new HashMap());
                result.add(questionCourante);
                idQuestionCourante = idQuestion;
            }
            String reponse = res.getString("reponse");
            int nbReponses = res.getInt("nb_reponses");
            questionCourante.getReponses().put(reponse, nbReponses);
        }
        return result;
    }
}
//avooir le libelle jusqu'au nb_reponse
// apres on cher les nombre d'etudiant t2 obliger de joindre avec personne car on a besoind es savoir qui est etudiant
//