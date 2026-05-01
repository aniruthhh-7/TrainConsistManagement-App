import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppTest {

    // ✅ Test 1: Valid capacity creation
    @Test
    void testException_ValidCapacityCreation() {
        assertDoesNotThrow(() -> {
            TrainConsistManagementApp.PassengerBogie bogie =
                    new TrainConsistManagementApp.PassengerBogie("Sleeper", 72);
            assertNotNull(bogie);
        });
    }

    // ⚠️ Test 2: Negative capacity should throw exception
    @Test
    void testException_NegativeCapacity_ThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("Sleeper", -10)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ⚠️ Test 3: Zero capacity should throw exception
    @Test
    void testException_ZeroCapacity_ThrowsException() {
        Exception exception = assertThrows(
                TrainConsistManagementApp.InvalidCapacityException.class,
                () -> new TrainConsistManagementApp.PassengerBogie("AC Chair", 0)
        );
        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // 🧩 Test 4: Exception message validation
    @Test
    void testException_ExceptionMessageValidation() {
        try {
            new TrainConsistManagementApp.PassengerBogie("First Class", 0);
            fail("Expected InvalidCapacityException was not thrown");
        } catch (TrainConsistManagementApp.InvalidCapacityException e) {
            assertEquals("Capacity must be greater than zero", e.getMessage());
        }
    }
}