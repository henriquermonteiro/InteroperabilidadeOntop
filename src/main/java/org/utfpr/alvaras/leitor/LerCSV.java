/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.leitor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import org.utfpr.alvaras.control.Utils;
import org.utfpr.alvaras.control.impl.BingGeocoding;
import org.utfpr.alvaras.control.impl.ClassifyChainLink;
import org.utfpr.alvaras.control.impl.DictionaryBuilderLink;
import org.utfpr.alvaras.control.impl.GISExporter;
import org.utfpr.alvaras.control.impl.GeocodingChainLink;
import org.utfpr.alvaras.control.impl.ReplacerChainLink;
import org.utfpr.alvaras.control.impl.ToUpperChainLink;
import org.utfpr.alvaras.control.impl.TrimChainLink;
import org.utfpr.alvaras.model.Alvara;
import org.utfpr.alvaras.model.Endereco;

/**
 *
 * @author henrique
 */
public class LerCSV {

    public static void main(String... args) {
        FileInputStream fis = null;
//        FileOutputStream fos = null;
        try {
            File f = new File("Alvaras-Base_de_Dados.CSV");
            fis = new FileInputStream(f);
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis, "UTF-8"));

            reader.readLine();
            ArrayList<Alvara> alvaras = ler(reader, null);

            File f_key = new File("googleApiKey.key");
            FileInputStream fKey = new FileInputStream(f_key);
            BufferedReader readerKey = new BufferedReader(new InputStreamReader(fKey));

            String API_KEY = readerKey.readLine();
            
            readerKey.close();
            
            f_key = new File("bingMapsApiKey.key");
            fKey = new FileInputStream(f_key);
            readerKey = new BufferedReader(new InputStreamReader(fKey));
            
            String API_KEY_BING = readerKey.readLine();
            
            readerKey.close();

            f_key = new File("postgis.conf");
            fKey = new FileInputStream(f_key);
            readerKey = new BufferedReader(new InputStreamReader(fKey));

            String URL = readerKey.readLine();

            readerKey.close();

            ClassifyChainLink classify = new ClassifyChainLink();
            GISExporter gisExp = new GISExporter(URL, "user", "1234");
//            GeocodingChainLink geo = new GeocodingChainLink(API_KEY, null);
            BingGeocoding geo = new BingGeocoding(API_KEY_BING, null);
//            DictionaryBuilderLink dic = new DictionaryBuilderLink();
            TrimChainLink trimer = new TrimChainLink();
            ReplacerChainLink replacer = new ReplacerChainLink();
            ToUpperChainLink toUpp = new ToUpperChainLink();

            replacer.addLink(trimer);
//            replacer.addLink(dic);

            replacer.addLink(classify);
            replacer.addLink(geo);
            replacer.addLink(gisExp);

            toUpp.addLink(replacer);

            ArrayList<Integer> list = gisExp.getRecordedAlvaras();

//            int k = 0;
            for (Alvara a : alvaras) {
//                k++;
                if (a.getNumeroDoAlvara().matches("\\d+")) {
                    if (!list.contains(Integer.parseInt(a.getNumeroDoAlvara()))) {
                        toUpp.process(a);
                    }
                }

//                System.out.println(a);
//                
//                if(k >= 10) break;
            }
//            System.out.println("Counted: " + classify.getCount());
//            dic.printDictionary();
//            File f2 = new File("dictionary.csv");
//            fos = new FileOutputStream(f2);
//            
//            dic.saveDictionary(fos);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LerCSV.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LerCSV.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
//                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(LerCSV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static ArrayList<Alvara> ler(BufferedReader reader, JFrame frame) {
        try {
            ArrayList<Alvara> alvaras = new ArrayList<>();

            String s;
            
            int k = 0;

            while ((s = reader.readLine()) != null) {
                String[] splited = s.split(";");

                if (splited.length == 15) {
                    Alvara a = new Alvara();
                    a.setNomeEmpresarial(splited[0]).setDataInicioDeAtividade(Utils.getCalendarFor(splited[1])).setNumeroDoAlvara(splited[2]);
                    a.setDataEmissao(Utils.getCalendarFor(splited[3])).setDataExpiracao(Utils.getCalendarFor(splited[4])).setAtividadePrincipal(splited[5]);
                    a.setAtividadeSecundaria(splited[6]).setAtividadeSecundaria2(splited[7]);

                    Endereco end = new Endereco();
                    end.setLogradouro(splited[8]);
                    end.setNumero(splited[9]);
                    end.setUnidade(splited[10]);
                    end.setAndar(splited[11]);
                    end.setComplemento(splited[12]);
                    end.setBairro(splited[13]);
                    end.setCep(splited[14]);

                    a.setEndereco(end);

                    alvaras.add(a);
                    
                    if(frame != null){
                        frame.setTitle(++k + " registros encontrados  ");
                    }
                }
            }

            return alvaras;
        } catch (IOException ex) {
            Logger.getLogger(LerCSV.class.getName()).log(Level.SEVERE, null, ex);

            return null;
        }
    }
}
