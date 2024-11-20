

public class Stack<T> {
    private int size;
    private T[] data;
    private int capacity;

    public Stack(int capacity){
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element){
        if (size >= capacity) {
            throw new IllegalStateException("Стек переполнен");
        }
        data[size] = element;
        size++;
    }

    public String pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        size--;
        T poppedElement = data[size];
        data[size] = null; 
        return "Элемент удален " + poppedElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(10);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        stack.size();
        System.out.println(stack.peek());
        stack.push(4);
        System.out.println(stack.pop());
    }
}
