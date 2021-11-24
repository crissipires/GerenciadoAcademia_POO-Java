package br.ucsal.poo.ted.persistence;

import br.ucsal.poo.ted.domain.Instrutor;
import br.ucsal.poo.ted.domain.SexoEnum;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class InstrutorDAO implements Dao<Instrutor>{

    private static List<Instrutor> instrutorList = new ArrayList<>(List.of(
            new Instrutor("Marcão", SexoEnum.MASCULINO, LocalDate.of(1995,05,01), 14423044L)));

    public void add(Instrutor objeto) {
        instrutorList.add(objeto);
    }

    public List<Instrutor> findall() {
        List<Instrutor> instrutors = new ArrayList<>(instrutorList);
        instrutors.sort(Comparator.comparing(Instrutor::getNome));
        return instrutors;
    }

    public Instrutor findbyId(Integer id){
        return instrutorList.stream()
                .filter(instrutor -> instrutor.getIdIntrutor().equals(id))
                .findAny()
                .orElse(null);
    }
}
