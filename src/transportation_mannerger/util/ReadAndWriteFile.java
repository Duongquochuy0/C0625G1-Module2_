package transportation_mannerger.util;

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
}
