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
public class ReplacerChainLink extends ResponsibilityChain<Alvara>{

    private static String replacer(String inputString){
        return inputString.replaceAll("[^\\p{L}0-9\\s]|\\s\\p{L}\\s|\\s\\p{L}\\z|\\sDE\\s|\\sEM\\s|\\sE\\s|\\sCOM\\s|\\sAO\\s", " ").replaceAll("\\s+", " ");
    }
    
    @Override
    public Alvara change(Alvara input) {
        return input.setAtividadePrincipal(replacer(input.getAtividadePrincipal())).setAtividadeSecundaria(replacer(input.getAtividadeSecundaria())).setAtividadeSecundaria2(replacer(input.getAtividadeSecundaria2()));
    }

    @Override
    public int getStatus() {
        return ResponsibilityChain.RUNNING;
    }
}
