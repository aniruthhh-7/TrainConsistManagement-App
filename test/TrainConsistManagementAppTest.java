import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    public void testFilterBogiesByCapacity() {
        // Arrange
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("General", 90)
        );

        // Act
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        // Assert
        assertEquals(2, filteredBogies.size());

        assertEquals("Sleeper", filteredBogies.get(0).name);
        assertEquals(72, filteredBogies.get(0).capacity);

        assertEquals("General", filteredBogies.get(1).name);
        assertEquals(90, filteredBogies.get(1).capacity);
    }
}
