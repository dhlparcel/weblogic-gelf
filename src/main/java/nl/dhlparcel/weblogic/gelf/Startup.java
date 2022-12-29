package nl.dhlparcel.weblogic.gelf;

import biz.paluch.logging.gelf.jul.GelfLogHandler;
import weblogic.logging.LoggingHelper;

import java.util.logging.Logger;

public class Startup {

    public static void main(String[] argv) {
        System.out.println("Gelf logging Startup class called");
        try {
            Logger logger = LoggingHelper.getServerLogger();
            logger.info("Registering JUL GelfLogHandler");
            logger.addHandler(new GelfLogHandler());
            logger.info("Registered GelfLogHandler");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
