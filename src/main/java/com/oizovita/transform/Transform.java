package com.oizovita.transform;

import com.oizovita.exeptions.MaxMinException;

import java.util.ArrayList;
import java.util.List;

public interface Transform {
    Transform range(String stringMin, String stringMax, String stringStep) throws MaxMinException;

    void render();
}
