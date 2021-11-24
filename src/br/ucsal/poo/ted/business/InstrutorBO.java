package br.ucsal.poo.ted.business;

import br.ucsal.poo.ted.domain.Instrutor;
import br.ucsal.poo.ted.exception.NegocioException;
import br.ucsal.poo.ted.persistence.InstrutorDAO;

import java.time.LocalDate;
import java.util.List;

public class InstrutorBO {

    private static InstrutorDAO instrutorDAO = new InstrutorDAO();

    public static void add(Instrutor instrutor) throws NegocioException {
        if(instrutor.getCodigoCREF() <= 0){
            throw new NegocioException("[ERRO] Codigo CREF valido!");
        }

        if(instrutor.getDataNascimento().isAfter(LocalDate.now())){
            throw new NegocioException("[ERRO] Data invalida!");
        }

        instrutorDAO.add(instrutor);
    }

    public static Instrutor findbyId(Integer id) throws NegocioException {
        Instrutor instrutor = instrutorDAO.findbyId(id);
        if(instrutor == null) throw new NegocioException("Id não encontrado!");
        return instrutorDAO.findbyId(id);
    }

    public static List<Instrutor> findall() throws NegocioException {
        List<Instrutor> instrutores = instrutorDAO.findall();
        if(instrutores.isEmpty()) throw new NegocioException("Não temos instrutores cadastrados");
        return instrutores;
    }
}
