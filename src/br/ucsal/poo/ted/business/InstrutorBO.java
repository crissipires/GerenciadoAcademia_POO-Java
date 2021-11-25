package br.ucsal.poo.ted.business;

import br.ucsal.poo.ted.domain.Instrutor;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.exception.NotFoundException;
import br.ucsal.poo.ted.persistence.InstrutorDAO;

import java.time.LocalDate;
import java.util.List;

public class InstrutorBO {

    private static InstrutorDAO instrutorDAO = new InstrutorDAO();

    public static void add(Instrutor instrutor) throws NegocioException {

        validacaoAdd(instrutor);
        instrutorDAO.add(instrutor);
    }

    public static Instrutor findbyId(Integer id) throws NotFoundException {
        Instrutor instrutor = instrutorDAO.findbyId(id);
        if(instrutor == null) throw new NotFoundException("Id não encontrado!");
        return instrutorDAO.findbyId(id);
    }

    public static List<Instrutor> findall() throws NotFoundException {
        List<Instrutor> instrutores = instrutorDAO.findall();
        if(instrutores.isEmpty()) throw new NotFoundException("Não temos instrutores cadastrados");
        return instrutores;
    }

    private static void validacaoAdd(Instrutor instrutor) throws NegocioException {
        for (Instrutor instrutor1 : instrutorDAO.findall()) {
            if(instrutor1.getCodigoCREF().equals(instrutor.getCodigoCREF())){
                throw new NegocioException("Já existe um instrutor cadastrado com esse CodigoCREF");
            }
        }

        if(instrutor.getCodigoCREF() <= 0){
            throw new NegocioException("[ERRO] Codigo CREF valido!");
        }

        if(instrutor.getDataNascimento().isAfter(LocalDate.now())){
            throw new NegocioException("[ERRO] Data invalida!");
        }
    }
}
