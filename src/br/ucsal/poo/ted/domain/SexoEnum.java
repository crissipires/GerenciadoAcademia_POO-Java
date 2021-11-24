package br.ucsal.poo.ted.domain;

public enum SexoEnum {
    MASCULINO("M"),
    FEMININO("F");

    private String letraSexo;

    SexoEnum(String sexo) {
        this.letraSexo = sexo;
    }

    public String getLetraSexo() {
        return letraSexo;
    }

    public static SexoEnum ObterSexoPorLetra(String letter){
        for(SexoEnum sexoEnum: values()){
            if(sexoEnum.getLetraSexo().equalsIgnoreCase(letter)) return sexoEnum;
        }
        return null;
    }

}
