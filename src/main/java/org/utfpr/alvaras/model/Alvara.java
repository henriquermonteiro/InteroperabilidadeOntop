/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.utfpr.alvaras.model;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author henrique
 */
public class Alvara {

    private String nomeEmpresarial;
    private Calendar dataInicioDeAtividade;
    private String numeroDoAlvara;
    private Calendar dataEmissao;
    private Calendar dataExpiracao;
    private String atividadePrincipal;
    private String atividadeSecundaria;
    private String atividadeSecundaria2;
    private Endereco endereco;
    private String atividadePrincipalAgregada;
    private String atividadeSecundariaAgregada;
    private ArrayList<String> classificacoes;

    public Alvara() {
        classificacoes = new ArrayList<>();
    }

    public String getNomeEmpresarial() {
        return nomeEmpresarial;
    }

    public Alvara setNomeEmpresarial(String nomeEmpresarial) {
        this.nomeEmpresarial = nomeEmpresarial;
        return this;
    }

    public Calendar getDataInicioDeAtividade() {
        return dataInicioDeAtividade;
    }

    public Alvara setDataInicioDeAtividade(Calendar dataInicioDeAtividade) {
        this.dataInicioDeAtividade = dataInicioDeAtividade;
        return this;
    }

    public String getNumeroDoAlvara() {
        return numeroDoAlvara;
    }

    public Alvara setNumeroDoAlvara(String numeroDoAlvara) {
        this.numeroDoAlvara = numeroDoAlvara;
        return this;
    }

    public Calendar getDataEmissao() {
        return dataEmissao;
    }

    public Alvara setDataEmissao(Calendar dataEmissao) {
        this.dataEmissao = dataEmissao;
        return this;
    }

    public Calendar getDataExpiracao() {
        return dataExpiracao;
    }

    public Alvara setDataExpiracao(Calendar dataExperacao) {
        this.dataExpiracao = dataExperacao;
        return this;
    }

    public String getAtividadePrincipal() {
        return atividadePrincipal;
    }

    public Alvara setAtividadePrincipal(String atividadePrincipal) {
        this.atividadePrincipal = atividadePrincipal;
        return this;
    }

    public String getAtividadeSecundaria() {
        return atividadeSecundaria;
    }

    public Alvara setAtividadeSecundaria(String atividadeSecundaria) {
        this.atividadeSecundaria = atividadeSecundaria;
        return this;
    }

    public String getAtividadeSecundaria2() {
        return atividadeSecundaria2;
    }

    public Alvara setAtividadeSecundaria2(String atividadeSecundaria2) {
        this.atividadeSecundaria2 = atividadeSecundaria2;
        return this;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Alvara setEndereco(Endereco endereco) {
        this.endereco = endereco;
        return this;
    }

    public String getAtividadePrincipalAgregada() {
        return atividadePrincipalAgregada;
    }

    public Alvara setAtividadePrincipalAgregada(String atividadePrincipalAgregada) {
        this.atividadePrincipalAgregada = atividadePrincipalAgregada;
        return this;
    }

    public String getAtividadeSecundariaAgregada() {
        return atividadeSecundariaAgregada;
    }

    public Alvara setAtividadeSecundariaAgregada(String atividadeSecundariaAgregada) {
        this.atividadeSecundariaAgregada = atividadeSecundariaAgregada;
        return this;
    }

    public ArrayList<String> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(ArrayList<String> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public Object getByCode(String identifier) {
        switch (identifier) {
            case Constants.NUMERO_ALVARA:
                return numeroDoAlvara;
            case Constants.NOME_EMPRESARIAL:
                return nomeEmpresarial;
            case Constants.DATA_INICIO_ATIVIDADE:
                return dataInicioDeAtividade;
            case Constants.DATA_EMISSAO:
                return dataEmissao;
            case Constants.DATA_EXPIRACAO:
                return dataExpiracao;
            case Constants.ENDERECO:
                return endereco;
            case Constants.ATIVIDADE_PRINCIPAL:
                return atividadePrincipal;
            case Constants.ATIVIDADE_SECUNDARIA:
                return atividadeSecundaria;
            case Constants.ATIVIDADE_SECUNDARIA2:
                return atividadeSecundaria2;
            case Constants.ATIVIDADE_PRINCIPAL_AGREGADA:
                return atividadePrincipalAgregada;
            case Constants.ATIVIDADE_SECUNDARIA_AGREGADA:
                return atividadeSecundariaAgregada;
            default:
                if (Constants.WARNINGS) {
                    System.err.println("Erro ao tentar acessar campo: " + identifier);
                    System.err.println("Campo não encontrado. [" + this.getClass() + "]");
                }

                return null;
        }
    }

    @Override
    public String toString() {
        return "Alvara{" + "nomeEmpresarial=" + nomeEmpresarial + ", dataInicioDeAtividade=" + dataInicioDeAtividade + ", numeroDoAlvara=" + numeroDoAlvara + ", dataEmissao=" + dataEmissao + ", dataExpiracao=" + dataExpiracao + ", atividadePrincipal=" + atividadePrincipal + ", atividadeSecundaria=" + atividadeSecundaria + ", atividadeSecundaria2=" + atividadeSecundaria2 + ", endereco=" + endereco + ", atividadePrincipalAgregada=" + atividadePrincipalAgregada + ", atividadeSecundariaAgregada=" + atividadeSecundariaAgregada + '}';
    }
}
