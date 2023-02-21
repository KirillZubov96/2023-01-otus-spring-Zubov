package ru.otus.service;

import com.opencsv.CSVReader;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;

@Service
public class FileResourceService implements FileService {
    @Override
    public Resource getFileFromResource(String fileName) {
        return new ClassPathResource(fileName);
    }

    @Override
    @SneakyThrows
    public List<String[]> readCsvFileAsStringRows(Resource resource) {
        return (new CSVReader(new FileReader(resource.getURI().getPath()), ';')).readAll();
    }
}
