package study.java.day11_20260722;

import java.util.ArrayList;

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

        Product foundProduct = manager.findProductById(2);

        if ( foundProduct != null) {
            System.out.println("商品が見つかりました。");
            foundProduct.showInfo();
        } else {
            System.out.println("商品が見つかりませんでした。");
        }
    }
}
