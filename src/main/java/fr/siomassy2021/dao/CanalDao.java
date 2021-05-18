package fr.siomassy2021.dao;

import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Evaluation;
import fr.siomassy2021.model.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanalDao {

    private static int canal;

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
}
