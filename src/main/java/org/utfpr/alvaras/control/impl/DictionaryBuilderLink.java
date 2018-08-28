/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;
import org.utfpr.util.Tuple;

/**
 *
 * @author henrique
 */
public class DictionaryBuilderLink extends ResponsibilityChain<Alvara> {

    private HashMap<String, Tuple<Integer, ArrayList<String>>> dictionary;

    public DictionaryBuilderLink() {
        dictionary = new HashMap<>();
    }

    private void processString(String inputString) {
        String[] splited = inputString.split(" ");

        for (String s : splited) {
            if (s.isEmpty()) {
                continue;
            }
            
            if (dictionary.get(s) == null) {
                ArrayList<String> array = new ArrayList<>();
                if (!array.contains(inputString)) {
                    array.add(inputString);
                }
                dictionary.put(s, new Tuple(1, array));
            } else {
                Tuple<Integer, ArrayList<String>> tuple = dictionary.get(s);
                tuple.setT(tuple.getT() + 1);
                ArrayList<String> array = tuple.getU();

                if (!array.contains(inputString)) {
                    array.add(inputString);
                }

                dictionary.put(s, tuple);
            }
        }
    }

    @Override
    public Alvara change(Alvara input) {
        processString(input.getAtividadePrincipal());
        processString(input.getAtividadeSecundaria());
        processString(input.getAtividadeSecundaria2());

        return input;
    }

    public void printDictionary() {
        for (String key : dictionary.keySet()) {
            System.out.println(key + ";" + dictionary.get(key).getT() + ";" + dictionary.get(key).getU());
        }
    }

    public void saveDictionary(FileOutputStream fos) throws IOException {
        DataOutputStream dos = new DataOutputStream(fos);

        for (String key : dictionary.keySet()) {
            dos.writeChars(key + ";" + dictionary.get(key).getT() + ";" + dictionary.get(key).getU() + "\n");
        }
    }

    @Override
    public int getStatus() {
        return RUNNING;
    }

}
