package com.labs.br.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Cliente {

    public Cliente(String cpf, String nome, int rg, String uf_rg, String orgao_emissor, Date data_nascimento, String genero, String email, int telefone, int telefone_secundario, int cep, String logradouro, int numero, String complemento, String bairro, String municipio, String uf) {
        this.cpf = cpf;
        this.nome = nome;
        this.rg = rg;
        this.uf_rg = uf_rg;
        this.orgao_emissor = orgao_emissor;
        this.data_nascimento = data_nascimento;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.telefone_secundario = telefone_secundario;
        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.municipio = municipio;
        this.uf = uf;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cpf;
    private String nome;
    private int rg;
    private String uf_rg;
    private String orgao_emissor;
    private Date data_nascimento;
    private String genero;
    private String email;
    private int telefone;
    private int telefone_secundario;
    private int cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;

}
