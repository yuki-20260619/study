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
         */

        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int allSeats = sc.nextInt();
        int groups = sc.nextInt();

        //シートクラスをインスタンス
        Seat[] seats = new Seat[allSeats];
        for (int i = 0; i < allSeats; i++) {
            seats[i] = new Seat(i + 1);
        }

        for (int i = 0; i < groups; i++) {
            int visitor = sc.nextInt();
            int startNumber = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();

            //シート番号を取得
            for (int j = startNumber; j <= (visitor + startNumber) -1; j++) {
                int seatNumber;

                if (startNumber > allSeats) {
                    seatNumber = startNumber - allSeats;
                } else {
                    seatNumber = startNumber;
                }

                list.add(seatNumber);
            }

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
                for (int j = 0; j < list.size(); j++) {
                    seats[j].isFree();
                }
            }

            //リストを空にする
            list.clear();
        }

        //来客数を数える
        int visitors = 0;

        for (int i = 1; i <= allSeats; i++) {
            boolean enable = seats[i].getSituation();

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

    public void isFree() {
        if (this.situation == true) {
            this.situation = false;
        }
    }

    public Boolean getSituation() {
        return this.situation;
    }
}
