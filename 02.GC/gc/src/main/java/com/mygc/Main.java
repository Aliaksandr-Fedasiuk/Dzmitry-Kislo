package com.mygc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List objects = new ArrayList();
    private static boolean cont = true;
    private static String input;
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Memory Tool!");

        while (cont) {
            System.out.println(
                    "\n\nI have " + objects.size() + " objects in use, about" +
                            (objects.size()) + "MB." +
                            "\nWhat would you like me to do?\n" +
                            "1. Create some objects\n" +
                            "2. Remove some objects\n" +
                            "0. Quit");
            input = in.readLine();
            if ((input != null) && (input.length() >= 1)) {
                if (input.startsWith("0")) cont = false;
                if (input.startsWith("1")) createObjects();
                if (input.startsWith("2")) removeObjects();
            }
        }

        System.out.println("Bye!");
    }

    private static void removeObjects() {
        System.out.println("Removing objects...");
        int end = objects.size() - 1;
        if (end >= 0) {
            objects.remove(end);
        }

    }

    private static void createObjects() {
        System.out.println("Creating objects...");
        //1 element of array = 1 MB
        objects.add(new byte[1024 * 1024]);
    }


}
