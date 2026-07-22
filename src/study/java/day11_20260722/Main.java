package study.java.day11_20260722;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(1, "りんご", 120));
        products.add(new Product(2, "みかん", 180));
        products.add(new Product(3, "バナナ", 150));

        for (Product product : products) {
            product.showInfo();
        }
    }
}
