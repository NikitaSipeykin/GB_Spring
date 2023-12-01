package com.hw.lesson2.product;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Component
public class ProductRepository implements StarterPack{
    private final String[] PRODUCT_NAME = { "LuxeBlend", "EcoHarbor", "VitaVista", "GloGrove", "CrispCraft",
            "QuantuQuill", "ZestifyZen", "AquaSculpt", "FloraFlicker", "SwiftSpark", "SereniSip", "SolarLoom",
            "PulsePetal", "ZephyrZoom", "BrioBurst", "NexaNourish", "EpicureEase", "VelvetVista", "AetherAura",
            "RetroRipple"};

    private List<Product> productList;

    private static int idCounter = 0;
    Random random = new Random();

    public List<Product> getFullProductList() {
        return productList;
    }

    public Product getOneProduct(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
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
