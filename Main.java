import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the room(in m)");
        double length = scanner.nextDouble();

        System.out.println("Enter the breadth of the room(in m)");
        double breadth = scanner.nextDouble();

        System.out.println("Enter the plant area of a single plant(in cm2)");
        int plantArea = scanner.nextInt();

        OxygenPlantCalculator calculator = new OxygenPlantCalculator(length, breadth, plantArea);
        calculator.calculatePlantsAndOxygen();

        scanner.close();
    }

    static class OxygenPlantCalculator {
        private double roomLength;
        private double roomBreadth;
        private int plantArea;

        public OxygenPlantCalculator(double roomLength, double roomBreadth, int plantArea) {
            this.roomLength = roomLength;
            this.roomBreadth = roomBreadth;
            this.plantArea = plantArea;
        }

        public void calculatePlantsAndOxygen() {
            if (roomLength <= 0) {
                System.out.println("Invalid length");
                return;
            }

            if (roomBreadth <= 0) {
                System.out.println("Invalid breadth");
                return;
            }

            if (plantArea <= 0) {
                System.out.println("Invalid plant area");
                return;
            }

            double roomArea = roomLength * roomBreadth;
            int totalPlants = calculateTotalPlants(roomArea);

            double totalOxygen = calculateTotalOxygen(totalPlants);
            System.out.printf("Total number of plants is %d\n", totalPlants);
            System.out.printf("Total oxygen production is %.2f litres\n", totalOxygen);
        }

        private int calculateTotalPlants(double roomArea) {
            int plantsPerSet = (int) (roomArea / (plantArea / (100.0 * 100.0)));
            return (plantsPerSet / 10) * 10;
        }

        private double calculateTotalOxygen(int totalPlants) {
            return totalPlants * 0.9;
        }
    }
}
