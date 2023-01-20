package aoc.day10;

import aoc.Day;

import java.util.Arrays;
import java.util.List;

public class Day10 implements Day {

    @Override
    public String part1(List<String> input) {
        int cycle = 0;
        int x = 1;
        int signalStrengthSum = 0;
        for (String instruction : input) {
            if(instruction.equals("noop")) {
                cycle++;
                if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    signalStrengthSum += (cycle * x);
                }
            } else {
                int amountToChange = Integer.parseInt(instruction.split(" ")[1]);
                cycle++;
                if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    signalStrengthSum += (cycle * x);
                }
                cycle++;
                if(cycle == 20 || cycle == 60 || cycle == 100 || cycle == 140 || cycle == 180 || cycle == 220) {
                    signalStrengthSum += (cycle * x);
                }
                x += amountToChange;
            }
        }

        return String.valueOf(signalStrengthSum);
    }
    @Override
    public String part2(List<String> input) {
        int cycle = 0;
        int x = 1;
        int signalStrengthSum = 0;
        String crtLine = "";
        for (String instruction : input) {
            if(instruction.equals("noop")) {
                cycle++;
                if(cycle == x || cycle == x+1 || cycle == x+2) {
                    crtLine += "#";
                } else {
                    crtLine += ".";
                }
                if (cycle == 40) {
                    System.out.println(crtLine);
                    crtLine = "";
                    cycle = 0;
                }
            } else {
                int amountToChange = Integer.parseInt(instruction.split(" ")[1]);
                cycle++;
                if(cycle == x || cycle == x+1 || cycle == x+2) {
                    crtLine += "#";
                } else {
                    crtLine += ".";
                }
                if (cycle == 40) {
                    System.out.println(crtLine);
                    crtLine = "";
                    cycle = 0;
                }
                cycle++;
                if(cycle == x || cycle == x+1 || cycle == x+2) {
                    crtLine += "#";
                } else {
                    crtLine += ".";
                }
                if (cycle == 40) {
                    System.out.println(crtLine);
                    crtLine = "";
                    cycle = 0;
                }
                x += amountToChange;
            }
        }

        return String.valueOf(signalStrengthSum);
    }

}
