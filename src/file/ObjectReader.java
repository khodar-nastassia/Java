package file;

import dto.Reservation;
import dto.Workplace;

import java.io.*;
import java.util.*;

public class ObjectReader {

    public static Object readObjectsFromFile(String filePath, Class<?> type) {


        File file = new File(filePath);

        if (!file.exists()) {
            return createEmptyCollection(type);
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (type == Reservation.class && obj instanceof List) {
                return obj;
            } else if (type == Workplace.class && obj instanceof Map) {
                return obj;
            }else {
                System.out.println("unexpected content in file.");

            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return createEmptyCollection(type);
    }

    private static Object createEmptyCollection(Class<?> type) {

        if (type == Reservation.class) {
            ArrayList<Reservation> loadedObjects =  new ArrayList<Reservation>();
            return loadedObjects;
        } else if (type == Workplace.class) {
            HashMap<Integer, Workplace> loadedObjects = new HashMap<Integer, Workplace>();
            return loadedObjects;
        }
        return null;
    }
}