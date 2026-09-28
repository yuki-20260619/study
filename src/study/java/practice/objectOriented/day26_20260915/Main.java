package study.java.practice.objectOriented.day26_20260915;

public class Main {
    public static void main (String[] args) {
        /*
         適切な箇所をインスタンス化できるクラスに変更し、エラーを解消してください。
        */
        // インスタンス化しているクラスの記述を見直し
        //SuperPaiza paiza = new SuperPaiza();
        Paiza paiza = new Paiza();
        paiza.id = 813;
        paiza.printID();

        /*
         抽象メソッドの本体を定義のみに変更し、サブクラスに具象メソッドとしてオーバーライドするようコードを変更し、エラーを解消してください。
        */
        paiza.printID();

        /*
         インターフェースのフィールドに定義されている変数paizaに関する初期化処理について、追記修正しエラーを解消することで、
         813
         と出力されるよう変更してください。
        */
        //Paiza1 paiza1 = new Paiza1();
        System.out.println(Paiza1.paiza);

        /*
         インターフェースのフィールドにスタティックメソッドであるpaizaを定義して、エラーを解消してください。
        */
        Paiza2.paiza();

        /*
         具象クラスであるBraveクラスに、Lightningインターフェースを実装し、抽象メソッドであるlightningメソッドをオーバーライドし「ライトニング」と出力するようにしてください。
        */
        Brave brave = new Brave();
        brave.lightning();

        /*
         具象クラスであるBraveクラスに、LightningインターフェースとSlashインターフェースを実装し、抽象メソッドであるlightningメソッドslashメソッドをオーバーライドし、それぞれ「ライトニング」「スラッシュ」と出力するようにしてください。
        */
        brave.lightning();
        brave.slash();

        /*
         具象クラスであるBraveクラスに、LightningインターフェースとSlashインターフェースを実装しています。この2つのインターフェースに定義されている抽象メソッドであるlightningメソッドslashメソッドをオーバーライドして、それぞれ、
          スライムにライトニングを放った
          スライムにスラッシュを放った
         と出力されるようコードを追加してください。
        */
        Lightning brave1 = new Brave();
        Slash brave2 = new Brave();

        brave1.lightning("スライム");
        brave2.slash("スライム");

        /*
         Lightningインターフェースにデフォルトキーワードを使用して、chantメソッドを定義するコードを追加してください。
        */
        brave.chant();

        /*
         Lightningインターフェースにデフォルトキーワードを使用して、lightningメソッドを定義しています。このlightningメソッド内で呼び出しているchantメソッドを定義するコードを追加してください。
         この際、chantメソッドをLightningインターフェースの外から呼び出している記述も削除してください。
        */
        Lightning1 brave3 = new Brave1();
        brave3.lightning();
    }
}

abstract class SuperPaiza {
    public Integer id;
    //public void printID() {
    abstract public void printID();
    //    System.out.println(id);
    //}
}

class Paiza extends SuperPaiza {
    public void printID() {
        System.out.println(id);
    }
}

interface Paiza1 {
    // インターフェースのフィールド
    int paiza = 813;
}

interface Paiza2 {
    // 以下にインターフェースのスタティックメソッドを記述
    static void paiza() {
        System.out.println(813);
    }
}

interface Lightning {
    void lightning();
    void lightning(String enemy);
    default void chant() {
        System.out.println("詠唱");
    }
}

interface Lightning1 {
    default void lightning() {
        System.out.println(chant());
    }

    // 以下にプライベートキーワードを使用して、chantメソッド を定義
    private String chant() {
        return "ライトニング";
    }
}

interface Slash {
    void slash();
    void slash(String enemy);
}

abstract class Human {
}

// 以下にインターフェースを実装
class Brave extends Human implements Lightning, Slash {
    // 以下にインターフェースに定義された抽象メソッドをオーバライドする lightningメソッド を記述
    @Override
    public void lightning() {
        System.out.println("ライトニング");
    }

    // 以下にインターフェースに定義された抽象メソッドをオーバライドする記述を追加
    @Override
    public void slash() {
        System.out.println("スラッシュ");
    }

    // 以下にインターフェースに定義された抽象メソッドをオーバライドし、スライムにライトニングを放った、となるよう具象メソッドを記述
    @Override
    public void lightning(String enemy) {
        System.out.println(enemy + "にライトニングを放った");
    }

    // 以下にインターフェースに定義された抽象メソッドをオーバライドし、スライムにスラッシュを放った、となるよう具象メソッドを記述
    @Override
    public void slash(String enemy) {
        System.out.println(enemy + "にスラッシュを放った");
    }
}

class Brave1 extends Human implements Lightning1 {

}