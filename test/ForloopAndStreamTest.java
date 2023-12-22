
import org.junit.jupiter.api.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ForloopAndStreamTest {

    static List<Integer> nums = new ArrayList<>();

    @BeforeAll
    public static void makeNumList(){
        nums .clear();
        for (int i = 0; i < 5000000; i++) {
            nums.add(i);
        }
    }

    @Test
    public void a_init() throws InterruptedException {
        long startTime = System.currentTimeMillis();

        Thread.sleep(5000);

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("init Time : " + durationTimeSec);
    }

    @Test
    public void c_ForloopTest() {
        List<String> strings = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < nums.size(); i++) {
            strings.add(nums.get(i) + UUID.randomUUID().toString());
        }

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("For-loop Time : " + durationTimeSec);
        strings.clear();
    }

    @Test
    public void d_ForeachTest() {
        List<String> strings = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        for (Integer i: nums) {
            strings.add(nums.get(i) + UUID.randomUUID().toString());
        }

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("For-each Time : " + durationTimeSec);
        strings.clear();
    }

    @Test
    public void e_StreamTest() {
        List<String> strings = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        nums.forEach(num -> {
            strings.add(nums.get(num) + UUID.randomUUID().toString());
        });

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("Stream.foreach Time : " + durationTimeSec);
        strings.clear();
    }

    @Test
    public void f_IntStreamTest() {
        List<String> strings = new ArrayList<>();
        long startTime = System.currentTimeMillis();

        IntStream.range(0, nums.size()).forEach(i ->{
            strings.add(nums.get(i) + UUID.randomUUID().toString());
        });

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("Intstream.foreach Time : " + durationTimeSec);
        strings.clear();
    }
}
