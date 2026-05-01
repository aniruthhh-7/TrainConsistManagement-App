import java.util.*;
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        System.out.println("UC19 - Binary Search for Bogie ID\n");

        String[] bogieIds = {"86101", "BG205", "BG309", "BG412", "BG550"};

        Arrays.sort(bogieIds);

        String key = "BG309";

        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        int low = 0;
        int high = bogieIds.length - 1;
        boolean found = false;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                found = true;
                break;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println();

        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " not found in the list.");
        }

        System.out.println("\nUC19 search completed ...");
    }
}