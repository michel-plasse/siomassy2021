/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


/**
 *
 * @author sana
 */
public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer idEvaluation;
   
    private String intitule;
    
    private Timestamp passeeA;
    
    private Time duree;
   
    private Boolean estCorrigee;
    
    private Canal canal;
     
    private Personne  personne;
    
    private float note;
    
    private float moyenne;
     
    private float noteMax;
      
    private float noteMin;

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public float getNoteMax() {
        return noteMax;
    }

    public void setNoteMax(float noteMax) {
        this.noteMax = noteMax;
    }

    public float getNoteMin() {
        return noteMin;
    }

    public void setNoteMin(float noteMin) {
        this.noteMin = noteMin;
    }
    
    
    
    

    public Evaluation() {
    }

    public Evaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public Evaluation(Integer idEvaluation, String intitule, Timestamp passeeA, Time duree, Boolean estCorrigee, float note ) {
        this.idEvaluation = idEvaluation;
        this.intitule = intitule;
        this.passeeA = passeeA;
        this.duree = duree;
        this.estCorrigee = estCorrigee;
        this.note = note;
    }

    public Evaluation(String intitule,Integer idEvaluation, float moyenne, float noteMax, float noteMin) {
        this.intitule = intitule;
        this.idEvaluation = idEvaluation;
        this.moyenne = moyenne;
        this.noteMax = noteMax;
        this.noteMin = noteMin;
        
    }
    
    
    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public Integer getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(Integer idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Timestamp getPasseeA() {
        return passeeA;
    }

    public void setPasseeA(Timestamp passeeA) {
        this.passeeA = passeeA;
    }

    public Time getDuree() {
        return duree;
    }

    public void setDuree(Time duree) {
        this.duree = duree;
    }

    public Boolean getEstCorrigee() {
        return estCorrigee;
    }

    public void setEstCorrigee(Boolean estCorrigee) {
        this.estCorrigee = estCorrigee;
    }

    public Canal getCanal() {
        return canal;
    }

    public void setCanal(Canal canal) {
        this.canal = canal;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    
}
