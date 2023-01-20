package aoc.day08;

import aoc.Day;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day08 implements Day {

    @Override
    public String part1(List<String> input) {
        int visibleTrees = (input.get(0).length() * 2) + ((input.size()-2) * 2);
        for(int y = 1; y < input.size() - 1; y++) {
            String rowOfTrees = input.get(y);
            for (int x = 1; x < rowOfTrees.length() - 1; x++) {
                int finalX = x;
                String columnOfTrees = input.stream().reduce("", (column, row) -> column += row.charAt(finalX));
                int treeHeight = Integer.parseInt(String.valueOf(rowOfTrees.charAt(x)));
                boolean visibleBefore = Arrays.stream(rowOfTrees.substring(0, x)
                        .split(""))
                        .map(Integer::parseInt)
                        .map(height -> height < treeHeight)
                        .reduce(true, (visible, lower) -> visible = lower ? visible : false);
                boolean visibleAfter = Arrays.stream(rowOfTrees.substring(x + 1)
                        .split(""))
                        .map(Integer::parseInt)
                        .map(height -> height < treeHeight)
                        .reduce(true, (visible, lower) -> visible = lower ? visible : false);
                boolean visibleAbove = Arrays.stream(columnOfTrees.substring(0,y)
                        .split(""))
                        .map(Integer::parseInt)
                        .map(height -> height < treeHeight)
                        .reduce(true, (visible, lower) -> visible = lower ? visible : false);
                boolean visibleBelow = Arrays.stream(columnOfTrees.substring(y + 1)
                        .split(""))
                        .map(Integer::parseInt)
                        .map(height -> height < treeHeight)
                        .reduce(true, (visible, lower) -> visible = lower ? visible : false);
                if (visibleBefore || visibleAfter || visibleAbove || visibleBelow) {
                    visibleTrees++;
                }
            }
        }

        return String.valueOf(visibleTrees);
    }

    @Override
    public String part2(List<String> input) {
        int maxScenicScore = 0;
        for(int y = 1; y < input.size() - 1; y++) {
            String rowOfTrees = input.get(y);
            for (int x = 1; x < rowOfTrees.length() - 1; x++) {
                int finalX = x;
                String columnOfTrees = input.stream().reduce("", (column, row) -> column += row.charAt(finalX));
                int treeHeight = Integer.parseInt(String.valueOf(rowOfTrees.charAt(x)));
                int treesVisibleBefore = 0;
                for (int i = x-1; i >= 0 ; i--) {
                    treesVisibleBefore++;
                    if (Integer.parseInt(String.valueOf(rowOfTrees.charAt(i))) >= treeHeight) {
                        break;
                    }
                }
                int treesVisibleAfter = 0;
                for (int i = x+1; i < rowOfTrees.length() ; i++) {
                    treesVisibleAfter++;
                    if (Integer.parseInt(String.valueOf(rowOfTrees.charAt(i))) >= treeHeight) {
                        break;
                    }
                }
                int treesVisibleAbove = 0;
                for (int i = y-1; i >= 0; i--){
                    treesVisibleAbove++;
                    if (Integer.parseInt(String.valueOf(columnOfTrees.charAt(i))) >= treeHeight) {
                        break;
                    }
                }
                int treesVisibleBelow = 0;
                for (int i = y+1; i < columnOfTrees.length(); i++){
                    treesVisibleBelow++;
                    if (Integer.parseInt(String.valueOf(columnOfTrees.charAt(i))) >= treeHeight) {
                        break;
                    }
                }
                int treesScenicScore = treesVisibleBefore * treesVisibleAfter * treesVisibleAbove * treesVisibleBelow;
                if (treesScenicScore > maxScenicScore) {
                    maxScenicScore = treesScenicScore;
                }
            }
        }

        return String.valueOf(maxScenicScore);
    }

}
