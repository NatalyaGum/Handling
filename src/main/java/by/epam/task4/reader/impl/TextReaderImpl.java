package by.epam.task4.reader.impl;

import by.epam.task4.exception.HandlingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import by.epam.task4.reader.TextReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;

public class TextReaderImpl implements TextReader {
    static Logger logger = LogManager.getLogger();

    @Override
    public String readText(String pathToFile) throws HandlingException {
        String text;

        try {
            text = Files.readString(Paths.get(pathToFile));
            logger.info("Text: " + "\n" + text);

        } catch (FileNotFoundException ex) {
            logger.error(pathToFile + " - the file was not found, ", ex);
            throw new HandlingException(pathToFile + " - the file was not found, ", ex);
        } catch (IOException ex) {
            logger.error(pathToFile + " I/O error ", ex);
            throw new HandlingException(pathToFile + " I/O error ", ex);

        }
        return text;
    }
}




