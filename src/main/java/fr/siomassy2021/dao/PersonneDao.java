package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author michel
 */
public class PersonneDao {

  /**
   * Personne de login et password donnés. Renvoie null si pas trouvé.
   *
   * @param login
   * @param password
   * @return
   */
    public static Personne getByEmail(String email) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT id_personne, nom, prenom, email, tel, pwd\n" +
        "FROM personne\n" +
        "WHERE email = '" + email + "'";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Personne p = new Personne(rs.getInt("id_personne"), rs.getString("prenom"), rs.getString("nom"), rs.getString("email"), rs.getString("tel"), rs.getString("pwd"));
            return p;
        }
        else
            return null;
    }
    
  public static Personne getByLoginPassword(String login, String password) throws SQLException {
    Personne result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT * FROM personne WHERE email=? AND pwd=?";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setString(1, login);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      result = new Personne(
              rs.getInt("id_personne"),
              rs.getString("prenom"),
              rs.getString("nom"),
              rs.getString("email"),
              rs.getString("tel"),
              null); // pas de mot de passe en mémoire
    }
    return result;
  }

}
