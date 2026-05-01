import java.util.Arrays;
import java.util.Scanner;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=== Train Consist Management App ===");

        // Step 1: Create an array of bogie IDs (can be empty for testing)
        String[] bogieIds = {}; // Try with empty array to trigger exception
        // String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"}; // Uncomment for valid case

        // Step 2: Validate state before searching
        if (bogieIds.length == 0) {
            throw new IllegalStateException("Search operation not allowed: No bogies in train consist.");
        }

        // Step 3: Sort bogie IDs (Binary Search requires sorted data)
        Arrays.sort(bogieIds);

        // Step 4: Display sorted bogie IDs
        System.out.println("\nSorted Bogie IDs in Train:");
        System.out.println(Arrays.toString(bogieIds));

        // Step 5: Accept search key from user
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter Bogie ID to search: ");
        String searchKey = scanner.nextLine();

        // Step 6: Perform Binary Search
        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = searchKey.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                System.out.println("Bogie ID " + searchKey + " found at position " + (mid + 1));
                found = true;
                break;
            } else if (comparison < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        // Step 7: Display result if not found
        if (!found) {
            System.out.println("Bogie ID " + searchKey + " not found in train consist.");
        }

        scanner.close();
    }
}