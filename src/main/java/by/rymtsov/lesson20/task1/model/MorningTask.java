package main.java.by.rymtsov.lesson20.task1.model;

/**
 * This class is a thread
 * that describes morning.
 */

public class MorningTask implements Runnable {

    private String taskName;

    public MorningTask(String taskName) {
        this.taskName = taskName;
    }

    public void run() {
        switch (taskName) {
            case "News":
                System.out.println("Reading news.");
                break;
            case "Breakfast":
                System.out.println("Having breakfast.");
                break;
            case "Coffee":
                System.out.println("Drinking coffee.");
                break;
            default:
                System.out.println("Morning.");
        }
    }
}
