package app;

import ui.ProgramLoop;

/**
 * Main entry point. Starts the ProgramLoop.
 */
public class Main {
    public static void main(String[] args) {
        ProgramLoop loop = new ProgramLoop();
        loop.start();
    }
}
