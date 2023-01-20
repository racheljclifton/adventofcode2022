package aoc.day06;

import aoc.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Day06 implements Day {

    @Override
    public String part1(List<String> input) {
        int beginningOfMessage = 0;
        String message = input.get(0);
        String window = message.substring(0,4);
        for (int i = 4; i < message.length(); i++) {

            if (window.replace(String.valueOf(window.charAt(0)),"").length() < 3 ||
                    window.replace(String.valueOf(window.charAt(1)),"").length() < 3 ||
                    window.replace(String.valueOf(window.charAt(2)),"").length() < 3) {
                window = window.substring(1) + message.charAt(i);
            } else {
                beginningOfMessage = i;
                break;
            }
        }

        return String.valueOf(beginningOfMessage);
    }

    @Override
    public String part2(List<String> input) {

        int beginningOfMessage = 0;
        String message = input.get(0);
        String window = message.substring(0,14);
        for (int i = 14; i < message.length(); i++) {

            if (window.replace(String.valueOf(window.charAt(0)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(1)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(2)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(3)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(4)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(5)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(6)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(7)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(8)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(9)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(10)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(11)),"").length() < 13 ||
                    window.replace(String.valueOf(window.charAt(12)),"").length() < 13) {
                window = window.substring(1) + message.charAt(i);
            } else {
                beginningOfMessage = i;
                break;
            }
        }

        return String.valueOf(beginningOfMessage);
    }

}
