package study.java.practice.exceptions.day19_20260908;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;

public class Main {
    public static void main (String[] args) throws Exception {
        /*
         コードを修正して、例外が発生してもtestと出力するように修正してください。
        */
        //test();

        /*
         mainメソッドでIOExceptionが発生したら「入出力例外が発生しました」と出力します。
         ただし、コードが不十分なため、実行するとコンパイルエラーが発生します。
         コードを修正してください。
        */
        try {
            test();
        } catch(IOException e) {
            System.out.println("入出力例外が発生しました");
        }
    }

    static void test() throws Exception {
        System.out.println("test");
    }

    static void test1() throws IOException {
        Files.lines(Paths.get("/", "a"), Charset.forName("UTF-8"));
    }
}
