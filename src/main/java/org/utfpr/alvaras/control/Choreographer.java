/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control;

/**
 *
 * @author henrique
 */
public class Choreographer {
    public static ResponsibilityChain<Alvara> getDictionaryChain(){
        ToUpperChainLink toUpp = new ToUpperChainLink();
        ReplacerChainLink replacer = new ReplacerChainLink();
        TrimChainLink trimer = new TrimChainLink();
        DictionaryBuilderLink dic = new DictionaryBuilderLink();
        
        trimer.addLink(dic);
        replacer.addLink(trimer);
        toUpp.addLink(replacer);
        
        return return toUpp;
    }
    
    public static ResponsibilityChain<Alvara> getExecutionChain(){
        return null;
    }
}
