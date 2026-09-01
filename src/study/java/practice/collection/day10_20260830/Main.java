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


    }
}
