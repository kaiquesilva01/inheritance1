package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {
            System.out.println("Product #" + i + " data:");

            System.out.print("Commom, used or imported (c/u/i)? ");
            char type = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();

            if (type == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name,price,customsFee));
            } else if (type == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                LocalDate manufacture = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                list.add(new UsedProduct(name,price,manufacture));
            }
            else {
                list.add(new Product(name,price));
            }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product pdct : list) {
            System.out.println(pdct.priceTag());
        }

        sc.close();
    }
}