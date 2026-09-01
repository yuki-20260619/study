package study.java.practice.loop.day11_20260831;

public class Main {
    public static void main(String[] args) {
        /*
         二重ループを作成し、外側の繰り返し処理で 外側i回目 と出力したあと、内側の繰り返し処理で 内側j回目 と出力してください。
         なお、ループの回数はともに 3 回とし、各出力のあとは改行してください。
        */
        for (int i = 1; i < 4; i++) {
            System.out.println("外側" + i + "回目");

            for (int j = 1; j < 4; j++) {
                System.out.println("内側" + j + "回目");
            }
        }

        /*
         二重ループをおこなうコードが用意されています。
         外側の繰り返し処理にコードを追加して、変数 i の値が 2 のとき、なにも出力せずに繰り返し処理を中断して、処理を継続させてください。
        */
        for (int i = 1; i < 4; i++) {
            if (i == 2) {
                continue;
            }
            System.out.println("外側" + i + "回目");

            for (int j = 1; j < 4; j++) {
                System.out.println("内側" + j + "回目");
            }

            System.out.println("ループ" + i + "回目終了");
        }

        /*
         二重ループをおこなうコードが用意されています。
         内側の繰り返し処理にコードを追加して、変数 j の値が 2 のとき
         内側の繰り返し処理ではなにも出力せずに繰り返し処理を中断して、処理を継続させてください。
        */
        for (int i = 1; i < 4; i++) {
            System.out.println("外側" + i + "回目");
            for (int j = 1; j < 4; j++) {
                if (j == 2) {
                    continue;
                }
                System.out.println("内側" + j + "回目");
            }
            System.out.println("ループ" + i + "回目終了");
        }

        /*
         二重ループをおこなうコードが用意されています。
         外側の繰り返し処理にコードを追加して、変数 i の値が 2 のとき、なにも出力せずに繰り返し処理を終了して、ブロックを抜けてください。
        */
        for (int i = 1; i < 4; i++) {
            if (i == 2) {
                break;
            }
            System.out.println("外側" + i + "回目");
            for (int j = 1; j < 4; j++) {
                System.out.println("内側" + j + "回目");
            }
        }

        /*
         二重ループをおこなうコードが用意されています。
         コードを追加して、変数 j の値が 2 のとき
         内側の繰り返して処理ではなにも出力せずに繰り返し処理を終了して、ブロックを抜けてください。
        */
        for (int i = 1; i < 4; i++) {
            System.out.println("外側" + i + "回目");
            for (int j = 1; j < 4; j++) {
                if (j == 2) {
                    break;
                }
                System.out.println("内側" + j + "回目");
            }
        }
    }
}
