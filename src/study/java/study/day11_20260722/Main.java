package study.java.study.day11_20260722;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // ↓↓ ProductManager作成によりコメントアウト ↓↓
        //ArrayList<Product> products = new ArrayList<>();

        //products.add(new Product(1, "りんご", 120));
        //products.add(new Product(2, "みかん", 180));
        //products.add(new Product(3, "バナナ", 150));

        //for (Product product : products) {
        //    product.showInfo();
        //}
        // ↑↑ ProductManager作成によりコメントアウト ↑↑

        // ↓↓ ProductManager作成後 ↓↓
        ProductManager manager = new ProductManager();

        manager.addProduct(new Product(1, "りんご", 120));
        manager.addProduct(new Product(2, "みかん", 180));
        manager.addProduct(new Product(3, "バナナ", 150));

        manager.showAllProducts();
        // ↑↑ ProductManager作成後 ↑↑

        System.out.println();
        System.out.println("商品ID検索");

        // ↓↓ 例外処理作成の為コメントアウト ↓↓
        //Product foundProduct = manager.findProductById(2);

        //if (foundProduct != null) {
        //    System.out.println("商品が見つかりました。");
        //    foundProduct.showInfo();
        //} else {
        //    System.out.println("商品が見つかりませんでした。");
        //}
        // ↑↑ 例外処理作成の為コメントアウト ↑↑

        try {
            Product foundProduct = manager.findProductById(9);

            System.out.println("商品が見つかりました。");
            foundProduct.showInfo();
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("===== 商品管理システム =====");
            System.out.println("1.商品一覧");
            System.out.println("2.商品検索");
            System.out.println("3.商品追加");
            System.out.println("4.商品削除");
            System.out.println("0.終了");
            System.out.println("選択してください：");

            int menu = scanner.nextInt();

            switch (menu) {

                case 1:
                    manager.showAllProducts();
                    break;

                case 2:
                    System.out.println("検索するIDを入力してください。");
                    int id = scanner.nextInt();

                    try {
                        Product product = manager.findProductById(id);
                        product.showInfo();
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 3:
                    System.out.print("商品IDを入力してください。");
                    int newId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("商品名を入力してください。");
                    String newName = scanner.nextLine();

                    System.out.print("価格を入力してください。");
                    int newPrice = scanner.nextInt();

                    Product newProduct = new Product(newId,newName,newPrice);
                    manager.addProduct(newProduct);

                    System.out.println("商品を追加しました。");
                    newProduct.showInfo();
                    break;

                case 4:
                    System.out.print("削除する商品IDを入力してください：");
                    int removeId = scanner.nextInt();

                    try {
                        manager.removeProductById(removeId);
                        System.out.println("商品を削除しました。");
                    } catch (ProductNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                case 0:
                    System.out.println("終了します。");
                    scanner.close();
                    return;

                default:
                    System.out.println("メニュー番号が正しくありません。");
            }
        }
    }
}
