package by.epam.task4.reader;

import by.epam.task4.exception.HandlingException;


public interface TextReader {

    String readText(String pathToFile) throws HandlingException;
}
