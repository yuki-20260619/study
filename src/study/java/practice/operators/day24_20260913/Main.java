package study.java.practice.operators.day24_20260913;

public class Main {
    public static void main (String[] args) {
        /*
         num変数に格納された値の、二進数の符号なし整数値の文字列表現を返すコードを追加してください。
        */
        int num = 163;

        // ここに、引数の数値の、二進数の符号なし整数値の文字列表現を返すメソッドを記述する
        System.out.println(Integer.toBinaryString(num));

        /*
         num変数を1bit左にシフトするコードを追加し、出力される内容を変更してください。
        */
        // ここに、左シフト演算を記述する
        num = num << 1;
        System.out.println(Integer.toBinaryString(num));

        /*
         現在、num変数を出力すると、10010110と出力されます。
         この、10010110を1bit右にシフトするコードを追加し、出力される内容を変更してください。
        */

        num = 150;

        // ここに、符号付き右シフト演算を記述する
        num = num >> 1;
        System.out.println(Integer.toBinaryString(num));

        /*
         現在、num変数を出力すると、-150と出力されます。
         num変数の十進数での値は符号がマイナスのまま、1bit右にシフトするコードを追加し、出力される内容を変更してください。
        */
        num = -150;

        // ここに、符号付き右シフト演算を記述する
        num = num >> 1;
        System.out.println(num);

        /*
         現在、num変数を出力すると、10010110と出力されます。
         この、10010110を1bit右にシフトするコードを追加し、出力される内容を変更してください。
        */
        num = 150;

        // ここに、符号なし右シフト演算を記述する
        num >>>= 1;
        System.out.println(Integer.toBinaryString(num));

        /*
         現在、num変数を出力すると、-150と出力されます。
         この、-150を1bit右にシフトし、空いた左側には0を挿入するコードを追加し、出力される内容を変更してください。
        */
        num = -150;

        // ここに、符号なし右シフト演算を記述する
        num >>>= 1;
        System.out.println(num);

        /*
         num1変数とnum2変数の値を論理積演算した結果をnum3変数に格納し、num3変数に格納された値が、出力されるようコードを変更してください。
        */
        int num1 = 163;
        int num2 = 150;

        // ここで、num1 変数と num2 変数の値を論理積演算し、num3 変数に格納する
        int num3 = num1 & num2;

        System.out.println(num3);
        System.out.println(Integer.toBinaryString(num3));

        /*
         num1変数とnum2変数の値を論理和演算した結果をnum3変数に格納し、num3変数に格納された値が、出力されるようコードを変更してください。
        */
        num3 = num1 | num2;

        System.out.println(num3);
        System.out.println(Integer.toBinaryString(num3));

        /*
         num1変数とnum2変数の値を排他的論理和演算した結果をnum3変数に格納し、num3変数に格納された値が、出力されるようコードを変更してください。
        */
        num3 = num1 ^ num2;

        System.out.println(num3);
        System.out.println(Integer.toBinaryString(num3));

        /*
         num1変数の値を反転した結果をnum2変数に格納し、num2変数に格納された値が、出力されるようコードを変更してください。
        */
        num2 = ~num1;

        System.out.println(num2);
        System.out.println(Integer.toBinaryString(num2));
    }
}
