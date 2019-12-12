package com.hmtmcse.progress;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderExample1 {

    public static void main(String[] args) {

        ProcessBuilder processBuilder = new ProcessBuilder();

        // Run this on Windows, cmd, /c = terminate after this run
        processBuilder.command("cmd.exe", "/c", "ping google.com -t");

        try {

            Process process = processBuilder.start();

            // blocked :(
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
            System.out.println("\nExited with error code : " + exitCode);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
