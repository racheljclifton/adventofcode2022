package aoc.day04;

import aoc.day03.Day03;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;

public class Day04Test {

    @Test
    public void testPart1(){
        // Given
        List<String> input = loadInput("day04test.txt");

        // When
        String result = new Day04().part1(input);

        // Then
        assertEquals("2", result);
    }

    @Test
    public void testPart2(){
        // Given
        List<String> input = loadInput("day04test.txt");

        // When
        String result = new Day04().part2(input);

        // Then
        assertEquals("4", result);
    }

    private static List<String> loadInput(String fileName){
        try(BufferedReader r = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(fileName)))){
            return r.lines().collect(toList());
        } catch(IOException e){
            throw new UncheckedIOException(e);
        }
    }
}
