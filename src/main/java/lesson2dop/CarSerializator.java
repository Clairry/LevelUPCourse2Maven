package lesson2dop;

public class CarSerializator implements Serializer<Car> {

    public CarSerializator () {};

    @Override
    public String serialize (Car object) {
        return "Модель: "+object.getName()+"; Год выпуска: " + object.getYear() + "; Пробег: " + object.getKilometre() + "; Цена: "+object.getPrice();
    }
}
