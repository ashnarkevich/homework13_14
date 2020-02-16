package com.gmail.petrikov05.repository;

import java.io.IOException;
import java.util.List;

public interface FileRepository {

    List<String> getLineList(String fileName) throws IOException;

}
