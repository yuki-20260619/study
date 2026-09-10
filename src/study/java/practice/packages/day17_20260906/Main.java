package study.java.practice.packages.day17_20260906;

// ここに import文 を記述する
// ここにオンデマンド型宣言を記述する
import java.util.*;

// ここに 単一staticインポート を記述する
import static java.lang.Math.min;

// ここに オンデマンドstaticインポート を記述する
import static java.lang.Long.*;

public class Main {
    public static void main (String[] args) {
        /*
         java.utilパッケージ の Listクラス と ArrayListクラス を使用しようとしているコードが記述されています。
         このコードが正常に終了するように、 java.utilパッケージ の Listクラス と ArrayListクラス を使用できるようにする import文 を追加してください。
        */
        List<String> list = new ArrayList<String>(){
            {
                add("勇者");
                add("戦士");
            }
        };

        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        /*
         java.utilパッケージ の複数のクラスなどを使用しようとしているコードが記述されています。
         このコードが正常に終了するように、 java.utilパッケージ でオンデマンド型の宣言を追加してください。
        */
        ArrayList<String> job = new ArrayList<String>();

        job.add("勇者");
        job.add("戦士");

        for(int i = 0; i < job.size(); i++) {
            System.out.println(job.get(i));
        }
        Map<String, String> m = new HashMap<>();
        Date d = new Date();

        /*
         Mathクラス の min というメソッドを使用しようとしているコードが記述されています。
         このコードが正常に動作するように、 Mathクラス の min というメソッドをインポートするためのコードを追加してください。
        */
        System.out.println(min(55, 135));

        /*
         Longクラス の複数の staticメソッド を使用しようとしているコードが記述されています。
         このコードが正常に動作するように、 Longクラス の staticメソッド が必要に応じて staticインポート されるようにするためのコードを追加してください。
        */
        System.out.println(max(55, 135));
        System.out.println(min(55, 135));
    }
}
