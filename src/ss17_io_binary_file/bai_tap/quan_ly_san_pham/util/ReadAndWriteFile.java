package ss17_io_binary_file.bai_tap.quan_ly_san_pham.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public static void writeFileCSV(String filePath, List<String> stringList, boolean append) throws IOException {
        File file = new File(filePath);
        FileWriter fileWriter= new FileWriter(file, append);
        BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);
        for (String line : stringList) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        try {
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("lỗi đóng file");
        }
    }
    public static List<String> readFileCSV(String filePath) throws IOException {
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        FileReader fileReader= new FileReader(file);
        BufferedReader bufferedReader =new BufferedReader(fileReader);
        String line = null;
        while ((line=bufferedReader.readLine())!=null){
            stringList.add(line);
        }
        try {
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.out.println("lỗi đóng file");
        }
        return stringList;
    }
    public static <T> void writeListObjectToDat(String pathFile, List<T> objectList) {
        File file = new File(pathFile);
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(objectList);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Lỗi ghi file");
        }
    }
    public static <T> List<T> readListObjectFromDat(String pathFile){
        List<T> objectList = new ArrayList<>();
        File file = new File(pathFile);
        FileInputStream fileInputStream=null;
        ObjectInputStream objectInputStream=null;
        if(file.length()>0){
            try{
                fileInputStream= new FileInputStream(file);
                objectInputStream =new ObjectInputStream(fileInputStream);
                objectList=(List<T>)objectInputStream.readObject();
            }catch (FileNotFoundException e){
                System.out.println("Lỗi tên file");
            }catch (IOException e){
                System.out.println("Lỗi đọc file");
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
        }
        return objectList;
    }
}
