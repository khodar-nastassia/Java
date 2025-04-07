package file;

import java.io.*;
import java.util.ArrayList;

public class ObjectReader {

    public static <T>ArrayList<T> readObjectsFromFile(String filePath, Class<T> cl) {

        ArrayList<T> loadedObjects = new ArrayList<>();
        File file = new File(filePath);

        if (!file.exists()) {
            return loadedObjects;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    Object obj = ois.readObject();
                    if (cl.isInstance(obj)){
                        loadedObjects.add(cl.cast(obj));
                    }
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Read error: " + e.getMessage());
        }
        return loadedObjects;
    }
}