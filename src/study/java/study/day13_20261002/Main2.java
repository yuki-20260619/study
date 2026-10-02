package study.java.study.day13_20261002;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        /*
        PAIZA病院のシステムを解析します。
        不正アクセスを試みるクラッカーからユーザーを守るために、ユーザーが設定するパスワードが十分に複雑であるようにしなくてはなりません。
        PAIZA病院は、パスワードの複雑さの条件として以下の 3 つを定めました。

        ・長さが 6 以上
        ・英字と数字の両方を含む必要がある
        ・同じ文字を 3 つ以上連続で使用することはできない

        なお、英字の大文字と小文字は区別する必要はありません。
        パスワードの候補が入力として与えられるので、複雑さの条件をすべて満たす場合は "Valid"、そうでない場合は "Invalid" と出力してください。

        例えば、入力例 1 で与えられる 7Caaad9 は 1 つ目の条件と 2 つ目の条件を満たしますが、aaa と 3 つ以上同じ文字が連続で使用されているため、複雑さの条件をすべて満たしません。

        ・パスワードの候補となる文字列 t が与えられます。
        ・入力は 1 行となり、末尾に改行が 1 つ入ります。
         */
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        boolean result = passwordCheck(password);

        if (result == true) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    static Boolean passwordCheck(String password) {

        if (password.length() < 6) {
            return false;
        }

        if (!password.matches("(?=.*[A-Za-z])(?=.*[0-9]).+")) {
            return false;
        }

        if (password.matches(".*(.)\\1{2}.*")) {
            return false;
        }

        return true;
    }
}
