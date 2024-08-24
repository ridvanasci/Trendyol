package com.example.trendyol;
import com.example.trendyol.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;


@SpringBootApplication
public class TrendyolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrendyolApplication.class, args);

    Product product = new Product();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Urun Adi Giriniz: ");
    String UrunAdi =scanner.next();
    product.setUrunAdi(UrunAdi); // 1.0

   // product.setUrunAdi("Kitap");
    product.setUrunAciklamasi("Kitap Aciklamasi");
    product.setUrunFiyati(10.0f);
    product.setStok("10");
    System.out.println("Urun Adi :" + product.getUrunAdi());
    System.out.println("Urun Aciklamasi :" + product.getUrunAciklamasi());
    System.out.println("Urun Fiyati :" + product.getUrunFiyati());
    System.out.println("Stok :" + product.getStok());
     }
}