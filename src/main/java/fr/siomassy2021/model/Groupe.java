/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ben
 */
public class Groupe {
    private int idGroupe;
    private int idEfg;
    List<Personne> membresDuGroupe = new ArrayList<Personne>();
    
    public void ajouterMembre(Personne p) {
        membresDuGroupe.add(p);
    }

    public Groupe(int idGroupe, int idEfg) {
        this.idGroupe = idGroupe;
        this.idEfg = idEfg;
    }

    public Groupe() {
    }
    
    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    public void setIdEfg(int idEfg) {
        this.idEfg = idEfg;
    }

    public void setMembresDuGroupe(ArrayList<Personne> membresDuGroupe) {
        this.membresDuGroupe = membresDuGroupe;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public int getIdEfg() {
        return idEfg;
    }

    public List<Personne> getMembresDuGroupe() {
        return membresDuGroupe;
    }
    
    
    
}
