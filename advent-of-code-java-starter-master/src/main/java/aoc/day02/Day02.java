package aoc.day02;

import aoc.Day;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day02 implements Day {

    @Override
    public String part1(List<String> input) {
        int score = 0;
        for(String round: input) {
            char theirHand = round.charAt(0);
            char myHand = round.charAt(2);
            if(myHand == 'X') {
                score += 1;
                if(theirHand == 'A') {
                    score += 3;
                } else if (theirHand == 'C') {
                    score += 6;
                }
            } else if(myHand == 'Y') {
                score += 2;
                if(theirHand == 'A') {
                    score += 6;
                } else if (theirHand == 'B') {
                    score += 3;
                }
            } else {
                score += 3;
                if (theirHand == 'B') {
                    score += 6;
                } else if (theirHand == 'C') {
                    score += 3;
                }
            }
        }

        return String.valueOf(score);
    }

    @Override
    public String part2(List<String> input) {
        int score = 0;
        for(String round: input) {
            char theirHand = round.charAt(0);
            char myHand = round.charAt(2);
            if(myHand == 'X') {
                if(theirHand == 'A') {
                    score += 3;
                } else if (theirHand == 'B') {
                    score += 1;
                } else if (theirHand == 'C') {
                    score += 2;
                }
            } else if(myHand == 'Y') {
                score += 3;
                if(theirHand == 'A') {
                    score += 1;
                } else if (theirHand == 'B') {
                    score += 2;
                } else if (theirHand == 'C') {
                    score += 3;
                }
            } else {
                score += 6;
                if(theirHand == 'A') {
                    score += 2;
                } else if (theirHand == 'B') {
                    score += 3;
                } else if (theirHand == 'C') {
                    score += 1;
                }
            }
        }

        return String.valueOf(score);
//        15355 is too high
    }

}
