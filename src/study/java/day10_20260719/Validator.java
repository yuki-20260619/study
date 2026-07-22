package study.java.day10_20260719;

public class Validator {
    public static void checkAge(int age)  {
        if (age < 0) {
            throw new IllegalArgumentException("年齢は0以上で入力してください。");
        }

        System.out.println("年齢：" + age);
    }
}
