/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Groupe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author admin
 */
public class EFGDao {

    public int creerGroupe(int idEFG, int idUser) throws SQLException {
        int idGroupe = 0;
        Connection connection = Database.getConnection();
        Statement canal1 = connection.createStatement();
        String sql = "select MAX(id_groupe) as idgroupe FROM groupe_efg where id_efg = " + idEFG + ";";
        ResultSet res = canal1.executeQuery(sql);
        if (res.absolute(1)) {
            while (res.next()) {
                idGroupe = res.getInt("idgroupe") + 1;
            }

        } else {
            idGroupe = 0;
        }

        String insert = "INSERT INTO groupe_efg (id_efg, id_groupe) VALUES (?, ?);";
        PreparedStatement stmt = connection.prepareStatement(insert);

        stmt.setInt(1, idEFG);
        stmt.setInt(2, idGroupe);
        stmt.execute();

        String insert2 = "INSERT INTO membre_groupe_efg (id_personne, id_efg,id_groupe) VALUES(?, ?, ?);";
        PreparedStatement stmt2 = connection.prepareStatement(insert2);

        stmt2.setInt(1, idUser);
        stmt2.setInt(2, idEFG);
        stmt2.setInt(3, idGroupe);
        stmt2.execute();
        
        return idGroupe;
    }
    

}
