package CopyBigFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter source file : ");
        String sourcePath =  sc.nextLine();
        System.out.println("Enter destination file : ");
        String destPath = sc.nextLine();


        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);

        try{
            copYFileUsingJava7Files(sourceFile,destFile);
            System.out.println("Copy completed !");
        }catch (Exception e){
            System.out.println("Can't copy that file !");
            e.printStackTrace();
        }
    }

    public static void copYFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(),dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }



    public static void copyFileUsingStream(File source, File dest){
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{

            inputStream = new FileInputStream(source);
            outputStream =  new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer))>0){
                outputStream.write(buffer,0,length);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
