package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
    

    public void insert(Personne personne) throws SQLException {

        Connection connection = Database.getConnection();
        String insert = "INSERT INTO personne (prenom, nom, email,pwd,tel) VALUES ( ?, ?, ?, ?,?);";
        //compile la requete
        PreparedStatement stmt = connection.prepareStatement(insert);
        
        stmt.setString(1, personne.getPrenom());
        stmt.setString(2, personne.getNom());
        stmt.setString(3, personne.getEmail());
        stmt.setString(4,personne.getPwd());
        stmt.setString(5,personne.getTel());
        
        stmt.execute();

    }
    
    public int getByLastId() throws SQLException{
        int id=0;
        Connection connection = Database.getConnection();
        String sql = "SELECT MAX(id_personne) as id\n" +
                      "from personne;";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
    }

}
