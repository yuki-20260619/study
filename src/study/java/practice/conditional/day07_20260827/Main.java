package study.java.practice.conditional.day07_20260827;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        /*
         このままではエラーになります。
         コードを修正して、変数 i の値が 5 であれば iは5 と出力してください。
        */
        Integer i = 5;

        if (i == 5) {
            System.out.println("iは5");
        }

        /*
         このままではエラーになります。
         コードを修正して、変数 i2 の値が 10 であれば i2は10 と出力してください。
        */
        Integer i2 = 10;

        if (i2 == 10) {
            System.out.println("i2は10");
        }

        /*
         変数 i3 の値が 5 のときに i3は5 と出力するコードが用意されています。
         コードを追加して、変数 i3 の値が 5 でないときに i3は5ではない と出力してください。
        */
        Integer i3 = 7;

        if (i3 == 5) {
            System.out.println("i3は5");
        } else {
            System.out.println("i3は5ではない");
        }

        /*
         変数 i4 の値が 1 のときに 1位です 、それ以外の時に 最下位です と出力するコードが用意されています。
         コードを追加して、変数 i4 の値が 2 のときに 2位です と出力してください。
        */
        Integer i4 = 2;

        if (i4 == 1) {
            System.out.println("1位です");
        } else if(i4 == 2) {
            System.out.println("2位です");
        } else {
            System.out.println("最下位です");
        }

        /*
         ArrayList 型の変数 scores が用意されています。
         コードを追加して、変数 scores の全要素に対して、その値が70点以上のときは 合格 と出力し、それ以外の時は 不合格 と出力してください。

         なお、繰り返し処理は、forEach メソッドと拡張 for 文のどちらを使用しても問題ありません。
        */
        ArrayList<Integer> scores = new ArrayList<>();

        scores.add(30);
        scores.add(70);
        scores.add(90);
        scores.add(69);

        scores.forEach(score -> {
            if (score >= 70) {
                System.out.println("合格");
            } else {
                System.out.println("不合格");
            }
        });

        /*
         ArrayList 型の変数 members が用意されています。
         コードを追加して、 members に kirishima が含まれている時は membersにkirishimaは含まれている と出力し、
         それ以外の時は membersにkirishimaは含まれていない と出力してください。
        */
        ArrayList<String> members = new ArrayList<>();

        members.add("kirishima");
        members.add("rokumura");


        members.forEach(member -> {
            // 以下にコードを追加
            if (member.equals("kirishima")) {
                System.out.println("membersにkirishimaは含まれている");
            } else {
                System.out.println("membersにkirishimaは含まれていない");
            }
        });

        /*
         Integer 型の変数 x と 変数 y が用意されています。
         コードを追加して、変数 x もしくは変数 y の値が偶数のときに xとyのいずれか、もしくは両方とも偶数です と出力し、
         それ以外の時は xとyは奇数です と出力してください。
        */
        Integer x = 37;
        Integer y = 16;

        // 以下のコードを修正
        if (x % 2 == 0 || y % 2 == 0) {
            System.out.println("xとyのいずれか、もしくは両方とも偶数です");
        } else {
            System.out.println("xとyは奇数です");
        }

        /*
         Integer 型の変数 x2 と 変数 y2 が用意されています。
         コードを追加して、変数 x2 と変数 y2 の値が両方とも偶数のときに xとyは偶数です と出力し、
         それ以外の時は x2とy2のいずれか、もしくは両方とも奇数です と出力してください。
        */
        Integer x2 = 30;
        Integer y2 = 18;
        // 以下のコードを修正
        if (x2 % 2 == 0 && y2 % 2 == 0) {
            System.out.println("x2とy2は偶数です");
        } else {
            System.out.println("x2とy2のいずれか、もしくは両方とも奇数です");
        }
    }
}
