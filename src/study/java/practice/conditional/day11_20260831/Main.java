package study.java.practice.conditional.day11_20260831;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         標準入力から値を受け取るコードが用意されています。
         switch 文を使用して、受け取った値に合わせて以下のような出力をおこなうコードを作成してください。
        */
        Scanner sc = new Scanner(System.in);
        Integer i = sc.nextInt();

        switch(i) {
            case 1 -> System.out.println("ONE");
            case 2 -> System.out.println("TWO");
            default -> System.out.println("OVER");
        }

        /*
         switch 式を使用して、受け取った値に合わせて以下のような出力をおこなうコードを作成してください。
        */
        String value = switch(i) {
            case 1, 3 -> "ODD";
            case 2, 4 -> "EVEN";
            default -> "OVER";
        };

        System.out.println(value);

        /*
         switch 式を使用して、受け取った値に合わせて文字列型の変数 judge に代入をおこない、以下のような出力をおこなうコードを作成してください。
        */
        String judge = switch(i) {
            case 1, 3 -> "ODD";
            case 2, 4 -> "EVEN";
            default -> "OVER";
        };

        System.out.println(judge);
    }
}
