import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    private boolean binarySearch(String[] bogieIds, String key) {
        Arrays.sort(bogieIds);
        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = bogieIds[mid].compareTo(key);

            if (result == 0) {
                return true;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }

    @Test
    void testBinarySearch_BogieFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogieIds, "BG309"));
    }

    @Test
    void testBinarySearch_BogieNotFound() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertFalse(binarySearch(bogieIds, "BG999"));
    }

    @Test
    void testBinarySearch_FirstElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_LastElementMatch() {
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};
        assertTrue(binarySearch(bogieIds, "BG550"));
    }

    @Test
    void testBinarySearch_SingleElementArray() {
        String[] bogieIds = {"BG101"};
        assertTrue(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_EmptyArray() {
        String[] bogieIds = {};
        assertFalse(binarySearch(bogieIds, "BG101"));
    }

    @Test
    void testBinarySearch_UnsortedInputHandled() {
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};
        assertTrue(binarySearch(bogieIds, "BG205"));
    }
}