class TestB extends TestA {
    static String test_static = "StaticB";
    String test = "B";

    public static void testingStatic() {
        System.out.println(test_static);
    }

    public void testingLikeStatic() {
        System.out.println(test_static);
        System.out.println(super.test_static);
    }

    public void testing() {
        System.out.println(test);
        System.out.println(super.test);
    }
}
