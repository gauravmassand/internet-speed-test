package com.internet.speed.internet.speed;

import com.internet.speed.internet.speed.model.CSVObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConstructCSVObject {

    public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Autowired
    PythonProcess pythonProcess;

    public CSVObject createCSVObject() {
        CSVObject csvObject = new CSVObject();
        LocalDateTime now = LocalDateTime.now();
        csvObject.setCurrentDateTime(dtf.format(now));
        csvObject.setSpeed(pythonProcess.callPythonScript());
        return csvObject;
    }
}
