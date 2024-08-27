package org.example.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggerApplication {

    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogprocessor(new DebugLogProcessor(new ErrorLogProcessor(null)));
        logProcessor.log(Loglevel.DEBUG, "siddhu1");
        logProcessor.log(Loglevel.INFO, "siddhu2");
        logProcessor.log(Loglevel.ERROR, "siddhu3");
//        SpringApplication.run(LoggerApplication.class, args);
    }

}
