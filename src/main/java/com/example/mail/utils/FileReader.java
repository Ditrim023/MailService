package com.example.mail.utils;


import com.example.mail.exeption.FileReadException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Nikita Krutoguz
 */

public class FileReader {

    public String read(String fileName) {
        String content;
        try {
            Path path = Paths.get(Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI());
            Stream<String> lines = Files.lines(path);
            content = lines.collect(Collectors.joining("\n"));
            lines.close();
        } catch (URISyntaxException | IOException | NullPointerException e) {
            throw new FileReadException();
        }

        return content;
    }

    public InputStream readAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return classLoader.getResourceAsStream(fileName);
    }
}
