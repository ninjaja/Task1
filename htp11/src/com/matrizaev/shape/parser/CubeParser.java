package com.matrizaev.shape.parser;

import com.matrizaev.shape.reader.CubeReader;
import com.matrizaev.shape.validator.CubeValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CubeParser {

        public List<Double> cubeParse(List<String> listToParse) {

        ArrayList<Double> parsedList = new ArrayList<>();

        Pattern p = Pattern.compile("-?\\d+\\.\\d+");

        for (String s: listToParse) {
            Matcher m = p.matcher(s);
            while (m.find()) {
                Double parsedNumber = Double.parseDouble(m.group());
                parsedList.add(parsedNumber);
            }
        }
        return parsedList;
    }

}
