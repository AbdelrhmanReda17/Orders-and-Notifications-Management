package Application.Utilities.Database;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository<T , S> {
    void save(T object);
    void delete(T object);
    T findById(S id);
    void update(T object);
    List<T> findAll();
    boolean existsById(S id);
    void deleteById(S id);
}
