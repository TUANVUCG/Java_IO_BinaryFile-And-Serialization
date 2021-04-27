package WriteStudentListToBinaryFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"Hiep","Nam Dinh"));
        studentList.add(new Student(5,"Tu","Ha Nam"));
        studentList.add(new Student(7,"Kien","Ha Tinh"));
        studentList.add(new Student(2,"Hieu","Ha Noi"));
        studentList.add(new Student(3,"Vu","Bac Ninh"));


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Path : ");
        String path = sc.nextLine();
        writeToFile(path,studentList);

        // Doc file
        List<Student> studentDataFromFile = readDataFromFile(path);
        for(Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> studentList){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
            oos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path){
        List<Student> studentList = new ArrayList<>();
        FileInputStream fis =null;
        ObjectInputStream ois = null;
        try{
             fis = new FileInputStream(path);
             ois = new ObjectInputStream(fis);
             studentList = (List<Student>) ois.readObject();
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(fis!=null){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }try{
                if(ois!=null){
                    ois.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return studentList;
    }
}
