package aoc.day08;

import aoc.day05.Day05;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day08Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day08test.txt");

        // When
        String result = new Day08().part1(input);

        // Then
        assertEquals("21", result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = loadInput("day08test.txt");

        // When
        String result = new Day08().part2(input);

        // Then
        assertEquals("8", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
