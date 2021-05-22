/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Questionnaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class QuestionnaireDao {
    /**
   * Retourne un entrainement par idQuestionnaire
   *
   * @param idQuestionnaire
   * @param Createur
   * @param Libelle
   * @return
   */

    public static List<Questionnaire> getByIdQuestionnaire(int idQuestionnaire) throws SQLException {
      List<Questionnaire> result = new ArrayList<Questionnaire>();
      Connection connection = Database.getConnection();
      String sql = "SELECT * FROM questionnaire WHERE id_questionnaire=?";
      PreparedStatement stmt = connection.prepareCall(sql);
      stmt.setInt(1, idQuestionnaire);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        result.add(new Questionnaire(
           rs.getInt("id_questionnaire"))); 
    }
    return result;
  }
}

  

