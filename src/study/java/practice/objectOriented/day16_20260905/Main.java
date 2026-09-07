package study.java.practice.objectOriented.day16_20260905;

public class Main {
    public static void main(String[] args) {
        /*
         Fruits クラス、それを継承するApple クラスとOrange クラス、Peach クラス、Orange クラスのインスタンスを参照するfが用意されています。
         コードに演算子を追加して、f が継承しているクラスを調べましょう。
        */
        Orange o1 = new Orange();
        Fruits f = o1;

        // 下記のコードを修正する
        System.out.println(f instanceof Fruits);
        System.out.println(f instanceof Apple);
        System.out.println(f instanceof Orange);
        System.out.println(f instanceof Peach);

        /*
         コードを追加して、フルーツクラス と出力されるようにtoString メソッドを再定義してください。
        */
        Object a1 = new Fruits();

        System.out.println(a1.toString());

        /*
         Object クラスのインスタンスb1, b2 , b3が用意されています。
         コードを修正して、b1とb2、b1とb3がお互いに等しいかどうかを調べて出力してください。
        */
        Object b1 = new Object();
        Object b2 = b1;
        Object b3 = new Object();

        // 下記のコードを修正
        //b1とb2が等しいかどうか
        System.out.println(b1 == b2);

        //b1とb3が等しいかどうか
        System.out.println(b1 == b3);

        /*
         Object クラスのインスタンスc1 が用意されています。
         コードを修正して、c1 のクラスを表す文字列表現を出力してください。
        */
        Object c1 = new Object();

        //下記のコードを修正
        System.out.println(c1.getClass());

        /*
         Fruits クラスが定義されています。printJapanese メソッド内ではgetJapanese メソッドを呼び出し、その実行結果を出力しています。
         このまま実行すると、null が返されてしまいます。適切な位置にthis を追記して、「果物」と出力させるようにしてください。
        */
        Fruits f1 = new Fruits("果物");
        f1.printJapanese();

        /*
         Fruits クラスが定義されています。printJapanese メソッド内ではgetJapanese メソッドを呼び出し、その実行結果を出力しています。
         このまま実行すると、コンパイルエラーになってしまいます。引数無しのコンストラクタを呼び出し、文字列「果物」を渡して、オーバーロードされたコンストラクタを呼び出すように、コードを追加してください。
        */
        Fruits f2 = new Fruits();
        f2.printJapanese();

        /*
         Fruits クラス、それを継承するPeach クラスが定義されています。
         Fruits クラスには、season というメソッドが定義されており、Peach クラスでオーバーライドされています。
         Peach クラスのtest メソッドにコードを追加して、Fruits クラスのseason メソッドを呼び出してください。
        */
        (new Peach()).test();


    }
}

class Fruits {
    //ここにコードを追加
    public String toString() {
        return "フルーツクラス";
    }

    private String japanese;
    public String japanese1 = "果物";

    public Fruits(){
        this.japanese = "果物";
    }

    public Fruits(String japanese){
        this.japanese = japanese;
    }

    public String getJapanese(){
        return japanese;
    }

    public void printJapanese(){
        System.out.println(this.getJapanese());
    }

    public void fruitsMethod(){
        System.out.println("fruitsMethod");
    }

    public void season(){
        System.out.println("all season");
    }
}

class Apple extends Fruits {
}

class Orange extends Fruits {
}

class Peach extends Fruits {
    public String japanese1 = "桃";

    public void season(){
        System.out.println("summer");
    }

    void test() {
        //ここにコードを追加
        super.season();
    }
}
