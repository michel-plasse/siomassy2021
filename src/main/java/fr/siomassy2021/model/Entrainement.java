/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

/**
 *
 * @author Karolawski
 */
public class Entrainement {
  
  private int id;
  private int idQuestionnaire;
  private int idCanal;

  public Entrainement(int id, int idQuestionnaire, int idCanal) {
    this.id = id;
    this.idQuestionnaire = idQuestionnaire;
    this.idCanal = idCanal;
  }

  public Entrainement() {
  }

  public int getId() {
    return id;
  }

  public int getIdQuestionnaire() {
    return idQuestionnaire;
  }

  public int getIdCanal() {
    return idCanal;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setIdQuestionnaire(int idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }

  public void setIdCanal(int idCanal) {
    this.idCanal = idCanal;
  }

  @Override
  public String toString() {
    return "Entrainement{" + "id=" + id + ", idQuestionnaire=" + idQuestionnaire + ", idCanal=" + idCanal + '}';
  }
  
  
 
  
}
