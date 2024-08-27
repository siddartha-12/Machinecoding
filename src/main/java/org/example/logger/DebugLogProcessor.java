package org.example.logger;

public class DebugLogProcessor extends LogProcessor{

    public DebugLogProcessor(LogProcessor nextProcessor) {
        super(nextProcessor);
    }
    public void log(Loglevel loglevel, String message) {
        if(loglevel == Loglevel.DEBUG) {
            System.out.println("DEBUG: " + message);
        }
        else{
            super.log(loglevel, message);
        }
    }
}
