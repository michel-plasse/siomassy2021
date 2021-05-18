package fr.siomassy2021.dao;

import fr.siomassy2021.model.Personne;
import fr.siomassy2021.model.Question;
import fr.siomassy2021.model.Reponse;
import java.util.ArrayList;
import java.util.List;

 
public class ReponsesQuestionDao {

     
    public static List<Reponse> getReponsesByIdCanal(int IdCanal) {
    // Le résultat est toujours appelé result
    List<Reponse> result = new ArrayList<>();
    // Les canaux d'abord mis en dur
    
    Personne personne1 = new Personne(1,"Borel", "IBOMBO","ibombo.borel@goutlook.fr","0613670062","123456");
    Personne personne2 = new Personne(1, "bienvenu", "LOUZOLO", "louzolo_carmel@yahoo.fr", "0651750772", "12345678");
    
    Question question1 = new Question();
    question1.setLibelle("quel heure est il?");
    result.add(new Reponse(question1, "il est 15heure",personne1));
    
    Question question2 = new Question();
    question2.setLibelle("on est quelle date");
    result.add(new Reponse(question2, "le 1 janvier",personne2));
    
    return result;
}
}