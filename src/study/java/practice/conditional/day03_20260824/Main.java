package study.java.practice.conditional.day03_20260824;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();

        // if
        // 受け取った整数が100以上の場合、その数値を表示する
        if (number >= 100) {
            System.out.println(number);
        }

        // else
        // 受け取った整数が100より大きい場合、その整数データを表示する
        // 受け取った整数が100より大きくない場合、100以下ですと表示する
        if (number > 100) {
            System.out.println(number);
        } else {
            System.out.println("100以下です");
        }

        // else if
        // 受け取った整数が100と等しい場合、その整数データを表示する
        // 受け取った整数が100より大きい場合、100より大きいと表示する
        // 受け取った整数が100より大きくない場合、100より小さいと表示する
        if (number == 100) {
            System.out.println(number);
        } else if (number > 100) {
            System.out.println("100より大きい");
        } else {
            System.out.println("100より小さい");
        }

        // equals
        // 受け取った文字列がHelloと等しい場合、こんにちはと表示する
        String greeting = scan.next();

        if (greeting.equals("Hello")) {
            System.out.println("こんにちは");
        }

        // else-equals
        // 受け取った文字列がHelloと等しい場合、こんにちはと表示する
        // 受け取った文字列がHelloと等しくない場合、さようならと表示する
        if (greeting.equals("Hello")) {
            System.out.println("こんにちは");
        } else {
            System.out.println("さようなら");
        }
    }
}

