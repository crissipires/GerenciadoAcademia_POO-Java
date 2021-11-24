package br.ucsal.poo.ted.domain;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private static int sequencia = 1;

    private final Integer matricula;
    private Long cpf;
    private Double peso;
    private TreinoEnum treinoEnum;
    private Instrutor instrutor;
    private final LocalDate DATAMATRICULA;

    public Aluno(String nome, SexoEnum sexoEnum, LocalDate dataNascimento,
                 Long cpf, Double peso, Instrutor instrutor, TreinoEnum treinoEnum) {
        super(nome, sexoEnum, dataNascimento);
        this.matricula = sequencia++;
        this.cpf = cpf;
        this.peso = peso;
        this.treinoEnum = treinoEnum;
        this.instrutor = instrutor;
        this.DATAMATRICULA = LocalDate.now();
    }


    public Integer getMatricula() {
        return matricula;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public TreinoEnum getTreino() {
        return treinoEnum;
    }

    public void setTreino(TreinoEnum treinoEnum) {
        this.treinoEnum = treinoEnum;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public LocalDate getDATAMATRICULA() {
        return DATAMATRICULA;
    }

    public Integer getIdade(){
        return LocalDate.now().getYear() - getDataNascimento().getYear();
    }

    @Override
    public String toString() {
        return " Matricula: " + getMatricula() +
                "\n Nome: " + getNome() +
                "\n Sexo: " + getSexo() +
                "\n Idade: " + getIdade() +
                "\n Cpf: " + getCpf() +
                "\n Peso: " + getPeso() +
                "\n Instrutor: " + getInstrutor().getNome() +
                "\n Treino: " + getTreino() + " - " + getTreino().getTexto() +
                "\n Data de inicio: " + getDATAMATRICULA();
    }

}
