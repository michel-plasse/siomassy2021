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
  private int idEtudiant;

  public EntrainementEtudiant(int idEntrainementEtudiant, int idEtudiant) {
    this.idEntrainementEtudiant = idEntrainementEtudiant;
    this.idEtudiant = idEtudiant;
  }

  public EntrainementEtudiant() {
  }

  public int getIdEntrainementEtudiant() {
    return idEntrainementEtudiant;
  }

  public int getIdEtudiant() {
    return idEtudiant;
  }

  public void setIdEntrainementEtudiant(int idEntrainementEtudiant) {
    this.idEntrainementEtudiant = idEntrainementEtudiant;
  }

  public void setIdEtudiant(int idEtudiant) {
    this.idEtudiant = idEtudiant;
  }

  @Override
  public String toString() {
    return "EntrainementEtudiant{" + "idEntrainementEtudiant=" + idEntrainementEtudiant + ", idEtudiant=" + idEtudiant + '}';
  }

  @Override
  protected void finalize() throws Throwable {
    super.finalize(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    return super.clone(); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public int hashCode() {
    return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
  }
  
  
  
}
