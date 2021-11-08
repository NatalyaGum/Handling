package by.epam.task4.parser.impl;

import by.epam.task4.entity.TextComposite;
import by.epam.task4.entity.ComponentType;
import by.epam.task4.parser.TextParser;
import by.epam.task4.parser.impl.SymbolParser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser implements TextParser {

    //private final String WORD_DELIMITER_REGEX = "[А-я\\p{Alpha}]+";
    private final TextParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String data) {

        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
       // Pattern pattern = Pattern.compile(WORD_DELIMITER_REGEX);
// matcher = pattern.matcher(data);
        List<String> symbols= new ArrayList<>();

       /* while (matcher.find()){
            symbols.add(matcher.group());
              }

        for (String symbol: symbols) {*/
            TextComposite nextComposite = symbolParser.parse(data);
            wordComposite.add(nextComposite);

        return wordComposite;
    }
}
