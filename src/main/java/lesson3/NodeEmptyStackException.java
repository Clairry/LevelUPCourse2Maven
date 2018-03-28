package lesson3;

public class NodeEmptyStackException extends RuntimeException {

    public NodeEmptyStackException () {
        System.err.println("Stack is empty");
    }
}
