package fr.epita.assistants;

import fr.epita.assistants.loggingThreads.*;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Logger loggerMain = LoggerFactory.getLogger(Main.class);
        loggerMain.info("Entering application");

        TimeWaster waster = new TimeWaster();

        Thread sum = new Thread(() -> waster.sumUpTo(123456789));
        Thread thread = new Thread(waster::doImportantThing);

        sum.start();
        thread.start();
        thread.interrupt();
        sum.join();
        thread.join();
        loggerMain.info("Clean application exit");
    }
}