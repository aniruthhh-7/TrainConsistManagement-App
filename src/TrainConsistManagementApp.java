import java.util.Scanner;

public class TrainConsistManagementApp {

    // ---- CUSTOM EXCEPTION ----
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // ---- PASSENGER BOGIE MODEL WITH VALIDATION ----
    static class PassengerBogie {
        private String bogieType;
        private int seatCapacity;

        public PassengerBogie(String bogieType, int seatCapacity) throws InvalidCapacityException {
            if (seatCapacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
            this.bogieType = bogieType;
            this.seatCapacity = seatCapacity;
        }

        public void displayDetails() {
            System.out.println("Created Bogie: " + bogieType + " -> " + seatCapacity);
        }
    }

    // ---- MAIN METHOD ----
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("UC14 - Handle Invalid Bogie Capacity");
        System.out.println("------------------------------------");

        try {
            System.out.print("Enter Passenger Bogie Type (Sleeper / AC Chair / First Class): ");
            String type = scanner.nextLine();

            System.out.print("Enter Seat Capacity: ");
            int capacity = scanner.nextInt();

            PassengerBogie bogie = new PassengerBogie(type, capacity);
            bogie.displayDetails();

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            System.out.println("\nUC14 exception handling completed ...");
        }

        scanner.close();
    }
}