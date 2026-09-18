package study.java.practice.arrays.day22_20260911;

import java.util.*;

public class Main {
    public static void main (String[] args) {
        /*
         このコードの配列 array の全ての要素を出力するために、for文による繰り返し処理を行うコードを追加してください。
        */
        String[] array = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、for文によって配列の全ての要素を出力するためのコードを記述する
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        /*
         このコードの配列 array の全ての要素を出力するために、拡張for文による繰り返し処理を行うコードを追加してください。
        */
        String[] array1 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、拡張for文によって配列の全ての要素を出力するためのコードを記述する
        for (String str : array1) {
            System.out.println(str);
        }

        /*
         このコードの配列 array の全ての要素を出力するために、streamを利用したforEachメソッドを使用するコードを追加してください。
        */
        String[] array2 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // ここに、streamを利用したforEachメソッドによって、配列の全ての要素を出力するためのコードを記述する
        Arrays.stream(array2).forEach(str1 -> System.out.println(str1));

        /*
         String 型の長さ 5 の配列の要素が、それぞれ長さ 5 の配列をあらわす変数 array を、配列作成式により宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列作成式として五次元配列の宣言を記述する
        String[][][][][] array3 = new String[5][5][5][5][5];
        System.out.println(array3[0][0][0][0][0]);

        /*
         String 型の長さ 2 の配列の要素が、それぞれ レッド 、 ブルー 、 ピンク 、 グリーン 、 イエロー を文字列に持つ、 String 型の二次元配列をあらわす変数 array を宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列初期化子を記述する
        String[][] array4 =
                {
                        {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"},
                        {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"}
                };
        System.out.println(array4[0][0]);

        /*
         長さ 2 の配列の要素として、それぞれ レッド 、 ブルー 、 ピンク 、 グリーン 、 イエロー を文字列に持つ、 var を使用した配列をあらわす変数 array を宣言するコードを追加してください。
        */
        // 下記コードの不足部分に追記する形で、配列作成式と配列初期化子を一緒に使用したコードを記述する
        var array5 = new String[][]
                {
                        {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"},
                        {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"}
                };
        System.out.println(array5[0][0]);

        /*
         長さ 2 の配列の、インデックスが 0 の要素として、文字列 レッド 、 ブルー 、 ピンク を、インデックスが 1 の要素として、文字列 グリーン 、 イエロー 、 ゴールド を持つ、 String 型の配列をあらわす変数 array が用意されています。
         このコードの二次元配列 array のインデックスが 0 要素の 2番目の要素である ブルー を出力するコードを追加してください。
        */
        String[][] array6 =
                {
                        {"レッド", "ブルー", "ピンク"},
                        {"グリーン", "イエロー", "ゴールド"}
                };

        // 下記コードの不足部分に追記する形で、配列アクセス式を記述する
        System.out.println(array6[0][1]);

        /*
         このコードの二次元配列 array の全ての要素を出力するために、for文による繰り返し処理を行うコードを追加してください。
        */
        String[][] array7 =
                {
                        {"レッド", "ブルー", "ピンク"},
                        {"グリーン", "イエロー", "ゴールド"}
                };

        // 下記コードの不足部分に追記する形で、for文によって配列の全ての要素を出力するためのコードを記述する
        for (int i = 0; i < array7.length; i++) {
            for (int j = 0; j < array7[i].length; j++){
                System.out.println(array7[i][j]);
            }
        }

        /*
         このコードの二次元配列 array の全ての要素を出力するために、拡張for文による繰り返し処理を行うコードを追加してください。
        */
        String[][] array8 =
                {
                        {"レッド", "ブルー", "ピンク"},
                        {"グリーン", "イエロー", "ゴールド"}
                };

        // 下記コードの不足部分に追記する形で、拡張for文によって配列の全ての要素を出力するためのコードを記述する
        for (String i[] : array8) {
            for (String j : i) {
                System.out.println(j);
            }
        }

        /*
         このコードの配列 array の全ての要素を、要素として持つリスト team を出力するために、asListメソッドを使ったコードを追加してください。
        */
        String[] array9 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};
        // この下にasListメソッドを記述する
        List<String> team = Arrays.asList(array9);

        System.out.println(team);

        /*
         このコードの配列 array と array2 が同等であるか判定するために、equalsメソッドを使ったコードを追加してください。
        */
        String[] array10 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};
        String[] array11 = {"レッド", "ブルー", "ピンク", "ゴールド", "イエロー"};

        // 下記コードの不足部分に追記する形で、equalsメソッドを記述する
        System.out.println(Arrays.equals(array10, array11));

        /*
         このコードの配列 array の要素の値を確認するために、toStringメソッドを使ったコードを追加してください。
        */
        String[] array12 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、toStringメソッドを記述する
        System.out.println(Arrays.toString(array12));

        /*
         このコードの二次元配列 array の深層内容を文字列表現で確認するために、deepToStringメソッドを使ったコードを追加してください。
        */
        var array13 =
                new String[][]
                        {
                                {"レッド", "ブルー", "ピンク"},
                                {"グリーン", "イエロー", "ゴールド"}
                        };

        // 下記コードの不足部分に追記する形で、deepToStringメソッドを記述する
        System.out.println(Arrays.deepToString(array13));

        /*
         このコードの配列 array の内容をコピーした長さ 4 の配列 array2 を用意するために、copyOfメソッドを使ったコードを追加してください。
        */
        String[] array14 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // 下記コードの不足部分に追記する形で、copyOfメソッドを記述する
        String[] array15 = Arrays.copyOf(array14, 4);

        System.out.println(Arrays.toString(array15));

        /*
         このコードの長さ6の配列arrayの各要素に、100を格納するために、fillメソッドを使ったコードを追加してください。
        */
        int[] array16 = new int[6];

        // 下記コードの不足部分に追記する形で、fillメソッドを記述する
        Arrays.fill(array16, 100);
        System.out.println(Arrays.toString(array16));

        /*
         このコードの配列 array の要素を、昇順に並び替えるために、sortメソッドを使ったコードを追加してください。
        */
        String[] array17 = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};

        // この下にsortメソッドを記述する
        Arrays.sort(array17);

        System.out.println(Arrays.toString(array17));
    }
}
