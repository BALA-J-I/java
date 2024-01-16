import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter weight in kg");
        double weight = scanner.nextDouble();

        System.out.println("Enter height in cm");
        double height = scanner.nextDouble();

        double bmi = calculateBMI(weight, height);

        System.out.printf("Your BMI is %.2f. ", bmi);

        if (bmi >= 25) {
            System.out.println("You are overweight");
            double weightToReduce = bmi - 24.9;
            System.out.printf("Reduce %.2f kg to be fit\n", weightToReduce);
        } else if (bmi >= 18.5) {
            System.out.println("You are fit and healthy");
        } else {
            System.out.println("You are underweight");
            double weightToGain = 18.5 - bmi;
            System.out.printf("Gain %.2f kg to be fit\n", weightToGain);
        }

        scanner.close();
    }

    private static double calculateBMI(double weight, double height) {
        return weight / ((height / 100) * (height / 100));
    }
}
