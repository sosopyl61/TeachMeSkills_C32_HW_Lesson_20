package main.java.by.rymtsov.lesson20.task2.model;

import main.java.by.rymtsov.lesson20.task2.constant.Constants;

/**
 * This class describes a service station.
 */

public class ServiceStation implements Constants {
    private final int capacity = Constants.MAX_CAR_SERVICES;
    private int currentCarsServices = 0;

    public ServiceStation() {
        System.out.println("Service station created.");
    }

    public synchronized void addCar() throws InterruptedException {
        while (currentCarsServices >= capacity) {
            System.out.println("Service station is full.");
            wait();
        }
        currentCarsServices++;
        System.out.println("Car is successfully added. Current service is: " + currentCarsServices);
        notifyAll();
    }

    public synchronized void removeCar() throws InterruptedException {
        while (currentCarsServices <= 0) {
            System.out.println("No cars to service.");
            wait();
        }
        currentCarsServices--;
        System.out.println("Car is successfully removed. Current service is: " + currentCarsServices);
        notifyAll();
    }
}
