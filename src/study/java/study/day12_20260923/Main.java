package study.java.study.day12_20260923;

import java.util.*;

public class Main {
    public static void main(String[] args) {
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
