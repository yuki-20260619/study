package study.java.practice.standardInput.day08_20260828;

import java.util.Scanner;
import java.util.ArrayList;

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

        /*
         標準入力から文字列データを 3 個受け取り、ArrayList にまとめて出力してください。
        */
        ArrayList<String> animals = new ArrayList<>();
        Scanner sc3 = new Scanner(System.in);

        animals.add(sc3.nextLine());
        animals.add(sc3.nextLine());
        animals.add(sc3.nextLine());

        System.out.println(animals);

        /*
         入力タブの 1 行目に、データの個数が整数で与えられ、2 行目以降に文字列データが与えられます。
         標準入力からデータを受け取り、2 行目以降のデータを ArrayList にまとめて、ArrayList を出力してください。
        */
        ArrayList<String> users = new ArrayList<>();
        Scanner sc4 = new Scanner(System.in);
        int n = sc4.nextInt();

        for (int i2 = 0; i2 < n; i2++) {
            users.add(sc4.next());
        }

        System.out.println(users);
    }
    }
}
