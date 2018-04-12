package lesson10dop;

import lesson10dop.Department;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int employee_id;

    @Column
    private Department department;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private String email;

    public Employee(int id, String login, String name, String last_name, String email) {
        this.login = login;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public Employee() {}
}
