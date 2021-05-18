 
package fr.siomassy2021.model;

/**
 *
 * @author KIMONA
 */
public class Reponse {
  private Question question;
  private String reponse;
  private Personne personne;

    public Reponse(Question question, String reponse, Personne personne) {
        this.question = question;
        this.reponse = reponse;
        this.personne = personne;
    }

     

     

     

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    

    public Reponse() {
    }
    
    
}
