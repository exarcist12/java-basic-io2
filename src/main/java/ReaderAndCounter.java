import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ReaderAndCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String filename = scanner.next();
        String str = scanner.next();;
        byte[] bytesMyStr = str.getBytes();
        byte[] bytes = reading("src/main/"+ filename);
        System.out.println(countRepeat(bytes, bytesMyStr));

    }


    public static byte[] reading(String path){
        String data = null;
        byte[] bytes = new byte[0];
        try (BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path))) {
            bytes = bufferedInputStream.readAllBytes();
            data = new String(bytes, StandardCharsets.UTF_8);
            System.out.println(data);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return bytes;
    }

    public static int countRepeat(byte[] text, byte[] needle) {
        if (needle.length == 0 || text.length < needle.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= text.length - needle.length; i++) {
            boolean found = true;
            for (int j = 0; j < needle.length; j++) {
                if (text[i + j] != needle[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                count++;
            }
        }
        return count;
    }
}