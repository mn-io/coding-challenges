class TestA {
    static String test_static = "StaticA";
    String test = "A";

    public static void testingStatic() {
        System.out.println(test_static);
    }

    public void testingLikeStatic() {
        System.out.println(test_static);
    }

    public void testing() {
        System.out.println(test);
    }
}
