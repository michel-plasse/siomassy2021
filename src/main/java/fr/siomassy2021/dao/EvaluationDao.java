package fr.siomassy2021.dao;

import fr.siomassy2021.model.Evaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sana
 */
public class EvaluationDao {


  public static List<Evaluation> getListEvaluations() throws SQLException {
    List<Evaluation> result = new ArrayList<Evaluation>();
    Connection connection = Database.getConnection();
    String sql = "SELECT * FROM evaluation";
    PreparedStatement stmt = connection.prepareCall(sql);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      result .add(new Evaluation(
              rs.getInt("id_evaluation"),
              rs.getString("intitule"),
              rs.getTimestamp("passee_a"),
              rs.getTime("duree"),
              rs.getBoolean("est_corrigee"))); 
    }
    
    
    return result;
  }

    public EvaluationDao() {
    }


}
