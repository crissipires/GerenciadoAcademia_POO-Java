package br.ucsal.poo.ted.persistence;

import java.util.List;

public interface Dao<T> {

    void add(T objeto);

    List<T> findall();

    T findbyId(Integer id);
}
