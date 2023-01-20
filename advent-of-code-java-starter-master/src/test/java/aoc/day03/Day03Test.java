package aoc.day03;

import aoc.day02.Day02;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day03Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day03test.txt");

        // When
        String result = new Day03().part1(input);

        // Then
        assertEquals("157", result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = loadInput("day03test.txt");

        // When
        String result = new Day03().part2(input);

        // Then
        assertEquals("70", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
