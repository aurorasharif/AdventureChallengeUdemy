package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<Integer, Location> locations=new HashMap<>();
    private static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);

        locations.get(2).addExit("N", 5);

        locations.get(3).addExit("W", 1);

        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);

        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);

        int presentLocation=1;
        while (true){
            System.out.println(locations.get(presentLocation).getDescription());
            if (presentLocation==0) break;
            System.out.println("Enter which direction you wish to go: ");
            String[] input=sc.nextLine().toUpperCase().split(" ");
            String direction=null;
            for (String s : input) {
                if (s.equals("NORTH") || s.equals("SOUTH") || s.equals("EAST") || s.equals("WEST") || s.equals("QUIT")){
                    switch (s){
                        case "NORTH":
                            direction="N";
                            break;
                        case "SOUTH":
                            direction="S";
                            break;
                        case "EAST":
                            direction="E";
                            break;
                        case "WEST":
                            direction="W";
                            break;
                        case "QUIT":
                            direction="Q";
                            break;
                    }
                }
            }
            if (locations.get(presentLocation).getExits().containsKey(direction)){
                presentLocation=locations.get(presentLocation).getExits().get(direction);
                System.out.println(presentLocation);
            } else System.out.println("You cant go to that direction");
        }
    }
}
