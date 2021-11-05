package by.epam.task4.entity;

import by.epam.task4.exception.HandlingException;

public interface TextComponent {

    void add (TextComponent component) throws HandlingException;
    void remove (TextComponent component) throws HandlingException;
    String toString();
}
