import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    private List<Bogie> createTestDataset(int size) {
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
            bogies.add(new Bogie("First Class", 24));
            bogies.add(new Bogie("Sleeper", 70));
        }
        return bogies;
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = createTestDataset(100);
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                filtered.add(b);
            }
        }
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = createTestDataset(100);
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = createTestDataset(100);

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        assertEquals(loopFiltered.size(), streamFiltered.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = createTestDataset(1000);

        long start = System.nanoTime();
        bogies.stream().filter(b -> b.capacity > 60).collect(Collectors.toList());
        long end = System.nanoTime();

        long duration = end - start;
        assertTrue(duration > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = createTestDataset(100000);
        List<Bogie> filtered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
        assertFalse(filtered.isEmpty());
        assertTrue(filtered.stream().allMatch(b -> b.capacity > 60));
    }
}