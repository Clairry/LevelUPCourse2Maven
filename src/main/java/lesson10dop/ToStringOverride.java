package lesson10dop;

import java.lang.reflect.Field;

public class ToStringOverride {

    private static String result = "";

    public static String toString(Object object) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Class objectClass = object.getClass();
        final Field[] fields = objectClass.getDeclaredFields();

        for (Field field:fields) {
            Boolean type = (field.getType().isPrimitive() || (field.getType() == String.class)) ? false : true;

            if (type) {
                Class innerClass=Class.forName(field.getType().getName());
                Object innerObject =  innerClass.newInstance();
                ToStringOverride.toString(innerObject);
            }
            else{
                result = result + field.getName() + " ";
            }
        }

        return result;
    }
}
