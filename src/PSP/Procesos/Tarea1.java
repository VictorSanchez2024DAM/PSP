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
            ProcessBuilder fail = new ProcessBuilder(new String[]{"false"});
            Process process2 = fail.start();

            int code2 = process2.waitFor();
            System.out.println(code2);

            // 4

            ProcessBuilder fail2 = new ProcessBuilder(new String[]{"commando_inexistente"});
            Process process3 = fail2.start();

            int code3 = process3.waitFor();
            System.out.println(code3);

            // 5
            // a) When it exits with "System.exit" the number means the code of exit of the process, any different than 0
            // usually means an error has occurred, so we can control different type of errors managing and sending different
            // exit codes.
            // b) It allows the subprocess to use the same input and output streams as the parent process meaning this that
            // any output from this subprocess will be visible in the parent process terminal and any input that the subprocess needs
            // could be provided by the parent process input stream


            // 6

            String directoryCreate = "mkdir my_directory";
            String directoryDelete = "rmdir my_directory";

            System.out.println("Creamos el directorio...");
            commandExecute(directoryCreate);

            System.out.println("Borramos el directorio...");
            commandExecute(directoryDelete);


            // 7

            ProcessBuilder sleep = new ProcessBuilder(new String[]{"sleep", "10"});
            sleep.inheritIO();
            Process processIsAlive = sleep.start();




        } catch (IOException e) {
            System.err.println("Error...");
        } catch (InterruptedException e) {
            System.err.println("Error...");
        }
    }

    // 6
    public static void commandExecute(String command) throws IOException, InterruptedException{
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.inheritIO();

        Process process = processBuilder.start();
        int exitCode = process.waitFor();

        System.out.println(exitCode);

    }
}
