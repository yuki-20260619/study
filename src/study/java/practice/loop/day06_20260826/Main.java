package study.java.practice.loop.day06_20260826;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        /*
         コードを追加して、変数 users の全ての要素をひとつずつ出力してください。
        */
        ArrayList<String> users = new ArrayList<>();

        users.add("kirishima");
        users.add("rokumura");
        users.add("midorikawa");

        users.forEach((String user) -> {
            System.out.println(user);
        });

    }
}
