/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

/**
 *
 * @author sana
 */
public class PresenceSeance {
    
    private Personne idPersonne;
    private Seance idSeance;
    private int niveauParticipation;
    
    

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public Seance getIdSeance() {
        return idSeance;
    }

    public int getNiveauParticipation() {
        return niveauParticipation;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public void setIdSeance(Seance idSeance) {
        this.idSeance = idSeance;
    }

    public void setNiveauParticipation(int niveauParticipation) {
        this.niveauParticipation = niveauParticipation;
    }

    public PresenceSeance(Personne idPersonne, Seance idSeance, int niveauParticipation) {
        this.idPersonne = idPersonne;
        this.idSeance = idSeance;
        this.niveauParticipation = niveauParticipation;
    }
    
    public PresenceSeance(){
        super();
    }
}
