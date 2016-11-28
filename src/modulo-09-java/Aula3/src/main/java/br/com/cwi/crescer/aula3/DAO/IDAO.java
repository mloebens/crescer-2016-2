package br.com.cwi.crescer.aula3.DAO;

import java.util.List;

/**
 *
 * @author maicon.loebens
 * @param <T>
 * @param <ID>
 */
public interface IDAO<T, ID> {
    void insert(T t);
    void delete(T t);
    T find(ID id);
    List<T> findAll();
    
}
