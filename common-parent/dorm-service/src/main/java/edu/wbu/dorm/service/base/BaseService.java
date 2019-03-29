package edu.wbu.dorm.service.base;

public interface BaseService<T> {
    T findById(String id);
    T findById(int id);
}
