package br.ucsal.poo.ted.business;


import br.ucsal.poo.ted.domain.Aluno;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.exception.NotFoundException;
import br.ucsal.poo.ted.persistence.AlunoDAO;

import java.time.LocalDate;
import java.util.List;


public class AlunoBO {

    private static AlunoDAO alunoDAO = new AlunoDAO();

    public static void add( Aluno aluno) throws NegocioException {
        validacaoAdd(aluno);
        alunoDAO.add(aluno);
    }

    public static Aluno findbyId(Integer id) throws NotFoundException {
        Aluno aluno = alunoDAO.findbyId(id);
        if (aluno == null) throw new NotFoundException("Matricula não encontrada!");
        return alunoDAO.findbyId(id);
    }

    public static List<Aluno> findall() throws NotFoundException {
        List<Aluno> alunos = alunoDAO.findall();
        if(alunos.isEmpty()) throw new NotFoundException("Não temos alunos cadastrados!");
        return alunos;
    }

    private static void validacaoAdd(Aluno aluno) throws NegocioException {
        for (Aluno aluno1 : alunoDAO.findall()) {
            if(aluno1.getCpf().equals(aluno.getCpf())) {
                throw new NegocioException("Já existe um aluno cadastrado com esse CPF!");
            }
        }

        if(aluno.getPeso() <= 0) throw new NegocioException("[ERRO] Adicione um peso valido!");

        if(aluno.getDataNascimento().isAfter(LocalDate.now())) throw new NegocioException("[ERRO] Data invalida!");
    }
}
