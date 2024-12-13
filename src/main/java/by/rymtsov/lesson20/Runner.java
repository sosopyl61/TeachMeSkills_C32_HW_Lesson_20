package main.java.by.rymtsov.lesson20;

import main.java.by.rymtsov.lesson20.task1.model.MorningTask;
import main.java.by.rymtsov.lesson20.task1.props.PropsHandler;
import main.java.by.rymtsov.lesson20.task2.model.CarAdder;
import main.java.by.rymtsov.lesson20.task2.model.CarRemover;
import main.java.by.rymtsov.lesson20.task2.model.ServiceStation;

/**
 * This is an application runner class.
 * Tasks:
 * Task 1
 * Create a program that simulates the morning: reading the news, tomorrow, coffee.
 * Set each thread to a name and priority from the config file.
 * Let there be 3 threads.
 * Create and run 3 threads.
 * Make two options: using the Runnable interface and/or using the Thread class.
 *
 * Task 2
 * There is a service station. The station can service a maximum of a certain number of cars.
 * Create a class that will run in a separate thread and will add cars for service at the service station.
 * Create a class that will run in a separate thread and will take fixed cars from the service station.
 * Let the maximum number of cars available for service be specified in the interface for storing constants.
 * Use synchronized, wait, notify.
 */

public class Runner {
    public static void main(String[] args) {
        Thread morningThread1 = new Thread(new MorningTask(PropsHandler.getName("MORNING_TASK_NAME_1")));
        Thread morningThread2 = new Thread(new MorningTask(PropsHandler.getName("MORNING_TASK_NAME_2")));
        Thread morningThread3 = new Thread(new MorningTask(PropsHandler.getName("MORNING_TASK_NAME_3")));

        morningThread1.setPriority(PropsHandler.getPriority("MORNING_PRIORITY_1"));
        morningThread2.setPriority(PropsHandler.getPriority("MORNING_PRIORITY_2"));
        morningThread3.setPriority(PropsHandler.getPriority("MORNING_PRIORITY_3"));

        morningThread1.start();
        morningThread2.start();
        morningThread3.start();

        ServiceStation serviceStation = new ServiceStation();
        Thread adderThread = new Thread(new CarAdder(serviceStation));
        Thread removerThread = new Thread(new CarRemover(serviceStation));

        removerThread.start();
        adderThread.start();

    }
}
