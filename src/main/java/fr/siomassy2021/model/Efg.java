/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.sql.Date;

/**
 *
 * @author Administrateur
 */
public class Efg {

    private int idEFG;
    private String intitule;
    private int idCreateur;
    private int idCanal;

    public Efg(String intitule, int idCreateur, int idCanal) {
        this.intitule = intitule;
        this.idCreateur = idCreateur;
        this.idCanal = idCanal;
    }

    public Efg() {
    }

    public Efg(int idEFG, String intitule, int idCreateur, int idCanal) {
        this.idEFG = idEFG;
        this.intitule = intitule;
        this.idCreateur = idCreateur;
        this.idCanal = idCanal;
    }

    public Efg(String intitule) {
        this.intitule = intitule;
    }

     

    public String getIntitule() {
        return intitule;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public int getIdEFG() {
        return idEFG;
    }

    public void setIdEFG(int idEFG) {
        this.idEFG = idEFG;
    }
    
    
}
