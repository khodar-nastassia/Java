public class Main {
    public static void main(String[] args) throws Exception {


        String classesDir = "ClassLoader/resources";
        MyClassLoader myLoader = new MyClassLoader(classesDir);

        Class<?> ravenClass = myLoader.loadClass("Raven");
        Object raven = ravenClass.getDeclaredConstructor().newInstance();
        ravenClass.getMethod("setLatinName", String.class).invoke(raven,"Corvus corax");
        String name = (String) ravenClass.getMethod("getLatinName").invoke(raven);
        System.out.println("Latin name: " + name);
        ravenClass.getMethod("fly").invoke(raven);
    }
}
