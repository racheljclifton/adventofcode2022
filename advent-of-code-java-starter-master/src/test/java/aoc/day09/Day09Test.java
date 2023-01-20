package aoc.day09;

import aoc.day08.Day08;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day09Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day09test.txt");

        // When
        String result = new Day09().part1(input);

        // Then
        assertEquals("13", result);
    }

    @Test
    public void testPart2a(){
        // Given
        List<String> input = loadInput("day09test.txt");

        // When
        String result = new Day09().part2(input);

        // Then
        assertEquals("0", result);
    }

    @Test
    public void testPart2b(){
        // Given
        List<String> input = loadInput("day09test2.txt");

        // When
        String result = new Day09().part2(input);

        // Then
        assertEquals("36", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
