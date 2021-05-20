/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.util.HashMap;

/**
 *
 * @author Karolawski
 */
public class EntrainementEtudiant extends Entrainement {
  
  private int idEntrainementEtudiant;
  private Personne etudiant;
  private HashMap<String,Integer> entrainements;

  public EntrainementEtudiant(int idEntrainementEtudiant, Personne etudiant) {
    this.idEntrainementEtudiant = idEntrainementEtudiant;
    this.etudiant = etudiant;
  }

  public EntrainementEtudiant() {
  }
  
   public EntrainementEtudiant(int idEntrainementEtudiant) {
         this.idEntrainementEtudiant = idEntrainementEtudiant;

  }

  public HashMap<String, Integer> getEntrainements() {
    return entrainements;
  }
  

  public int getIdEntrainementEtudiant() {
    return idEntrainementEtudiant;
  }

  public Personne getEtudiant() {
    return etudiant;
  }

  public void setEntrainements(HashMap<String, Integer> entrainements) {
    this.entrainements = entrainements;
  }

  
  public void setIdEntrainementEtudiant(int idEntrainementEtudiant) {
    this.idEntrainementEtudiant = idEntrainementEtudiant;
  }

  public void setEtudiant(Personne etudiant) {
    this.etudiant = etudiant;
  }

  @Override
  public String toString() {
    return "EntrainementEtudiant{" + "idEntrainementEtudiant=" + idEntrainementEtudiant + ", etudiant=" + etudiant + '}';
  }


  
  
  
}
