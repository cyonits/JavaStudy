import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ForloopAndStreamArraysTest {

    static Integer[] nums = new Integer[50000000];

    @BeforeAll
    public static void makeNumList(){
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
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

        for (int i = 0; i < nums.length; i++) {
            strings.add(String.valueOf(nums[i]));
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
            strings.add(String.valueOf(nums[i]));
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

        Arrays.stream(nums).forEach(num -> {
            strings.add(String.valueOf(nums));
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

        IntStream.range(0, nums.length).forEach(i ->{
            strings.add(String.valueOf(nums[i]));
        });

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("Intstream.foreach Time : " + durationTimeSec);
        strings.clear();
    }
}
