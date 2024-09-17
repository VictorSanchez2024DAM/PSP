package PSP.Procesos;

import java.io.IOException;

public class Tarea1 {
    public static void main(String[] args) {
        try {
            // 1
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("kcalc");

            int code = process.waitFor();
            System.out.println(code);


            // 2
            ProcessBuilder builder = new ProcessBuilder(new String[]{"kcalc"});
            Process process1 = builder.start();


            int code1 = process1.waitFor();
            System.out.println(code1);

            // 3



        } catch (IOException e) {
            System.err.println("Error...");
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
    }
}
