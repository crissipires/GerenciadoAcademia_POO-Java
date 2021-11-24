package br.ucsal.poo.ted.presentation;

import br.ucsal.poo.ted.presentation.util.UtilTUI;

public class MenuTUI {

    public static void executar() {
        OpcoesMenuEnum opSelecionada = null;
        do {
            try {
                exibirOpcoesMenuPrincipal();
                opSelecionada = obterOpSelecionada();
                executarOp(opSelecionada);
            } catch (Exception e){
                System.out.println("Algo deu errado... (Erro="+ e.getClass() + ")");
                e.printStackTrace();
            }
        } while (opSelecionada == null || !opSelecionada.equals(OpcoesMenuEnum.SAIR));
    }

    private static void executarOp(OpcoesMenuEnum opSelecionada){
        switch (opSelecionada){
            case CADASTRAR_ALUNO:
                AlunoTUI.cadastrarAluno();
                break;
            case CADASTRAR_TREINADOR:
                InstrutorTUI.cadastrarInstrutor();
                break;
            case EXIBIR_ALUNOS:
                AlunoTUI.exibirAlunos();
                break;
            case EXIBIR_TREINADORES:
                InstrutorTUI.exibirInstrutores();
                break;
            case BUSCAR_ALUNO:
                AlunoTUI.buscarAlunoId();
                break;
            case BUSCAR_TREINADOR:
                InstrutorTUI.buscarInstrutorId();
                break;
            case SAIR:
                System.out.println("Programa finalizado.");
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static OpcoesMenuEnum obterOpSelecionada() {
        Integer opInteger = UtilTUI.getInteger("Informe a opção desejada: ");
        return OpcoesMenuEnum.valueOfInteger(opInteger);
    }

    private static void exibirOpcoesMenuPrincipal() {
        System.out.println("\n------ Gerenciador MyAcademy ------");
        for(OpcoesMenuEnum opMenu : OpcoesMenuEnum.values()){
            System.out.println(opMenu.getOpCompleta());
        }
    }

}
