public class HomeWorkApp {
    public static void main(String[] args) {
        System.out.println(TestParent.test(1));
        System.out.println(TestClass.test(1));

    }

}

class TestClass extends TestParent {

    static int test(int asd) {
        asd ^= 1;
        return asd;
    }
}

class TestParent {
    static int asd;

    static int test(int asd) {
        asd += asd;
        return asd;
    }
}
