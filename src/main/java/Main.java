import javax.swing.*;

/**
 * Test Main class to check the functionalities implemented in the C++ wrapper class
 */
public class Main {
    public static void main(String[] args) {
        NativeWrapper wrapper = new NativeWrapper();

        // Test the wrapper methods
        System.out.println("Expected: TEST, Output: " + wrapper.processString("test"));
        System.out.println("Expected: 15, Output: " + wrapper.performCalculation(5 , 10));
        wrapper.cleanup();

        // Simple message dialog
        JOptionPane.showMessageDialog(null, "Finished!", "Title", JOptionPane.INFORMATION_MESSAGE);
        try {
            // Wait for 3 second (3000 milliseconds)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            // Handle interruption
            Thread.currentThread().interrupt();
        }
    }
}
