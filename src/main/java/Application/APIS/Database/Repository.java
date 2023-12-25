package Application.APIS.Database;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository<T , S> {
    public void save(T object);
    public void delete(T object);
    public T findById(S id);
    public void update(T object);
    public List<T> findAll();
    public boolean existsById(S id);
    public void deleteById(S id);
    public void deleteAll();
}
