package study.java.practice.standardInput.day03_20260823;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 文字列を標準入力から受け取る
        Scanner scan = new Scanner(System.in);
        String message = scan.next();
        System.out.println(message);

        // 整数を標準入力から受け取る
        Scanner scan2 = new Scanner(System.in);
        int number = scan2.nextInt();
        System.out.println(number);

        // 受け取った整数を計算する
        System.out.println(number * 10);
    }

}
