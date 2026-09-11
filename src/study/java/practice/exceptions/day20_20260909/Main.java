package study.java.practice.exceptions.day20_20260909;

import java.io.*;

public class Main {
    public static void main (String[] args) {
        /*
         mainメソッド内で例外の発生有無に関わらず「finally」と出力したいです。
         ただし、コードの内容が不十分なため「finally」と出力しません。
         コードを修正してください
        */
        try {
            test();
        } catch (IOException e) {
            System.out.println("IOExceptionエラーです");
        } finally {
            System.out.println("finally");
        }

        /*
         「例外が発生しました」と標準エラー出力をしたいです。
         tryブロックのなかにthrowを使ったコードを書き加えてください。
        */
        try {
            // ここにコードを追加する
            throw new Exception();
        } catch (Exception e) {
            System.err.println("例外が発生しました");
        }
    }

    static void test() throws IOException {

    }
}
