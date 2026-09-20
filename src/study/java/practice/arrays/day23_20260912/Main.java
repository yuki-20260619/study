package study.java.practice.arrays.day23_20260912;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        /*
         String 型の配列初期化処理が用意されています。
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、繰り返し処理を用いたコードを追加してください。
        */
        String[] array = {"レッド", "ブルー", "ピンク", "グリーン", "イエロー"};
        ArrayList<String> list = new ArrayList<>();

        // この下に繰り返し処理を記述する
        for (int i = 0; i < array.length ; i++) {
            list.add(array[i]);
        }
        System.out.println(list);

        /*
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、Collectionsクラス の addAllメソッド を用いたコードを追加してください。
        */
        ArrayList<String> list1 = new ArrayList<>();

        // この下に Collectionsクラス の addAllメソッド による処理を記述する
        Collections.addAll(list1, array);
        System.out.println(list1);

        /*
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、Listインターフェース の ofメソッド を用いたコードを追加してください。
        */
        // この下に Listインターフェース の ofメソッド による処理を記述する
        List<String> list2 = List.of(array);
        System.out.println(list2);

        /*
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、Arraysクラス の streamメソッド を使用して、配列から Stream を生成し、collectメソッド を用いて、リストに要素を追加するコードを追加してください。
        */
        // この下に Arraysクラス の streamメソッド による処理と、collectメソッド による処理を記述する
        List<String> list3 =
                Arrays
                        .stream(array)
                        .collect(Collectors.toList());
        System.out.println(list3);

        /*
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、Arraysクラス の streamメソッド を使用して、配列から Stream を生成し、toListメソッド を用いて、リストに要素を追加するコードを追加してください。
        */
        // この下に Arraysクラス の streamメソッド による処理と、toListメソッド による処理を記述する
        List<String> list4 =
                Arrays
                        .stream(array)
                        .toList();
        System.out.println(list4);

        /*
         このコードの配列 array の全ての要素を、要素として持つリストを出力するために、Arraysクラス の streamメソッド を使用して、配列から Stream を生成し、boxedメソッド を用いて、リストに要素を追加するコードを追加してください。
        */
        int[] array1 = {55, 135};

        // この下に Arraysクラス の streamメソッド による処理と、boxedメソッド による処理を記述する
        List<Integer> list5 =
                Arrays
                        .stream(array1)
                        .boxed()
                        .toList();
        System.out.println(list5);

        /*
         このコードのリスト list の全ての要素を、要素として持つ配列を出力するために、繰り返し処理を用いたコードを追加してください。
        */
        List<String> l = List.of("レッド", "ブルー", "ピンク", "グリーン", "イエロー");
        String[] a = new String[list.size()];

        // この下に繰り返し処理を記述する
        for (int i = 0; i < list.size(); i++) {
            a[i] = l.get(i);
        }
        System.out.println(Arrays.toString(a));

        /*
         このコードのリスト list の全ての要素を、要素として持つ配列を出力するために、Listインターフェース の toArrayメソッド を用いたコードを追加してください。
        */
        // この下に、Listインターフェース の toArrayメソッド を用いたコードを記述する
        String[] a1 = l.toArray(new String[l.size()]);
        System.out.println(Arrays.toString(a1));

        /*
         このコードのリスト list の全ての要素を、要素として持つ配列を出力するために、Stream の toArrayメソッド を用いたコードを追加してください。
        */
        // この下に、Stream の toArrayメソッド を用いたコードを記述する
        String[] a2 =
                l.stream()
                        .toArray(String[]::new);
        System.out.println(Arrays.toString(a2));

        /*
         このコードのリスト list の全ての要素を、要素として持つ配列を出力するために、Stream の 中間操作である mapToIntメソッド を利用して IntStream に変換し、toArrayメソッド を用いて、配列に要素を追加するコードを追加してください。
        */
        List<Integer> l1 = List.of(55, 135);

        // この下に Stream の 中間操作である mapToIntメソッド による処理と、toArrayメソッド による処理を記述する
        int[] a3 =
                l1.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
        System.out.println(Arrays.toString(a3));
    }
}
