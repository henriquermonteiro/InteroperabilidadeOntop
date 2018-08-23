/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class BingGeocoding extends ResponsibilityChain<Alvara>{
    private final String API_KEY;
    
    public BingGeocoding(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    @Override
    public Alvara change(Alvara input) {
        if(input.getClassificacoes().isEmpty()){
            return input;
        }
        
        if(input.getEndereco().getLongitude() <= 180 && input.getEndereco().getLongitude() >= -180 && input.getEndereco().getLatitude() <= 90 && input.getEndereco().getLatitude() >= -90){
            return input;
        }
        
        try{
            URL url = new URL("http://dev.virtualearth.net/REST/v1/Locations?"+input.getEndereco().toBingSearchString() + "&key=" + API_KEY);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            
            int responseCode = connection.getResponseCode();
            
            if(responseCode == 200){
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                
                String line;
                StringBuilder content = new StringBuilder("");
                
                while((line = reader.readLine()) != null){
                    content.append(line);
                }
                
                reader.close();
                connection.disconnect();
                
                JSONObject json = new JSONObject(content.toString());
                
                if(json.get("statusCode").equals(200)){
                    JSONArray resources = ((JSONObject)json.getJSONArray("resourceSets").get(0)).getJSONArray("resources");
                    
                    String confidence = "";
                    
                    for(Object res : resources){
                        JSONObject axR = ((JSONObject)res).getJSONObject("point");
                        
                        if(axR.get("type").equals("Point")){
                            JSONArray coord = axR.getJSONArray("coordinates");
                            
                            input.getEndereco().setLatitude(coord.getDouble(0));
                            input.getEndereco().setLongitude(coord.getDouble(1));
                            
                            break;
                        }
                    }
                }
            }
        }catch(IOException ex){}
        
        return input;
    }
    
}
