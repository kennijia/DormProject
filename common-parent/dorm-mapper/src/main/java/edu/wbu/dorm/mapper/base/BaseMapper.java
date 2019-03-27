package edu.wbu.dorm.mapper.base;

public interface BaseMapper<T> {

    T findById(String id);
    T findById(int id);
    T findByIdAndPassword(T t);
}
