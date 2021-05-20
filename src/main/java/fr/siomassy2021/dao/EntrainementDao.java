package fr.siomassy2021.dao;

import fr.siomassy2021.model.EntrainementEtudiant;
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
   * @return result
   * @throws java.sql.SQLException
   */
  public static List<EntrainementEtudiant> getByIdEtudiant(int idEtudiant) throws SQLException {
    List<EntrainementEtudiant> result = new ArrayList<>();
    Connection connection = Database.getConnection();
    String sql = "SELECT q.libelle, e.id_entrainement, et.id_etudiant\n"
            + "FROM entrainement_etudiant et\n"
            + "INNER JOIN entrainement e\n"
            + "ON e.id_entrainement = et.id_entrainement\n"
            + "INNER JOIN questionnaire q\n"
            + "ON e.id_questionnaire = q.id_questionnaire\n"
            + "WHERE et.id_etudiant = ?";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idEtudiant);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      result.add(new EntrainementEtudiant(
              rs.getInt("id_etudiant"),
              rs.getInt("id_entrainement"),
              rs.getString("libelle")
      ));

    }
    return result;
  }
}
