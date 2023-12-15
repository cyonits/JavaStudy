
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IllegalAccessExceptionTest {

    @Test
    public void illegalAccessExceptionTest() throws IllegalAccessException {
        PrivateClass privateClass = new PrivateClass();

        Field[] fields = privateClass.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(f -> assertThrows(IllegalAccessException.class, () -> {
            f.get(f);
        }));

        assertDoesNotThrow(() -> privateClass.noIllegalAccessExceptionTest(privateClass));

        assertDoesNotThrow(() -> setAccessibleTest(privateClass));
    }

    public void setAccessibleTest(PrivateClass privateClass) throws IllegalAccessException {
        Field[] fields = privateClass.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            f.get(privateClass);
        }
    }
}
