package fr.siomassy2021.dao;

import java.sql.*;
import java.time.LocalDateTime;

public class Database {

   protected static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
   protected static final String URL = "jdbc:mysql://localhost/siomassy2021";
   protected static final String USER = "siomassy2021_user";
   protected static final String PASSWORD = "siomassy2021_pwd";

   public enum SortOrder {
      ASC, DESC;
   }

   static {
      // Chargement du pilote
      // Ne doit avoir lieu qu'une seule fois
      try {
         Class.forName(DRIVER_NAME).newInstance();
         System.out.println("*** Driver loaded.");
      } catch (ClassNotFoundException e) {
         System.err.println("*** ERROR: Driver " + DRIVER_NAME + " not found");
      } catch (InstantiationException e) {
         System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
         System.err.println(e.getMessage());
      } catch (IllegalAccessException e) {
         System.err.println("*** ERROR: Impossible to create an instance of " + DRIVER_NAME);
         System.err.println(e.getMessage());
      }
   }

   /**
    * Fournit une connexion à la base de données. Ne fait pas appel à un pool de
    * connexion, mâme si cela est envisageable plus tard (ne changerait rien à
    * l'appel de la méthode)
    *
    * @throws java.sql.SQLException
    */
   public static Connection getConnection() throws SQLException {
      return DriverManager.getConnection(URL, USER, PASSWORD);
   }

   /** Réinitialise la base de données en appelant la procédure
    * stockée siomassy2021_reset().
    * @throws SQLException 
    */
   public static void reset(LocalDateTime dateEffet) throws SQLException {
      Connection connection = Database.getConnection();
      CallableStatement stmt = connection.prepareCall("CALL reset_siomassy2021(?)");
      stmt.setTimestamp(1, Timestamp.valueOf(dateEffet));
      stmt.execute();
      stmt.close();
      connection.close();
   }
}
