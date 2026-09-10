package study.java.practice.classes.day18_20260907.protectedClass;

public class ProtectedClass {
    protected String field = "ProtectedField";

    //protected ProtectedClass() {
    public ProtectedClass() {
        System.out.println("ProtectedConstructor");
    }

    protected void test() {
        System.out.println("ProtectedMethod");
    }
}
