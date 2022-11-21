package com.labs.br.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.util.Date;

@Entity
@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Cliente {

    public Cliente(String cpf, String nome, String rg, String uf_rg, String orgao_emissor, Date data_nascimento, String genero, String email, String telefone, String telefone_secundario, String cep, String logradouro, String numero, String complemento, String bairro, String municipio, String uf, Date ultimaalteracao) {
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
        this.ultimaalteracao = ultimaalteracao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String cpf;
    private String nome;
    private String rg;
    private String uf_rg;
    private String orgao_emissor;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date data_nascimento;
    private String genero;
    private String email;
    private String telefone;
    private String telefone_secundario;
    private String cep;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String municipio;
    private String uf;
    private  Date ultimaalteracao;

}