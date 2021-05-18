/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.siomassy2021.dao;

import fr.siomassy2021.model.Canal;
import fr.siomassy2021.model.Efg;
import fr.siomassy2021.model.Question;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class EfgDAO {
    
        public static List<Efg> getByCanalId(int canalId) {
        // Le résultat est toujours appelé result
        List<Efg> result = new ArrayList<Efg>();
        // Les canaux d'abord mis en dur
        result.add(new Efg("BTS SIO 2021"));
        result.add(new Efg( "CDA 2021"));
        return result;
    }


    
}
