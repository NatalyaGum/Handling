package by.epam.task4.parser.impl;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import by.epam.task4.parser.TextParser;
import by.epam.task4.parser.impl.SentenceParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ParagraphParser implements TextParser {

    private static final String PARAGRAPH_REGEX = "[\\n\\t]+";
    private final TextParser sentenceParser = new SentenceParser();

    @Override
    public TextComposite parse(String text) {
        TextComposite paragraphComposite = new TextComposite(ComponentType.PARAGRAPH);
        String[] paragraphs = text.split(PARAGRAPH_REGEX);

        for (String paragraph : paragraphs) {
            TextComponent nextComposite = sentenceParser.parse(paragraph);
            paragraphComposite.add(nextComposite);
        }
        return paragraphComposite;
    }

}
