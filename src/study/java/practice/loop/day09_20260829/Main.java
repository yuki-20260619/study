package study.java.practice.loop.day09_20260829;

public class Main {
    public static void main(String[] args) {
        /*
         1 から 7まで出力したあとに paiza! と出力するコードが用意されています。
         このコードを変更して、800 から 812 まで出力したあとに paiza! と表示するようにしてください。
        */
        Integer i = 800; //ここを修正する
        while(i <= 812){  //ここを修正する
            System.out.println(i);
            i++;
        }
        System.out.println("paiza!");
    }
}
