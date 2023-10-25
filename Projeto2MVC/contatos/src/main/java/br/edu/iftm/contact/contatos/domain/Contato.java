package br.edu.iftm.contact.contatos.domain;

import java.sql.Date;

import lombok.Data;

@Data
public class Contato {

    private String nome;
    private Date dataNascimento;
    private String matricula;

    public Contato() {
        
    }
    public Contato(String nome, Date dataNascimento, String matricula) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.matricula = matricula;
    }

    
    
}