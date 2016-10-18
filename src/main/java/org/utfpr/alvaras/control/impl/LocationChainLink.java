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
public class LocationChainLink extends ResponsibilityChain<Alvara> {

    @Override
    public Alvara change(Alvara input) {
        //Latitude Longitude padrão para prova de conceito.
        //para obter atraves de pesquisa ver: https://developers.google.com/maps/documentation/geocoding/intro?hl=pt-br

        input.getEndereco().setLatitude(-25.4388258);
        input.getEndereco().setLongitude(-49.2687522);

        return input;
    }

}
