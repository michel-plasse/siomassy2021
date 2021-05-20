package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PersonneDaoTest {
  
  @Test
  public void testGetByLoginPassword() throws Exception {
    System.out.println("getByLoginPassword");
    String login = "etudiant1@gmail.com";
    String password = "azerty";
    assertNotNull(PersonneDao.getByLoginPassword(login, password));
  }

  @Test
  public void testGetByLoginPasswordPasTrouve() throws Exception {
    System.out.println("getByLoginPassword");
    String login = "etudiant1@gmail.com";
    String password = "toto";
    assertNull(PersonneDao.getByLoginPassword(login, password));
  }

  @Test
  public void testInsert() throws Exception {
    System.out.println("insert");
    // Reinitialiser la base
    Database.reset(LocalDateTime.now());
    Personne personne = new Personne(0, "prenom", "nom", 
            "email@gmail.com", "0123456789", "pwd");
    // Pas present dans la base
    assertNull(PersonneDao.getByEmail("email@gmail.com"));
    // Inserer
    PersonneDao instance = new PersonneDao();
    instance.insert(personne);
    // La personne devrait avoir le id 8
    personne.setId(8); // ce devrait etre fait dans le insert
    // Elle est bien dans la base
    // (il faut avoir redefini equals dans Personne)
    assertEquals(personne, PersonneDao.getByEmail("email@gmail.com"));
  }
  
}
