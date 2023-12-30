package Application.Utilities.Database;

public interface IModel<T> {
    T getId();
    void setId(T id);
}