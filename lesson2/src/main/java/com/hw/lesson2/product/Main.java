package com.hw.lesson2.product;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(AppConfig.class);

        var pr = context.getBean(ProductRepository.class);
        var cart = context.getBean(Cart.class);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect an action:");
            System.out.println("1. Add dto to cart");
            System.out.println("2. Display dto list");
            System.out.println("3. Product removal");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the ID of the dto you want to add: \n");
                    pr.displayProductInfo();
                    int idAdd = scanner.nextInt();
                    if(idAdd > 4){
                        System.out.println("No such id\n");
                        break;
                    }
                    System.out.println("Your choice -> " + pr.getOneProduct(idAdd).toString());
                    scanner.nextLine();
                    cart.insertProduct(idAdd, pr);
                    System.out.println("Product added.");
                    break;
                case 2:
                    System.out.println("List of products:");
                    cart.displayProductInfo();
                    break;
                case 3:
                    System.out.print("Enter the ID of the dto you want to remove: \n");
                    cart.displayProductInfo();
                    int idRemove = scanner.nextInt();
                    boolean flag = true;
                    for (Product product: cart.getProductCart()) {
                        if(product.getId() == idRemove){
                            scanner.nextLine();
                            cart.removeProduct(idRemove);
                            System.out.println("Product removed.");
                            flag = false;
                            break;
                        }
                    }
                    if(flag){
                        System.out.println("No such id\n");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Incorrect entry. Please enter a number between 1 and 4.");
            }
        }
    }
}
