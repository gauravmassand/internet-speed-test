package com.internet.speed.internet.speed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class PythonProcess {

    Logger logger = LoggerFactory.getLogger(PythonProcess.class);

    public double callPythonScript() {
        double speed = 0;
        try {
            logger.info("Starting process to get speed");
            String pythonScriptPath = new File(PythonProcess.class.getResource("/speed_test.py").getFile()).getAbsolutePath();
            ProcessBuilder pb = new ProcessBuilder("python3", pythonScriptPath);
            pb.redirectErrorStream(true);
            Process proc = pb.start();

            Reader reader = new InputStreamReader(proc.getInputStream());
            BufferedReader bf = new BufferedReader(reader);
            String s;
            while ((s = bf.readLine()) != null) {
                speed = Double.parseDouble(s);
            }
            logger.info("Speed process completed successfully");
        } catch (IOException e) {
            logger.error("Exception while running script {}", e.getMessage());
        }
        return speed;
    }
}
