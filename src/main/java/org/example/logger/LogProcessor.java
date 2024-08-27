package org.example.logger;

public abstract class LogProcessor {
    private LogProcessor nextProcessor;
    public LogProcessor(LogProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public void log(Loglevel loglevel, String message) {
        if(this.nextProcessor != null) {
            this.nextProcessor.log(loglevel, message);
        }
    }
}
