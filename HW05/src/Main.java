public class Main {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        tree.add(1);
        tree.add(2);
        tree.add(3);
        tree.add(4);
        tree.add(5);
        tree.add(5);
        tree.add(5);

        tree.remove(3);

        tree.display();
    }
}