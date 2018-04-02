package lesson2dop;

public class App {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Car carTest=new Car("Mini Cooper Hatch III", "2016", "83000", "1200000");
        String carStringForExchange=SerializedByProcessor.process(carTest);
        System.out.println(carStringForExchange);
        User userTest=new User();
        String userStringForExchange=SerializedByProcessor.process(userTest);
        System.out.println(userStringForExchange);
    }
}
