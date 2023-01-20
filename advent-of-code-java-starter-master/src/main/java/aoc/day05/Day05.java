package aoc.day05;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day05 implements Day {

    @Override
    public String part1(List<String> input) {
        List<Stack<String>> stacksOfCrates = new ArrayList<>();
        Stack<String> stackOne = new Stack<>();
        stackOne.push("N");
        stackOne.push("B");
        stackOne.push("D");
        stackOne.push("T");
        stackOne.push("V");
        stackOne.push("G");
        stackOne.push("Z");
        stackOne.push("J");
        stacksOfCrates.add(stackOne);

        Stack<String> stackTwo = new Stack<>();
        stackTwo.push("S");
        stackTwo.push("R");
        stackTwo.push("M");
        stackTwo.push("D");
        stackTwo.push("W");
        stackTwo.push("P");
        stackTwo.push("F");
        stacksOfCrates.add(stackTwo);

        Stack<String> stackThree = new Stack<>();
        stackThree.push("V");
        stackThree.push("C");
        stackThree.push("R");
        stackThree.push("S");
        stackThree.push("Z");
        stacksOfCrates.add(stackThree);

        Stack<String> stackFour = new Stack<>();
        stackFour.push("R");
        stackFour.push("T");
        stackFour.push("J");
        stackFour.push("Z");
        stackFour.push("P");
        stackFour.push("H");
        stackFour.push("G");
        stacksOfCrates.add(stackFour);

        Stack<String> stackFive = new Stack<>();
        stackFive.push("T");
        stackFive.push("C");
        stackFive.push("J");
        stackFive.push("N");
        stackFive.push("D");
        stackFive.push("Z");
        stackFive.push("Q");
        stackFive.push("F");
        stacksOfCrates.add(stackFive);

        Stack<String> stackSix = new Stack<>();
        stackSix.push("N");
        stackSix.push("V");
        stackSix.push("P");
        stackSix.push("W");
        stackSix.push("G");
        stackSix.push("S");
        stackSix.push("F");
        stackSix.push("M");
        stacksOfCrates.add(stackSix);

        Stack<String> stackSeven = new Stack<>();
        stackSeven.push("G");
        stackSeven.push("C");
        stackSeven.push("V");
        stackSeven.push("B");
        stackSeven.push("P");
        stackSeven.push("Q");
        stacksOfCrates.add(stackSeven);

        Stack<String> stackEight = new Stack<>();
        stackEight.push("Z");
        stackEight.push("B");
        stackEight.push("P");
        stackEight.push("N");
        stacksOfCrates.add(stackEight);

        Stack<String> stackNine = new Stack<>();
        stackNine.push("W");
        stackNine.push("P");
        stackNine.push("J");
        stacksOfCrates.add(stackNine);


//        Stack<String> stackOne = new Stack<>();
//        stackOne.push("Z");
//        stackOne.push("N");
//        stacksOfCrates.add(stackOne);
//
//        Stack<String> stackTwo = new Stack<>();
//        stackTwo.push("M");
//        stackTwo.push("C");
//        stackTwo.push("D");
//        stacksOfCrates.add(stackTwo);
//
//        Stack<String> stackThree = new Stack<>();
//        stackThree.push("P");
//        stacksOfCrates.add(stackThree);

//        number of blocks to move at index 5
//        stack to move them from at index 12
//        stack to move them to at index 17
        for (int i = 0; i < input.size(); i++){
            if(input.get(i).isBlank()){
                for(int j = i+1; j < input.size(); j++) {
                    String[] instruction = input.get(j).split(" ");
                    Stack<String> stackToMoveFrom = stacksOfCrates.get(Integer.parseInt(instruction[3]) - 1);
                    Stack<String> stackToMoveTo = stacksOfCrates.get(Integer.parseInt(instruction[5]) - 1);
                    for (int k = 1; k <= Integer.parseInt(instruction[1]); k++) {
                        stackToMoveTo.push(stackToMoveFrom.pop());
                    }
                }
                break;
            }
        }

        return stacksOfCrates.stream().map(Stack::pop).reduce("", (tops, crate) -> tops + crate);
    }

    @Override
    public String part2(List<String> input) {

        List<String> stacksOfCrates = new ArrayList<>();
//        String stackOne = "NZ";
//        stacksOfCrates.add(stackOne);
//        String stackTwo = "DCM";
//        stacksOfCrates.add(stackTwo);
//        String stackThree = "P";
//        stacksOfCrates.add(stackThree);
        stacksOfCrates.add("JZGVTDBN");
        stacksOfCrates.add("FPWDMRS");
        stacksOfCrates.add("ZSRCV");
        stacksOfCrates.add("GHPZJTR");
        stacksOfCrates.add("FQZDNJCT");
        stacksOfCrates.add("MFSGWPVN");
        stacksOfCrates.add("QPBVCG");
        stacksOfCrates.add("NPBZ");
        stacksOfCrates.add("JPW");

//        number of blocks to move at index 5
//        stack to move them from at index 12
//        stack to move them to at index 17
        for (int i = 0; i < input.size(); i++){
            if(input.get(i).isBlank()){
                for(int j = i+1; j < input.size(); j++) {
                    String[] instruction = input.get(j).split(" ");
                    int numberStackToMoveFrom = Integer.parseInt(instruction[3]) - 1;
                    int numberStackToMoveTo = Integer.parseInt(instruction[5]) - 1;
                    int numberOfCratesToMove = Integer.parseInt(instruction[1]);
                    String stackToMoveFrom = stacksOfCrates.get(numberStackToMoveFrom);
                    String stackToMoveTo = stacksOfCrates.get(numberStackToMoveTo);

                    String cratesToMove = numberOfCratesToMove < stackToMoveFrom.length() ? stackToMoveFrom.substring(0, numberOfCratesToMove) : stackToMoveFrom.substring(0);
                    stacksOfCrates.remove(numberStackToMoveTo);
                    stacksOfCrates.add(numberStackToMoveTo, cratesToMove + stackToMoveTo);

                    stackToMoveFrom = numberOfCratesToMove < stackToMoveFrom.length() ? stackToMoveFrom.substring(numberOfCratesToMove) : "";
                    stacksOfCrates.remove(numberStackToMoveFrom);
                    stacksOfCrates.add(numberStackToMoveFrom, stackToMoveFrom);
                }
                break;
            }
        }

        return stacksOfCrates.stream().reduce("", (tops, crate) -> tops + crate.charAt(0));
    }

}
