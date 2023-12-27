package Application.Utilities.Database;

import java.util.Iterator;
import java.util.List;


public class DataRepository<T , S> implements Repository<T , S> {
    protected List<T> data;
    protected DataRepository(Class<T> clazz) {
      DatabaseFactory<T> databaseFactory = new DatabaseFactory<>();
      data = databaseFactory.createDatabase(clazz);
    }
    @Override
    public void save(T object) {
        for (T item : data) {
            if (((IModel) object).getId() == ((IModel) item).getId()) {
                throw new IllegalStateException("Object is  already exists");
            }
        }
        data.add(object);
    }

    @Override
    public void delete(T object) {
        data.remove(object);
    }

    @Override
    public T findById(S id) {
        for (T object : data) {
            if (object instanceof IModel && ((IModel) object).getId() == Integer.parseInt(id.toString())) {
                return object;
            }
        }
        throw new IllegalStateException("Couldn't find this Object");
    }

    @Override
    public void update(T object) {
        Iterator<T> itr = data.iterator();
        while (itr.hasNext()) {
            T item = itr.next();
            if (((IModel) object).getId() == ((IModel) item).getId()) {
                itr.remove();
                data.add(object);
                return;
            }
        }
        throw new IllegalStateException("Couldn't find this Object");
    }

    @Override
    public List<T> findAll() {
        return data;
    }

    @Override
    public boolean existsById(S id) {
        for (T object : data) {
            if (object instanceof IModel && ((IModel) object).getId() == Integer.parseInt(id.toString())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void deleteById(S id) {
        Iterator<T> itr = data.iterator();
        while (itr.hasNext()) {
            T item = itr.next();
            if (Integer.parseInt(id.toString()) == ((IModel) item).getId()) {
                itr.remove();
                return;
            }
        }
        throw new IllegalStateException("Couldn't find this Object");
    }
}
