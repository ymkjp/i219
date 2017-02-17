// % java -ea TestAssert
public class TestAssert {
    public static void main(String[] args) {
        Integer m = new Integer(3);
        Integer n = new Integer(3);
        assert m == n : "m & n refer to different objects";
    }
}