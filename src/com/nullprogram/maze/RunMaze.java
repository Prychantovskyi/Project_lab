package com.nullprogram.maze;

import javax.swing.JFrame;

/**
 * Set up an animation as a standalone application.
 */
public final class RunMaze {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 40;
    private static final int SCALE = 15;
    private static final int SPEED = 10;
    private final int coordinate_x;
    private final int coordinate_y;

    /**
     * Inputs start coordinates.
     * @param x  x coordinate of start
     * @param y  y coordinate of start
     */
    public RunMaze(final int x ,final int y) {
        coordinate_x = x;
        coordinate_y = y;
    }

    public void StartProject() {
        /* Fix for poor OpenJDK performance. */
        System.setProperty("sun.java2d.pmoffscreen", "false");

        /* Default maze behaviour */
        int width = WIDTH;
        int height = HEIGHT;
        int scale = SCALE;
        int speed = SPEED;

        Maze maze = new DepthMaze(width, height, scale,coordinate_x,coordinate_y);
        JFrame frame = new JFrame("Maze");
        MazeDisplay display = new MazeDisplay(maze);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(display);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);

        /* Now solve the maze */
        MazeSolver solver = new MazeSolver(maze, speed);
        solver.addListener(display);
        solver.start();
    }
}