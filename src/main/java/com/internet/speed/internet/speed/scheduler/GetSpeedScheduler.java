package com.internet.speed.internet.speed.scheduler;

import com.internet.speed.internet.speed.ConstructCSVObject;
import com.internet.speed.internet.speed.model.CSVObject;
import com.internet.speed.internet.speed.worker.CSVWorker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class GetSpeedScheduler {

    Logger logger = LoggerFactory.getLogger(GetSpeedScheduler.class);

    @Autowired
    ConstructCSVObject constructCSVObject;

    ExecutorService executor = Executors.newSingleThreadExecutor();

    @Scheduled(fixedRate = 20000)
    public void scheduleSpeedAtIntervals() {
        logger.info("Starting scheduler");
        CSVObject csvObject = constructCSVObject.createCSVObject();
        logger.info("Scheduler completed");
        CSVWorker csvWorker = new CSVWorker(csvObject);
        executor.submit(csvWorker);
    }
}
