package lesson6.dao;

import lesson6.domain.Department;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public interface DepartmentDao {
    Department create(int id, String name, String city) throws SQLException;

    Department update(int id, String name, String city) throws SQLException;

    void delete(int id) throws SQLException;

    Collection<Department> findAll() throws SQLException;

    Department findById(int id) throws SQLException;
}
