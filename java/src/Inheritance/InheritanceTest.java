public class InheritanceTest {

    public static void main(String[] args) {
        System.out.println("-- Parent class");
        System.out.println("all A");
//        System.out.println("static member: " + TestA.test_static);
//        System.out.print("static function: ");
//        TestA.testingStatic();
//
//        TestA testA = new TestA();
//        System.out.println("-- instance: ");
//        System.out.println("field: " + testA.test);
//        System.out.println("static member: " + testA.test_static);
//        System.out.print("static like function: ");
//        testA.testingLikeStatic();
//
//        System.out.print("function: ");
//        testA.testing();

        System.out.println("-----------------");

        System.out.println("Regular inheritance");
        System.out.println("all B");
//        System.out.println("static member: " + TestB.test_static);
//        System.out.print("static function: ");
//        TestB.testingStatic();
//
//        TestB testB = new TestB();
//        System.out.println("Instance: ");
//        System.out.println("field: " + testB.test);
//        System.out.println("static member: " + testB.test_static);
//        System.out.print("static like function: ");
//        testB.testingLikeStatic();
//
//        System.out.print("function: ");
//        testB.testing();

        System.out.println("-----------------");
        TestA testAB = new TestB();
        System.out.println("Instance casted: ");
        System.out.println("field: " + testAB.test);
        System.out.println("static member: " + testAB.test_static);
        System.out.print("static like function: ");
        testAB.testingLikeStatic();

        System.out.print("function: ");
        testAB.testing();
    }
}
