/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.NoteEvaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sana
 */
public class EvaluationDao {

    public static void genererNotesVides(int idEvaluation) throws SQLException {

        Connection connection = Database.getConnection();

        String sql = "INSERT IGNORE INTO note_evaluation(id_etudiant, id_evaluation)\n"
                + "SELECT t1.id_personne,t2.id_evaluation\n"
                + "FROM\n"
                + "(SELECT mc.id_personne, mc.id_canal\n"
                + "FROM\n"
                + "	membre_canal mc\n"
                + "		INNER JOIN\n"
                + "	personne p\n"
                + " 		ON\n"
                + " 	mc.id_personne=p.id_personne\n"
                + "WHERE p.est_formateur = 0 AND p.est_administrateur=0 AND mc.id_canal = \n"
                + " (\n"
                + "     SELECT id_canal\n"
                + "     FROM evaluation\n"
                + "     WHERE id_evaluation = ?\n"
                + "  )\n"
                + " )t1\n"
                + " LEFT OUTER JOIN\n"
                + " (\n"
                + "     SELECT id_evaluation,id_canal\n"
                + "     FROM evaluation\n"
                + "     WHERE id_evaluation=?\n"
                + " )t2\n"
                + "     	ON\n"
                + "     t2.id_canal = t1.id_canal\n"
                + "GROUP BY t2.id_evaluation, t1.id_personne;\n";

        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idEvaluation);
        stmt.setInt(2, idEvaluation);

        stmt.execute();

        /*List<NoteEvaluation> result = new ArrayList();
        List<Etudiant> listeEtudiant = new ArrayList();
        NoteEvaluation eval;
        while (res.next()) {
            listeEtudiant.add(new Etudiant("nom_etudiant", "prenom_etudiant"));
            eval = new NoteEvaluation("intitule", "date_de_passage", listeEtudiant, 12);
            result.add(eval);
        }
        return result;*/
    }

public static List<Evaluation> getListEvaluations(int idCanal, int idEtudiant) throws SQLException {
    List<Evaluation> result = new ArrayList<Evaluation>();
    Connection connection = Database.getConnection();
    String sql =
    "SELECT * FROM evaluation e left join note_evaluation ne on e.id_evaluation = "
            + "ne.id_evaluation where e.id_canal =? "
            + "and (ne.id_etudiant is null or ne.id_etudiant = ?) "
            + "order by e.passee_a desc ";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idCanal);
    stmt.setInt(2, idEtudiant);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      result.add(new Evaluation(
              rs.getInt("id_evaluation"),
              rs.getString("intitule"),
              rs.getTimestamp("passee_a"),
              rs.getTime("duree"),
              rs.getBoolean("est_corrigee"),
              rs.getFloat("note"))
              );
      
    }
    
    
    return result;
  }

    
 public static Evaluation getInfoEvaluation(int id_evaluation) throws SQLException {
    Evaluation result = new Evaluation();
    Connection connection = Database.getConnection();
    String sql = "SELECT e.id_evaluation , e.intitule,  AVG(note) as moyenne ,Max(note) as note_maximum, Min(note) as note_minimum  " +
        "FROM evaluation e join note_evaluation ne  " +
        "on e.id_evaluation = ne.id_evaluation  where e.id_evaluation= ? " +
            "group by (e.id_evaluation)	";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, id_evaluation);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      result = 
            new Evaluation(
                    rs.getString("intitule"),
                    rs.getInt("id_evaluation"),
                    rs.getFloat("moyenne"),
                    rs.getFloat("note_maximum"),
                    rs.getFloat("note_minimum")
             );
      
    }
    
    
    return result;
  }

    public EvaluationDao() {
    }


}
