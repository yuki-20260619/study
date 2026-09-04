package study.java.practice.objectOriented.day15_20260904;

public class Main {
    public static void main (String[] args) {
        /*
         スーパークラスとして Job クラスが用意されています。
         このコードの Yusha をサブクラスとして、スーパークラスである Job クラスを継承するコードを追加してください。
        */
        Yusha y = new Yusha();

        /*
         Job クラスに、インスタンス変数として、HP と Attack を定義するコードを追加してください。
        */
        Yusha Player1 = new Yusha();

        Player1.HP = 200;
        Player1.Attack = 70;

        System.out.println(Player1.HP);
        System.out.println(Player1.Attack);

        /*
         Job クラスに、インスタンスメソッドとして、 battle メソッドを定義するコードを追加してください。
        */
        Player1.battle("スライム");

        /*
         Job クラスにある、private なインスタンス変数 HP について操作するアクセサを定義するコードを追加してください。
        */
        Player1.setHP(200);
        Player1.printHP();

        /*
         Job クラスにある、インスタンスメソッドの battle メソッドを、サブクラスから上書きするコードを追加してください。
        */
        Player1.battle("スライム");

        /*
         Job クラスにある、インスタンスメソッドの Battle メソッドを、サブクラス Yusha クラスと wizard クラスから、ぞれぞれ上書きするコードを追加してください。
        */
        Job Player2 = new Yusha();
        Job Player3 = new Wizard();

        Player2.battle("スライム");
        Player3.battle("スライム");

        /*
         callHit メソッドとして、 Job クラスにあるインスタンスメソッドの hit メソッドを、 Main クラスから呼び出すコードを追加してください。
        */
        Yusha Player4 = new Yusha();
        Wizard Player5 = new Wizard();

        callHit(Player4);
        callHit(Player5);
    }

    //　Jobクラスにあるインスタンスメソッドのhitメソッドを、Mainクラスから呼び出すコードを記述する
    public static void callHit(Job Player) {
        Player.hit();
    }
}

class Job {
    int HP;
    int Attack;

    //　この下にスーパークラスのインスタンスメソッドを記述する
    public void battle(String enemy) {
        System.out.println(enemy + "と戦っている");
    }

    //　この下にスーパークラスのインスタンス変数にアクセスするためのアクセサを記述する
    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return HP;
    }

    public void hit() {
        System.out.println("100のダメージ");
    }
}

class Yusha extends Job {
    public void printHP() {
        System.out.println(getHP());
    }

    //　インスタンスメソッドのBattleメソッドを、サブクラスから上書きするコードを記述する
    public void battle(String enemy) {
        System.out.println("勇敢にも" + enemy + "と戦っている");
    }

    public void hit() {
        System.out.println("80のダメージ");
    }
}

class Wizard extends Job {
    //　インスタンスメソッドのbattleメソッドを、冷静にスライムと戦っている、となるように、サブクラスから上書きするコードを記述する
    public void battle(String enemy) {
        System.out.println("冷静に" + enemy + "と戦っている");
    }

    public void hit() {
        System.out.println("120のダメージ");
    }
}
