public class Main {
    public static void main(String[] args) {
        ArrayQueue<Object> a = new ArrayQueue<>();
        a.enqueue(0);
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);

        a.dequeue();
        a.dequeue();
    }
}