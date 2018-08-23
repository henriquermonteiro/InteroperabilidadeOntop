/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.control.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.utfpr.alvaras.control.ResponsibilityChain;
import org.utfpr.alvaras.model.Alvara;

/**
 *
 * @author henrique
 */
public class GISExporter extends ResponsibilityChain<Alvara> {

    private Connection conn;
    private ArrayList<Alvara> buffer;
    private final SimpleDateFormat sdf;

    public GISExporter(String URL, String user, String password) {
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        buffer = new ArrayList<>();

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(URL, user, password);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GISExporter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Alvara change(Alvara input) {
        if (!input.getClassificacoes().isEmpty()) {
            if (input.getEndereco().getLatitude() != null) {
                buffer.add(input);

//                if(buffer.size() > 99){
                flush();
//                }
            }
        }

        return input;
    }

    public ArrayList<Integer> getRecordedAlvaras() {
        ArrayList<Integer> ret = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet r = st.executeQuery("SELECT numero_alvara FROM alvara ORDER BY numero_alvara");

            while (r.next()) {
                ret.add(r.getInt("numero_alvara"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(GISExporter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ret;
    }

    private String toDate(Calendar date) {
        return sdf.format(date.getTime());
    }

    private void flush() {
        String SQL = "";

        for (Alvara a : buffer) {
            SQL += "INSERT INTO alvara "
                    + "(numero_alvara, nome_empresarial, inicio_atividade, emissao, "
                    + "expiracao, atividade1, atividade2, atividade3, endereco, "
                    + "numero, unidade, andar, complemento, bairro, cep, localizacao) "
                    + "VALUES ( " + a.getNumeroDoAlvara() + ", "
                    + "'" + a.getNomeEmpresarial() + "', "
                    + "'" + toDate(a.getDataInicioDeAtividade()) + "', "
                    + "'" + toDate(a.getDataEmissao()) + "', "
                    + "'" + toDate(a.getDataExpiracao()) + "', "
                    + "'" + a.getAtividadePrincipal() + "', "
                    + "'" + a.getAtividadeSecundaria() + "', "
                    + "'" + a.getAtividadeSecundaria2() + "', "
                    + "'" + a.getEndereco().getLogradouro() + "', "
                    + "'" + a.getEndereco().getNumero() + "', "
                    + "'" + a.getEndereco().getUnidade() + "', "
                    + "'" + a.getEndereco().getAndar() + "', "
                    + "'" + a.getEndereco().getComplemento() + "', "
                    + "'" + a.getEndereco().getBairro() + "', "
                    + "'" + a.getEndereco().getCep() + "', "
                    + "ST_GeomFromText('POINT(" + a.getEndereco().getLongitude() + " " + a.getEndereco().getLatitude() + ")', 4326)); ";

            for (String c : a.getClassificacoes()) {
                SQL += "INSERT INTO categoria_alvara "
                        + "(numero_alvara, categoria) "
                        + "VALUES ( " + a.getNumeroDoAlvara() + ", "
                        + "'" + c + "' ); ";
            }
        }

        try {
            Statement st = conn.createStatement();
            st.executeUpdate(SQL);

        } catch (SQLException ex) {
            Logger.getLogger(GISExporter.class.getName()).log(Level.SEVERE, null, ex);
        }

        buffer.clear();
    }

}
