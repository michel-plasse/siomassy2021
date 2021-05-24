/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.util.List;

/**
 *L intitulé et la date de passage de l evaluation
    La liste des étudiants ayant participer
    Un champ de saisi pour que le formateur insère une note
 * @author borelibombo
 */
public class NoteEvaluation {
    
    private String intitule;
    private String datePassage;
    private List<Etudiant> listeEtudiant;
    private int note; 

    public NoteEvaluation(String intitule, String datePassage, List<Etudiant> listeEtudiant, int note) {
        this.intitule = intitule;
        this.datePassage = datePassage;
        this.listeEtudiant = listeEtudiant;
        this.note = note;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDatePassage() {
        return datePassage;
    }

    public void setDatePassage(String datePassage) {
        this.datePassage = datePassage;
    }

    public List<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    public void setListeEtudiant(List<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    public float getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "intitule=" + intitule + ", datePassage=" + datePassage + ", listeEtudiant=" + listeEtudiant + ", note=" + note + '}';
    }
    
}
