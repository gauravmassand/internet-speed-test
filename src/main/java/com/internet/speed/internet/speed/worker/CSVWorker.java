package com.internet.speed.internet.speed.worker;

import com.internet.speed.internet.speed.model.CSVObject;
import com.opencsv.CSVWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;

public class CSVWorker implements Runnable {
    Logger logger = LoggerFactory.getLogger(CSVWorker.class);

    CSVObject csvObject;

    public CSVWorker(CSVObject csvObject) {
        this.csvObject = csvObject;
    }

    @Override
    public void run() {
        logger.info("Writing to csv file starts");
        String csvPath = "/home/ankita/gaurav/internet-speed-test/speed-test-data.csv";
        File file = new File(csvPath);
        try {
            FileWriter outputCSVFile = new FileWriter(file, true);
            CSVWriter csvWriter = new CSVWriter(outputCSVFile);
            String[] csvObjectData = {csvObject.getCurrentDateTime(), String.valueOf(csvObject.getSpeed())};
            csvWriter.writeNext(csvObjectData);
            csvWriter.close();
        } catch (Exception e) {
            logger.error("Error while writing to file {}", e.getMessage());
        }

    }
}
