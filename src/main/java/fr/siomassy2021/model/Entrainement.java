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
  
  private int idEntrainement;
  private Questionnaire questionnaire;
  private Canal canal;

  public Entrainement(int idEntrainement, Questionnaire questionnaire, Canal canal) {
    this.idEntrainement = idEntrainement;
    this.questionnaire = questionnaire;
    this.canal = canal;
  }

  public Entrainement() {
  }

  public int getIdEntrainement() {
    return idEntrainement;
  }

  public Questionnaire getQuestionnaire() {
    return questionnaire;
  }

  public Canal getCanal() {
    return canal;
  }

  public void setIdEntrainement(int idEntrainement) {
    this.idEntrainement = idEntrainement;
  }

  public void setQuestionnaire(Questionnaire questionnaire) {
    this.questionnaire = questionnaire;
  }

  public void setCanal(Canal canal) {
    this.canal = canal;
  }

  @Override
  public String toString() {
    return "Entrainement{" + "idEntrainement=" + idEntrainement + ", questionnaire=" + questionnaire + ", canal=" + canal + '}';
  }

  

  
  
 
  
}
