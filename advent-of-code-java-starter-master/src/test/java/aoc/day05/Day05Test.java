package aoc.day05;

import aoc.day04.Day04;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day05Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day05test.txt");

        // When
        String result = new Day05().part1(input);

        // Then
        assertEquals("CMZ", result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = loadInput("day05test.txt");

        // When
        String result = new Day05().part2(input);

        // Then
        assertEquals("MCD", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
