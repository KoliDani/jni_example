/**
 * C++ wrapper class
 */
public class NativeWrapper {
    static {
        // Load the native library
        setupLibrary();
    }

    /**
     * Checks the operating system and selects the proper compiled library accordingly
     */
    private static void setupLibrary() {
        // Get the current jar file location
        // Add the library location to the path
        String currentPath = System.getProperty("user.dir");

        // Check which os we're on
        String osName = System.getProperty("os.name").toLowerCase();
        if (osName.contains("windows")) {
            // Windows
            currentPath += "\\" + "native_libs" + "\\" + "windows" + "\\";
        } else if (osName.contains("linux")) {
            // Linux
        } else {
            // Mac
        }
        currentPath += "NativeWrapper.dll";

        // Load the correct library
        System.load(currentPath);
    }

    // Native method declarations
    public native int performCalculation(int a, int b);
    public native String processString(String input);
    public native void initialize();
    public native void cleanup();

    /**
     * Constructor
     */
    public NativeWrapper() {
        initialize();
    };
}