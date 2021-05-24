package fr.siomassy2021.dao;

import fr.siomassy2021.model.EntrainementEtudiant;
import fr.siomassy2021.model.Question;
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
   * @param idEtudiant
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

  /**
   * Retourne les questions d'un entrainement par idEntrainement et idEtudiant
   *
   * @param IdEntrainement
   * @param idEtudiant
   * @return result
   * @throws java.sql.SQLException
   */
  public static List<EntrainementEtudiant> getQuestionsByIdEntrainementIdEtudiant(int IdEntrainement, int idEtudiant) throws SQLException {
    // Le résultat est toujours appelé result
    List<EntrainementEtudiant> result = new ArrayList<>();
    Connection connection = Database.getConnection();
    // Les canaux d'abord mis en dur
    String sql = "SELECT qcm.libelle, qcm.id_questionnaire, oq.id_option_qcm, oq.id_qcm, re.id_entrainement \n"
            + "FROM qcm\n"
            + "INNER JOIN option_qcm oq\n"
            + "ON qcm.id_qcm = oq.id_qcm\n"
            + "INNER JOIN reponse_entrainement re\n"
            + "ON oq.id_option_qcm = re.id_option_qcm\n"
            + "INNER JOIN entrainement_etudiant ee\n"
            + "ON re.id_entrainement = ee.id_entrainement\n"
            + "WHERE ee.id_entrainement=? AND ee.id_etudiant=?\n";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, IdEntrainement);
    stmt.setInt(2, idEtudiant);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      result.add(new EntrainementEtudiant(
              rs.getInt("id_questionnaire"),
              rs.getInt("id_entrainement"),
              rs.getString("libelle")));
    }
    return result;

  }
}
