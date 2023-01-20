package aoc.day11;

import aoc.day10.Day10;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day11Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day11test.txt");

        // When
        String result = new Day11().part1(input);

        // Then
        assertEquals("", result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = loadInput("day11test.txt");

        // When
        String result = new Day11().part2(input);

        // Then
        assertEquals("", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
