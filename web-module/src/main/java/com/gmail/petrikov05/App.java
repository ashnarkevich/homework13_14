package com.gmail.petrikov05;

import com.gmail.petrikov05.controller.config.AppConfig;
import com.gmail.petrikov05.controller.constant.FileConstant;
import com.gmail.petrikov05.service.FileService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.refresh();

        FileConstant fileConstant = context.getBean(FileConstant.class);
        String fileName = fileConstant.getFileName();
        FileService fileService = context.getBean(FileService.class);
        int sum = fileService.getSum(fileName);

        logger.info("Sum of numbers : " + sum);

    }

}
