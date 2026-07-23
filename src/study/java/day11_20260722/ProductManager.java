package study.java.day11_20260722;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showAllProducts() {

        for (Product product : products) {
            product.showInfo();
        }
    }

    public Product findProductById(int id) throws ProductNotFoundException {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        throw new ProductNotFoundException(
                "商品ID" + id + " は存在しません。");
    }
}

