package fr.siomassy2021.dao;

import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Efg;
import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.Question;
import fr.siomassy2021.model.Questionnaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CanalDao {

    private static int canal;
    
    public static void ajouterMembreCanal(int idCanal, int idPersonne) throws SQLException{
        Connection connection = Database.getConnection();
        String sql = "INSERT into membre_canal (id_canal, id_personne, ajoute_a) values (?,?, now())";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        stmt.setInt(2, idPersonne);
        stmt.execute();
        System.out.println("idCanal " + idCanal + " idPersonne " + idPersonne);
    }
    
    public static int getById(int idCanal) throws SQLException {
        int result = 0;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_canal FROM canal WHERE id_canal = " + idCanal;
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            result = idCanal;
        }
        return result;
    }
    public static List<Canal> getByMemberId(int memberId) {
        // Le résultat est toujours appelé result
        List<Canal> result = new ArrayList<Canal>();
        // Les canaux d'abord mis en dur
        result.add(new Canal(1, "BTS SIO 2021"));
        result.add(new Canal(1, "CDA 2021"));
        return result;
    }

    public static List<Canal> getAll() throws SQLException {
        List<Canal> result = new ArrayList<Canal>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM canal";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new Canal(
                    rs.getInt("id_canal"),
                    rs.getString("nom")));
        }
        return result;
    }

    public static List<Question> getQuestionsByIdCanal(int idCanal) {

        List<Question> result = new ArrayList<Question>();

        HashMap<String, Integer> reponses = new HashMap();
        reponses.put("oui", 2);
        reponses.put("non", 1);
        result.add(new Question("Avez-vous fini ?", 2, reponses));
        reponses = new HashMap();
        reponses.put("1h", 2);
        reponses.put("30min", 1);
        reponses.put("1h30min", 2);
        result.add(new Question("Combien de temps voulez-vous pour ce TP ?", 0, reponses));
        return result;
    }

    public static List<Efg> getEFGSByIdCanal(int idcanal) throws SQLException {
        List<Efg> liste = new ArrayList<>();
        Connection connection = Database.getConnection();

        Statement canal1 = connection.createStatement();

        String requete = "select * from efg  where id_canal = '" + idcanal + "';";

        ResultSet res = canal1.executeQuery(requete);

        while (res.next()) {
            int idEfg = res.getInt("id_efg");
            String intitule = res.getString("intitule");
            int idcreateur = res.getInt("id_createur");
            int id_canal = res.getInt("id_canal");

            Efg e1 = new Efg(idEfg, intitule, idcreateur, idcanal); //Créer une instance de client pour chaque client dans la base

            liste.add(e1); // on ajoute l'instance 

        }
        return liste;
    }
  
    public static List<Questionnaire> getQuestionnairesByIdFormateur(int idFormateur) {
       Questionnaire q = new Questionnaire();
        List<Questionnaire> result = new ArrayList();
        result.add(q);
        return result;
    }

}
