package study.java.practice.standardInput.day01_20260821;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 3つの整数を標準入力から受け取って計算する
        Scanner sc = new Scanner(System.in);

        int balance = sc.nextInt();
        int salary = sc.nextInt();
        int shopping = sc.nextInt();

        int result = balance + salary - shopping;

        System.out.println(result);
    }
}
