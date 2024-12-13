package main.java.by.rymtsov.lesson20.task1.props;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * This is a properties' handler.
 * It can get info from config.properties.
 */

public class PropsHandler {

    private static final String ROOT_CONFIG = "src/main/java/by/rymtsov/lesson20/task1/resources/config.properties";

    public static int getPriority(String priority) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(ROOT_CONFIG)) {
            props.load(input);
            return Integer.parseInt(props.getProperty(priority));
        } catch (IOException e) {
            System.out.println("Error.");
        }
        return 0;
    }

    public static String getName(String name) {
        Properties props = new Properties();
        try (InputStream input = new FileInputStream(ROOT_CONFIG)) {
            props.load(input);
            return props.getProperty(name);
        } catch (IOException e) {
            System.out.println("Error.");
        }
        return "";
    }
}
