package study.java.practice.classes.day13_20260902;

public class Main {
    public static void main(String[] args) {
        /*
         クラス Prac のインスタンス化をおこなうコードが用意されています。
         コードを追加して、クラス Prac を定義してください。
        */
        Prac p = new Prac();

        /*
         Prac クラスをインスタンス化して出力をおこなうコードが用意されています。
         コードを追加して、Prac クラスにインスタンス変数 message を定義し、インスタンス変数 message に こんにちは を代入して出力してください。
        */
        p.message = "こんにちは";

        System.out.println(p.message);

        /*
         Prac クラスと変数 p1、p2 が用意されています。
         コードを追加して、Prac クラスに戻り値が message である getMessage メソッドを定義してください。
         また、Main メソッド内で以下の処理を実行してください。
        */
        Prac p1 = new Prac();
        Prac p2 = new Prac();

        p1.message = "こんにちは";
        p2.message = "こんばんは";

        System.out.println(p1.getMessage());
        System.out.println(p2.getMessage());

        /*
         Prac クラスと変数 p が用意されています。
         Prac クラスに、戻り値はなく、インスタンス変数 message を出力する printMessage メソッドを定義して、Main メソッド内で呼び出してください。
        */
        p.printMessage();

        /*
         Prac クラスと変数 p が用意されています。
         Prac クラスに、String 型の値を受け取り、それを出力する printStringValue メソッドを定義して、Main メソッド内で呼び出してください。
        */
        p.printStringValue("こんにちは");

        /*
         Prac クラスと変数 p が用意されています。
         Prac クラスに、int 型の値を 2 つ受け取り、それを足し算した値を出力する printAddInt メソッドを定義して、Main メソッド内で呼び出してください。
         なお、printAddInt メソッドの実引数は 5, 10 としてください。
        */
        p.printAddInt(5, 10);

        /*
         Prac クラスと変数 p が用意されています。
         オーバーロードを使って、Prac クラスに引数を受け取らない printValue メソッドを定義して、main メソッド内で呼び出してください。
         なお、新しく定義した printValue メソッドでは、String 型の値を受け取る printValue メソッドを呼び出し、引数に こんにちは を渡してください。
        */
        p.printValue("Hello");
        p.printValue();

        /*
         Prac クラスと変数 p4 が用意されています。
         デフォルトコンストラクタを定義して、インスタンス化の際に デフォルトコンストラクタ と出力してください。
        */
        Prac p4 = new Prac();

        /*
         Prac クラスと変数 p5 が用意されています。
         String 型の値を受け取るコンストラクタを定義して、以下の処理を行ってください。

         - インスタンス変数 message に受け取った文字列を代入
         - インスタンス変数 message の値を出力

         また、インスタンス化の際は、実引数に 仮引数のあるコンストラクタ を渡してください。
        */
        Prac p5 = new Prac("仮引数のあるコンストラクタ");

        /*
         Prac クラスに static キーワードの付与されたメンバー変数 number を定義し、 700 を出力できるようにしてください。
        */
        System.out.println(Prac.NUMBER);

        /*
         static メソッドを追記して、paiza,kirishima,813 を出力してください
        */
        Prac.print(813);
    }
}

class Prac {
    String message;

    public Prac() {
        System.out.println("デフォルトコンストラクタ");
    }

    public Prac(String message) {
        this.message = message;
        System.out.println(message);
    }


    String getMessage() {
        return message;
    }

    void printMessage() {
        System.out.println(message);
    }

    void printStringValue(String message) {
        System.out.println(message);
    }

    void printAddInt(int i1, int i2) {
        System.out.println(i1 + i2);
    }

    void printValue(String s) {
        System.out.println(s);
    }

    void printValue() {
        printValue(String.valueOf("こんにちは"));
    }

    public static final int NUMBER = 700;

    static void print(int i) {
        System.out.println("paiza");
        print(String.valueOf(i));
    }
    static void print(String s) {
        System.out.println("kirishima");
        System.out.println(s);
    }
}
