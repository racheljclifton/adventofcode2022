package aoc.day11;

import aoc.Day;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day11 implements Day {

    @Data
    private class Monkey {
        Queue<Integer> items = new PriorityQueue<>();
        String operand;
        String operationNumber;
        int divisibleBy;
        int trueMonkey;
        int falseMonkey;
    }

    @Override
    public String part1(List<String> input) {
        List<Integer> numberOfInspections = new ArrayList<>();
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        numberOfInspections.add(0);
        List<Monkey> monkeys = new ArrayList<>();
        for(int i = 0; i < input.size(); i+=7) {
            Monkey monkey = new Monkey();

            String[] startingItems = input.get(i + 1).replace(",", "").split(" ");
            for(int j = 4; j < startingItems.length; j++) {
                monkey.items.add(Integer.parseInt(startingItems[j]));
            }

            String[] operationInstructions = input.get(i + 2).split(" ");
            monkey.operand = operationInstructions[6];
            monkey.operationNumber = operationInstructions[7];

            monkey.divisibleBy = Integer.parseInt(input.get(i + 3).split(" ")[5]);
            monkey.trueMonkey = Integer.parseInt(input.get(i + 4).split(" ")[9]);
            monkey.falseMonkey = Integer.parseInt(input.get(i + 5).split(" ")[9]);

            monkeys.add(monkey);
        }

        for (int i = 1; i <= 20; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                Monkey monkey = monkeys.get(j);
                while (!monkey.items.isEmpty()) {
                    int worry = monkey.items.remove();
                    if (monkey.operand.equals("+")) {
                        worry = (worry + Integer.parseInt(monkey.operationNumber)) / 3;
                    } else if (monkey.operand.equals("*")) {
                        if (monkey.operationNumber.equals("old")) {
                            worry = (worry * worry) / 3;
                        } else {
                            worry = (worry * (Integer.parseInt(monkey.operationNumber)) / 3);
                        }
                    }
                    if (worry % monkey.divisibleBy == 0) {
                        monkeys.get(monkey.trueMonkey).items.add(worry);
                    } else {
                        monkeys.get(monkey.falseMonkey).items.add(worry);
                    }
                    int currentNumber = numberOfInspections.remove(j);
                    numberOfInspections.add(j, currentNumber + 1);
                }
            }
        }

        numberOfInspections.sort(Collections.reverseOrder());
        return String.valueOf(numberOfInspections.get(0) * numberOfInspections.get(1));
    }

    @Data
    private class Monkey2 {
        Queue<Long> items = new PriorityQueue<>();
        String operand;
        String operationNumber;
        int divisibleBy;
        int trueMonkey;
        int falseMonkey;
    }

    @Override
    public String part2(List<String> input) {
        List<Long> numberOfInspections = new ArrayList<>();
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        numberOfInspections.add(0L);
        List<Monkey2> monkeys = new ArrayList<>();
        for(int i = 0; i < input.size(); i+=7) {
            Monkey2 monkey = new Monkey2();

            String[] startingItems = input.get(i + 1).replace(",", "").split(" ");
            for(int j = 4; j < startingItems.length; j++) {
                monkey.items.add(Long.parseLong(startingItems[j]));
            }

            String[] operationInstructions = input.get(i + 2).split(" ");
            monkey.operand = operationInstructions[6];
            monkey.operationNumber = operationInstructions[7];

            monkey.divisibleBy = Integer.parseInt(input.get(i + 3).split(" ")[5]);
            monkey.trueMonkey = Integer.parseInt(input.get(i + 4).split(" ")[9]);
            monkey.falseMonkey = Integer.parseInt(input.get(i + 5).split(" ")[9]);

            monkeys.add(monkey);
        }

        long modValue = monkeys.stream().map(monkey -> monkey.divisibleBy).reduce(1, (product, num) -> product = product * num);

        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < monkeys.size(); j++) {
                Monkey2 monkey = monkeys.get(j);
                while (!monkey.items.isEmpty()) {
                    long worry = monkey.items.remove();
                    if (monkey.operand.equals("+")) {
                        worry = (worry + Integer.parseInt(monkey.operationNumber));
                    } else if (monkey.operand.equals("*")) {
                        if (monkey.operationNumber.equals("old")) {
                            worry = (worry * worry);
                        } else {
                            worry = (worry * (Integer.parseInt(monkey.operationNumber)));
                        }
                    }
                    worry = worry % (modValue);
                    if (worry % monkey.divisibleBy == 0) {
                        monkeys.get(monkey.trueMonkey).items.add(worry);
                    } else {
                        monkeys.get(monkey.falseMonkey).items.add(worry);
                    }
                    long currentNumber = numberOfInspections.remove(j);
                    numberOfInspections.add(j, currentNumber + 1);
                }
            }
        }

        numberOfInspections.sort(Collections.reverseOrder());
        return String.valueOf(numberOfInspections.get(0) * numberOfInspections.get(1));
    }

}
