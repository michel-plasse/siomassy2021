/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrateur
 */
public class InscriptionDAO {
    
    public int registration(Personne personne) throws ClassNotFoundException, SQLException {
        
        Connection connection = Database.getConnection();
        String insert = "INSERT INTO client (prenom, nom, email,pwd,tel) VALUES ( '"+personne.getPrenom()+"', '"+personne.getNom()+"', '"+personne.getEmail()+"', '"+personne.getPwd()+"', '"+personne.getTel()+"');";

        Statement canalInscription = connection.createStatement();
        
        canalInscription.execute(insert);
        
        
        
        
        return 0;
    }
    
}
