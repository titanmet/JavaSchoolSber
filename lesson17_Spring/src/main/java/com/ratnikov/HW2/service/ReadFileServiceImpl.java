package com.ratnikov.HW2.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReadFileServiceImpl implements ReadFileService {

    @Override
    @SneakyThrows
    public List<String> readFiles(String file) {
        return Files.lines(Paths.get(file)).collect(Collectors.toList());
    }
}

