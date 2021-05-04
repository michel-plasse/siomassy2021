 package fr.siomassy2021.dao;

import fr.siomassy2021.model.Question;
import java.util.ArrayList;
import java.util.List;

 
public class RepondreQuestionDao {

    public static List<Question> getQuestionsByIdCanal(int IdCanal) {
    // Le résultat est toujours appelé result
    List<Question> result = new ArrayList<>();
    // Les canaux d'abord mis en dur
    result.add(new Question(1, "BTS SIO 2021"));
    result.add(new Question(1, "CDA 2021"));
    return result;
}
}