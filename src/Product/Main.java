package Product;

import WriteStudentListToBinaryFile.Student;

import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap lua chon cua ban");
        String choose = "";
        do{
            System.out.println("1. Them thong tin mot san pham");
            System.out.println("2. Hien thi tat ca san pham");
            System.out.println("3. Ghi thong tin san pham vao file");
            System.out.println("4. Doc thong tin san pham tu file");
            System.out.println("5. Tim san pham theo ten");
            System.out.println("6. Sua thong tin san pham theo ten");
            System.out.println("7. Xoa san pham theo ten");
            System.out.println("0. Thoat chuong trinh");
            choose = sc.nextLine();
            switch (choose){
                case "1" :
                    productManager.addProduct();
                    break;
                case "2":
                    productManager.showAllProduct();
                    break;
                case "3":
                    productManager.writeProductToFile();
                    break;
                case "4":
                    productManager.readProductInfoFromFile();
                    productManager.showAllProduct();
                    break;
                case "5":
                    System.out.println("Nhap ten san pham can tim :");
                    String nameSearch = sc.nextLine();
                    productManager.showProductInfoByName(nameSearch);
                    break;
                case "6":
                    System.out.println("Nhap ten san pham can sua : ");
                    String nameEdit = sc.nextLine();
                    productManager.editProductByName(nameEdit);
                    break;
                case "7":
                    System.out.println("Nhap ten san pham can xoa : ");
                    String findName = sc.nextLine();
                    productManager.removeProductInfoFromFile(findName);
                    break;
                case "0":
                    System.err.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhap sai");
                    break;
            }

        }while (!choose.equals("0"));
    }
}
