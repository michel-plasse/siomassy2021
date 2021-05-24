 package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.Question;
import fr.siomassy2021.model.Reponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

 
public class QuestionDao {

    public static List<Question> getQuestionsByIdCanal(int IdCanal) {
    // Le résultat est toujours appelé result
    List<Question> result = new ArrayList<>();
    // Les canaux d'abord mis en dur
    result.add(new Question("fini ?"));
    result.add(new Question("ce point est compris ?"));
    return result;
}
      public static List<Reponse> getReponsesByIdCanal(int IdCanal) throws SQLException {
        Connection connection = Database.getConnection();

// Le résultat est toujours appelé result
        List<Reponse> result = new ArrayList<>();

        String sql = "SELECT  p.id_personne, q.libelle as question, rq.libelle as reponse, p.prenom, p.nom\n"
                + "from reponse_question rq\n"
                + " \n"
                + "inner join question q on rq.id_question = q.id_question\n"
                + "inner join personne p on rq.id_personne = p.id_personne\n"
                + "group by  p.id_personne, q.libelle , rq.libelle, p.prenom, p.nom";

        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet res = stmt.executeQuery();
        while (res.next()) {
            Question question = new Question(res.getString("question"));
            String reponse = res.getString("reponse");
            String prenom = res.getString("prenom");
            String nom = res.getString("nom");
            Personne p1 = new Personne(res.getInt("id_personne"), res.getString("prenom"),
                    res.getString("nom"));
            result.add(new Reponse(question, reponse, p1));
        }
        // Les canaux d'abord mis en dur
        //Personne personne1 = new Personne(1, "Borel", "IBOMBO", "ibombo.borel@goutlook.fr", "0613670062", "123456");
        //Personne personne2 = new Personne(1, "bienvenu", "LOUZOLO", "louzolo_carmel@yahoo.fr", "0651750772", "12345678");

        //Question question1 = new Question();
        //question1.setLibelle("quel heure est il?");
        //result.add(new Reponse(question1, "il est 15heure", personne1));
        //Question question2 = new Question();
        //question2.setLibelle("on est quelle date");
        //result.add(new Reponse(question2, "le 1 janvier", personne2));
        return result;
    }
}
 
