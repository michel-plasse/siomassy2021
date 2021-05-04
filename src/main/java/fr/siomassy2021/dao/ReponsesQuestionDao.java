package fr.siomassy2021.dao;

import fr.siomassy2021.model.Reponse;
import java.util.ArrayList;
import java.util.List;

 
public class ReponsesQuestionDao {

     
    public static List<Reponse> getReponsesByIdCanal(int IdCanal) {
    // Le résultat est toujours appelé result
    List<Reponse> result = new ArrayList<>();
    // Les canaux d'abord mis en dur
    result.add(new Reponse(1, "BTS SIO 2021"));
    result.add(new Reponse(1, "CDA 2021"));
    return result;
}
}