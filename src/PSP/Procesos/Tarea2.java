package PSP.Procesos;

import java.io.*;


public class Tarea2 {
    public static void main(String[] args) {


        try {
            // 1
            ProcessBuilder hello = new ProcessBuilder("echo", "Hello World");
            Process p = hello.start();
            String line;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }
            int exitCode = p.waitFor();
            System.out.println(exitCode);

            // 2
            ProcessBuilder invalid = new ProcessBuilder("ps -rer");
            Process p2 = invalid.start();
            try(BufferedReader br = new BufferedReader(new InputStreamReader(p2.getInputStream()))){
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }
            int exitCode2 = p2.waitFor();
            System.out.println(exitCode2);


            // 3

            ProcessBuilder writeAndRead = new ProcessBuilder("cat");
            Process p3 = writeAndRead.start();

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(p3.getOutputStream()))) {
                bw.write("Hooooolaaaaaaa");
                bw.newLine();
                bw.flush();
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(p3.getInputStream()))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            }

            int exitCode3 = p3.waitFor();
            System.out.println(exitCode3);

            // 4
            // We are trying to start a console process to execute the command dir or ls in linux
            // then we read the output of the command then we execute the command exit to close the cmd
            // process returning the exit code of the process, what is happening is that everything is fine
            // until the exit command is executed, the program never ends until you force it to end giving us
            // the exception of "broken pipe".

            // 5
            // We can just change the order of the program lines and it works, first we write everything, then we read
            // the lines provided by the console.
            ProcessBuilder pb = new ProcessBuilder(new String[]{"bash"});
            Process process = null;
                process = pb.start();
                try (BufferedWriter bw = new BufferedWriter(new
                        OutputStreamWriter(process.getOutputStream()));
                     BufferedReader br = new BufferedReader(new
                             InputStreamReader(process.getInputStream()))) {
                    bw.write("ls");
                    bw.newLine();
                    bw.flush();

                    bw.write("exit");
                    bw.newLine();
                    bw.flush();

                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }

                }
                System.out.println(process.waitFor());

                // 6
            ProcessBuilder nslookup = new ProcessBuilder("nslookup");
            Process p6 = nslookup.start();

            try(BufferedReader br = new BufferedReader(new InputStreamReader(p3.getInputStream()))){
                while((line = br.readLine()) != null){
                    System.out.println(line);
                }
            }
            int exitCode6 = p6.waitFor();
            System.out.println(exitCode6);


            } catch (IOException | RuntimeException | InterruptedException e) {
                System.err.println("Error...");
            }
        }
    }

