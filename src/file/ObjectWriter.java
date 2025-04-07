package file;

import java.io.*;
import java.util.ArrayList;

public class ObjectWriter {

    public static void writeObjectToFile(Object object, String filePath) {

        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
                return;
            }
        }

        try (ObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(filePath, true))) {
            oos.writeObject(object);
        } catch (IOException e) {
            System.out.println("Write error: " + e.getMessage());
        }
    }

    public static <T> void rewriteObjectsFile(ArrayList<T> objects, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            for (T obj : objects) {
                oos.writeObject(obj);
            }
        } catch (IOException e) {
            System.out.println("Rewrite error: " + e.getMessage());
        }
    }





}