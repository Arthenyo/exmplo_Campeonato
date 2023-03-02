package dao;

public interface GenericDAO<T> {

    public void saveOrUpdate(T object);

    public T findById(Class clazz, Long id);

    public void remove(T object);
}
