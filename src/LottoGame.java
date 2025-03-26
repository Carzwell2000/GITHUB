import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import java.util.Scanner;

public class LottoGame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/LottoDatabase";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome to the Lotto Game!");

            boolean continuePlaying = true;

            while (continuePlaying) {
                System.out.println("Enter 6 unique numbers between 0 and 40:");

                int[] userNumbers = new int[6];
                for (int i = 0; i < 6; i++) {
                    int number;
                    boolean isDuplicate;
                    do {
                        System.out.print("Enter number " + (i + 1) + ": ");
                        number = scanner.nextInt();
                        isDuplicate = false;

                        for (int j = 0; j < i; j++) {
                            if (userNumbers[j] == number) {
                                isDuplicate = true;
                                System.out.println("You already entered this number.");
                                break;
                            }
                        }

                        if (!isDuplicate && (number < 0 || number > 40)) {
                            System.out.println("Invalid number. Please enter a number between 0 and 40.");
                        }
                    } while (isDuplicate || number < 0 || number > 40);

                    userNumbers[i] = number;
                }

                saveToDatabase(userNumbers);
                System.out.println("Your numbers have been saved!");

                System.out.println("Now running the lottery...");
                runLotto(userNumbers);

                System.out.print("Do you want to play again? (yes/no): ");
                String response = scanner.next().toLowerCase();
                if (!response.equals("yes")) {
                    continuePlaying = false;
                }
            }

            System.out.println("Thank you for playing! Goodbye!");
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void saveToDatabase(int[] numbers) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        String insertSQL = "INSERT INTO LotteryNumbers (num1, num2, num3, num4, num5, num6) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        for (int i = 0; i < 6; i++) {
            pstmt.setInt(i + 1, numbers[i]);
        }
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }

    private static void runLotto(int[] userNumbers) {
        Random random = new Random();
        int[] winningNumbers = new int[6];
        System.out.println("Winning numbers are:");

        for (int i = 0; i < 6; i++) {
            winningNumbers[i] = random.nextInt(41);
            System.out.print(winningNumbers[i] + " ");
        }
        System.out.println();

        System.out.println("Checking your numbers against the winning numbers...");
        int matchCount = 0;
        for (int num : userNumbers) {
            for (int winNum : winningNumbers) {
                if (num == winNum) {
                    matchCount++;
                }
            }
        }

        System.out.println("You matched " + matchCount + " numbers!");
    }
}
