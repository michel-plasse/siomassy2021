/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

/**
 *
 * @author Lenovo
 */
public class Questionnaire {
  
  private int idQuestionnaire;
  private int idCreateur;
  private String libelle;

  public Questionnaire(int idQuestionnaire, int idCreateur, String libelle) {
    this.idQuestionnaire = idQuestionnaire;
    this.idCreateur = idCreateur;
    this.libelle = libelle;
  }

  public Questionnaire() {
  }

  public int getIdQuestionnaire() {
    return idQuestionnaire;
  }

  public int getIdCreateur() {
    return idCreateur;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setIdQuestionnaire(int idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }

  public void setIdCreateur(int idCreateur) {
    this.idCreateur = idCreateur;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public String toString() {
    return "Questionnaire{" + "idQuestionnaire=" + idQuestionnaire + ", idCreateur=" + idCreateur + ", libelle=" + libelle + '}';
  }
  
  
  
  
}
