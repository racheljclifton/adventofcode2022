package aoc.day09;

import aoc.Day;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day09 implements Day {

    @Override
    public String part1(List<String> input) {
        Set<String> tailLocations = new HashSet<>();
        tailLocations.add("0,0");
        int hx = 0;
        int hy = 0;
        int tx = 0;
        int ty = 0;
        for (int i = 0; i < input.size(); i ++) {
            String movement = input.get(i);
            String direction = String.valueOf(movement.charAt(0));
            int amount = Integer.parseInt(movement.substring(2));
            if (direction.equals("R")) {
                for (int j = 0; j < amount; j++) {
                    hx++;
                    if (hx - tx > 1) {
                        tx++;
                        if (hy - ty >= 1) {
                            ty++;
                        } else if (ty - hy >= 1) {
                            ty--;
                        }
                        tailLocations.add(tx + "," + ty);
                    }
                }
            } else if (direction.equals("L")) {
                for (int j = 0; j < amount; j++) {
                    hx--;
                    if (tx - hx > 1) {
                        tx--;
                        if (hy - ty >= 1) {
                            ty++;
                        } else if (ty - hy >= 1) {
                            ty--;
                        }
                        tailLocations.add(tx + "," + ty);
                    }
                }
            } else if (direction.equals("U")) {
                    for (int j = 0; j < amount; j++) {
                        hy++;
                        if (hy - ty > 1) {
                            ty++;
                            if (hx - tx >= 1) {
                                tx++;
                            } else if (tx - hx >= 1) {
                                tx--;
                            }
                            tailLocations.add(tx + "," + ty);
                        }
                    }
            } else if (direction.equals("D")) {
                for (int j = 0; j < amount; j++) {
                    hy--;
                    if (ty - hy > 1) {
                        ty--;
                        if (hx - tx >= 1) {
                            tx++;
                        } else if (tx - hx >= 1) {
                            tx--;
                        }
                        tailLocations.add(tx + "," + ty);
                    }
                }
            }
        }
        return String.valueOf(tailLocations.size());
    }

    private class Coordinate {
        int x;
        int y;
    }
    @Override
    public String part2(List<String> input) {
        Set<String> tailLocations = new HashSet<>();
        tailLocations.add("0,0");


//        for (int i = 0; i < input.size(); i ++) {
//            String movement = input.get(i);
//            String direction = String.valueOf(movement.charAt(0));
//            int amount = Integer.parseInt(movement.substring(2));
//            if (direction.equals("R")) {
//                for (int j = 0; j < amount; j++) {
//                    hx++;
//                    if (hx - x1 > 1) {
//                        x1++;
//                        if (hy - y1 >= 1) {
//                            y1++;
//                        } else if (y1 - hy >= 1) {
//                            y1--;
//                        }
//                        tailLocations.add(x9 + "," + y9);
//                    }
//                }
//            } else if (direction.equals("L")) {
//                for (int j = 0; j < amount; j++) {
//                    hx--;
//                    if (tx - hx > 1) {
//                        tx--;
//                        if (hy - ty >= 1) {
//                            ty++;
//                        } else if (ty - hy >= 1) {
//                            ty--;
//                        }
//                        tailLocations.add(tx + "," + ty);
//                    }
//                }
//            } else if (direction.equals("U")) {
//                for (int j = 0; j < amount; j++) {
//                    hy++;
//                    if (hy - ty > 1) {
//                        ty++;
//                        if (hx - tx >= 1) {
//                            tx++;
//                        } else if (tx - hx >= 1) {
//                            tx--;
//                        }
//                        tailLocations.add(tx + "," + ty);
//                    }
//                }
//            } else if (direction.equals("D")) {
//                for (int j = 0; j < amount; j++) {
//                    hy--;
//                    if (ty - hy > 1) {
//                        ty--;
//                        if (hx - tx >= 1) {
//                            tx++;
//                        } else if (tx - hx >= 1) {
//                            tx--;
//                        }
//                        tailLocations.add(tx + "," + ty);
//                    }
//                }
//            }
//        }
        return String.valueOf(tailLocations.size());
    }

}
