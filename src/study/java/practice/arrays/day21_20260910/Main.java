package study.java.practice.arrays.day21_20260910;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        /*
         String 型の配列をあらわす変数 array を宣言するコードを追加してください。作成した配列の1番目の要素（インデックス0）に「レッド」という文字列を代入して、それを出力してください。
        */
        // ここに配列をあらわす変数の宣言を記述する
        String[] array = new String[1];
        array[0] = "レッド";

        System.out.println(array[0]);

        /*
         String 型の配列をあらわす変数 array を、長さが 3 の配列として生成する配列作成式により、配列を宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列作成式を記述する
        String[] array1 = new String[3];
        System.out.println(Arrays.toString(array1));

        /*
         レッド 、 ブルー 、 ピンク 、 グリーン 、 イエロー の文字列を要素に持つ、 String 型の配列をあらわす変数 array を宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列初期化子を記述する
        String[] array2 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};
        System.out.println(Arrays.toString(array2));

        /*
         レッド 、 ブルー 、 ピンク 、 グリーン 、 イエロー の文字列を要素に持つ、 var を使用した配列をあらわす変数 array を宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列作成式と配列初期化子を一緒に使用したコードを記述する
        var array3 = new String[] {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};
        System.out.println(Arrays.toString(array3));

        /*
         長さ 5 の String 型の配列をあらわす変数 array が用意されています。
         このコードの配列 array の4番目の要素である グリーン を出力するコードを追加してください。
        */
        String[] array4 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、配列アクセス式を記述する
        System.out.println(array4[3]);

        /*
         String 型の配列の初期化処理が用意されています。
         このコードの配列 array の6番目の要素である ホワイト を ゴールド に置き換えるコードを追加してください。
        */
        String[] array5 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー", "ホワイト"};
        // ここに配列の要素の置き換えるコードを記述する
        array5[5] = "ゴールド";
        System.out.println(Arrays.toString(array5));

        /*
         String 型の配列の初期化処理が用意されています。
         このコードの配列 array の最後の要素を出力するためのコードを追加してください。
        */
        String[] array6 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、配列の最後の要素を出力するためのコードを記述する
        System.out.println(array6[array6.length - 1]);
    }
}
