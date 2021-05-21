 
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

    public Reponse(String question, String reponse, int personne, String prenom, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Reponse(String question, String reponse, int personne) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
