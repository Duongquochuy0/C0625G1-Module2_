package ss17_io_binary_file.bai_tap.coppy_file_binary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CoppyBinaryFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập địa chỉ file nguồn: ");
        String sourcePath = scanner.nextLine();
        System.out.println("Nhập địa chỉ file đích: ");
        String targetPath = scanner.nextLine();
        File sourceFile = new File(sourcePath);
        File targetFile = new File(targetPath);
        if (!sourceFile.exists()) {
            System.out.println("Tệp nguồn không tồn tại");
            return;
        }
        if (targetFile.exists()) {
            System.out.println("Tệp đích đã tồn tại");
            return;
        }
        try (FileInputStream fileInputStream = new FileInputStream(sourceFile);
             FileOutputStream fileOutputStream = new FileOutputStream(targetFile)) {
            int byteRead;
            int totalBytes = 0;
            while (true) {
                byteRead = fileInputStream.read();
                if (byteRead == -1) {
                    break;
                }
                fileOutputStream.write(byteRead);
                totalBytes++;
            }

            System.out.println("Số byte đã sao chép: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Lỗi sao chép");
        }
    }
}
