package study.java.practice.loop.day07_20260827;

import java.util.ArrayList;

public class Main {
    public static void main (String[] args) {
        /*
         ArrayList 型の変数 animals が用意されています。
         コードを追加して、変数 animals の全ての要素をひとつずつ出力してください。

         なお、引数を囲んでいるカッコと、処理を囲んでいる波カッコは省略してください。
        */
        ArrayList<String> animals = new ArrayList<>();

        animals.add("dog");
        animals.add("cat");
        animals.add("panda");

        animals.forEach(animal -> System.out.println(animal));

        /*
         ArrayList 型の変数 users が用意されています。
         コードを追加して、変数 users の全ての要素をひとつずつ出力してください。
        */

        ArrayList<String> users = new ArrayList<>();

        users.add("kirishima");
        users.add("rokumura");
        users.add("midorikawa");

        // 下にコードを追加する
        users.forEach(user -> System.out.println(user));

        /*
         ArrayList 型の変数 users が用意されています。
         コードを追加して、変数 users の全ての要素をひとつずつ大文字に変換して出力してください。
        */
        ArrayList<String> users = new ArrayList<>();

        users.add("kirishima");
        users.add("rokumura");
        users.add("midorikawa");

        // 下にコードを追加してください
        users.forEach(user -> {
            String upperUser = user.toUpperCase();
            System.out.println(upperUser);
        });

        /*
         ArrayList 型の変数 users2 が用意されています。
         コードを追加して、変数 users2 の全ての要素をひとつずつ出力してください。
        */
        ArrayList<String> users2 = new ArrayList<>();

        users2.add("kirishima");
        users2.add("rokumura");
        users2.add("midorikawa");

        // 下にコードを追加してください
        for (String user: users2) {
            System.out.println(user);
        }
    }
}
