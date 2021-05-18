package fr.siomassy2021.model;

import java.util.Objects;

/**
 *
 * @author michel
 */
public class Personne {
  private int id, id_groupe;
  private String prenom, nom, email, tel, pwd;

  /** 
   * Constructeur
   * @param id
   * @param id_groupe
   * @param prenom
   * @param nom
   * @param email
   * @param tel
   * @param pwd 
   */
  public Personne(int id, String prenom, String nom, String email, String tel, String pwd) {
    this.id = id;
    this.prenom = prenom;
    this.nom = nom;
    this.email = email;
    this.tel = tel;
    this.pwd = pwd;
  }
  
  public Personne(int id, String prenom, String nom, int id_groupe) {
    this.id = id;
    this.prenom = prenom;
    this.nom = nom;
    this.id_groupe = id_groupe;
  }
  
  public int getIdGroupe() {
      return id_groupe;
  }
  
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 89 * hash + this.id;
    hash = 89 * hash + Objects.hashCode(this.prenom);
    hash = 89 * hash + Objects.hashCode(this.nom);
    hash = 89 * hash + Objects.hashCode(this.email);
    hash = 89 * hash + Objects.hashCode(this.tel);
    hash = 89 * hash + Objects.hashCode(this.pwd);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Personne other = (Personne) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.email, other.email)) {
      return false;
    }
    if (!Objects.equals(this.tel, other.tel)) {
      return false;
    }
    if (!Objects.equals(this.pwd, other.pwd)) {
      return false;
    }
    return true;
  }
  
}
