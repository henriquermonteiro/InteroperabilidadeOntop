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
public class ToUpperChainLink extends ResponsibilityChain<Alvara>{

    @Override
    public Alvara change(Alvara input) {
        input.setAtividadePrincipal(input.getAtividadePrincipal().toUpperCase());
        input.setAtividadeSecundaria(input.getAtividadeSecundaria().toUpperCase());
        input.setAtividadeSecundaria2(input.getAtividadeSecundaria2().toUpperCase());
        
        return input;
    }

    @Override
    public int getStatus() {
        return ResponsibilityChain.RUNNING;
    }
    
}
