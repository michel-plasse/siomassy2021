/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import java.util.List;
import fr.siomassy2021.model.Groupe;
import fr.siomassy2021.model.Personne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ben
 */
public class GroupesEfgDao {
    public static List<Groupe> getMembresByIdEfg(int idEfg) throws SQLException {
        int idGroupe = 0;
        Groupe g = null;
        List<Groupe> listeGroupesEfg = new ArrayList<Groupe>();
        Connection connection = Database.getConnection();
        String sql = "SELECT p.nom, p.prenom, mgr.id_personne, mgr.id_groupe, mgr.id_efg \n" +
        "FROM personne p\n" +
        "	INNER JOIN\n" +
        "membre_groupe_efg mgr ON mgr.id_personne = p.id_personne\n" +
        "WHERE mgr.id_efg = " + idEfg + "\nORDER BY mgr.id_groupe";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Personne p = new Personne(rs.getInt("id_personne"), rs.getString("prenom"), rs.getString("nom"));
            if (rs.getInt("id_groupe") != idGroupe) {
                g = new Groupe(rs.getInt("id_groupe"), idEfg);
                g.ajouterMembre(p);
                listeGroupesEfg.add(g);
                idGroupe = rs.getInt("id_groupe");
            }
            else {
                g.ajouterMembre(p);
            }
        }
        return listeGroupesEfg;
    }
}
