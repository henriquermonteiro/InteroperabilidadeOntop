/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control;

import org.utfpr.alvaras.control.impl.*;
import org.utfpr.alvaras.gui.MainFrame;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class Choreographer {

    public static ResponsibilityChain<Alvara> getDictionaryChain() {
        ToUpperChainLink toUpp = new ToUpperChainLink();
        ReplacerChainLink replacer = new ReplacerChainLink();
        TrimChainLink trimer = new TrimChainLink();
        DictionaryBuilderLink dic = new DictionaryBuilderLink();

        trimer.addLink(dic);
        replacer.addLink(trimer);
        toUpp.addLink(replacer);

        return toUpp;
    }

    public static ResponsibilityChain<Alvara> getExecutionChain(String googleApiKey, String bingApiKey, String postgreURL, String postgreUser, String postgrePW, MainFrame frame) {
        FilterChainLink filter = new FilterChainLink();
        ToUpperChainLink toUpp = new ToUpperChainLink();
        ReplacerChainLink replacer = new ReplacerChainLink();
        ClassifyChainLink classify = new ClassifyChainLink();
        GeocodingChainLink ggeo = new GeocodingChainLink(googleApiKey, frame);
        BingGeocoding bgeo = new BingGeocoding(bingApiKey, frame);
        GISExporter gisExp = new GISExporter(postgreURL, postgreUser, postgrePW);
        
        filter.setExclude(gisExp.getRecordedAlvaras());
        
        bgeo.addLink(gisExp);
        ggeo.addLink(bgeo);
        classify.addLink(ggeo);
        replacer.addLink(classify);
        toUpp.addLink(replacer);
        filter.addLink(toUpp);

        return filter;
    }
}
