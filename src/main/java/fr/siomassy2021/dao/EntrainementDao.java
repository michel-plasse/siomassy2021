package fr.siomassy2021.dao;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.String;
import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Entrainement;
import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.Questionnaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karolawski
 */
public class EntrainementDao {
  
   /**
   * Retourne un entrainement par idEntrainement
   *
   * @param idEntrainement
   * @param Questionnaire
   * @param Canal
   * @return
   */
  
    public static List<Entrainement> getByIdEntrainement(int idEntrainement) throws SQLException {
      List<Entrainement> result = new ArrayList<Entrainement>();
      Connection connection = Database.getConnection();
      String sql = "SELECT * FROM entrainement WHERE id_entrainement=?";
      PreparedStatement stmt = connection.prepareCall(sql);
      stmt.setInt(1, idEntrainement);
      ResultSet rs = stmt.executeQuery();
      while (rs.next()) {
        result.add(new Entrainement(
           rs.getInt("id_entrainement"))); 
    }
    return result;
  }
}

//, Questionnaire questionnaire, Canal canal
// stmt.setObject(2, questionnaire);
  //stmt.setObject(3, canal);