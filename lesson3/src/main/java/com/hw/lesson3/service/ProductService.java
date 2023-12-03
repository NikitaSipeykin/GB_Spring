package com.hw.lesson3.service;

import com.hw.lesson3.dto.Product;
import com.hw.lesson3.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getFullProductList() {
        return productRepository.getFullProductList();
    }

    public Product getOneProduct(int id) {
        return productRepository.getOneProduct(id);
    }

    public void addProductToRepo(Product product){
        productRepository.addProductToRepo(product);
    }

    public void displayProductInfo() {
        productRepository.displayProductInfo();
    }
}
