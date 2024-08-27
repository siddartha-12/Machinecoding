package org.example.logger;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Loglevel loglevel, String message) {
        if(loglevel == Loglevel.ERROR) {
            System.out.println("ERROR: " + message);
        }
        else{
            super.log(loglevel, message);
        }
    }

}
