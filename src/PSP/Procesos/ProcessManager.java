package PSP.Procesos;

import java.io.IOException;

public class ProcessManager {
    public static void main(String[] args) {
        String[] commands = {"kcalc"};
        try {
           Process p = Runtime.getRuntime().exec(commands);


           ProcessBuilder builder = new ProcessBuilder(new String[]{"kcalc"});
           Process process = builder.start();

            int code = process.waitFor();
            System.out.println(code);
        } catch (IOException e) {
            System.err.println("Error...");
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
    }
}
