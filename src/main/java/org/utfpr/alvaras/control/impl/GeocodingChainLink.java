/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.GeocodingApiRequest;
import com.google.maps.errors.OverDailyLimitException;
import com.google.maps.errors.OverQueryLimitException;
import com.google.maps.model.GeocodingResult;
import com.google.maps.model.LatLng;
import java.util.concurrent.TimeUnit;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.gui.MainFrame;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class GeocodingChainLink extends ResponsibilityChain<Alvara>{
    private Long counter;
    private final GeoApiContext context;
    private int currentStatus;
    private MainFrame frame;
    
    public GeocodingChainLink(String API_KEY, MainFrame frame) {
        this.counter = 0l;
        this.frame = frame;
        context = new GeoApiContext().setApiKey(API_KEY);
        context.setConnectTimeout(100, TimeUnit.MILLISECONDS);
        context.setMaxRetries(3);
        currentStatus = UNKOWN;
    }

    public Long getCounter() {
        return counter;
    }

    @Override
    public Alvara change(Alvara input) {
        if(input.getClassificacoes().isEmpty() || currentStatus == UNAVAILABLE){
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
                
                if(frame != null)
                    frame.appendText("Google|Geocoding successfull ID: " + input.getNumeroDoAlvara());
                
                currentStatus = RUNNING;
            }
        }catch(OverDailyLimitException | OverQueryLimitException oEx){
            oEx.printStackTrace();
                
            if(frame != null)
                frame.appendText("Google|Geocoding error ID: " + input.getNumeroDoAlvara());
            
            currentStatus = UNAVAILABLE;
        }catch(Exception e){
            e.printStackTrace();
                
            if(frame != null)
                frame.appendText("Google|Geocoding error ID: " + input.getNumeroDoAlvara());
            
            currentStatus = WEBSERVICE_ERROR;
        }
        
        return input;
    }

    @Override
    public int getStatus() {
        return currentStatus;
    }
    
}
