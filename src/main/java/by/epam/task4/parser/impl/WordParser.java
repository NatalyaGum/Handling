package by.epam.task4.parser.impl;

import by.epam.task4.entity.TextComposite;
import by.epam.task4.entity.ComponentType;
import by.epam.task4.parser.TextParser;

public class WordParser implements TextParser {

    private final TextParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String data) {

        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        TextComposite nextComposite = symbolParser.parse(data);
        wordComposite.add(nextComposite);
        return wordComposite;
    }
}