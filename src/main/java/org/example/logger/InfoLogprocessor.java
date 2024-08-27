package org.example.logger;

public class InfoLogprocessor extends LogProcessor {
    public InfoLogprocessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Loglevel loglevel, String message) {
        if(loglevel == Loglevel.INFO) {
            System.out.println("INFO: " + message);
        }
        else{
            super.log(loglevel, message);
        }
    }
}
