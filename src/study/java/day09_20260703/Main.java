package study.java.day09_20260703;
import java.io.File;                        // 課題１
import java.io.IOException;                 // 課題２
import java.io.FileWriter;                  // 課題３
import java.io.FileReader;                  // 課題５
import java.io.BufferedReader;              // 課題５
import java.nio.charset.StandardCharsets;   // 課題６
import java.nio.file.Files;                 // 課題６
import java.util.HashSet;                   // 課題１１
import java.util.Set;                       // 課題１１

public class Main {
    public static void main (String[] args) {
        // 課題１：Fileクラス
        System.out.println("課題１：Fileクラス");
        File file = new File("sample.txt");

        System.out.println(file.exists());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        System.out.println();

        // 課題２：ファイル作成
        System.out.println("課題２：ファイル作成");

        try {
            if (file.createNewFile()) {
                System.out.println("ファイルを作成しました。");
            } else {
                System.out.println("ファイルは既に存在します。");
            }
        } catch (IOException e) {
            System.out.println("ファイル作成に失敗しました。");
        }
        System.out.println();

        // 課題３：ファイル書き込み
        System.out.println("課題３：ファイル書き込み");

        try {
            FileWriter writer = new FileWriter(file);

            writer.write("Java Day09");
            writer.close();

            System.out.println("ファイルへ書き込みました。");

        } catch (IOException e) {

            System.out.println("書き込みに失敗しました。");
        }

        System.out.println();

        // 課題４：try-with-resources
        System.out.println("課題４：try-with-resources");

        try (FileWriter writer = new FileWriter(file)) {

            writer.write("Hello Java");

            System.out.println("ファイルへ書き込みました。");

        } catch (IOException e) {

            System.out.println("書き込みに失敗しました。");

        }

        System.out.println();

        // 課題５：ファイルの読み込み
        System.out.println("課題５：ファイルの読み込み");

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {

            System.out.println("読み込みに失敗しました。");
        }
        System.out.println();

        // 課題６：csvファイルの読み込み
        System.out.println("課題６：csvファイルの読み込み");
        System.out.println("FileReader使用（文字コード指定なし）");

        File normalCsv = new File("sample.csv");

        try (BufferedReader reader =
                new BufferedReader(new FileReader(normalCsv))) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

            }
        } catch (IOException e) {

            System.out.println("読み込みに失敗しました。");

        }
        System.out.println();

        System.out.println("Charsets使用（UTF-8指定）");

        try (BufferedReader reader =
                Files.newBufferedReader(
                        normalCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {

                System.out.println(line);

            }

        } catch (IOException e) {

            System.out.println("読み込みに失敗しました。");

        }
        System.out.println();

        // 課題７：split()でcsvを列ごとに分割する
        System.out.println("課題７：split()でcsvを列ごとに分割する");

        try (BufferedReader reader =
                Files.newBufferedReader(
                        normalCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                System.out.println("商品名：" + data[0]);
                System.out.println("価格：" + data[1]);

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("読み込みに失敗しました。");
        }

        // 課題８：ヘッダー行をスキップする
        System.out.println("課題８：ヘッダー行をスキップする");

        try (BufferedReader reader =
                Files.newBufferedReader(
                        normalCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("商品名：" + data[0]);
                System.out.println("価格：" + data[1]);

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("読み込みに失敗しました。");
        }

        // 課題９：列数チェック
        System.out.println("課題９：列数チェック");

        File invalidCsv = new File("sample2.csv");

        try (BufferedReader reader =
                Files.newBufferedReader(
                        invalidCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 2) {
                    System.out.println("列数エラー：" + line);
                    continue;
                }

                System.out.println("商品名：" + data[0]);
                System.out.println("価格：" + data[1]);

                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("読み込みに失敗しました。");
        }
        System.out.println();

        // 課題１０：型チェック
        System.out.println("課題１０：型チェック");

        File typeErrorCsv = new File("sample3.csv");

        try (BufferedReader reader =
                Files.newBufferedReader(
                        typeErrorCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 2) {
                    System.out.println("列数エラー：" + line);
                    continue;
                }

                try {
                    int price = Integer.parseInt(data[1]);

                    System.out.println("商品名：" + data[0]);
                    System.out.println("価格：" + price);

                    System.out.println();
                } catch (NumberFormatException e) {
                    System.out.println("型エラー：" + line);
                }
            }
        } catch (IOException e) {
            System.out.println("読み込みに失敗しました。");
        }
        System.out.println();

        // 課題１１：重複チェック
        System.out.println("課題１１：重複チェック");

        File duplicateCsv = new File("sample4.csv");
        Set<String> productSet = new HashSet<>();

        try (BufferedReader reader =
                Files.newBufferedReader(
                        duplicateCsv.toPath(),
                        StandardCharsets.UTF_8)) {

            reader.readLine();
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                if (data.length != 2) {
                    System.out.println("列数エラー：" + line);
                    continue;
                }

                try {
                    int price = Integer.parseInt(data[1]);

                    String key = data[0] + "," + price;

                    if (productSet.contains(key)) {
                        System.out.println("重複エラー：" + line);
                        continue;
                    }

                    productSet.add(key);

                    System.out.println("商品名：" + data[0]);
                    System.out.println("価格：" + price);
                    System.out.println();

                } catch (NumberFormatException e) {
                    System.out.println("型エラー：" + line);
                }
            }
        } catch (IOException e) {
            System.out.println("読み込みに失敗しました。");
        }
    }
}