
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ForloopAndStreamTest {

    static List<Integer> nums = new ArrayList<>();
    Integer sum;

    @BeforeEach
    public void makeNumList(){
        nums .clear();
        for (int i = 0; i < 100000000; i++) {
            nums.add(i);
        }
    }

    @BeforeEach
    public void makeSumZero(){
        sum = 0;
    }

    @Test
    public void ForloopTest() {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < nums.size(); i++) {
            sum += nums.get(i);
            if(sum < 1000000000){
                sum = 0;
            }
        }

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("For-loop Time : " + durationTimeSec);
    }

    @Test
    public void ForeachTest() {
        long startTime = System.currentTimeMillis();

        for (int i: nums) {
            sum += nums.get(i);
            if(sum < 1000000000){
                sum = 0;
            }
        }

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("For-each Time : " + durationTimeSec);
    }

    @Test
    public void StreamTest() {
        long startTime = System.currentTimeMillis();

        nums.forEach(num -> {
            sum += num;
            if(sum < 1000000000){
                sum = 0;
            }
        });

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("Stream.foreach Time : " + durationTimeSec);
    }

    @Test
    public void IntStreamTest() {
        long startTime = System.currentTimeMillis();

        IntStream.range(0, nums.size()).forEach(i ->{
            sum += nums.get(i);
            if(sum < 1000000000){
                sum = 0;
            }
        });

        long endTime = System.currentTimeMillis();
        long durationTimeSec = endTime - startTime;
        System.out.println("Intstream.foreach Time : " + durationTimeSec);
    }
}
