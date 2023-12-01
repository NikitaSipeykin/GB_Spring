package com.hw.lesson2.product;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart implements StarterPack{

    private List<Product> productCart;

    public List<Product> getProductCart() {
        return productCart;
    }

    public void insertProduct(int id, ProductRepository pr){
        Product product = pr.getOneProduct(id);
        productCart.add(product);
    }

    public void removeProduct(int id){
        productCart.removeIf(product -> product.getId() == id);
    }

    public void displayProductInfo() {
        for (Product product : productCart) {
            System.out.println(product.toString());
        }
    }
    @PostConstruct
    public void starterPack(){
        this.productCart = new ArrayList<>();
    }
}
