import java.io.*;

public class MyClassLoader extends ClassLoader{
    private final String classesDir;

    public MyClassLoader(String classesDir) {
        this.classesDir = classesDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = name + ".class";
        File classFile = new File(classesDir, fileName);

        if (!classFile.exists()) {
            throw new ClassNotFoundException("Class file not found: " + classFile.getAbsolutePath());
        }

        try {
            byte[] classBytes = loadClassData(classFile);
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Failed to load class " + name, e);
        }
    }

    private byte[] loadClassData(File file) throws IOException {
        try (InputStream input = new FileInputStream(file);
             ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
            int data;
            while ((data = input.read()) != -1) {
                buffer.write(data);
            }
            return buffer.toByteArray();
        }
    }
}
