/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 * 
 * @author henrique
 */
public class SaveChainLink extends ResponsibilityChain<Alvara>{

    @Override
    public Alvara change(Alvara input) {
        if(!input.getAtividadePrincipalAgregada().isEmpty()){
            save(input);
        }
        
        return input;
    }

    private void save(Alvara input) {
        //Conectar no BD e fazer insert;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
