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
public class EntrainementEtudiant {
  
  private int idEntrainementEtudiant;
  private Personne etudiant;

  public EntrainementEtudiant(int idEntrainementEtudiant, Personne etudiant) {
    this.idEntrainementEtudiant = idEntrainementEtudiant;
    this.etudiant = etudiant;
  }

  public EntrainementEtudiant() {
  }

  public int getIdEntrainementEtudiant() {
    return idEntrainementEtudiant;
  }

  public Personne getEtudiant() {
    return etudiant;
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
