package main.java.by.rymtsov.lesson20.task2.model;

/**
 * This class is a car adder.
 * It can add cars to the service station.
 */

public class CarAdder implements Runnable {
    private final ServiceStation serviceStation;

    public CarAdder(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                serviceStation.addCar();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
