package th02;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void writeToFile(String path, List<Student> students) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readDataFromFile(String path) {
        List<Student> students = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return students;
    }

    public static void main(String[] args) {
        String PATH_FILE = "C:\\Users\\ADMIN\\Desktop\\MODULE 3\\SS17_ThucHanh\\src\\th02\\student.txt";
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "nhung1", "Hà Nội"));
        students.add(new Student(2, "nhung2", "Đà nẵng"));
        students.add(new Student(3, "nhung3", "Hồ Chí Minh"));
        students.add(new Student(4, "nhung4", "Huế"));
        students.add(new Student(5, "nhung5", "Hải Phòng"));
        // ghi file
        writeToFile(PATH_FILE,students);
        // đọc file
        List<Student> studentDataFromFile = readDataFromFile(PATH_FILE);
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }

    }

}


