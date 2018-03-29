package lesson2dop;

public class House {

    public House(Integer yearOfConstruction, Integer numberOfFlats) {
        this.yearOfConstruction = yearOfConstruction;
        this.numberOfFlats = numberOfFlats;
    }

    public House () {};

    private Integer yearOfConstruction;

    private Integer numberOfFlats;

    public Integer getYearOfConstruction() {
        return yearOfConstruction;
    }

    public Integer getNumberOfFlats() {
        return numberOfFlats;
    }
}
