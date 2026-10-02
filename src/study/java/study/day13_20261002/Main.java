package study.java.study.day13_20261002;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        /*
        昔この公園ではある競技の大会がよく開催されていました。各試合結果の記録が見つかりましたが、どのチームが優勝したかの記録は欠損しています。
        そこであなたは各試合結果から優勝チームを調べるプログラムを作成することにしました。

        大会は勝ち点方式の総当り戦で行います。勝つと2点、引き分けで1点、負けると0点勝ち点が増えます。
        すべての試合が終わったあと、勝ち点が一番多いチームが優勝です。

        大会の参加人数と、試合結果が入力されたときに、何番目のチームが勝ち点いくつの何勝何敗何引き分けで優勝したか出力するプログラムを書いてください。

        ・1行目に大会参加人数を表す整数 N、
        ・続く N 行の i (1 ≦ i ≦ N) 行目には、i 番目のチームと j (1 ≦ j ≦ N) 番目のチームの試合結果を表す文字 c_{ i, j } が入力されます。

        c_{ i, j } は
        　　・ i 番目のチームが j 番目のチームに勝ったときには "W"
        　　・ i 番目のチームが j 番目のチームと引き分けたときには "D"
        　　・ i 番目のチームが j 番目のチームに負けたときには "L"
        　　・ i = j のときには "-" になります。

        ・入力は合計で N + 1 行となり、入力値最終行の末尾に改行が１つ入ります。
         */
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();
        Map<Integer, Integer> result = new LinkedHashMap<>();
        Map<Integer, String> matchResults = new LinkedHashMap<>();

        for (int i = 0; i < numbers; i++) {
            String game = sc.next();

            //スコアを取得
            result.put(i + 1, totalScore(game));
            //勝敗結果を取得
            matchResults.put(i + 1, totalResult(game));
        }

        //優勝者を取得
        int winner = isWinner(result);
        //優勝者のスコアを取得
        int winnersScore = result.get(winner);
        //勝敗結果を取得
        String winnersResult = matchResults.get(winner);

        //結果を出力
        System.out.println(winner + " " + winnersScore + " " + winnersResult);

    }

    static Integer totalScore(String game) {
        int score = 0;

        for (int j = 0; j < game.length(); j++) {
            char c = game.charAt(j);

            //勝ち（W）で2点、引き分け（D）で1点加点する
            switch (c) {
                case 'W':
                    score = score + 2;
                    continue;
                case 'D':
                    score++;
                    continue;
                default:
                    continue;
            }
        }

        //合計点を返す
        return score;
    }

    static String totalResult(String game) {
        int W = 0;
        int D = 0;
        int L = 0;

        for (int j = 0; j < game.length(); j++) {
            char c = game.charAt(j);

            //勝ち（W）で2点、引き分け（D）で1点加点する
            switch (c) {
                case 'W':
                    W++;
                    continue;
                case 'D':
                    D++;
                    continue;
                case 'L':
                    L++;
                    continue;
                default:
                    continue;
            }
        }

        //集計結果を返す
        return W + " " + D + " " + L;
    }

    static Integer isWinner(Map<Integer, Integer> result) {
        int bestScore = 0;
        int Winner = 0;

        for(Map.Entry<Integer, Integer> entry : result.entrySet()) {
            if (bestScore < entry.getValue()) {
                //ベストスコアと勝者を更新する
                Winner = entry.getKey();
                bestScore = entry.getValue();
            }
        }

        //優勝者を返す
        return Winner;
    }
}
