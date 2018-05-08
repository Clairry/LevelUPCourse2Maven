package lesson10.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employee_id;

    @OneToOne
    @JoinColumn(name="department_id")
    private Departments department;

    @OneToOne(mappedBy = "employee")
    private EmployeeInfo employeeInfo;

    @OneToOne(mappedBy = "employee")
    private EmployeeGroup employeeGroup;

    @Column(nullable = false, unique = true, length = 6)
    private String login;

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 30)
    private String last_name;

    @Column(nullable = false, length = 40)
    private String email;

    public Employee(int id, String login, String name, String last_name, String email) {
        this.login = login;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public Employee() {}

}

