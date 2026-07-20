package study.java.day10_20260719;

public class Main {
    public static void main(String[] args) {
        // 課題１：（エラー無）整数へ変換する
        System.out.println("課題１：（エラー無）整数へ変換す");

        try {
            int number = Integer.parseInt("100");
            System.out.println(number);
        } catch (Exception e) {
            System.out.println("エラー");
        }

        System.out.println();

        //課題２：（エラー有）整数へ変換する
        System.out.println("課題２：（エラー有）整数へ変換す");

        try {
            int number = Integer.parseInt("abc");
            System.out.println(number);
        } catch (Exception e) {
            System.out.println("変換できません");
        }

        System.out.println();

        //課題３：finally
        System.out.println("課題３：finally");

        try {
            System.out.println("処理開始");
        } catch (Exception e) {
            System.out.println("エラー");
        } finally {
            System.out.println("少量処理");
        }

        System.out.println();
    }
}
