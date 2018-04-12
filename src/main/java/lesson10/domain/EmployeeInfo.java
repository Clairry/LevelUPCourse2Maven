package lesson10.domain;

import javax.persistence.*;

@Entity
@Table(name = "employee_info")
public class EmployeeInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private int age;

    @Column(nullable = false)
    private String position;

    @Column
    private Boolean sex;

    @Column
    private String internal_telephone;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
