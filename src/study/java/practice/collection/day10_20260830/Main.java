package study.java.practice.collection.day10_20260830;

import java.util.LinkedHashMap;

public class Main {
    public static void main(String[] args) {
        /*
         LinkedHashMap 型の変数 users が用意されています。
         コードを追加して、変数 users に キーが 1、値が kirishima のペアを追加して、変数 users を出力してください。
        */
        LinkedHashMap<Integer, String> users = new LinkedHashMap<>();

        users.put(1,"kirishima");

        System.out.println(users);

        /*
         コードを追加して、変数 users の 1 に紐づく値を取得して、出力してください。
        */
        users.put(2, "rokumura");
        users.put(3, "midorikawa");

        System.out.println(users.get(1));

        /*
         コードを追加して、変数 users の保持しているペアの数を取得して、出力してください。
        */
        System.out.println(users.size());

        /*
         コードを追加して、変数 users にキーが 2 のペアが存在するか確認して、結果を出力してください。
        */
        System.out.println(users.containsKey(2));

        /*
         コードを追加して、変数 users のキーが 1 のペアを削除して、変数 users を出力してください。
        */
        users.remove(1);

        System.out.println(users);

        /*
         コードを追加して、変数 users の全てのペアを削除して、変数 users を出力してください。
        */
        users.clear();

        System.out.println(users);

        /*
         コードを追加して、変数 users が空かどうか確認して、結果を出力してください。
        */
        System.out.println(users.isEmpty());

        /*
         forEach メソッドを使用して、変数 users のペアをひとつずつ key:value の形式で出力してください。
        */
        users.put(1, "kirishima");
        users.put(2, "rokumura");
        users.put(3, "midorikawa");

        users.forEach((key, value) -> System.out.println(key + ":" + value));

        /*
         keySet メソッドでキーのセットを取得し、拡張 for 文で変数 users のペアをひとつずつ key:value の形式で出力してください。
        */
        for (int key : users.keySet()) {
            String value = users.get(key);
            System.out.println(key + ":" + value);
        }

    }
}
