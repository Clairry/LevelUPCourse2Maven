package lesson2dop;

@SerializedBy("lesson2dop.CarSerializator")
public class Car {
    private String name;
    private String year;
    private String kilometre;
    private String price;

    public Car() {};

    public Car(String name, String year, String kilometre, String price) {
        this.name=name;
        this.year=year;
        this.kilometre=kilometre;
        this.price=price;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getKilometre() {
        return kilometre;
    }

    public String getPrice() {
        return price;
    }
}
