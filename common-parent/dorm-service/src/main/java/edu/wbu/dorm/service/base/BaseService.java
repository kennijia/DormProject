package edu.wbu.dorm.service.base;

public interface BaseService<T> {
    public T findById(String id);
    public T findById(int id);
}
