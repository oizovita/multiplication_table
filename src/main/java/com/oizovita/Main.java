package com.oizovita;

import com.oizovita.transform.DoubleTransform;
import com.oizovita.transform.IntegerTransform;
import com.oizovita.transform.Transform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Main
 */
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static final String INT = "int";
    private static final String DOUBLE = "double";

    public static void main(String[] args) throws IOException {
        logger.info("Start program");
        var config = Config.init();

        Transform t;
        try {
            switch (config.type()) {
                case INT:
                    t = new IntegerTransform();
                    t.range(config.min(), config.max(), config.step()).render();
                    break;
                case DOUBLE:
                    t = new DoubleTransform();
                    t.range(config.min(), config.max(), config.step()).render();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + config.type());
            }
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }

        logger.info("End program");
    }
}
