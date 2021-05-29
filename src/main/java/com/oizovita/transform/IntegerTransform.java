package com.oizovita.transform;

import com.oizovita.exeptions.MaxMinException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class IntegerTransform implements Transform {

    private static final Logger logger = LogManager.getLogger(IntegerTransform.class);
    private List<Integer> integerList;

    @Override
    public Transform range(String stringMin, String stringMax, String stringStep) throws MaxMinException {
        var min = Integer.parseInt(stringMin);
        var max = Integer.parseInt(stringMax);
        var step = Integer.parseInt(stringStep);

        if (max < min) {
            throw new MaxMinException("Min can't bigger than max");
        }

        this.integerList = new ArrayList<>();

        this.integerList.add(min);
        var tmp = min;
        while (tmp < max - step) {
            tmp += step;

            this.integerList.add(tmp);
        }
        this.integerList.add(max);

        return this;
    }

    @Override
    public void render() {
        for (var i = 0; i < this.integerList.size(); i++) {
            for (var j = 0; j < this.integerList.size(); j++) {
                logger.info("{}  * {} = {}", this.integerList.get(i), this.integerList.get(j), this.integerList.get(i) * this.integerList.get(j));
            }
            logger.info("\n");
        }
    }
}
