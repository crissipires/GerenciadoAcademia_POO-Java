package br.ucsal.poo.ted.persistence;

import br.ucsal.poo.ted.domain.Aluno;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AlunoDAO implements Dao<Aluno>{

    private static List<Aluno> alunoList = new ArrayList<>();

    public void add(Aluno objeto) {
        alunoList.add(objeto);
    }

    public List<Aluno> findall() {
        List<Aluno> alunos = new ArrayList<>(alunoList);
        alunos.sort(Comparator.comparing(Aluno::getNome));
        return alunos;
    }

    public Aluno findbyId(Integer id) {
        return alunoList.stream()
                .filter(aluno -> aluno.getMatricula().equals(id))
                .findAny()
                .orElse(null);
    }
}
