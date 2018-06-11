package com.matrizaev.shape.validator;

import com.matrizaev.shape.exception.CubeValidationException;
import com.matrizaev.shape.reader.CubeReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CubeValidator {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> cubeValidate(List<String> listToValidate) throws CubeValidationException {

        ArrayList<String> validatedList = new ArrayList<>();
        Pattern p = Pattern.compile("-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s-?\\d+\\.\\d+\\s\\d+\\.\\d+");

        for(String s : listToValidate) {
            if(p.matcher(s).find()) {
                validatedList.add(s);
            } else {
                LOGGER.log(Level.INFO, "Validation: string [" + s + "] is incorrect");
            }
        }
        if (validatedList.isEmpty()) {
            LOGGER.log(Level.WARN, "Validation: no correct data found");
            throw new CubeValidationException("Validation: no correct data found");
        }
        return validatedList;
    }
}
