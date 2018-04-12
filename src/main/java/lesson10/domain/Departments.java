package lesson10.domain;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int department_id;

    @OneToOne(mappedBy = "department")
    private Employee employee;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 50)
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

    public Departments(int department_id, Employee employee, String name, String city) {
        this.department_id = department_id;
        this.employee = employee;
        this.name = name;
        this.city = city;
    }

    public Departments() {}
}
