package lesson6;

import lesson6.dao.DepartmentDaoImpl;
import lesson6.domain.Department;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class App {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws SQLException {
        PropertiesJdbcConfiguration confProperties=new PropertiesJdbcConfiguration();
        Configuration conf=new Configuration();
        conf=confProperties.load();
        Department dep_example;
        String connectionString="jdbc:mysql://"+conf.getHost()+":"+conf.getPort()+"/"+conf.getDatabase()+"?serverTimezone=UTC&useSSL=false";
        try (Connection connection = DriverManager.getConnection(connectionString, conf.getUsername(), conf.getPassword())) {
            DepartmentDaoImpl example = new DepartmentDaoImpl(connection);

            dep_example = example.create(4, "IT", "Moscow");
            System.out.println(dep_example.getDepartmentId()+"; "+dep_example.getName()+"; "+dep_example.getCity());

            dep_example = example.update(4, "Marketing", "Spb");
            System.out.println(dep_example.getDepartmentId()+"; "+dep_example.getName()+"; "+dep_example.getCity());

            example.delete(4);

            Collection<Department> resultExample = new ArrayList<Department>();
            resultExample = example.findAll();
            System.out.println();
            for (Department dep_each : resultExample) {
                System.out.println(dep_each.getDepartmentId()+"; "+dep_each.getName()+"; "+dep_each.getCity());
            }
            System.out.println();

            dep_example = example.findById(3);
            System.out.println(dep_example.getDepartmentId()+"; "+dep_example.getName()+"; "+dep_example.getCity());
        }
    }
}
