package main.java.by.rymtsov.lesson20.task2.model;

/**
 * This class is a car remover.
 * It can remove cars from the service station.
 */

public class CarRemover implements Runnable {
    private final ServiceStation serviceStation;

    public CarRemover(ServiceStation serviceStation) {
        this.serviceStation = serviceStation;
    }

    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                serviceStation.removeCar();
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
