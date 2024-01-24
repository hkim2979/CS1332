public class Main {
    public static void main(String[] args) {
        ArrayList<Object> a = new ArrayList<>();


        a.addToFront(777);
        a.addToBack(88);

        a.removeFromFront();
        //a.removeFromBack();


        a.print();
    }
}