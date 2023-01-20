package aoc.day07;

import aoc.Day;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day07 implements Day {

    @Override
    public String part1(List<String> input) {
        Map<String, Integer> directoryTotals = new HashMap<>();
        return null;
    }

    private class Directory {
        List<Directory> directories;
        List<File> files;

        Directory(){
            directories = new ArrayList<>();
            files = new ArrayList<>();
        }

        public List<File> getFiles() {
            return files;
        }

        public void setFiles(List<File> files) {
            this.files = files;
        }

        public void addFile(File file) {
            this.files.add(file);
        }

        public List<Directory> getDirectories() {
            return directories;
        }

        public void setDirectories(List<Directory> directories) {
            this.directories = directories;
        }

        public void addDirectory(Directory directory) {
            this.directories.add(directory);
        }
    }

    private class File {
        int size;

        File(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
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
