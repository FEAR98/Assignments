package org.example;

import java.sql.SQLException;
import java.util.List;

public interface PersonDAO<T>
{
    List<T> findAll() throws SQLException;

    void save(T entity) throws SQLException;

    int update(int id, T entity) throws SQLException;

    void delete(int id) throws SQLException;

    T findById(int id);
}

