package Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    List<Product> productList = new ArrayList<>();

    // Them san pham
    public void addProduct() {
        Product product = new Product();
        product.inputProductInfo();
        for(Product product1 : productList){
            if(product1.getId()==product.getId()){
                System.err.println("Ma san pham da ton tai !");
                return;
            }
            if(product1.getName().equals(product.getName())){
                System.err.println("Ten san pham da ton tai !");
                return;
            }
        }
        productList.add(product);
    }

    // Hien thi tat ca san pham
    public void showAllProduct() {
        for (Product product : productList) {
            product.showProductInfo();
        }
    }

    // Ghi san pham vao file
    public void writeProductToFile() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("Product.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(productList);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // Doc thong tin san pham tu file
    public List<Product> readProductInfoFromFile() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Product.txt");
            ois = new ObjectInputStream(fis);
            productList = (List<Product>) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return productList;
    }

    // Tim san pham theo ten
    public int findProductByName(String name) {
        readProductInfoFromFile();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().equals(name)) {
                return i;
            }
        }
        System.err.println("Khong tim thay ten san pham phu hop !");
        return -1;
    }

    // Hien thong tin san pham theo ten
    public void showProductInfoByName(String name){
        if(findProductByName(name)!=-1){
            productList.get(findProductByName(name)).showProductInfo();
        }
    }

    // Xoa thong tin san pham tu File theo ten
    public void removeProductInfoFromFile(String name) {
        readProductInfoFromFile();
        if (findProductByName(name) != -1) {
            int i = findProductByName(name);
            productList.remove(i);
        }
        System.out.println("Danh sach san pham sau khi xoa");
        for (Product product : productList) {
            product.showProductInfo();
        }
    }

    // Sua thong tin san pham theo ten
    public void editProductByName(String  name){
        if(findProductByName(name)!=-1){
            Product product = new Product();
            product.inputProductInfo();
            productList.set(findProductByName(name),product);
        }
    }
}
