package lesson10dop;

import lesson10.domain.Employee;

import javax.persistence.*;

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int department_id;

    @Column(nullable = false)
    private String name;

    @Column
    private String city;

    public int getDepartment_id() {
        return department_id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Department(int department_id, Employee employee, String name, String city) {
        this.department_id = department_id;
        this.name = name;
        this.city = city;
    }

    public Department() {}
}
