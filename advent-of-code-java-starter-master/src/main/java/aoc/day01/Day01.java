package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day01 implements Day {

    @Override
    public String part1(List<String> input) {
        int highestTotalCalories = 0;
        int currentTotalCalories = 0;
        for (int i = 0; i <= input.size(); i++) {
            if(i == input.size() || input.get(i).isEmpty()) {
                if(currentTotalCalories > highestTotalCalories) {
                    highestTotalCalories = currentTotalCalories;
                }
                currentTotalCalories = 0;
            } else {
                currentTotalCalories += Integer.parseInt(input.get(i));
            }
        }
        return String.valueOf(highestTotalCalories);
    }

    @Override
    public String part2(List<String> input) {
        List<Integer> totals = new ArrayList<>();
        int currentTotalCalories = 0;
        for (int i = 0; i <= input.size(); i++) {
            if(i == input.size() || input.get(i).isEmpty()) {
                totals.add(currentTotalCalories);
                currentTotalCalories = 0;
            } else {
                currentTotalCalories += Integer.parseInt(input.get(i));
            }
        }
        Collections.sort(totals, Collections.reverseOrder());
        return String.valueOf(totals.get(0) + totals.get(1) + totals.get(2));
    }

}
