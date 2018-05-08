package lesson10.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "employee_group")
public class EmployeeGroup implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToOne
    @JoinColumn(name = "group_id")
    private Group group;
}
