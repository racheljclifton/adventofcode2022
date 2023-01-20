package aoc.day03;

import aoc.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day03 implements Day {

    @Override
    public String part1(List<String> input) {
        List<Character> itemsToRearrange = new ArrayList<>();
        for (String rucksack : input){
            int divider = rucksack.length()/2;
            String compartmentOne = rucksack.substring(0, divider);
            String compartmentTwo = rucksack.substring(divider, rucksack.length());
            for (char item : compartmentOne.toCharArray()) {
                if (compartmentTwo.contains(String.valueOf(item))) {
                    itemsToRearrange.add(item);
                    break;
                }
            }
        }
        int priority = 0;
        for (Character item : itemsToRearrange){
            if (Character.isLowerCase(item)) {
                priority += (Character.getNumericValue(item) - 9);
            } else {
                priority += (Character.getNumericValue(item) + 17);
            }
        }

        return String.valueOf(priority);
    }

    @Override
    public String part2(List<String> input) {
        List<Character> badgesToAuthenticate = new ArrayList<>();
        for (int i = 0; i < input.size() - 2; i += 3){
            String rucksackOne = input.get(i);
            String rucksackTwo = input.get(i+1);
            String rucksackThree = input.get(i+2);
            for (char item : rucksackOne.toCharArray()) {
                if (rucksackTwo.contains(String.valueOf(item)) && rucksackThree.contains(String.valueOf(item))) {
                    badgesToAuthenticate.add(item);
                    break;
                }
            }
        }
        int priority = 0;
        for (Character badge : badgesToAuthenticate){
            if (Character.isLowerCase(badge)) {
                priority += (Character.getNumericValue(badge) - 9);
            } else {
                priority += (Character.getNumericValue(badge) + 17);
            }
        }

        return String.valueOf(priority);
    }

}
