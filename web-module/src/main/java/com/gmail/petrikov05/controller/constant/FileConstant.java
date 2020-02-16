package com.gmail.petrikov05.controller.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileConstant {

    @Value("${file.path}")
    private String fileName;

    public String getFileName() {
        return fileName;
    }

}
