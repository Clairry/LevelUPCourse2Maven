package lesson2dop;

import lesson2dop.AnnotationNotFoundException;
import lesson2dop.Car;
import lesson2dop.House;
import lesson2dop.SerializedByProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class SerializedByTest {

    @Test
    public void testSerializedByProcessor_car_returnString() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Car carTest=new Car("Mini Cooper Hatch III", "2016", "83000", "1200000");
        Object carStringForExchange = SerializedByProcessor.process(carTest);
        boolean result = carStringForExchange instanceof String;
        Assertions.assertTrue(result);
    }

    @Test
    public void testSerializedByProcessor_car_returnNotNullString() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Car carTest=new Car("Mini Cooper Hatch III", "2016", "83000", "1200000");
        String carStringForExchange = SerializedByProcessor.process(carTest);
        boolean result = (carStringForExchange != null);
        Assertions.assertTrue(result);
    }

    @Test
    public void testSerializedByProcessor_house_annotationNotFoundException () {
        House houseTest = new House();
        Assertions.assertThrows(
                AnnotationNotFoundException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        SerializedByProcessor.process(houseTest);
                    }
                }
        );
    }

}
