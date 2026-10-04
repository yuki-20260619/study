package study.java.study.day14_20261003;
import java.util.*;

public class Main {
    public static void main (String[] args) {
        /*
         学校の子どもたちがじゃんけんをしています。特にA くんと B くんはじゃんけんが大好きで毎日しており、それぞれ「自分のほうが強い」と言い合っています。
         そこであなたは二人のじゃんけんの結果を記録し、どちらが強いのか判定するプログラムを作ってあげることにしました。
         これからAくんとBくんは N 回じゃんけんをします。

         A くんと B くんの出した手が N 回分与えられるので、A くんが勝った回数と B くんが勝った回数を数えるプログラムを作成してください。

         じゃんけんの手はグー、チョキ、パーのいずれかで、
         グーはチョキに勝ち、チョキはパーに勝ち、パーはグーに勝ちます。

        入力では
         ・グーは "g"
         ・チョキは "c"
         ・パーは "p"
        で表現されます。

        A くんの勝った数、B くんの勝った数を以下のフォーマットで出力してください。。
         */

        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int countA = 0;
        int countB = 0;

        for (int i = 0; i < number; i++) {
            String A = sc.next();
            String B = sc.next();

            if (matchResults(A, B) == true) {countA++;}
            if (matchResults(B, A) == true) {countB++;}

        }

        System.out.println(countA);
        System.out.println(countB);

    }

    static Boolean matchResults(String myself, String partner) {
        if (myself.equals("g") && partner.equals("c")) {
            return true;
        }
        if (myself.equals("c") && partner.equals("p")) {
            return true;
        }
        if (myself.equals("p") && partner.equals("g")) {
            return true;
        }
        return false;
    }
}
