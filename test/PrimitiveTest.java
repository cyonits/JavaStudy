
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrimitiveTest {

    @Test
    public void primitiveTest() {
        List<Class<?>> basicClazz = new ArrayList<>();
        List<Class<?>> wrapperClazz = new ArrayList<>();

        basicClazz.add(boolean.class);
        basicClazz.add(char.class);
        basicClazz.add(byte.class);
        basicClazz.add(short.class);
        basicClazz.add(int.class);
        basicClazz.add(long.class);
        basicClazz.add(float.class);
        basicClazz.add(double.class);

        wrapperClazz.add(Boolean.class);
        wrapperClazz.add(Character.class);
        wrapperClazz.add(Byte.class);
        wrapperClazz.add(Short.class);
        wrapperClazz.add(Integer.class);
        wrapperClazz.add(Long.class);
        wrapperClazz.add(Float.class);
        wrapperClazz.add(Double.class);
        wrapperClazz.add(String.class);

        basicClazz.forEach(bc -> assertTrue(bc.isPrimitive()));
        wrapperClazz.forEach(wc -> assertFalse(wc.isPrimitive()));
    }
}