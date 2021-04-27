package Product;

import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

public class Product implements Serializable {

    private int id;
    private String name;
    private String branch;
    private double price;

    public Product() {
    }

    public Product(int id, String name, String branch, double price) {
        this.id = id;
        this.name = name;
        this.branch = branch;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Nhap thong tin  san pham
    public void inputProductInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma san pham : ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten san pham : ");
        name = sc.nextLine();
        System.out.println("Nhap hang san xuat");
        branch = sc.nextLine();
    }

    // Hien thong tin san pham
    public void showProductInfo(){
        System.out.println(toString());
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", branch='" + branch + '\'' +
                ", price=" + price +
                '}';
    }
}
