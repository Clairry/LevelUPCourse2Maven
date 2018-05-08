package lesson10dop;

public class App {

    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        Employee emp = new Employee();

        System.out.println(ToStringOverride.toString(emp));
    }
}
