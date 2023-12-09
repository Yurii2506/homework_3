package Validator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static void validateAndPrintPhoneNumber(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (isValidPhoneNumber(line)) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Помилка читання файлу: " + e.getMessage());
        }
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile("\\(\\d{3}\\) \\d{3}-\\d{4}");

        Pattern pattern2 = Pattern.compile("\\d{3}-\\d{3}-\\d{4}");

        Matcher matcher = pattern.matcher(phoneNumber);

        Matcher matcher2 = pattern2.matcher(phoneNumber);

        return matcher.matches() || matcher2.matches();
    }
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Юрий\\IdeaProjects\\homework_3\\src\\Validator\\File.txt";

        validateAndPrintPhoneNumber(filePath);

    }

}