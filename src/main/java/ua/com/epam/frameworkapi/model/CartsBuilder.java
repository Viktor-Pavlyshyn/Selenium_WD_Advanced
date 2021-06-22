package ua.com.epam.frameworkapi.model;

public class CartsBuilder {
    Carts carts;

    public CartsBuilder() {
        this.carts = new Carts();
    }

    public CartsBuilder addProduct(String productCode){
        Product product = new Product();
        product.setCode(productCode);
     carts.setProduct(product);
     return this;
    }

    public CartsBuilder addQuantity(int quantity){
        carts.setQuantity(quantity);
        return this;
    }

    public Carts build(){
        return carts;
    }

}
