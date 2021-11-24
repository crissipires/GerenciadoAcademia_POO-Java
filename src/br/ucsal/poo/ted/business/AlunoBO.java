package br.ucsal.poo.ted.business;


import br.ucsal.poo.ted.domain.Aluno;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.persistence.AlunoDAO;

import java.time.LocalDate;
import java.util.List;


public class AlunoBO {

    private static AlunoDAO alunoDAO = new AlunoDAO();

    public static void add( Aluno aluno) throws NegocioException {
        if(aluno.getPeso() <= 0) throw new NegocioException("[ERRO] Adicione um peso valido!");

        if(aluno.getDataNascimento().isAfter(LocalDate.now())) throw new NegocioException("[ERRO] Data invalida!");

        alunoDAO.add(aluno);
    }

    public static Aluno findbyId(Integer id) throws NegocioException {
        Aluno aluno = alunoDAO.findbyId(id);
        if (aluno == null) throw new NegocioException("Matricula não encontrada!");
        return alunoDAO.findbyId(id);
    }

    public static List<Aluno> findall() throws NegocioException {
        List<Aluno> alunos = alunoDAO.findall();
        if(alunos.isEmpty()) throw new NegocioException("Não temos alunos cadastrados!");
        return alunos;
    }
}
