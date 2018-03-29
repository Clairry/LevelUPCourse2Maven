package lesson2dop;

public class AnnotationNotFoundException extends RuntimeException {
    public AnnotationNotFoundException () {System.err.println("Annotation is not found");}
}
