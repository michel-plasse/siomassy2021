/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author michel
 */
public class DatabaseTest {
  
  @Test
  public void testGetConnection() throws Exception {
    System.out.println("getConnection");
    assertNotNull(Database.getConnection());
  }

  @Test
  public void testReset() throws Exception {
    System.out.println("reset");
    assertDoesNotThrow(() -> {Database.reset(LocalDateTime.now());});
  }
  
}
