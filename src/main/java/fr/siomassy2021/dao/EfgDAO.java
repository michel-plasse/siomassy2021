/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Efg;
import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class EfgDAO {
    
        public List<Efg> getByCanalId(int canalId) {
        // Le résultat est toujours appelé result
        List<Efg> result = new ArrayList<Efg>();
        // Les canaux d'abord mis en dur
        result.add(new Efg("BTS SIO 2021"));
        result.add(new Efg( "CDA 2021"));
        return result;
    }

    public EfgDAO() {
    }
    
    public static List<Efg> getByCanalId2(int idcanal) throws SQLException {
        List<Efg> liste = new ArrayList<>();
        Connection connection = Database.getConnection();
        
        Statement canal1 = connection.createStatement(); 
        
        String requete = "select * from efg  where id_canal = '"+idcanal+"';";
        
        ResultSet res = canal1.executeQuery(requete); 
        
        while(res.next()) {
            int idefg = res.getInt("id_efg");

            String intitule = res.getString("intitule");
            int idcreateur = res.getInt("id_createur");
            int id_canal = res.getInt("id_canal");

            Efg e1 = new Efg(intitule, idcreateur, id_canal); //Créer une instance de client pour chaque client dans la base
            
            liste.add(e1); // on ajoute l'instance 

        }
        return liste;
        
    }
    
        
        


    
}
