package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import java.sql.SQLException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class EvaluationDaoTest {
  
 @Test
  public void getListEvaluations() throws Exception {
    System.out.println("getListEvaluations");
    EvaluationDao evd =   new EvaluationDao();
   // assertNotNull(evd.getListEvaluations(1,2));
  }
  

}
