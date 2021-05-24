/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.util.HashMap;

/**
 *
 * @author borelibombo
 */
public class Question {
    
    private String libelle;
    private int nbNonReponse;

    private HashMap<String,Integer> reponses;

    public Question(String libelle, int nbNonReponses, HashMap<String, Integer> lesReponses) {
        this.libelle = libelle;
        this.nbNonReponse = nbNonReponses;
        this.reponses = lesReponses;

    }

    public Question() {
    }
    public HashMap<String, Integer> getReponses() {
        return reponses;
    }

    public void setReponses(HashMap<String, Integer> reponses) {
        this.reponses = reponses;
    }
    
   
    public int getNbNonReponse() {
        return nbNonReponse;
    }

    public void setNbNonReponse(int nbNonReponse) {
        this.nbNonReponse = nbNonReponse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
    
    
}
