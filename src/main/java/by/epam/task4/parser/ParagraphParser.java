package by.epam.task4.parser;

import by.epam.task4.entity.ComponentType;
import by.epam.task4.entity.TextComponent;
import by.epam.task4.entity.TextComposite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;


public class ParagraphParser implements TextParser{
    static Logger logger = LogManager.getLogger();

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
