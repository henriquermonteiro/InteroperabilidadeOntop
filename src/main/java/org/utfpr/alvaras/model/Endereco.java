/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.model;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 *
 * @author henrique
 */
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String unidade;
    private String andar;
    private String complemento;
    private String cep;
    private Double latitude;
    private Double longitude;
    private String localidade;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String toSearchString() {
        return logradouro + " " + numero + ", " + bairro + ", Curitiba Paraná Brasil";
    }
    public String toBingSearchString() throws UnsupportedEncodingException {
        return "countryRegion=BR&locality=Curitiba&addressLine="+ URLEncoder.encode(logradouro + " " + numero + ", " + bairro, "UTF-8") +"&maxResults=5";
    }
    
}
