package br.ucsal.poo.ted.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Instrutor extends Pessoa {
    private static int sequencia = 1;

    private final Integer idIntrutor;
    private Long codigoCREF;

    public Instrutor(String nome, SexoEnum sexoEnum, LocalDate dataNascimento, Long codigoCREF) {
        super(nome, sexoEnum, dataNascimento);
        this.codigoCREF = codigoCREF;
        this.idIntrutor = sequencia++;
    }

    public Integer getIdIntrutor() {
        return idIntrutor;
    }

    public Long getCodigoCREF() {
        return codigoCREF;
    }

    public void setCodigoCREF(Long codigoCREF) {
        this.codigoCREF = codigoCREF;
    }

    public Integer getIdade(){
        return LocalDate.now().getYear() - getDataNascimento().getYear();
    }

    @Override
    public String toString() {
        return " Id: " + getIdIntrutor() +
                "\n Codigo CREF: " + getCodigoCREF() +
                "\n Nome: " + getNome() +
                "\n Sexo: " + getSexo() +
                "\n Idade:" + getIdade();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Instrutor)) return false;
        Instrutor instrutor = (Instrutor) o;
        return codigoCREF.equals(instrutor.codigoCREF);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCREF);
    }
}
