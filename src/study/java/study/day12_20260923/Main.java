package study.java.study.day12_20260923;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        東京の下町に長テーブルで有名な老舗うなぎ屋がありました。

        そのうなぎ屋にはとても大きい長テーブルがあり、テーブルの周りにn個の座席が配置されています。
        座席には、時計回りに1, 2, …, nと番号が振られています。
        座席はテーブルの周りに配置されているので、座席番号nの座席と1の座席は隣接しています。

        今、m個のグループの人達が座席に順番に座りに来ます。i番目(1≦i≦m)のグループの人数をa_i人とします。
        彼らは、長テーブルに並んだ座席の内、ある連続するa_i個の座席に一斉に座ろうとします。

        ただしお客さんは江戸っ子なので、それら座席のうち、いずれか一つでも既に先客に座られている座席があった場合、
        一人も座らずにグループ全員で怒って帰ってしまいます。江戸っ子は気が早いんでぃ。

        入力では、i番目のグループが座ろうとする連続した座席の位置は、整数b_iにより指定されます。
        i番目のグループは、座席番号b_iの座席を始点として、そこから時計回りにa_i個分の座席に座ろうとします。

        最後のグループが座りに来た後、無事に長テーブルの座席に着席出来ている人数を出力するプログラムを作成してください。

        n m
        a_1 b_1
        a_2 b_2
        ...
        a_m b_m

        ・入力はm+1行から成ります。
        ・1行目にはn(座席数)とm(グループ数)が半角スペース区切りで入力されます。
        ・i+1行目(1≦i≦m)には2個の整数a_i(グループの人数)とb_i(着席開始座席番号)が半角スペース区切りで入力されます。
        ・入力値最終行の末尾に改行が１つ入ります。
        ・文字列は標準入力から渡されます。

        入力値最終行の末尾に改行が１つ入ります。
        文字列は標準入力から渡されます。 標準入力からの値取得方法はこちらをご確認ください
         */

        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int allSeats = sc.nextInt();
        int groups = sc.nextInt();

        //シートクラスをインスタンス
        Seat[] seats = new Seat[allSeats + 1];

        for (int i = 1; i < allSeats + 1; i++) {
            seats[i] = new Seat(i);
        }

        for (int i = 0; i < groups; i++) {
            int visitor = sc.nextInt();
            int startNumber = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            //シート番号を取得
            for (int j = startNumber; j <= (visitor + startNumber) -1; j++) {
                int seatNumber = j % allSeats;

                if (seatNumber == 0) {
                    seatNumber = allSeats;
                }

                list.add(seatNumber);
            }

            //System.out.println("テスト：" + list);

            //空席状況を確認
            boolean possibility = true;

            for (int seatNumber : list) {
                boolean enable = seats[seatNumber].getSituation();

                if (enable == false) {
                    possibility = false;
                    break;
                }
            }

            //空席状況を変更
            if (possibility == true) {
                for (int seatNumber : list) {
                    seats[seatNumber].setSeatUse();
                }
            }
        }

        //来客数を数える
        int visitors = 0;

        for (int i = 1; i <= allSeats; i++) {
            boolean enable = seats[i].getSituation();

            //System.out.println("テスト：" + i + "：" + enable);

            if (enable == false) {
                visitors++;
            }
        }

        //結果を出力
        System.out.println(visitors);
    }
}

class Seat {
    private int number;
    private boolean situation = true;

    public Seat(int seatNumber) {
        this.number = seatNumber;
    }

    public void setSeatUse() {
        if (this.situation == true) {
            this.situation = false;
        }
    }

    public Boolean getSituation() {
        return this.situation;
    }
}
