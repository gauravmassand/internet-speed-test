package com.internet.speed.internet.speed.scheduler;

import com.internet.speed.internet.speed.ConstructCSVObject;
import com.internet.speed.internet.speed.model.CSVObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GetSpeedScheduler {

    Logger logger = LoggerFactory.getLogger(GetSpeedScheduler.class);

    @Autowired
    ConstructCSVObject constructCSVObject;

    @Scheduled(fixedRate = 20000)
    public void scheduleSpeedAtIntervals() {
        logger.info("Starting scheduler");
        CSVObject csvObject = constructCSVObject.createCSVObject();
        logger.info("CSV Object contents are {}", csvObject.toString());
    }
}
