package aoc.day04;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day04 implements Day {

    @Override
    public String part1(List<String> input) {
        int numOfCompleteOverlaps = 0;
        for(String elfPair : input) {
            String[] elfPairArray = elfPair.split(",");
            List<Integer> elfOneRange = Arrays.stream(elfPairArray[0].split("-")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer>  elfTwoRange = Arrays.stream(elfPairArray[1].split("-")).map(Integer::parseInt).collect(Collectors.toList());
            if ((elfOneRange.get(0) <= elfTwoRange.get(0) && elfOneRange.get(1) >= elfTwoRange.get(1)) ||
                    (elfTwoRange.get(0) <= elfOneRange.get(0) && elfTwoRange.get(1) >= elfOneRange.get(1))) {
                numOfCompleteOverlaps++;
            }
        }
        return String.valueOf(numOfCompleteOverlaps);
    }

    @Override
    public String part2(List<String> input) {
        int numOfOverlaps = 0;
        for(String elfPair : input) {
            String[] elfPairArray = elfPair.split(",");
            List<Integer> elfOneRange = Arrays.stream(elfPairArray[0].split("-")).map(Integer::parseInt).collect(Collectors.toList());
            List<Integer>  elfTwoRange = Arrays.stream(elfPairArray[1].split("-")).map(Integer::parseInt).collect(Collectors.toList());
            if ((elfOneRange.get(0) <= elfTwoRange.get(0) && elfOneRange.get(1) >= elfTwoRange.get(1)) ||
                    (elfOneRange.get(1) >= elfTwoRange.get(0) && elfOneRange.get(1) <= elfTwoRange.get(1)) ||
                    (elfTwoRange.get(0) <= elfOneRange.get(0) && elfTwoRange.get(1) >= elfOneRange.get(1)) ||
                    (elfTwoRange.get(1) >= elfOneRange.get(0) && elfTwoRange.get(1) <= elfOneRange.get(1))) {
                numOfOverlaps++;
            }
        }
        return String.valueOf(numOfOverlaps);
    }

}
