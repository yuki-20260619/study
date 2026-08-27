package study.java.practice.standardInput.day08_20260828;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
         nextLine を使用して標準入力から値を1つ受け取り、受け取った値を出力してください。
        */
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        System.out.println(str);

        /*
         next を使用して標準入力から値を1つ受け取り、受け取った値を出力してください。
        */
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        System.out.println(s);

        /*
         nextInt を使用して標準入力から値を1つ受け取り、受け取った値を 100 倍にして出力してください。
        */
        Scanner sc2 = new Scanner(System.in);
        int i = sc2.nextInt();

        System.out.println(i * 100);
    }
}
