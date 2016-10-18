/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class GeocodingChainLink extends ResponsibilityChain<Alvara>{
    private Long counter;
    private final GeoApiContext context;
    
    public GeocodingChainLink(String API_KEY) {
        this.counter = 0l;
        context = new GeoApiContext().setApiKey(API_KEY);
    }

    public Long getCounter() {
        return counter;
    }

    @Override
    public Alvara change(Alvara input) {
        if(input.getClassificacoes().isEmpty()){
            return input;
        }
        
        GeocodingApiRequest req = GeocodingApi.newRequest(context).address(input.getEndereco().toSearchString());
        GeocodingResult[] res;
        try{
            res = req.await();
            
            if(res.length > 0){
                LatLng latlong = res[0].geometry.location;
                
                input.getEndereco().setLatitude(latlong.lat);
                input.getEndereco().setLongitude(latlong.lng);
                
                counter++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return input;
    }
    
}
