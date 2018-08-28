/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.util.ArrayList;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class FilterChainLink extends ResponsibilityChain<Alvara>{
    private ArrayList<Integer> exclude;

    public FilterChainLink() {
        this.exclude = new ArrayList<>();
    }

    public FilterChainLink(ArrayList<Integer> exclude) {
        this.exclude = exclude;
        
        if(this.exclude == null){
            this.exclude = new ArrayList<>();
        }
    }

    public void setExclude(ArrayList<Integer> exclude) {
        this.exclude = exclude;
    }

    @Override
    public Alvara change(Alvara input) {
        if (input.getNumeroDoAlvara().matches("\\d+")) {
            if (!exclude.contains(Integer.parseInt(input.getNumeroDoAlvara()))) {
                return input;
            }
        }
        
        return null;
    }

    @Override
    public int getStatus() {
        return RUNNING;
    }
    
}
