package com.gmail.petrikov05.service.impl;

import java.io.IOException;
import java.util.List;

import com.gmail.petrikov05.repository.FileRepository;
import com.gmail.petrikov05.service.FileService;
import com.gmail.petrikov05.service.UtilService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

    private static final Logger logger = LogManager.getLogger(FileServiceImpl.class);

    private final FileRepository fileRepository;
    private final UtilService utilService;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, UtilService utilService) {
        this.fileRepository = fileRepository;
        this.utilService = utilService;
    }

    @Override
    public int getSum(String fileName) {

        int sum = 0;
        try {
            List<String> lineList = fileRepository.getLineList(fileName);
            for (String line : lineList) {
                sum += utilService.add(line);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return sum;
    }

}
