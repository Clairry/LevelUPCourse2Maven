package lesson9.domain;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "country-id-gen")
    @SequenceGenerator(name = "country-id-gen",
                        initialValue = 10000,
                        sequenceName = "alloc-country-id",
                        allocationSize = 20)
    private int id;

    @Column (nullable = false, unique = true)
    private String name;

    @Column (nullable = false, unique = true)
    private String capital;

    @Column
    private double population;

    public Country() {
    }

    public Country(int id, String name, String capital, double population) {
        this.id = id;
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setPopulation(double population) {
        this.population = population;
    }
}
