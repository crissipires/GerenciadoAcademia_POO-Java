package br.ucsal.poo.ted.presentation;


import br.ucsal.poo.ted.business.InstrutorBO;
import br.ucsal.poo.ted.domain.Instrutor;
import br.ucsal.poo.ted.domain.SexoEnum;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.exception.NotFoundException;
import br.ucsal.poo.ted.presentation.util.UtilTUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class InstrutorTUI {

    public static void cadastrarInstrutor(){
        exibirTxt("\n----- Cadastro de novo Instrutor -----");
        String opcao;
        do {
            Instrutor instrutor = obterInstrutor();
            try {
                InstrutorBO.add(instrutor);
                exibirTxt("Instrutor " + instrutor.getNome().toUpperCase(Locale.ROOT) + " cadastrado com sucesso!");
            } catch (NegocioException e) {
                exibirTxt(e.getMessage());
            }
            opcao = UtilTUI.getString("Deseja cadastrar outro instrutor? (S/N)");
        }while (opcao.equalsIgnoreCase("s"));
    }

    public static void exibirInstrutores(){
        try {
            List<Instrutor> instrutors = InstrutorBO.findall();
            exibirTxt("\n----- Instrutores Cadastrados -----");
            for (Instrutor instrutor : instrutors) {
                exibirTxt(" Id: " + instrutor.getIdIntrutor() +
                        ", Nome: " + instrutor.getNome() +
                        ", Sexo: " + instrutor.getSexo() +
                        ", Idade:" + instrutor.getIdade());
            }
            exibirTxt("--------------------------------------");
        } catch (NotFoundException e) {
            e.printStackTrace();

        }
    }

    public static void buscarInstrutorId(){
        exibirTxt("\n----- BUSCA INSTRUTOR POR ID ------");
        Integer id = UtilTUI.getInteger("Digite o Id:");
        try {
            Instrutor instrutor = InstrutorBO.findbyId(id);
            System.out.println(instrutor);
            exibirTxt("--------------------------------------");
        } catch (NotFoundException e) {
            exibirTxt(e.getMessage());
        }
    }

    private static Instrutor obterInstrutor(){
        String nome = UtilTUI.getString("Nome:");
        SexoEnum sexo = UtilTUI.getSexo("Sexo (M/F):");
        LocalDate dataNascimento = UtilTUI.getDate("Data de nascimento (dd/MM/yyyy):");
        Long codigoCREF = Long.parseLong(UtilTUI.getString("Codigo Cref:"));

        return new Instrutor(nome,sexo,dataNascimento,codigoCREF);
    }

    private static void exibirTxt(String txt) {
        System.out.println(txt);
    }

}
