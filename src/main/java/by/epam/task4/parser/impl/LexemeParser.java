package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.TextParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser implements TextParser {
   //static Logger logger = LogManager.getLogger();

    private final String LEXEME_REGEX = "\\s";
    final String PRE_PUNCTUATION_REGEX = "^\\p{Punct}";//"[.=,!?:;…()\\t\\n]";
    final String PUNCTUATION_REGEX = "\\p{Punct}$";
    private final TextParser wordParser = new WordParser();
    private final TextParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String data) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] lexemes = data.split(LEXEME_REGEX);

        for (String lexeme : lexemes) {
            Pattern pattern = Pattern.compile(PRE_PUNCTUATION_REGEX);
            Matcher matcher = pattern.matcher(lexeme);
            List<String> punctuation = new ArrayList<>();

            while (matcher.find()) {
                punctuation.add(matcher.group());
            }
            for (String symbol : punctuation) {
                TextComposite punctuationComposite = symbolParser.parse(symbol);
                lexemeComposite.add(punctuationComposite);
            }

            TextComposite nextComposite = wordParser.parse(lexeme);
            lexemeComposite.add(nextComposite);

            pattern = Pattern.compile(PUNCTUATION_REGEX);
            matcher = pattern.matcher(lexeme);
            punctuation = new ArrayList<>();

            while (matcher.find()) {
                punctuation.add(matcher.group());
            }
            for (String symbol : punctuation) {
                TextComposite punctuationComposite = symbolParser.parse(symbol);
                lexemeComposite.add(punctuationComposite);
            }

        }return lexemeComposite;
    }
}




