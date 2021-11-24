package br.ucsal.poo.ted.domain;

public enum TreinoEnum {
    INICIANTE(1,"3 Repetiçoes: Perna, Braço e Ombros."),
    INTERMEDIARIO(2,"5 Repetiçoes: Perna, Braço, Ombros e Costas"),
    AVANCADO(3,"10 Repetiçoes: Perna, Braço, Ombros e Glúteo ");

    private final Integer codigo;
    private final String texto;

    private TreinoEnum(Integer codigo, String texto){
        this.codigo = codigo;
        this.texto = texto;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getTexto() {
        return texto;
    }

    public static TreinoEnum obterTreinoPorCodigo(Integer codigo){
        for(TreinoEnum treinoEnum: values()){
            if(treinoEnum.getCodigo().equals(codigo)) return treinoEnum;
        }

        return null;
    }

}
