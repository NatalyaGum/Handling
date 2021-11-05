package by.epam.task4.parser;

import by.epam.task4.entity.Symbol;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.entity.ComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordParser implements TextParser{
    private final String PUNCTUATION_REGEX = "[.=,!?:;…()\\t\\n]";
    private final TextParser symbolParser = new SymbolParser();

    @Override
    public TextComposite parse(String data) {

        TextComposite wordComposite = new TextComposite(ComponentType.WORD);
        char[] lexeme = data.toCharArray();
        Pattern pattern = Pattern.compile(PUNCTUATION_REGEX);
        Matcher matcher;
        StringBuilder word = new StringBuilder();

        for (char ch : lexeme) {
            matcher = pattern.matcher(Character.toString(ch));
            if (matcher.matches()) {
                if (word.length() > 0) {
                    TextComposite nextComposite = symbolParser.parse(word.toString());
                    wordComposite.add(nextComposite);
                    word = new StringBuilder();
                }
                Symbol punctuation = new Symbol(ch);
                wordComposite.add(punctuation);
            } else {
                word.append(ch);
            }
        }
        if (word.length() > 0) {
            TextComposite nextComposite = symbolParser.parse(word.toString());
            wordComposite.add(nextComposite);
        }
        return wordComposite;
    }
}
