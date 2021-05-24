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
public class Qcm {
  
  private int idQcm;
  private int idQuestionnaire;
  private String libelle; 
  private int idCanal;

  public Qcm(int idQcm, int idQuestionnaire, String libelle, int idCanal) {
    this.idQcm = idQcm;
    this.idQuestionnaire = idQuestionnaire;
    this.libelle = libelle;
    this.idCanal = idCanal;
  }

  public Qcm() {
  }

  public int getIdQcm() {
    return idQcm;
  }

  public int getIdQuestionnaire() {
    return idQuestionnaire;
  }

  public String getLibelle() {
    return libelle;
  }

  public int getIdCanal() {
    return idCanal;
  }

  public void setIdQcm(int idQcm) {
    this.idQcm = idQcm;
  }

  public void setIdQuestionnaire(int idQuestionnaire) {
    this.idQuestionnaire = idQuestionnaire;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public void setIdCanal(int idCanal) {
    this.idCanal = idCanal;
  }

  @Override
  public String toString() {
    return "Qcm{" + "idQcm=" + idQcm + ", idQuestionnaire=" + idQuestionnaire + ", libelle=" + libelle + ", idCanal=" + idCanal + '}';
  }
  
  
  
}
