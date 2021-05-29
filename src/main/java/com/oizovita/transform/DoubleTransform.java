package com.oizovita.transform;

import com.oizovita.exeptions.MaxMinException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class DoubleTransform implements Transform {
    private static final Logger logger = LogManager.getLogger(DoubleTransform.class);
    private List<Double> doubleList;

    @Override
    public Transform range(String stringMin, String stringMax, String stringStep) throws MaxMinException {
        var min = Double.parseDouble(stringMin);
        var max = Double.parseDouble(stringMax);
        var step = Double.parseDouble(stringStep);

        if (max < min) {
            throw new MaxMinException("Min can't bigger than max");
        }

        this.doubleList = new ArrayList<>();

        this.doubleList.add(min);
        var tmp = min;
        while (tmp < max - step) {
            tmp += step;

            this.doubleList.add(tmp);
        }
        this.doubleList.add(max);

        return this;
    }

    @Override
    public void render() {
        for (var i = 0; i < this.doubleList.size(); i++) {
            for (var j = 0; j < this.doubleList.size(); j++) {
                logger.info("{}  * {} = {}", this.doubleList.get(i), this.doubleList.get(j), this.doubleList.get(i) * this.doubleList.get(j));
            }
            logger.info("\n");
        }
    }
}
