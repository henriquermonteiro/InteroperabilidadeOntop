/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control;

import java.util.Calendar;
import java.util.GregorianCalendar;
import org.utfpr.alvaras.model.Endereco;

/**
 *
 * @author henrique
 */
public class Utils {

    public static Calendar getCalendarFor(String string) {
        String[] splited = string.split("/");
        
        if(splited.length == 3){
            return new GregorianCalendar(Integer.parseInt(splited[2]), Integer.parseInt(splited[1]) - 1, Integer.parseInt(splited[0]));
        }
        
        return new GregorianCalendar();
    }

    public static Endereco getEnderecoFor(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
