package Application.APIS.Database;

import java.util.List;


public class DataRepository<T , S> implements Repository<T , S> {
    private List<T> data;
    protected DataRepository(Class<T> clazz) {
      DatabaseFactory<T> databaseFactory = new DatabaseFactory<T>();
      data = databaseFactory.createDatabase(clazz);
    }
    @Override
    public void save(T object) {
    }

    @Override
    public void delete(T object) {

    }

    @Override
    public T findById(S id) {
        System.out.println("id: " + id);
        for (T object : data) {
            if (object instanceof IModel && ((IModel) object).getId() == Integer.parseInt(id.toString())) {
                return object;
            }
        }
        return null;
    }


    @Override
    public void update(T object) {

    }

    @Override
    public List<T> findAll() {
        return data;
    }

    @Override
    public boolean existsById(S id) {
        return false;
    }

    @Override
    public void deleteById(S id) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void copy(T object) {

    }

    @Override
    public void saveAll(T[] objects) {

    }

    @Override
    public void updateAll(T[] objects) {

    }

    @Override
    public void deleteAll(T[] objects) {

    }

    @Override
    public void deleteByIds(S[] ids) {

    }
}
