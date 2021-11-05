package by.epam.task4.parser;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComposite;

public class LexemeParser implements TextParser{

    private final String LEXEME_REGEX = "\\s";
    private final TextParser wordParser = new WordParser();

    @Override
    public TextComposite parse(String data) {
        TextComposite lexemeComposite = new TextComposite(ComponentType.LEXEME);
        String[] lexemes = data.split(LEXEME_REGEX);

        for (String lexeme : lexemes) {
            TextComposite nextComposite = wordParser.parse(lexeme);
            lexemeComposite.add(nextComposite);
        }
        return lexemeComposite;
    }
}
