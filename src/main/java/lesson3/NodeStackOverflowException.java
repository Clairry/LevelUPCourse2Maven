package lesson3;

public class NodeStackOverflowException extends RuntimeException {
    public NodeStackOverflowException () {
        System.err.println("Stack is overflowed");
    }
}
