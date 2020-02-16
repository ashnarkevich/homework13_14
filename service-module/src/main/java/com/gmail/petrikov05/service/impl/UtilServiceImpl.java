package com.gmail.petrikov05.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gmail.petrikov05.service.UtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

    private static final Logger logger = LogManager.getLogger(UtilServiceImpl.class);

    @Value("${pattern.line}")
    private String regexLine;

    @Override
    public int add(String line) {
        int sum = 0;
        boolean isValidLine = validLine(line, regexLine);
        if (isValidLine) {
            sum = getSum(line);
        }

        return sum;
    }

    private boolean validLine(String line, String regexLine) {
        Pattern regexLinePattern = Pattern.compile(regexLine);
        Matcher m = regexLinePattern.matcher(line);
        if (m.find()) {
            return true;
        } else {
            logger.info("Line is wrong: " + line);
            return false;
        }
    }

    private int getSum(String numbers) {
        int sum = 0;
        String regexNumber = "\\d+";
        Pattern regexNumberPattern = Pattern.compile(regexNumber);
        Matcher matcherNumber = regexNumberPattern.matcher(numbers);
        while (matcherNumber.find()) {
            int number = Integer.parseInt(matcherNumber.group());
            sum += number;
        }
        return sum;
    }

}
