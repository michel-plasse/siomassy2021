package fr.siomassy2021.model;
 
public class Question {
  private int id;
  private String nom;
    
    public Question(int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    public int getId(){
       return id;
    }
    
    public void setId(int Id){
       this.id = id;
    }
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(String nom){
        this.nom = nom;
    }
}
