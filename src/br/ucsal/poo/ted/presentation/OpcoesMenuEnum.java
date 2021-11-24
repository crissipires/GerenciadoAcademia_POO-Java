package br.ucsal.poo.ted.presentation;

public enum OpcoesMenuEnum {

    CADASTRAR_ALUNO (1, "Cadastrar novo Aluno"),
    CADASTRAR_TREINADOR (2, "Cadastrar novo Instrutor"),
    EXIBIR_ALUNOS (3, "Exibir alunos cadastrados"),
    EXIBIR_TREINADORES (4, "Exibir Instrutores cadastrados"),
    BUSCAR_ALUNO (5, "Buscar aluno por MATRICULA"),
    BUSCAR_TREINADOR (6, "Buscar treinador por ID"),
    SAIR (9, "Sair do programa");

    private Integer codigo;
    private String texto;

    private OpcoesMenuEnum(Integer codigo, String texto){
        this.codigo = codigo;
        this.texto = texto;
    }

    public static OpcoesMenuEnum valueOfInteger(int opInteger) {
        for(OpcoesMenuEnum opMenu : values()) {
            if(opMenu.codigo.equals(opInteger))
                return opMenu;
        }
        return null;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTexto() {
        return texto;
    }

    public String getOpCompleta() {
        return codigo + " - " + texto;
    }
}
