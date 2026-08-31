package study.java.practice.collection.day09_20260829;

import java.util.LinkedHashSet;

public class Main {
    public static void main(String[] args) {
        /*
         LinkedHashSet 型の変数 animals の宣言および初期化処理をして、変数 animals を出力してください。
        */
        LinkedHashSet<String> animals = new LinkedHashSet<>();
        System.out.println(animals);

        /*
         コードを追加して、変数 animals の要素数を取得して、出力してください。
        */
        animals.add("cat");
        animals.add("dog");
        animals.add("lion");
        animals.add("cat");

        System.out.println(animals.size());

        /*
         コードを追加して、変数 animals に cat が含まれているか確認して、結果を出力してください。
        */
        System.out.println(animals.contains("cat"));

        /*
         コードを追加して、変数 animals から lion を削除して、変数 animals を出力してください。
        */
        animals.remove("lion");
        System.out.println(animals);

        /*
         コードを追加して、変数 animals の全要素を削除して、変数 animals を出力してください。
        */
        animals.clear();
        System.out.println(animals);

        /*
         コードを追加して、変数 animals が空かどうか確認して、結果を出力してください。
        */
        System.out.println(animals.isEmpty());

        animals.add("cat");
        animals.add("dog");
        animals.add("lion");

        System.out.println(animals.isEmpty());
    }
}
