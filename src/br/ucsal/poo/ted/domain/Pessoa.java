package br.ucsal.poo.ted.domain;

import java.time.LocalDate;

public abstract class Pessoa {
    private String nome;
    private SexoEnum sexoEnum;
    private LocalDate dataNascimento;

    public Pessoa(String nome, SexoEnum sexoEnum, LocalDate dataNascimento) {
        this.nome = nome;
        this.sexoEnum = sexoEnum;
        this.dataNascimento = dataNascimento;
    }

    public SexoEnum getSexo() {
        return sexoEnum;
    }

    public void setSexo(SexoEnum sexoEnum) {
        this.sexoEnum = sexoEnum;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
