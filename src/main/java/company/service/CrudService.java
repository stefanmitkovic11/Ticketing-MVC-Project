package company.service;

import java.util.List;

public interface CrudService<T, ID> {
    T save(T object);
    T findUserById(ID id);
    List<T> findAll();
    void delete(T object);
    void deleteById(ID id);
}
