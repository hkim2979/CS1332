public class Main {
    public static void main(String[] args) {
        ExternalChainingHashMap<Object, Object> a = new ExternalChainingHashMap<>();

        a.put(6,6);
        a.put(19,19);
        a.put(8,8);

        System.out.println(a.size());

        System.out.println(a.containsKey(0));
    }
}