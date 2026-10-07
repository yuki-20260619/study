package study.java.study.day15_20261006;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        /*
         単語を組み合わせて新単語を作ります。
         新単語は N 個の文字列を、前から順に結合して作ります。

         この時、冗長さをなくすため、 前から結合した単語の末尾 と 後ろの単語の先端 が一番長く一致するように結合します。

         例えば、 入力例 1 の "paiza", "apple", "letter" の場合、
         先頭から "paiza", "apple" を条件どおり重ねると "paizapple" となります。
         この単語を更に次の単語と重ねると "paizappletter" となります。

         なお、必ず前から順番に重ねるため、 入力例 2 の "poh", "p", "oh" を結合する場合は、
         "poh" と "p" を重ねた後の単語 "pohp" と "oh" を重ね "pohpoh" となります。

         N 個の単語が与えられるので、前から順番に単語を結合した場合の新単語を出力してください。
         */

        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        ArrayList<String> words = new ArrayList<>();
        String frontWord;
        String rearWord;
        String joinWord = "";
        String front;
        String rear;

        for (int i = 0; i < number; i++) {
            words.add(sc.next());
        }

        for (int i = 0; i < words.size() - 1; i++) {
            if (i == 0) {
                frontWord = words.get(i);
            } else {
                frontWord = joinWord;
            }
            rearWord = words.get(i + 1);

            int getNumber = 0;

            if (frontWord.length() <= rearWord.length()) {
                getNumber = frontWord.length();
            } else {
                getNumber = rearWord.length();
            }

            getNumber = strCheck(frontWord, rearWord, getNumber);

            front = frontWord.substring(0, frontWord.length());
            rear = rearWord.substring(rearWord.length() - (rearWord.length() - getNumber));

            joinWord = front + rear;
        }

        System.out.println(joinWord);
    }

    static Integer strCheck(String frontWord, String rearWord, int getNumber) {
        for (int i = getNumber; i >= 0; i--) {
            String frontCheck = frontWord.substring(frontWord.length() - i);
            String rearCheck = rearWord.substring(0, i);

            if (frontCheck.equals(rearCheck)) {
                return i;
            }
        }
        return 0;
    }
}