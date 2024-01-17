import java.util.Scanner;

public class Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number");
        int number = scanner.nextInt();

        if (isValidNumber(number)) {
            int reversedNumber = reverseNumber(number);
            System.out.println("Reversed number is " + reversedNumber);
            expandNumber(reversedNumber);
        } else {
            System.out.println(number + " is an invalid number");
        }

        scanner.close();
    }

    private static boolean isValidNumber(int number) {
        return number >= 1000 && number <= 9999;
    }

    private static int reverseNumber(int number) {
        int reversedNumber = 0;
        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10;
            number /= 10;
        }
        return reversedNumber;
    }

    private static void expandNumber(int number) {
        int placeValue = 1000;
        boolean isFirstTerm = true;

        while (placeValue > 0) {
            int digit = number / placeValue;
            if (digit != 0) {
                if (!isFirstTerm) {
                    System.out.print("+");
                }
                System.out.print(digit * placeValue);
                isFirstTerm = false;
            }
            number %= placeValue;
            placeValue /= 10;
        }

        System.out.println();
    }
}
