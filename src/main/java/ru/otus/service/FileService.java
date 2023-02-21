package ru.otus.service;

import org.springframework.core.io.Resource;

import java.util.List;

public interface FileService {

    Resource getFileFromResource(String fileName);

    List<String[]> readCsvFileAsStringRows(Resource resource);
}
