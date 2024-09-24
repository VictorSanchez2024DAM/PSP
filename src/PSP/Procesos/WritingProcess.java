package PSP.Procesos;

import java.io.*;

public class WritingProcess {
    public static void main(String[] args) {
        ProcessBuilder builder = new ProcessBuilder( "bash");
        builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        builder.redirectError(ProcessBuilder.Redirect.INHERIT);
        builder.redirectInput(ProcessBuilder.Redirect.INHERIT);


        try{
            Process p = builder.start();

            try(InputStream is = p.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr)){
                 String line;
                 while((line = br.readLine()) != null){
                     System.out.println(line);
                 }
            }


            try(OutputStream out = p.getOutputStream();
                OutputStreamWriter osw = new OutputStreamWriter(out);
                BufferedWriter bw = new BufferedWriter(osw)){
                bw.write("ls");
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e){
            System.err.println("Error...");
        }
    }
}
