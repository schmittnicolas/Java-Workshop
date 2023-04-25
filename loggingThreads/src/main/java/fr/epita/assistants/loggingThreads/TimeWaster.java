package fr.epita.assistants.loggingThreads;

import java.math.*;


import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class TimeWaster {
    private final Logger timeWasterLogger;;

    public TimeWaster() {
        timeWasterLogger = (Logger) LoggerFactory.getLogger(this.getClass());
        timeWasterLogger.setLevel(Level.TRACE);
        timeWasterLogger.trace("Calculating");

    }

    public BigInteger sumUpTo(int n) {

        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= n; i++) {
            sum = sum.add(BigInteger.valueOf(i));
        }

        timeWasterLogger.debug("Finished calculating sum up to {}: {}", n, sum);
        return sum;
    }

    public void doImportantThing() {

        timeWasterLogger.info("Waiting");
        try {
            Thread.sleep(2000);
            timeWasterLogger.setLevel(Level.INFO);
            timeWasterLogger.info("Successfully waited");
        } catch (InterruptedException e) {
            timeWasterLogger.setLevel(Level.ERROR);
            timeWasterLogger.error("Wait interrupted");
        }
    }
}
