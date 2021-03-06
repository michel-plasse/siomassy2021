/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.PresenceSeance;
import fr.siomassy2021.model.Seance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sana
 */
public class PresenceDao {

    public Seance getSeanceDemarre(int idCanal) {
            Seance result = null;
        try {
            Connection connection = Database.getConnection();
            String sql = "select * from  seance s where datediff( now(), debute_a) = 0 and id_canal = ?";
            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idCanal);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                result = new Seance(
                        rs.getInt("id_seance"),
                        rs.getTimestamp("debute_a")
                 ); 
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(PresenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return result;
  }

    public void etudiantPresent(int idSeance, int idPersonne) {
        try {
            Connection connection = Database.getConnection();
            String sql = "INSERT INTO presence_seance (id_seance, id_personne, niveau_participation) VALUES (?, ?, null);";
            
            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idSeance);
            stmt.setInt(2, idPersonne);
            stmt.executeUpdate();
         
           
        } catch (SQLException ex) {
            Logger.getLogger(PresenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean etudiantEstPresent(int idSeance, int idPersonne) {
            boolean  isPresent =false;
        try {
            Connection connection = Database.getConnection();
            String sql = "select * from  presence_seance where id_seance = ? and  id_personne=?";
            PreparedStatement stmt = connection.prepareCall(sql);
            stmt.setInt(1, idSeance);
            stmt.setInt(2, idPersonne);
            ResultSet rs = stmt.executeQuery();
          if (rs.next()) {
              isPresent= true;
          }
           
        } catch (SQLException ex) {
            Logger.getLogger(PresenceDao.class.getName()).log(Level.SEVERE, null, ex);
        }
         return isPresent;
  }
    
    
    public static List<PresenceSeance> getListPresenceSeance(int idSeance) throws SQLException {
    List<PresenceSeance> result = new ArrayList<PresenceSeance>();
    Connection connection = Database.getConnection();
    String sql =
    "select * from  presence_seance ps join personne p on ps.id_personne =p.id_personne where ps.id_seance = ? ";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idSeance);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      Personne pers =new Personne(rs.getInt("id_personne"), rs.getString("prenom"), rs.getString("nom"));
      result.add(new PresenceSeance(
            pers,
            null,
            0 ));
      
    }
    
    
    return result;
        }
        
}

  
    
    

