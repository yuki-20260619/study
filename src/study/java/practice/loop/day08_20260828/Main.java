package study.java.practice.loop.day08_20260828;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         for 文を使用して、0 から 10 までの数字をひとつずつ出力してください。
        */
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        /*
         ArrayList 型の変数 users が用意されています。
         コードを追加して、変数 users の要素をひとつずつ出力してください。
        */
        ArrayList<String> users = new ArrayList<>();
        users.add("kirishima");
        users.add("rokumura");
        users.add("midorikawa");

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i));
        }

        /*
         ArrayList 型の変数 users2 が用意されています。
         コードを追加して、forEach メソッドで変数 users2 の要素をひとつずつ出力してください。
        */
        ArrayList<String> users2 = new ArrayList<>();
        users2.add("kirishima");
        users2.add("rokumura");
        users2.add("midorikawa");

        users2.forEach(user -> System.out.println(user));

        /*
         ArrayList 型の変数 users3 が用意されています。
         コードを追加して、拡張for文で変数 users3 の要素をひとつずつ出力してください。
        */
        ArrayList<String> users3 = new ArrayList<>();
        users3.add("kirishima");
        users3.add("rokumura");
        users3.add("midorikawa");

        for (String user: users3) {
            System.out.println(user);
        }

        /*
         for 文と if 文を組み合わせて、1 から 30 までの範囲の偶数をひとつずつ出力してください。
        */
        for (int i = 1; i <= 30; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
