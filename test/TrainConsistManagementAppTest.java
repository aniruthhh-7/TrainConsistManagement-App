import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testStreamGroupingBehavior() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 60),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));
        assertEquals(3, grouped.size());
        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(2, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testCategoryClassification() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );
        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    @Test
    void testMultipleBogiesInSameGroup() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("AC Chair", 56),
                new Bogie("AC Chair", 60)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(1, grouped.size());
        assertEquals(2, grouped.get("AC Chair").size());
    }

    @Test
    void testDifferentBogieCategories() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("First Class", 24)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("First Class"));
        assertEquals(1, grouped.get("Sleeper").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    @Test
    void testEmptyCollectionHandling() {
        List<Bogie> bogies = new ArrayList<>();

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped.isEmpty());
    }

    @Test
    void testOriginalCollectionIntegrity() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        List<Bogie> copy = new ArrayList<>(bogies);

        bogies.stream().collect(Collectors.groupingBy(b -> b.name));

        assertEquals(copy.size(), bogies.size());
        assertEquals(copy.get(0).name, bogies.get(0).name);
        assertEquals(copy.get(1).capacity, bogies.get(1).capacity);
    }

    @Test
    void testMapStructureValidation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        Map<String, List<Bogie>> grouped = bogies.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(grouped instanceof Map);
        assertTrue(grouped.get("Sleeper") instanceof List);
        assertEquals("Sleeper", grouped.get("Sleeper").get(0).name);
    }
}