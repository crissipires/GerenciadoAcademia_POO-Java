package br.ucsal.poo.ted.presentation.util;


import br.ucsal.poo.ted.domain.SexoEnum;
import br.ucsal.poo.ted.domain.TreinoEnum;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class UtilTUI {

    private static Scanner sc = new Scanner(System.in);

    public static String getString(String txt) {
        System.out.print(txt);
        return sc.nextLine();
    }

    public static Double getDouble(String txt){
        while (true) {
            try {
                System.out.print(txt);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("[ERRO] Digito inválido!");
            }
        }
    }

    public static Integer getInteger(String txt){
        while (true) {
            try {
                System.out.print(txt);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e){
                System.out.println("[ERRO] Digito inválido!");
            }
        }
    }

    public static LocalDate getDate(String txt) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String dateBirthday = UtilTUI.getString(txt);
                return LocalDate.parse(dateBirthday, dateTimeFormatter);
            } catch (DateTimeParseException e) {
                System.out.println("[ERRO] Data inválida!");
            }
        }
    }

    public static SexoEnum getSexo(String txt) {
        while (true) {
            String sexoString = getString(txt);
            SexoEnum sexoEnum = SexoEnum.ObterSexoPorLetra(sexoString);

            if(sexoEnum != null){
                return sexoEnum;
            } else {
                System.out.println("[ERRO] Valor inválido!");
            }
        }

    }

    public static TreinoEnum getTreino(String txt) {
        while (true) {
            Integer codigo = getInteger(txt);
            TreinoEnum treinoEnum = TreinoEnum.obterTreinoPorCodigo(codigo);

            if(treinoEnum != null){
                return treinoEnum;
            } else {
                System.out.println("[ERRO] Valor inválido!");
            }
        }
    }

}
