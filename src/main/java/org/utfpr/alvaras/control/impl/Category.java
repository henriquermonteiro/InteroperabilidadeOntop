/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.util.HashMap;

/**
 *
 * @author henrique
 */
public class Category {
    private final HashMap<String, String> mapping;

    public Category() {
        mapping = new HashMap<>();
        
        String category = "ACOUGUE";
        mapping.put("ACOU", category);
        mapping.put("ACOUEGUE", category);
        mapping.put("ACOUG", category);
        mapping.put("ACOUGU", category);
        mapping.put("ACOUGUE", category);
        mapping.put("AÇOUGUES", category);
        mapping.put("OUGUE", category);
        
        category = "ACUCAR";
        mapping.put("ACUCAR", category);
        mapping.put("AÇÚCAR", category);
        
        category = "ALHO";
        mapping.put("ALHO", category);
        
        category = "ALIMENTICIO";
        mapping.put("ALI", category);
        mapping.put("ALIM", category);
        mapping.put("ALIME", category);
        mapping.put("ALIMEN", category);
        mapping.put("ALIMENT", category);
        mapping.put("ALIMENTAÇÃO", category);
        mapping.put("ALIMENTI", category);
        mapping.put("ALIMENTIC", category);
        mapping.put("ALIMENTICI", category);
        mapping.put("ALIMENTICIAS", category);
        mapping.put("ALIMENTÍCIAS", category);
        mapping.put("ALIMENTICIO", category);
        mapping.put("ALIMENTICIOS", category);
        mapping.put("ALIMENTÍCIOS", category);
        mapping.put("ALIMENTOS", category);
        
        category = "AMIDO";
        mapping.put("AMIDOS", category);
        
        category = "ARROZ";
        mapping.put("ARROZ", category);
        
        category = "ASSADO";
        mapping.put("ASSA", category);
        mapping.put("ASSAD", category);
        mapping.put("ASSADA", category);
        mapping.put("ASSADAS", category);
        mapping.put("ASSADDS", category);
        mapping.put("ASSADO", category);
        mapping.put("ASSADOS", category);
        
        category = "BANANA";
        mapping.put("BANANAS", category);
        
        category = "BAR";
        mapping.put("BAR", category);
        mapping.put("BARES", category);
        mapping.put("BOTEQUIM", category);
        
        category = "BATATA";
        mapping.put("BATATA", category);
        mapping.put("BATATAS", category);
        
        category = "BEBIDA";
        mapping.put("BEB", category);
        mapping.put("BEBI", category);
        mapping.put("BEBID", category);
        mapping.put("BEBIDA", category);
        mapping.put("BEBIDAS", category);
        
        category = "BOATE";
        mapping.put("BOATE", category);
        
        category = "BOLACHA";
        mapping.put("BISC", category);
        mapping.put("BISCOIT", category);
        mapping.put("BISCOITO", category);
        mapping.put("BISCOITOS", category);
        mapping.put("BOLACHAS", category);
        
        category = "BOLO";
        mapping.put("BOLOS", category);
        
        category = "BOMBONIERI";
        mapping.put("BOMBO", category);
        mapping.put("BOMBOM", category);
        mapping.put("BOMBON", category);
        mapping.put("BOMBONIE", category);
        mapping.put("BOMBONIEIRE", category);
        mapping.put("BOMBONIERE", category);
        mapping.put("BOMBONIERI", category);
        
        category = "BOMBOM";
        mapping.put("BOMBONS", category);
        
        category = "BOVINO";
        mapping.put("BOV", category);
        mapping.put("BOVINAS", category);
        mapping.put("BOVINO", category);
        mapping.put("BOVINOS", category);
        
        category = "BUFFET";
        mapping.put("BUF", category);
        mapping.put("BUFFE", category);
        mapping.put("BUFFET", category);
        
        category = "CACAU";
        mapping.put("CACAU", category);
        
        category = "CAFETERIA";
        mapping.put("CAFE", category);
        mapping.put("CAFÉ", category);
        mapping.put("CAFET", category);
        mapping.put("CAFETER", category);
        mapping.put("CAFETERIA", category);
        
        category = "CANTINA";
        mapping.put("CANT", category);
        mapping.put("CANTIN", category);
        mapping.put("CANTINA", category);
        mapping.put("CANTINAS", category);
        
        category = "CARNE";
        mapping.put("CARN", category);
        mapping.put("CARNE", category);
        mapping.put("CARNES", category);
        
        category = "CEREAL";
        mapping.put("CERE", category);
        mapping.put("CEREA", category);
        mapping.put("CEREAI", category);
        mapping.put("CEREAIS", category);
        
        category = "CERVEJA";
        mapping.put("CERV", category);
        mapping.put("CERVERVEJA", category);
        mapping.put("CERVERVEJAS", category);
        
        category = "CHA";
        mapping.put("CHA", category);
        mapping.put("CHÁ", category);
        mapping.put("CHÁS", category);
        
        category = "CHOCOLATE";
        mapping.put("CHO", category);
        mapping.put("CHOC", category);
        mapping.put("CHOCOL", category);
        mapping.put("CHOCOLATE", category);
        mapping.put("CHOCOLATES", category);
        
        category = "CHOPE";
        mapping.put("CHOP", category);
        mapping.put("CHOPE", category);
        mapping.put("CHOPES", category);
        mapping.put("CHOPP", category);
        
        category = "CHOPARIA";
        mapping.put("CHOPARIA", category);
        
        category = "CHURRASCARIA";
        mapping.put("CHUR", category);
        mapping.put("CHURR", category);
        mapping.put("CHURRASC", category);
        mapping.put("CHURRASCARIA", category);
        
        category = "CHURROS";
        mapping.put("CHURROS", category);
        
        category = "CONDIMENTO";
        mapping.put("CONDIM", category);
        mapping.put("CONDIMENTOS", category);
        
        category = "CONFEITARIA";
        mapping.put("CONFEI", category);
        mapping.put("CONFEIT", category);
        mapping.put("CONFEITA", category);
        mapping.put("CONFEITADOS", category);
        mapping.put("CONFEITAR", category);
        mapping.put("CONFEITARI", category);
        mapping.put("CONFEITARIA", category);
        mapping.put("CONFEITOS", category);
        
        category = "DOCE";
        mapping.put("DOCES", category);
        
        category = "FARMACIA";
        mapping.put("DROG", category);
        mapping.put("DROGA", category);
        mapping.put("DROGARIA", category);
        mapping.put("DROGAS", category);
        
        category = "ESPETINHO";
        mapping.put("ESPETINHO", category);
        
        category = "FARINHA";
        mapping.put("FARINHA", category);
        mapping.put("FARINHAS", category);
        
        category = "FEIJAO";
        mapping.put("FEIJÃO", category);
        
        category = "FRANGO";
        mapping.put("FRAN", category);
        mapping.put("FRANG", category);
        mapping.put("FRANGO", category);
        mapping.put("FRANGOS", category);
        
        category = "FRIGORIFICO";
        mapping.put("FRIGOR", category);
        mapping.put("FRIGORIF", category);
        mapping.put("FRIGORÍFICO", category);
        mapping.put("FRIGORIFICOS", category);
        
        category = "FRUTARIA";
        mapping.put("FRUTAR", category);
        mapping.put("FRUTARIA", category);
        
        category = "HAMBURGER";
        mapping.put("HAMBURGER", category);
        
        category = "HORTALICA";
        mapping.put("HOR", category);
        mapping.put("HORT", category);
        mapping.put("HORTAL", category);
        mapping.put("HORTALICAS", category);
        mapping.put("HORTALIÇAS", category);
        
        category = "HORTIFRUTIGRANJEIRO";
        mapping.put("HORTI", category);
        mapping.put("HORTIF", category);
        mapping.put("HORTIFR", category);
        mapping.put("HORTIFRITIGRANJEIRO", category);
        mapping.put("HORTIFRU", category);
        mapping.put("HORTIFRUT", category);
        mapping.put("HORTIFRUTI", category);
        mapping.put("HORTIFRUTIG", category);
        mapping.put("HORTIFRUTIGR", category);
        mapping.put("HORTIFRUTIGRA", category);
        mapping.put("HORTIFRUTIGRAN", category);
        mapping.put("HORTIFRUTIGRANJ", category);
        mapping.put("HORTIFRUTIGRANJE", category);
        mapping.put("HORTIFRUTIGRANJEI", category);
        mapping.put("HORTIFRUTIGRANJEIR", category);
        mapping.put("HORTIFRUTIGRANJEIROS", category);
        mapping.put("HORTIFRUTIGRANJEIU", category);
        mapping.put("HORTIFRUTUGRANJEIR", category);
        mapping.put("HORTIFUTIGRANJ", category);
        mapping.put("HOTIFRUTIGRANJEIROS", category);
        mapping.put("OTIFRUTIGRANJ", category);
        
        category = "HORTIGRANJEIRO";
        mapping.put("HORTIG", category);
        mapping.put("HORTIGR", category);
        mapping.put("HORTIGRA", category);
        mapping.put("HORTIGRAN", category);
        mapping.put("HORTIGRANJ", category);
        mapping.put("HORTIGRANJE", category);
        mapping.put("HORTIGRANJEI", category);
        mapping.put("HORTIGRANJEIR", category);
        mapping.put("HORTIGRANJEIRO", category);
        mapping.put("HORTIGRANJEIROS", category);
        mapping.put("HORTINGRANJEIROS", category);
        mapping.put("ORTIGR", category);
        
        category = "KREPS";
        mapping.put("KEEPS", category);
        mapping.put("KREPS", category);
        
        category = "LACTICINIO";
        mapping.put("LACTICINIOS", category);
        mapping.put("LATC", category);
        mapping.put("LATCINI", category);
        mapping.put("LATIC", category);
        mapping.put("LATICINI", category);
        mapping.put("LATICINIO", category);
        mapping.put("LATICINIOS", category);
        mapping.put("LATICÍNIOS", category);
        mapping.put("LTICINIOS", category);
        mapping.put("QUEIJ", category);
        mapping.put("QUEIJO", category);
        
        category = "LANCHONETE";
        mapping.put("LACH", category);
        mapping.put("LANC", category);
        mapping.put("LANCH", category);
        mapping.put("LANCHES", category);
        mapping.put("LANCHOENTE", category);
        mapping.put("LANCHON", category);
        mapping.put("LANCHONET", category);
        mapping.put("LANCHONETE", category);
        mapping.put("LANCHONETES", category);
        mapping.put("LONCHONETE", category);
        
        category = "LEGUME";
        mapping.put("LEG", category);
        mapping.put("LEGM", category);
        mapping.put("LEGU", category);
        mapping.put("LEGUM", category);
        mapping.put("LEGUME", category);
        mapping.put("LEGUMES", category);
        mapping.put("LEGUMINOSAS", category);
        
        category = "MANDIOCA";
        mapping.put("MANDIOCA", category);
        
        category = "MANGA";
        mapping.put("MANGA", category);
        
        category = "MARACUJA";
        mapping.put("MARACUJÁ", category);
        
        category = "MARMITA";
        mapping.put("MARMITAS", category);
        
        category = "MERCEARIA";
        mapping.put("MERCE", category);
        mapping.put("MERCEA", category);
        mapping.put("MERCEAIRA", category);
        mapping.put("MERCEAIRIA", category);
        mapping.put("MERCEAR", category);
        mapping.put("MERCEARI", category);
        mapping.put("MERCEARIA", category);
        mapping.put("MERCERIA", category);
        mapping.put("MERECEARIA", category);
        
        category = "MILHO";
        mapping.put("MILHO", category);
        
        category = "MORANGO";
        mapping.put("MORANGO", category);
        
        category = "PADARIA";
        mapping.put("PADARIA", category);
        mapping.put("PANI", category);
        mapping.put("PANIF", category);
        mapping.put("PANIFI", category);
        mapping.put("PANIFIC", category);
        mapping.put("PANIFICA", category);
        mapping.put("PANIFICACAO", category);
        mapping.put("PANIFICAÇÃO", category);
        mapping.put("PANIFICAD", category);
        mapping.put("PANIFICADOR", category);
        mapping.put("PANIFICADORA", category);
        
        category = "PALMITO";
        mapping.put("PALMITO", category);
        
        category = "PASTELARIA";
        mapping.put("PASTE", category);
        mapping.put("PASTEL", category);
        mapping.put("PASTELA", category);
        mapping.put("PASTELAR", category);
        mapping.put("PASTELARIA", category);
        
        category = "PEIXARIA";
        mapping.put("PEIX", category);
        mapping.put("PEIXARIA", category);
        mapping.put("PEIXE", category);
        mapping.put("PERCADO", category);
        mapping.put("PERCADOS", category);
        
        category = "PETISCARIA";
        mapping.put("PET", category);
        mapping.put("PETIS", category);
        mapping.put("PETISC", category);
        mapping.put("PETISCA", category);
        mapping.put("PETISCAR", category);
        mapping.put("PETISCARIA", category);
        
        category = "PIPOCA";
        mapping.put("PIP", category);
        mapping.put("PIPOC", category);
        mapping.put("PIPOCA", category);
        mapping.put("PIPOCAS", category);
        
        category = "PIZZARIA";
        mapping.put("PIZ", category);
        mapping.put("PIZZ", category);
        mapping.put("PIZZAR", category);
        mapping.put("PIZZARI", category);
        mapping.put("PIZZARIA", category);
        mapping.put("PIZZAS", category);
        
        category = "QUITANDA";
        mapping.put("QUIT", category);
        mapping.put("QUITAND", category);
        mapping.put("QUITANDA", category);
        
        category = "REFEITORIO";
        mapping.put("REF", category);
        mapping.put("REFEI", category);
        mapping.put("REFEIC", category);
        mapping.put("REFEICAO", category);
        mapping.put("REFEICOE", category);
        mapping.put("REFEICOES", category);
        mapping.put("REFEITORIO", category);
        mapping.put("REFEITÓRIO", category);
        
        category = "REFRIGERANTE";
        mapping.put("REFRI", category);
        mapping.put("REFRIGERAN", category);
        mapping.put("REFRIGERANT", category);
        mapping.put("REFRIGERANTES", category);
        
        category = "RESTAURANTE";
        mapping.put("REST", category);
        mapping.put("RESTA", category);
        mapping.put("RESTAU", category);
        mapping.put("RESTAUR", category);
        mapping.put("RESTAURANTE", category);
        mapping.put("RESTAURANTES", category);
        mapping.put("RETAURANTE", category);
        
        category = "ROTICERIA";
        mapping.put("ROT", category);
        mapping.put("ROTIC", category);
        mapping.put("ROTICE", category);
        mapping.put("ROTICER", category);
        mapping.put("ROTICERIA", category);
        
        category = "SALGADO";
        mapping.put("SALG", category);
        mapping.put("SALGAD", category);
        mapping.put("SALGADINHOS", category);
        mapping.put("SALGADO", category);
        mapping.put("SALGADOS", category);
        
        category = "SORVETERIA";
        mapping.put("GELADOS", category);
        mapping.put("SOR", category);
        mapping.put("SORV", category);
        mapping.put("SORVE", category);
        mapping.put("SORVET", category);
        mapping.put("SORVETE", category);
        mapping.put("SORVETER", category);
        mapping.put("SORVETERIA", category);
        mapping.put("SORVETES", category);
        mapping.put("SOVETERIA", category);
        
        category = "SUPERMERCADO";
        mapping.put("SUPERM", category);
        mapping.put("SUPERMERC", category);
        mapping.put("SUPERMERCADO", category);
        
    }
    
    public String checkCategoryForString(String inputS){
        return mapping.get(inputS);
    }
}
