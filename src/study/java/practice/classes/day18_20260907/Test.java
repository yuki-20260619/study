package study.java.practice.classes.day18_20260907;

//import study.java.practice.classes.day18_20260907.puckagePrivateClass.PackagePrivateClass;
import study.java.practice.classes.day18_20260907.protectedClass.ProtectedClass;

//public class Test {
//public class Test extends PackagePrivateClass {
public class Test extends ProtectedClass {
    public static void main(String... args) {
        //PackagePrivateClass pp = new PackagePrivateClass();
        //pp.test();
        //System.out.println(pp.field);
        Test t = new Test();
        //t.callMethod();
        ProtectedClass pc = new ProtectedClass();
        //pc.test();
        //System.out.println(pc.field);
        t.printField();
    }

    public void callMethod() {
        //test();
    }

    public void printField() {
        System.out.println(field);
    }
}
