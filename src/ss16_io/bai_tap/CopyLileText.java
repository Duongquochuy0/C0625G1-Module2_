package ss16_io.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyLileText {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhập đường dẫn file nguồn: ");
        String sourcePath =scanner.nextLine();
        System.out.print("Nhập đường dẫn file đích: ");
        String targetPath = scanner.nextLine();
        try (
                FileReader fr = new FileReader(sourcePath);
                BufferedReader br = new BufferedReader(fr);
                FileWriter fw = new FileWriter(new File(targetPath), false);
                BufferedWriter bw = new BufferedWriter(fw);
        ) {
            File targetFile = new File(targetPath);
            if (targetFile.length() > 0) {
                System.out.println("File đích đã tồn tại");
                return;
            }
            String line;
            int charCount = 0;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                charCount += line.length();
            }
            System.out.println(" Sao chép thành công sang file: " + targetPath);
            System.out.println("Số ký tự đã copy: " + charCount);
        } catch (FileNotFoundException e) {
            System.out.println("File nguồn không tồn tại");
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc ghi file: " + e.getMessage());
        }
    }

}
