/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.model;

import java.sql.Timestamp;

/**
 *
 * @author selim
 */
public class Seance {
    private int idSeance;
    private Timestamp debuteA;
    private Canal canal;
    
    public int getIdSeance(){
        return idSeance;
    }
    
    
    public Timestamp getDebutA(){
        return debuteA;
    }
        
    public Canal getCanal(){
         return canal;
    }
      
    
    public void setCanal(Canal canal){
        this.canal=canal;
    }
    
    public void setIdSeance(int idSeance){
        this.idSeance=idSeance;
    }
    
    
    public void setDebutA (Timestamp debutA){
        this.debuteA=debuteA;
        
    }

    @Override
    public String toString() {
        return "Seance{" + "idSeance=" + idSeance + ", debuteA=" + debuteA + ", canal=" + canal + '}';
    }

    public Seance(int idSeance, Timestamp debuteA) {
        this.idSeance = idSeance;
        this.debuteA = debuteA;
    }
       
    
        
    
    
    
    
    
    
}
