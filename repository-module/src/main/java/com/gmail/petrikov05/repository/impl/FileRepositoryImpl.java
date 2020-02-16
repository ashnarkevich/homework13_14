package com.gmail.petrikov05.repository.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.gmail.petrikov05.repository.FileRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class FileRepositoryImpl implements FileRepository {

    private static final Logger logger = LogManager.getLogger(FileRepositoryImpl.class);

    @Override
    public List<String> getLineList(String fileName) throws IOException {

        try {
            URI fileLocation = getClass().getResource(fileName).toURI();
            Path pathFile = Paths.get(fileLocation);
            try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(pathFile)))) {
                List<String> lineList = stream.collect(Collectors.toList());
                return lineList;
            }
        } catch (NullPointerException | IOException | URISyntaxException e) {
            logger.error("File not found");
            throw new IOException("File not found");
        }
    }

}