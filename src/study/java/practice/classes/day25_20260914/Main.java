package study.java.practice.classes.day25_20260914;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        /*
         コード内のインスタンスイニシャライザを完成させ、エラーを解消してください。
        */
        Paiza paiza = new Paiza();
        System.out.println(paiza.list);

        /*
         コードエリアには、空文字を出力するよう、インスタンスイニシャライザとコンストラクタに、それぞれコードが記述されています。
         このコードを、
         Hello
         paiza
         の順番で出力されるよう変更してください。
        */
        Paiza paiza1 = new Paiza();

        /*
         コードエリアには、空文字を出力するよう、スーパークラスのインスタンスイニシャライザと、継承したクラスのインスタンスイニシャライザ、コンストラクタに、それぞれコードが記述されています。
         このコードを、
         Super
         Hello
         paiza
         の順番で出力されるよう変更してください。
        */
        Paiza1 paiza2 = new Paiza1();

        /*
         スタティックイニシャライザをコード内に追加し、エラーを解消してください。
        */
        System.out.println(paiza.list);

        /*
         スタティックイニシャライザとコンストラクタに、それぞれコードが記述されています。
         このコードを、
         Hello
         paiza
         paiza
         paiza
         の順番で出力されるよう変更してください。
        */
        Paiza paiza3 = new Paiza();
        Paiza paiza4 = new Paiza();
        Paiza paiza5 = new Paiza();

        /*
         スーパークラスのスタティックイニシャライザと、継承したクラスのスタティックイニシャライザ、コンストラクタに、それぞれコードが記述されています。

         このコードを、
         Super
         Hello
         paiza
         paiza
         paiza
         の順番で出力されるよう変更してください。
        */
        Paiza1 paiza6 = new Paiza1();
        Paiza1 paiza7 = new Paiza1();
        Paiza1 paiza8 = new Paiza1();
    }
}

class SuperPaiza {
    //{
        // 以下に正しいと思う値を入力
    //    System.out.println("Super");
    //}

    static {
        // 以下に正しいと思う値を入力
        System.out.println("Super");
    }
}

class Paiza {
    //ArrayList<Integer> list;

    // ここにインスタンスイニシャライザを完成させるために必要な処理を記述
    //{
    //    list = new ArrayList<>();
    //    list.add(813);
    //}

    //{
    //    // 以下に正しいと思う値を入力
    //    System.out.println("Hello");
    //}

    static ArrayList<Integer> list;

    // ここに追記してスタティックイニシャライザを完成させる
    static {
        //list = new ArrayList<>();
        //list.add(813);

        // 以下に正しいと思う値を入力
        System.out.println("Hello");
    }

    Paiza() {
        // 以下に正しいと思う値を入力
        System.out.println("paiza");
    }
}

class Paiza1 extends SuperPaiza {
    //{
        // 以下に正しいと思う値を入力
    //    System.out.println("Hello");
    //}

    static {
        // 以下に正しいと思う値を入力
        System.out.println("Hello");
    }

    Paiza1() {
        // 以下に正しいと思う値を入力
        System.out.println("paiza");
    }
}