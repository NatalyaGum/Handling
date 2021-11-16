package by.epam.task4.service;

import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.exception.HandlingException;

import java.util.List;

public interface Service {
    List<TextComponent> sortParagraphs(TextComposite composite) throws HandlingException;

    List<TextComponent> findSentencesWithLongWord(TextComposite composite) throws HandlingException;


    void deleteSentencesWithLessWords(TextComposite composite, int wordsAmount);


    List<String> countRepeatWords(TextComposite composite);


    int countVowels(TextComponent sentence) throws HandlingException;


    int countConsonants(TextComponent sentence) throws HandlingException;
}
