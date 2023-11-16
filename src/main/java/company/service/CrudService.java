package company.service;

import java.util.List;

public interface CrudService<T, ID> {
    //    save, update, findById, delete, findAll
    T save(T object);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    void update(T object);
}
