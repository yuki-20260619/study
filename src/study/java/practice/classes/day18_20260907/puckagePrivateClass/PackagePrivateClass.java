package study.java.practice.classes.day18_20260907.puckagePrivateClass;

public class PackagePrivateClass {
//class PackagePrivateClass {

    String field = "PackagePrivateField";

    public PackagePrivateClass() {
    //PackagePrivateClass() {
        System.out.println("PackagePrivateConstructor");
    }

    void test() {
        System.out.println("PackagePrivateMethod");
    }
}
