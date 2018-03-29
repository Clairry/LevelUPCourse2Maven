package lesson6.dao;

import lesson6.domain.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class DepartmentDaoImpl implements DepartmentDao {

    Connection connection;

    public DepartmentDaoImpl() {
    }

    public DepartmentDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Department create(int id, String name, String city) throws SQLException {
        Department dep = new Department();
        try (Statement statement = connection.createStatement();) {
            String sql = "insert into departments values (" +  id + ", \"" + name + "\", \"" + city + "\")";
            statement.executeUpdate(sql);
            String sqlSelect ="select * from departments where department_id = " + id;
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                dep.setDepartmentId(resultSet.getInt("department_id"));
                dep.setName(resultSet.getString("name"));
                dep.setCity(resultSet.getString("city"));
            }
        }
        return dep;
    }

    @Override
    public Department update(int id, String name, String city) throws SQLException {
        Department dep = new Department();
        try (Statement statement = connection.createStatement();) {
            String sql = "update departments set name = \"" + name + "\", city = \"" + city + "\" where department_id = " + id;
            statement.executeUpdate(sql);
            String sqlSelect="select * from departments where department_id = " + id;
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()) {
                dep.setDepartmentId(resultSet.getInt("department_id"));
                dep.setName(resultSet.getString("name"));
                dep.setCity(resultSet.getString("city"));
            }
        }
        return dep;
    }

    @Override
    public void delete(int id) throws SQLException {
        try (Statement statement = connection.createStatement();) {
            String sql = "delete from departments where department_id = " + id;
            statement.executeUpdate(sql);
        }
    }

    @Override
    public Collection<Department> findAll() throws SQLException {
        ArrayList<Department> result = new ArrayList<Department>();

        try (Statement statement = connection.createStatement();) {
            String sql = "select * from departments";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Department dep = new Department();
                dep.setDepartmentId(resultSet.getInt("department_id"));
                dep.setName(resultSet.getString("name"));
                dep.setCity(resultSet.getString("city"));
                result.add(dep);
            }
        }
        return result;
    }


    @Override
    public Department findById(int id) throws SQLException {
        Department dep = new Department();
        try (Statement statement = connection.createStatement();) {
            String sql = "select * from departments where department_id = " + id;
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                dep.setDepartmentId(resultSet.getInt("department_id"));
                dep.setName(resultSet.getString("name"));
                dep.setCity(resultSet.getString("city"));
            }
        }
        return dep;
    }
}
