package br.ucsal.poo.ted.presentation;

import br.ucsal.poo.ted.business.AlunoBO;
import br.ucsal.poo.ted.business.InstrutorBO;
import br.ucsal.poo.ted.domain.Aluno;
import br.ucsal.poo.ted.domain.Instrutor;
import br.ucsal.poo.ted.domain.SexoEnum;
import br.ucsal.poo.ted.domain.TreinoEnum;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.exception.NotFoundException;
import br.ucsal.poo.ted.presentation.util.UtilTUI;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class AlunoTUI {

    public static void cadastrarAluno(){
        exibirTxt("\n------ Cadastro de novo Aluno ------");
        String opcao;
        do {
            Aluno aluno = obterAluno();
            try {
                AlunoBO.add(aluno);
                exibirTxt("Aluno " + aluno.getNome().toUpperCase(Locale.ROOT) + " cadastrado com sucesso!");
            } catch (NegocioException e) {
                exibirTxt(e.getMessage());
            }
            opcao = UtilTUI.getString("Deseja cadastrar outro aluno? (S/N)");
        }while (opcao.equalsIgnoreCase("s"));
    }

    public static void exibirAlunos(){
        try {
            List<Aluno> alunos = AlunoBO.findall();
            exibirTxt("\n------ ALUNOS CADASTRADOS ----------");
            for (Aluno aluno : alunos) {
                exibirTxt("Matricula: " + aluno.getMatricula()
                        + ", Nome: " + aluno.getNome()
                        + ", Sexo: " + aluno.getSexo()
                        + ", Idade: " + aluno.getIdade()
                        + ", Instrutor: " + aluno.getInstrutor().getNome()
                        + ", Treino: " + aluno.getTreino()
                );
            }
            exibirTxt("-------------------------------------");
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void buscarAlunoId(){
        exibirTxt("\n------- BUSCA ALUNO POR MATRICULA -----------");
        Integer id = UtilTUI.getInteger("Matricula: ");
        try {
            Aluno aluno = AlunoBO.findbyId(id);
            System.out.println(aluno);
        } catch (NotFoundException e) {
            exibirTxt(e.getMessage());
        }

    }

    private static Aluno obterAluno(){
        String nome = UtilTUI.getString("Nome:");
        SexoEnum sexoEnum = UtilTUI.getSexo("Sexo (M/F): ");
        LocalDate dataNascimento = UtilTUI.getDate("Data de nascimento (dd/MM/yyyy):");
        Long cpf = Long.parseLong(UtilTUI.getString("CPF:"));
        Double peso = UtilTUI.getDouble("Peso:");
        Instrutor instrutor = obterInstrutorValido();
        exibirTreinos();
        TreinoEnum treino = UtilTUI.getTreino("Treino:");
        return new Aluno(nome, sexoEnum, dataNascimento, cpf, peso,instrutor,treino);
    }

    private static void exibirTxt(String txt){
        System.out.println(txt);
    }

    public static Instrutor obterInstrutorValido(){
        InstrutorTUI.exibirInstrutores();
        while (true) {
            try {
                Integer instrutor = UtilTUI.getInteger("Id do Instrutor:");
                return InstrutorBO.findbyId(instrutor);
            } catch (NotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void exibirTreinos(){
        for(TreinoEnum treinoEnum : TreinoEnum.values()){
            System.out.printf("(%d) - %s ",treinoEnum.getCodigo(),treinoEnum );
        }
        System.out.println();
    }

}
