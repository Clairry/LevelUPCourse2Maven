package lesson3;

public class StackRealization {
    private Node tail;
    private int size;
    private int maxSize;

    public StackRealization(int maxSize){
        tail = null;
        size = 0;
        this.maxSize = maxSize;
    }

    public int getSize(){
        return size;
    }

    public Node getTail(){
        return tail;
    }

    public boolean isEmpty(){
        return tail == null;
    }

    public void push(Object value){
        if (size == maxSize) {
            throw new NodeStackOverflowException();
        }
        Node nod = new Node();
        nod.setValue(value);
        nod.setNext(tail);
        tail = nod;
        size++;
    }

    public Object peek(){
        if (isEmpty()) {
            throw new NodeEmptyStackException();
        }
        return tail.getValue();
    }

    public Object pop(){
        if(isEmpty()){
            throw new NodeEmptyStackException();
        }
        Object value = tail.getValue();
        tail = tail.getNext();
        size--;
        return value;
    }
}