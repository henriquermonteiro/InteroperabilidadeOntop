/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.io.File;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class ClassifyChainLink extends ResponsibilityChain<Alvara> {

    private final Category category;
    private int count;

    public ClassifyChainLink() {
        category = new Category(new File(""));
        
        count = 0;
    }
    
    private void changeStep(Alvara input, String[] activities_keyword){
        boolean flag = false;
        
        for (String keyword : activities_keyword) {
            String cat = category.checkCategoryForString(keyword);

            if (cat != null) {
                if (!input.getClassificacoes().contains(cat)) {
                    input.getClassificacoes().add(cat);
                }
                
                flag = true;
            }
        }
        
        if(flag){
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    @Override
    public Alvara change(Alvara input) {
        String[] activities_keyword = input.getAtividadePrincipal().split(" ");
        changeStep(input, activities_keyword);
        
        activities_keyword = input.getAtividadeSecundaria().split(" ");
        changeStep(input, activities_keyword);
        
        activities_keyword = input.getAtividadeSecundaria2().split(" ");
        changeStep(input, activities_keyword);
        
        return input;
    }

}
