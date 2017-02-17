public class TestEquals {
    public static void main(String[] args) {
        Integer m = new Integer(3);
        Integer n = new Integer(3);
        System.out.println("m==n: " + (m == n));
        System.out.println("m.equals(n): " + m.equals(n));
    }
}