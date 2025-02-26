package net.dityotech.student_management_system.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
public class Product{
    private Long id;
    private String name;
    private Double price;
    private Long quantity;
    //    public Product(){}
//
//    public Product(Long id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//
//    public Product(Long id, String name, Double price) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//    }
//
//    public Product(String name, Double price) {
//        this.name = name;
//        this.price = price;
//    }
//
//    public Product(Long id, String name, Double price, Long quantity) {
//        this.id = id;
//        this.name = name;
//        this.price = price;
//        this.quantity = quantity;
//    }

//    public static void main(String[] args) {
////        Product product = new Product(1L, "Shampoo");
////        Product product1 = new Product("Laptop", 2300D);
////        Product product2 = new Product(3L, "Mobile", 1100D, 2L);
//
//         Product product = Product.builder()
//                 .id(1L)
//                 .name("Shampoo")
//                 .build();
//
//         Product product1 = Product.builder()
//                 .name("Laptop")
//                 .price(2300D)
//                 .build();
//
//        Product product2 = Product.builder()
//                .name("TV")
//                .build();
//
//        Product product3 = Product.builder()
//                .id(3L)
//                .name("Mobile")
//                .price(1100D)
//                .quantity(2L)
//                .build();
//    }
}
