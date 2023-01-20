package aoc.day06;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day06Test {

    @Test
    public void testPart1a(){
        // Given
        List<String> input = Collections.singletonList("mjqjpqmgbljsphdztnvjfqwrcgsmlb");

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("7", result);
    }

    @Test
    public void testPart1b(){
        // Given
        List<String> input = Collections.singletonList("bvwbjplbgvbhsrlpgdmjqwftvncz");

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("5", result);
    }

    @Test
    public void testPart1c(){
        // Given
        List<String> input = Collections.singletonList("nppdvjthqldpwncqszvftbrmjlhg");

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("6", result);
    }

    @Test
    public void testPart1d(){
        // Given
        List<String> input = Collections.singletonList("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("10", result);
    }

    @Test
    public void testPart1e(){
        // Given
        List<String> input = Collections.singletonList("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        // When
        String result = new Day06().part1(input);

        // Then
        assertEquals("11", result);
    }

    @Test
    public void testPart2a(){
        // Given
        List<String> input = Collections.singletonList("mjqjpqmgbljsphdztnvjfqwrcgsmlb");

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("19", result);
    }

    @Test
    public void testPart2b(){
        // Given
        List<String> input = Collections.singletonList("bvwbjplbgvbhsrlpgdmjqwftvncz");

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("23", result);
    }

    @Test
    public void testPart2c(){
        // Given
        List<String> input = Collections.singletonList("nppdvjthqldpwncqszvftbrmjlhg");

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("23", result);
    }

    @Test
    public void testPart2d(){
        // Given
        List<String> input = Collections.singletonList("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg");

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("29", result);
    }

    @Test
    public void testPart2e(){
        // Given
        List<String> input = Collections.singletonList("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw");

        // When
        String result = new Day06().part2(input);

        // Then
        assertEquals("26", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
