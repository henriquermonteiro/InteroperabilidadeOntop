/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author henrique
 */
public class Category {

    private final HashMap<String, String> mapping;

    public final static String getDefaultMappingAsJSON() {
        String json =   "{ \"mapping\" : { "
                        + "\"ACOUGUE\" : ["
                                    + "\"ACOU\" , \"ACOUEGUE\" , \"ACOUG\" , \"ACOUGU\" , \"ACOUGUE\" , \"AÇOUGUES\" , \"OUGUE\" ] , "
                        + "\"ACUCAR\" : ["
                                    + "\"ACUCAR\" , \"AÇÚCAR\" ] , "
                        + "\"ALHO\" : ["
                                    + "\"ALHO\" ] , "
                        + "\"ALIMENTICIO\" : [ "
                                    + "\"ALI\" , \"ALIM\" , \"ALIME\" , \"ALIMEN\" , \"ALIMENT\" , \"ALIMENTAÇÃO\" , \"ALIMENTI\" , \"ALIMENTIC\" , \"ALIMENTICI\" , \"ALIMENTICIAS\" , \"ALIMENTÍCIAS\" , \"ALIMENTICIO\" , \"ALIMENTICIOS\" , \"ALIMENTÍCIOS\" , \"ALIMENTOS\" ] , "
                        + "\"AMIDO\" : [ "
                                    + "\"AMIDOS\" ] , "
                        + "\"ARROZ\" : [ "
                                    + "\"ARROZ\" ] , "
                        + "\"ASSADO\" : [ "
                                    + "\"ASSA\" , \"ASSAD\" , \"ASSADA\" , \"ASSADAS\" , \"ASSADDS\" , \"ASSADO\" , \"ASSADOS\" ] , "
                        + "\"BANANA\" : [ "
                                    + "\"BANANAS\" ] , "
                        + "\"BAR\" : [ "
                                    + "\"BAR\" , \"BARES\" , \"BOTEQUIM\" ] , "
                        + "\"BATATA\" : [ "
                                    + "\"BATATA\" , \"BATATAS\" ] , "
                        + "\"BEBIDA\" : [ "
                                    + "\"BEB\" , \"BEBI\" , \"BEBID\" , \"BEBIDA\" , \"BEBIDAS\" ] , "
                        + "\"BOATE\" : [ "
                                    + "\"BOATE\" ] , "
                        + "\"BOLACHA\" : [ "
                                    + "\"BISC\" , \"BISCOIT\" , \"BISCOITO\" , \"BISCOITOS\" , \"BOLACHAS\" ] , "
                        + "\"BOLO\" : [ "
                                    + "\"BOLOS\" ] , "
                        + "\"BOMBONIERI\" : [ "
                                    + "\"BOMBO\" , \"BOMBOM\" , \"BOMBON\" , \"BOMBONIE\" , \"BOMBONIEIRE\" , \"BOMBONIERE\" , \"BOMBONIERI\" ] , "
                        + "\"BOMBOM\" : [ "
                                    + "\"BOMBONS\" ] , "
                        + "\"BOVINO\" : [ "
                                    + "\"BOV\" , \"BOVINAS\" , \"BOVINO\" , \"BOVINOS\" ] , "
                        + "\"BUFFET\" : [ "
                                    + "\"BUF\" , \"BUFFE\" , \"BUFFET\" ] , "
                        + "\"CACAU\" : [ "
                                    + "\"CACAU\" ] , "
                        + "\"CAFETERIA\" : [ "
                                    + "\"CAFE\" , \"CAFÉ\" , \"CAFET\" , \"CAFETER\" , \"CAFETERIA\" ] , "
                        + "\"CANTINA\" : [ "
                                    + "\"CANT\" , \"CANTIN\" , \"CANTINA\" , \"CANTINAS\" ] , "
                        + "\"CARNE\" : [ "
                                    + "\"CARN\" , \"CARNE\" , \"CARNES\" ] , "
                        + "\"CEREAL\" : [ "
                                    + "\"CERE\" , \"CEREA\" , \"CEREAI\" , \"CEREAIS\" ] , "
                        + "\"CERVEJA\" : [ "
                                    + "\"CERV\" , \"CERVERVEJA\" , \"CERVERVEJAS\" ] , "
                        + "\"CHA\" : [ "
                                    + "\"CHA\" , \"CHÁ\" , \"CHÁS\" ] , "
                        + "\"CHOCOLATE\" : [ "
                                    + "\"CHO\" , \"CHOC\" , \"CHOCOL\" , \"CHOCOLATE\" , \"CHOCOLATES\" ] , "
                        + "\"CHOPE\" : [ "
                                    + "\"CHOP\" , \"CHOPE\" , \"CHOPES\" , \"CHOPP\" ] , "
                        + "\"CHOPARIA\" : [ "
                                    + "\"CHOPARIA\" ] , "
                        + "\"CHURRASCARIA\" : [ "
                                    + "\"CHUR\" , \"CHURR\" , \"CHURRASC\" , \"CHURRASCARIA\" ] , "
                        + "\"CHURROS\" : [ "
                                    + "\"CHURROS\" ] , "
                        + "\"CONDIMENTO\" : [ "
                                    + "\"CONDIM\" , \"CONDIMENTOS\" ] , "
                        + "\"CONFEITARIA\" : [ "
                                    + "\"CONFEI\" , \"CONFEIT\" , \"CONFEITA\" , \"CONFEITADOS\" , \"CONFEITAR\" , \"CONFEITARI\" , \"CONFEITARIA\" , \"CONFEITOS\" ] , "
                        + "\"DOCE\" : [ "
                                    + "\"DOCES\" ] , " 
                        + "\"FARMACIA\" : [ " 
                                    + "\"DROG\" , \"DROGA\" , \"DROGARIA\" , \"DROGAS\" ] , " 
                        + "\"ESPETINHO\" : [ " 
                                    + "\"ESPETINHO\" ] , " 
                        + "\"FARINHA\" : [ " 
                                    + "\"FARINHA\" , \"FARINHAS\" ] , " 
                        + "\"FEIJAO\" : [ " 
                                    + "\"FEIJÃO\" ] , " 
                        + "\"FRANGO\" : [ " 
                                    + "\"FRAN\" , \"FRANG\" , \"FRANGO\" , \"FRANGOS\" ] , " 
                        + "\"FRIGORIFICO\" : [ " 
                                    + "\"FRIGOR\" , \"FRIGORIF\" , \"FRIGORÍFICO\" , \"FRIGORIFICOS\" ] , " 
                        + "\"FRUTARIA\" : [ " 
                                    + "\"FRUTAR\" , \"FRUTARIA\" ] , " 
                        + "\"HAMBURGER\" : [ " 
                                    + "\"HAMBURGER\" ] , " 
                        + "\"HORTALICA\" : [ " 
                                    + "\"HOR\" , \"HORT\" , \"HORTAL\" , \"HORTALICAS\" , \"HORTALIÇAS\" ] , " 
                        + "\"HORTIFRUTIGRANJEIRO\" : [ " 
                                    + "\"HORTI\" , \"HORTIF\" , \"HORTIFR\" , \"HORTIFRITIGRANJEIRO\" , \"HORTIFRU\" , \"HORTIFRUT\" , \"HORTIFRUTI\" , \"HORTIFRUTIG\" , \"HORTIFRUTIGR\" , \"HORTIFRUTIGRA\" , \"HORTIFRUTIGRAN\" , \"HORTIFRUTIGRANJ\" , \"HORTIFRUTIGRANJE\" , \"HORTIFRUTIGRANJEI\" , \"HORTIFRUTIGRANJEIR\" , \"HORTIFRUTIGRANJEIROS\" , \"HORTIFRUTIGRANJEIU\" , \"HORTIFRUTUGRANJEIR\" , \"HORTIFUTIGRANJ\" , \"HOTIFRUTIGRANJEIROS\" , \"OTIFRUTIGRANJ\" ] , " 
                        + "\"HORTIGRANJEIRO\" : [ " 
                                    + "\"HORTIG\" , \"HORTIGR\" , \"HORTIGRA\" , \"HORTIGRAN\" , \"HORTIGRANJ\" , \"HORTIGRANJE\" , \"HORTIGRANJEI\" , \"HORTIGRANJEIR\" , \"HORTIGRANJEIRO\" , \"HORTIGRANJEIROS\" , \"HORTINGRANJEIROS\" , \"ORTIGR\" ] , " 
                        + "\"KREPS\" : [ " 
                                    + "\"KEEPS\" , \"KREPS\" ] , " 
                        + "\"LACTICINIO\" : [ " 
                                    + "\"LACTICINIOS\" , \"LATC\" , \"LATCINI\" , \"LATIC\" , \"LATICINI\" , \"LATICINIO\" , \"LATICINIOS\" , \"LATICÍNIOS\" , \"LTICINIOS\" , \"QUEIJ\" , \"QUEIJO\" ] , " 
                        + "\"LANCHONETE\" : [ " 
                                    + "\"LACH\" , \"LANC\" , \"LANCH\" , \"LANCHES\" , \"LANCHOENTE\" , \"LANCHON\" , \"LANCHONET\" , \"LANCHONETE\" , \"LANCHONETES\" , \"LONCHONETE\" ] , " 
                        + "\"LEGUME\" : [ " 
                                    + "\"LEG\" , \"LEGM\" , \"LEGU\" , \"LEGUM\" , \"LEGUME\" , \"LEGUMES\" , \"LEGUMINOSAS\" ] , " 
                        + "\"MANDIOCA\" : [ " 
                                    + "\"MANDIOCA\" ] , " 
                        + "\"MANGA\" : [ " 
                                    + "\"MANGA\" ] , " 
                        + "\"MARACUJA\" : [ " 
                                    + "\"MARACUJÁ\" ] , " 
                        + "\"MARMITA\" : [ " 
                                    + "\"MARMITAS\" ] , " 
                        + "\"MERCEARIA\" : [ " 
                                    + "\"MERCE\" , \"MERCEA\" , \"MERCEAIRA\" , \"MERCEAIRIA\" , \"MERCEAR\" , \"MERCEARI\" , \"MERCEARIA\" , \"MERCERIA\" , \"MERECEARIA\" ] , " 
                        + "\"MILHO\" : [ " 
                                    + "\"MILHO\" ] , " 
                        + "\"MORANGO\" : [ " 
                                    + "\"MORANGO\" ] , " 
                        + "\"PADARIA\" : [ " 
                                    + "\"PADARIA\" , \"PANI\" , \"PANIF\" , \"PANIFI\" , \"PANIFIC\" , \"PANIFICA\" , \"PANIFICACAO\" , \"PANIFICAÇÃO\" , \"PANIFICAD\" , \"PANIFICADOR\" , \"PANIFICADORA\" ] , " 
                        + "\"PALMITO\" : [ " 
                                    + "\"PALMITO\" ] , " 
                        + "\"PASTELARIA\" : [ " 
                                    + "\"PASTE\" , \"PASTEL\" , \"PASTELA\" , \"PASTELAR\" , \"PASTELARIA\" ] , " 
                        + "\"PEIXARIA\" : [ " 
                                    + "\"PEIX\" , \"PEIXARIA\" , \"PEIXE\" , \"PERCADO\" , \"PERCADOS\" ] , " 
                        + "\"PETISCARIA\" : [ " 
                                    + "\"PET\" , \"PETIS\" , \"PETISC\" , \"PETISCA\" , \"PETISCAR\" , \"PETISCARIA\" ] , " 
                        + "\"PIPOCA\" : [ " 
                                    + "\"PIP\" , \"PIPOC\" , \"PIPOCA\" , \"PIPOCAS\" ] , " 
                        + "\"PIZZARIA\" : [ " 
                                    + "\"PIZ\" , \"PIZZ\" , \"PIZZAR\" , \"PIZZARI\" , \"PIZZARIA\" , \"PIZZAS\" ] , " 
                        + "\"QUITANDA\" : [ " 
                                    + "\"QUIT\" , \"QUITAND\" , \"QUITANDA\" ] , " 
                        + "\"REFEITORIO\" : [ " 
                                    + "\"REF\" , \"REFEI\" , \"REFEIC\" , \"REFEICAO\" , \"REFEICOE\" , \"REFEICOES\" , \"REFEITORIO\" , \"REFEITÓRIO\" ] , " 
                        + "\"REFRIGERANTE\" : [ " 
                                    + "\"REFRI\" , \"REFRIGERAN\" , \"REFRIGERANT\" , \"REFRIGERANTES\" ] , " 
                        + "\"RESTAURANTE\" : [ " 
                                    + "\"REST\" , \"RESTA\" , \"RESTAU\" , \"RESTAUR\" , \"RESTAURANTE\" , \"RESTAURANTES\" , \"RETAURANTE\" ] , " 
                        + "\"ROTICERIA\" : [ " 
                                    + "\"ROT\" , \"ROTIC\" , \"ROTICE\" , \"ROTICER\" , \"ROTICERIA\" ] , " 
                        + "\"SALGADO\" : [ " 
                                    + "\"SALG\" , \"SALGAD\" , \"SALGADINHOS\" , \"SALGADO\" , \"SALGADOS\" ] , " 
                        + "\"SORVETERIA\" : [ " 
                                    + "\"GELADOS\" , \"SOR\" , \"SORV\" , \"SORVE\" , \"SORVET\" , \"SORVETE\" , \"SORVETER\" , \"SORVETERIA\" , \"SORVETES\" , \"SOVETERIA\" ] , " 
                        + "\"SUPERMERCADO\" : [ " 
                                    + "\"SUPERM\" , \"SUPERMERC\" , \"SUPERMERCADO\" ] "
                        + "} }";

        return json;
    }

    public Category(File categoryMapping) {
        StringBuilder json = new StringBuilder();
        try{
            if(categoryMapping.exists() && categoryMapping.isFile()){
                BufferedReader reader = new BufferedReader(new FileReader(categoryMapping));

                String line;

                while((line = reader.readLine()) != null){
                    json.append(line);
                }
            }
        }catch(IOException ex){
            System.err.println("Eror found while reading file. The default category will be used.");
            json = new StringBuilder();
        }
        
        if(json.length() == 0){
            json.append(getDefaultMappingAsJSON());
        }
        
        JSONObject jsonRoot = new JSONObject(json.toString());
        
        mapping = new HashMap<>();
        
        for(String elm : jsonRoot.getJSONObject("mapping").keySet()){
            for(Object s : jsonRoot.getJSONObject("mapping").getJSONArray(elm)){
                mapping.put(s.toString(), elm);
            }
        }
    }

    public String checkCategoryForString(String inputS) {
        return mapping.get(inputS);
    }
}
