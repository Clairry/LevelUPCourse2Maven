package lesson10.domain;

import javax.persistence.*;

@Entity
@Table(name="groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int group_id;

    @Column(nullable = false)
    private String name;

    @OneToOne(mappedBy = "group")
    private EmployeeGroup employeeGroup;
}
