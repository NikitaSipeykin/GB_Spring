package com.hw.lesson3.repository;

import com.hw.lesson3.dto.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class ProductRepository {
    private final String[] PRODUCT_NAME = { "LuxeBlend", "EcoHarbor", "VitaVista", "GloGrove", "CrispCraft",
            "QuantuQuill", "ZestifyZen", "AquaSculpt", "FloraFlicker", "SwiftSpark", "SereniSip", "SolarLoom",
            "PulsePetal", "ZephyrZoom", "BrioBurst", "NexaNourish", "EpicureEase", "VelvetVista", "AetherAura",
            "RetroRipple"};

    private List<Product> productList;

    private static int idCounter = 0;
    Random random = new Random();

    public List<Product> getFullProductList() {
        return List.copyOf(productList);
    }

    public Product getOneProduct(int id) {
       return productList.stream().filter(product -> product.getId() == id).
               findFirst().
               orElse(null);
    }

    public void addProductToRepo(Product product){
        productList.add(product);
    }

    public void displayProductInfo() {
        for (Product product : productList) {
            System.out.println(product.toString());
        }
    }

    @PostConstruct
    public void starterPack(){
        this.productList = new ArrayList<>();

        while (idCounter < 5) {
            int id = idCounter++;
            String title = PRODUCT_NAME[random.nextInt(19)];
            int cost = random.nextInt(999999);
            productList.add(new Product(id, title, cost));
        }
    }
}
