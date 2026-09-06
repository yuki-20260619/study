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

    }
}

class Fruits {
}

class Apple extends Fruits {
}

class Orange extends Fruits {
}

class Peach extends Fruits {
}
