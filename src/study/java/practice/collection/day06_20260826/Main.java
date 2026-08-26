package study.java.practice.collection.day06_20260826;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        /*
         コードを追加して、変数 members の要素 rokumura を
         1番最初に追加して、変数 members を出力してください。
        */
        ArrayList<String> members = new ArrayList<>();
        members.add("kirishima");
        members.add("midorikawa");
        //以下にコードを追加
        members.add(0,"rokumura");

        System.out.println(members);

        /*
         コードを追加して、変数 members の要素 rokumura を
         nara に置き換えて、変数 members を出力してください。
        */
        ArrayList<String> members2 = new ArrayList<>();
        members2.add("kirishima");
        members2.add("midorikawa");
        members2.add("rokumura");
        //以下にコードを追加
        members2.set(2,"nara");

        System.out.println(members2);

        /*
         コードを追加して、変数 members の要素 midorikawa を
         削除し、変数 members を出力してください。
        */
        ArrayList<String> members3 = new ArrayList<>();
        members3.add("kirishima");
        members3.add("midorikawa");
        members3.add("rokumura");
        // 以下にコードを追加
        int deleteNumber = members3.indexOf("midorikawa");
        members3.remove(deleteNumber);

        System.out.println(members3);

        /*
         コードを追加して、変数 members の全要素を削除して
         変数 members を出力してください。
        */
        ArrayList<String> members4 = new ArrayList<>();
        members4.add("kirishima");
        members4.add("midorikawa");
        members4.add("rokumura");
        // 以下にコードを追加
        members4.clear();

        System.out.println(members4);

        /*
         コードを追加して、変数 numbers の要素を昇順に並び替えて、出力してください。
        */
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(8);
        numbers.add(1);
        numbers.add(3);
        // 以下にコードを追加
        Collections.sort(numbers);

        System.out.println(numbers);

        /*
         コードを追加して、変数 numbers の要素を降順に並び替えて、出力してください。
        */
        ArrayList<Integer> numbers2 = new ArrayList<>();
        numbers2.add(8);
        numbers2.add(1);
        numbers2.add(3);
        // 以下にコードを追加
        Collections.sort(numbers2,Collections.reverseOrder());

        System.out.println(numbers2);

        /*
         コードを追加して、変数 members をコピーした ArrayList 型の変数 members_copy を作成した後、
         変数 members_copy の末尾に nara を追加して、出力してください。
        */
        ArrayList<String> members5 = new ArrayList<>();
        members5.add("kirishima");
        members5.add("midorikawa");
        members5.add("rokumura");

        //以下にコードを追加
        ArrayList<String> members_copy = new ArrayList<>(members5);
        members_copy.add("nara");

        System.out.println("members：" + members5);
        System.out.println("members_copy：" + members_copy);
    }
}
