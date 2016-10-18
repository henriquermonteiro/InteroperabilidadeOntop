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
public class TrimChainLink extends ResponsibilityChain<Alvara>{

    @Override
    public Alvara change(Alvara input) {
        return input.setAtividadePrincipal(input.getAtividadePrincipal().trim()).setAtividadeSecundaria(input.getAtividadeSecundaria().trim()).setAtividadeSecundaria2(input.getAtividadeSecundaria2().trim());
    }
    
}
