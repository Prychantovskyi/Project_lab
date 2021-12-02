package com.nullprogram.maze;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * Input start point and type of maze.
 */

public final class Main {
    
    /** 
     * @param args
     * @throws InterruptedException
     */
    public static void main(final String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        int inp = scanner.nextInt();
        if (inp == 0){
            int type = scanner.nextInt();
            int startx = scanner.nextInt();
            int starty = scanner.nextInt();

            for (int i = 0; i < type; i++){
                if (i == 0){
                    RunMaze runmaze = new RunMaze(startx, starty);
                    runmaze.StartProject();
                
                } else {
                    RunMaze runmaze = new RunMaze(0, 0);
                    runmaze.StartProject();
                
                }
                String a = scanner.nextLine();
                
            }

            scanner.close();
        } else {
            try{
                File file = new File("E://","input.txt");
                FileReader freader = new FileReader(file);
                BufferedReader reader = new BufferedReader(freader);
                int type = Integer.parseInt(String.valueOf(reader.readLine()));
                int startx = Integer.parseInt(String.valueOf(reader.readLine()));
                int starty = Integer.parseInt(String.valueOf(reader.readLine()));
                
                for (int i = 0; i < type; i++){
                    if (i == 0){
                        RunMaze runmaze = new RunMaze(startx, starty);
                        runmaze.StartProject();
                    
                    } else {
                        RunMaze runmaze = new RunMaze(0, 0);
                        runmaze.StartProject();
                    
                    }
                    String a = scanner.nextLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*
        int type = scanner.nextInt();
        int startx = scanner.nextInt();
        int starty = scanner.nextInt();

        for (int i = 0; i < type; i++){
            if (i == 0){
                RunMaze runmaze = new RunMaze(startx, starty);
                runmaze.StartProject();
                
            } else {
                RunMaze runmaze = new RunMaze(0, 0);
                runmaze.StartProject();
                
            }
            String a = scanner.nextLine();
        }

        scanner.close();
        */
    }
}