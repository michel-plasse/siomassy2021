/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Sana
 */
public class PresenceDaoTest {
    
     @Test
  public void etudiantPresent() throws Exception {
    System.out.println("etudiantPresent");
    PresenceDao pdt =   new PresenceDao();
     int idSeance = 1;
    int idPersonne = 4;
    pdt.etudiantPresent(idSeance,idPersonne);
    assertTrue(pdt.etudiantEstPresent(idSeance, idPersonne));
    
  }
}
