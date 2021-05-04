/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

/**
 *
 * @author borelibombo
 */
public class Question {
    
    private String libelle;
    private int nbNonReponses;

    public Question(String libelle, int nbNonReponses) {
        this.libelle = libelle;
        this.nbNonReponses = nbNonReponses;
    }

    public int getNbNonReponses() {
        return nbNonReponses;
    }

    public void setNbNonReponses(int nbNonReponses) {
        this.nbNonReponses = nbNonReponses;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
}
