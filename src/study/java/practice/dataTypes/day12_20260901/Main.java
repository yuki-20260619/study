package study.java.practice.dataTypes.day12_20260901;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         このままではエラーになります。
         コードを修正して、正しく実行できるようにしてください。
        */
        // ArrayList<int> l = new Arraylist<>();
        ArrayList<Integer> l = new ArrayList<>();

        l.add(8);
        l.add(1);
        l.add(3);

        System.out.println(l);

        /*
         Long 型から int 型に変換できずエラーになります。
         コードを修正して、明示的に Long 型から int 型にキャストして実行できるようにしてください。
        */
        long l2 = 813L;

        //int i = l2;
        int i = (int)l2;

        System.out.println(i);

        /*
         double 型から float 型に変換できずエラーになります。
         コードを修正して、明示的に double 型から float 型にキャストして実行できるようにしてください。
        */
        double d = 3.16;
        float f = 8.13f;

        //f = d;
        f = (float) d;

        System.out.println(f);

        /*
         double 型から int 型に変換できずエラーになります。
         コードを修正して、明示的に double 型から int 型にキャストして実行できるようにしてください。
        */
        int i2 = 0;
        double d2 = 3.16;

        //i2 = d;
        i2 = (int) d2;

        System.out.println(i2);

    }
}
