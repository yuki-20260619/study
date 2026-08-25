package study.java.practice.conditional.day05_20260825;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // for
        // Hello paizaと100回表示する
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello paiza");
        }

        // for
        // 受け取った整数の回数分、Hello paizaと表示する
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();

        for (int i = 0; i < count; i++) {
            System.out.println("Hello paiza");
        }

        // 1. 標準入力から整数を 1 個受け取る
        // 2. 受け取った整数を表示する
        // 3. 受け取った整数回分、以下の処理を繰り返す
        // a. さらに標準入力から整数を 1 個受け取る
        // b. その整数が 0 の場合、Xは0を表示する
        // c. その整数が 0 より大きい場合、Xはプラスを表示する
        // d. それ以外の場合、Xはマイナスを表示する
        // ※ X には、その整数を当てはめる
        for (int i = 0; i < count; i++) {
            int x = scan.nextInt();

            if (x == 0) {
                System.out.println(x + "は0");
            } else if (x > 0) {
                System.out.println(x + "はプラス");
            } else {
                System.out.println(x + "はマイナス");
            }
        }
    }
}

