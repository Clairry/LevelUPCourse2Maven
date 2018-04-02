package lesson2dop;

public class SerializedByProcessor {
    public static String process (Object object) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        final Class<?> objectClass = object.getClass();
        SerializedBy annotation = objectClass.getAnnotation(SerializedBy.class);
        if (annotation != null) {
            Class classForAnnotation=Class.forName(annotation.value());
            Serializer ser=(Serializer) classForAnnotation.newInstance();
            return ser.serialize(object);
        }
        else {throw new AnnotationNotFoundException();}
    }
}
