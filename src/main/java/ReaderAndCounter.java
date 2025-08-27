import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReaderAndCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите название файла: ");
        String filename = scanner.next();
        String str = scanner.next();;
        String fileText = reading("src/main/"+ filename);
        System.out.println(countRepeat(fileText, str));

    }



    public static String reading(String path){
        try {
            return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.err.println("Ошибка чтения файла: " + ex.getMessage());
            return "";
        }
    }

    public static int countRepeat(String text, String needle) {
        byte[] bytesText = text.getBytes();
        byte[] bytesNeedleMyStr = needle.getBytes();
        if (bytesNeedleMyStr.length == 0 || bytesText.length < bytesNeedleMyStr.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i <= bytesText.length - bytesNeedleMyStr.length; i++) {
            boolean found = true;
            for (int j = 0; j < bytesNeedleMyStr.length; j++) {
                if (bytesText[i + j] != bytesNeedleMyStr[j]) {
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