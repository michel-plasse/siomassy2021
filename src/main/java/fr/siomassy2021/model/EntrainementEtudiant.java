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
public class EntrainementEtudiant {
  
  private int idEntrainement;
  private int idEtudiant;
  private String libelle;
  private Question question;

  public EntrainementEtudiant(int idEntrainement, int idEtudiant, String libelle, Question question) {
    this.idEntrainement = idEntrainement;
    this.idEtudiant = idEtudiant;
    this.libelle = libelle;
    this.question = question;
  } 
  public EntrainementEtudiant(int idEntrainement, int idEtudiant, String libelle) {
    this.idEntrainement = idEntrainement;
    this.idEtudiant = idEtudiant;
    this.libelle = libelle;
  }

  public EntrainementEtudiant(int idEntrainement, int idEtudiant) {
    this.idEntrainement = idEntrainement;
    this.idEtudiant = idEtudiant;
  }

  public EntrainementEtudiant(int idEntrainement) {
    this.idEntrainement = idEntrainement;
  }
  
  public EntrainementEtudiant() {
  }

  public int getIdEntrainement() {
    return idEntrainement;
  }

  public int getIdEtudiant() {
    return idEtudiant;
  }

  public String getLibelle() {
    return libelle;
  }

  public Question getQuestion() {
    return question;
  }

  public void setIdEntrainement(int idEntrainement) {
    this.idEntrainement = idEntrainement;
  }

  public void setIdEtudiant(int idEtudiant) {
    this.idEtudiant = idEtudiant;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public void setQuestion(Question question) {
    this.question = question;
  }


  


  
  



  
  
  
  
}
