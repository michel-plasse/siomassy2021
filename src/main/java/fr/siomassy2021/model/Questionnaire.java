/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class Questionnaire {
  
  private int idQuestionnaire;
  private Personne createur;
  private String libelle;
  private HashMap<String,Integer> questions;

  public Questionnaire(int idQuestionnaire, Personne createur, String libelle) {
    this.idQuestionnaire = idQuestionnaire;
    this.createur = createur;
    this.libelle = libelle;
  }

  public HashMap<String, Integer> getQuestions() {
    return questions;
  }

  public Questionnaire() {
  }

  public int getIdQuestionnaire() {
    return idQuestionnaire;
  }

  public Personne getCreateur() {
    return createur;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setQuestions(HashMap<String, Integer> questions) {
    this.questions = questions;
  }

  public void setIdQuestionnaire(int idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }

  public void setCreateur(Personne createur) {
    this.createur = createur;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public String toString() {
    return "Questionnaire{" + "idQuestionnaire=" + idQuestionnaire + ", createur=" + createur + ", libelle=" + libelle + '}';
  }

  
  
  
  
}
