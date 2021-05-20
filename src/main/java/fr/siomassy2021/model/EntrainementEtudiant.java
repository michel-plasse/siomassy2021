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
public class EntrainementEtudiant {
  
  private int idEntrainement;
  private int idEtudiant;
  private String libelle;

  public EntrainementEtudiant(int idEntrainementEtudiant, int idEtudiant, String libelle) {
    this.idEntrainement = idEntrainementEtudiant;
    this.idEtudiant = idEtudiant;
    this.libelle = libelle;
  }

  public EntrainementEtudiant(int idEntrainement, Canal canal) {
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

  public void setIdEntrainement(int idEntrainement) {
    this.idEntrainement = idEntrainement;
  }

  public void setIdEtudiant(int idEtudiant) {
    this.idEtudiant = idEtudiant;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  
  



  
  
  
  
}
