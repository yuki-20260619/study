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

        //課題３：（エラー無）finally
        System.out.println("課題３：（エラー無）finally");

        try {
            System.out.println("処理を開始します。");

            int number = Integer.parseInt("200");
            System.out.println("変換結果：" + number);

        } catch (NumberFormatException e) {
            System.out.println("変換できません。");

        } finally {
            System.out.println("終了処理を実行します。");
        }

        System.out.println();

        //課題４：（エラー有）finally
        System.out.println("課題４：（エラー有）finally");

        try {
            System.out.println("処理を開始します。");

            int number = Integer.parseInt("abc");
            System.out.println("変換結果：" + number);

        } catch (NumberFormatException e) {
            System.out.println("変換できません。");

        } finally {
            System.out.println("終了処理を実行します。");
        }

        System.out.println();

        //課題５：例外メッセージを表示する
        System.out.println("課題５：例外メッセージを表示する");

        try {
            int number = Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("エラーが発生しました。");
            System.out.println(e.getMessage());
        }
        System.out.println();

        //課題６：throwsを使って例外を呼び出し元へ渡す
        System.out.println("課題６：throwsを使って例外を呼び出し元へ渡す");

        try {
            int number = Converter.convert("500");
            System.out.println(number);

            number = Converter.convert("abc");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("変換できません。");
            System.out.println(e.getMessage());
        }

        System.out.println();

        //課題７：throwを使って自分で例外を発生させる
        System.out.println("課題７：throwを使って自分で例外を発生させる");

        try {
            Validator.checkAge(20);
            Validator.checkAge(-5);
        } catch (IllegalArgumentException e) {
            System.out.println("入力エラー");
            System.out.println(e.getMessage());
        }

        System.out.println();
    }
}
