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
    public long count();
    public void copy(T object);
    public void saveAll(T[] objects);
    public void updateAll(T[] objects);
    public void deleteAll(T[] objects);
    public void deleteByIds(S[] ids);
}
